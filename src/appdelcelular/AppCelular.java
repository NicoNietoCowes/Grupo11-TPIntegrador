package appdelcelular;

import java.time.LocalTime;
import java.util.ArrayList;

import estacionamiento.EstViaApp;
import sistemaEstacionamientoMedido.SEM;
import zonaDeEstacionamiento.ZonaDeEstacionamiento;

// import java.time.LocalTime;

public class AppCelular implements MovementSensor {
	private String numeroCel;
	private String patente;
	private Integer creditoDisponible = 0;
	private ModoApp modoApp;
	private EstadoApp estado = new Caminando(this); // Se inicia la app con algún estado x, luego va cambiando en tiempo real.
	private EstViaApp estacionamiento;
	private ZonaDeEstacionamiento localizacion;
	private SEM sem;
	private ArrayList<String> notificaciones;
	
	/** Cuando se crea una AppCelular se indica el número de celular
	 * y la patente del usuario junto con el modo de inicio 
	 * (manual o automático) que luego puede ser modificado. */
	public AppCelular(String nroCel, String patente, ModoApp modo, SEM sem) {
		this.setNumeroCel(nroCel);
		this.setPatente(patente);
		this.cambiarModo(modo);
		this.sem = sem;
		this.notificaciones = new ArrayList<String>();
	}
	
	public String inicioDeEstacionamiento(LocalTime horaDeInicio) {
		String notificacion;
		if (this.getCreditoDisponible() > 0) {
			EstViaApp nuevoEstacionamiento = 
					new EstViaApp(this.getPatente(), this.getNumeroCel(), horaDeInicio, this.localizacion, this.getCreditoDisponible(), this.sem);
			sem.registrarEstacionamiento(nuevoEstacionamiento);
			this.asociarEstacionamiento(nuevoEstacionamiento);
			notificacion = "¡Estacionamiento iniciado! Hora de comienzo: " + horaDeInicio + 
					", Hora máxima de finalización: " + nuevoEstacionamiento.horaFin();
		} else {
			notificacion = "Saldo insuficiente. Estacionamiento no permitido";
		}
		return notificacion;
	}
	
	/** Corresponde al Evento 2 indicado en el enunciado, un usuario solicita finalizar un estacionamiento
	 * en una hora específica y recibe a modo de notificación una combinación de atributos correspondientes al 
	 * estacionamiento que acaba de dar de baja. 
	 * La app se encarga, además de lo mencionado, de indicar al SEM que finalice dicho estacionamiento en el sistema. 
	 * PRECONDICIÓN: La app tiene que haber iniciado un estacionamiento previamente. */
	public String finDeEstacionamiento(LocalTime horaDeFinalizacion) {
		sem.finalizarEstacionamiento(this.getEstacionamiento());
		this.getEstacionamiento().finalizarEstacionamiento(horaDeFinalizacion);
		return "¡Estacionamiento finalizado!"
				+ " Hora de comienzo: " + this.getEstacionamiento().getHoraInicio() + ","
				+ " Hora de finalización: " + horaDeFinalizacion + ","
				+ " Horas totales: " + this.getEstacionamiento().horasTranscurridas(horaDeFinalizacion) + ","
				+ " Costo de estacionamiento (en créditos): " + this.getEstacionamiento().costoActual(horaDeFinalizacion) + ","
				+ " Crédito disponible: " + this.getCreditoDisponible();
	}
	
	/** Devuelve el estacionamiento asociado a la app. */
	protected EstViaApp getEstacionamiento() {
		return this.estacionamiento;
	}

	/** Corresponde al Evento 3 indicado en el enunciado, un usuario solicita una consulta de saldo y
	 * se le devuelve en modo de texto, indicando el nro de celular y el crédito disponible. */
	public String consultaDeSaldo() {
		return "Este celular (" + this.getNumeroCel() + ") cuenta con " + this.getCreditoDisponible() + " créditos de estacionamiento";
	}
	
	/** En base al monto de crédito de estacionamiento recibido, se suma este 
	 * al crédito disponible. 
	 * OBSERVACIÓN: El crédito de estacionamiento no es un equivalente a pesos, esto
	 * está determinado al momento de la Compra en un PuntoDeVenta registrado por el SEM. */
	public void cargarCredito(Integer monto) {
		this.creditoDisponible =+ monto;
	}
	
	/** Devuelve el crédito de estacionamiento disponible en la app. */
	public Integer getCreditoDisponible() {
		return this.creditoDisponible;
	}
 
	/** Solo se llama al iniciar sesión en la app, setea el número de 
	 * celular que ingresa el usuario. */
	private void setNumeroCel(String nroCel) {
		this.numeroCel = nroCel;
	}
	
	/** Devuelve el número de celular del usuario registrado por la app. */
	public String getNumeroCel() {
		return this.numeroCel;
	}
	
	/** Solo se llama al iniciar sesión en la app, setea la patente que ingresa
	 * el usuario. */
	private void setPatente(String patente) {
		this.patente = patente;
	}
	
	/** Devuelve la patente del usuario registrado en la app. */
	public String getPatente() {
		return this.patente;
	}
	
	/** Modifica el modo actual de la app por el seleccionado por el usuario en un determinado 
	 * momento (el indicado en el parámetro). */
	protected void cambiarModo(ModoApp modoNuevo) {
		this.modoApp = modoNuevo;
	}
		
	/** En esta parte interpreto que la app, al estar implementando 
	 * la interfaz MovementSensor, puede recibir estos dos tipos de mensajes
	 * (tal y como indica el enunciado, asumo que llegan sin importar como lo sea que lo haga
	 * el sensor de movimiento) y los delega en el estado en el que se encuentra el usuario.
	 * Dicho estado está relacionado con algún sistema de geo-localización que también excede los
	 * fines de este trabajo. */
	@Override
	public void driving() {
		this.getEstado().driving();
	}

	/** Según lo indicado arriba, delega el mensaje recibido por el sensor de movimiento en el estado actual
	 * de la app.*/
	@Override
	public void walking() {
		this.getEstado().walking();
	}
	
	/** Modifica el estado actual de la app por el que se pasa por parámetro. Estos mensajes están enviandose constantemente
	 * entre los distintos tipos de Estado que puede adquirir la app. */
	public void cambiarEstado(EstadoApp nuevoEstado) {
		this.estado = nuevoEstado;
	}

	/** Delega el mensaje de posibleInicioDeEstacionamiento en el modo actual de la app. */
	public void posibleInicioDeEstacionamiento() {
		this.getModoApp().posibleInicioDeEstacionamiento();
	}

	/** Delega el mensaje de posibleFinDeEstacionamiento en el modo actual de la app. */
	public void posibleFinDeEstacionamiento() {
		this.getModoApp().posibleFinDeEstacionamiento();	
	}
	
	/** Devuelve el último modo de la app seleccionado por el usuario. */
	public ModoApp getModoApp() {
		return this.modoApp;
	}
	
	/** Devuelve el estado actual de la app, este es controlado por
	 * un sensor de movimiento integrado en la misma. */
	public EstadoApp getEstado() {
		return this.estado;
	}
	
	/** Agrega la última notificación recibida al listado de notificaciones (en el primer lugar, para 
	 * luego poder obtenerla con el getUltimaNotificacion(). */
	public void agregarNotificacion(String notificacion) {
		this.notificaciones.add(0, notificacion);
	}
	
	/** Devuelve la primera notificación de la lista, que corresponde con la última notificación que recibio la app.*/
	public String getUltimaNotificacion() {
		return this.notificaciones.get(0);
	}
	
	/** Deja vacío el listado de notificaciones. */
	public void borrarNotificaciones() {
		this.notificaciones.clear();
	}
	
	/** Devuelve el listado de notificaciones, en el orden de últimas a primeras. */
	public ArrayList<String> getNotificaciones() {
		return this.notificaciones;
	}

	/** Una vez creado el nuevo EstacionamientoViaApp mediante el método inicioDeEstacionamiento(), se 
	 * asocia dicho estacionamiento a la app. */
	public void asociarEstacionamiento(EstViaApp estacionamientoApp) {
		this.estacionamiento = estacionamientoApp;
	}

	/** Devuelve si se encuentra en una ZonaDeEstacionamiento. */
	public Boolean seEncuentraEnZonaEst() {
		return this.localizacion != null;
	}

	/** Representa el cambio de localizaciones (una especie de GPS) en el que el sensor de movimiento va actualizando 
	 * la localización en base a que ZonaDeEstacionamiento está transitando al momento. */
	public void actualizarLocalizacion(ZonaDeEstacionamiento zonaEst) {
		this.localizacion = zonaEst;
	}

	/** Indica si la app tiene un estacionamiento asociado. */
	public Boolean tieneEstacionamientoAsociado() {
		return this.getEstacionamiento() != null;
	}

	/** Indica si la localización actual se corresponde con la zona declarada en el estacionamiento. */
	public Boolean seEncuentraEnLaZonaDeSuEstacionamiento() {
		return this.getEstacionamiento().getZona() == this.localizacion;
	}
}