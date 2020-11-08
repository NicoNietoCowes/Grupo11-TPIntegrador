package appdelcelular;

import java.util.ArrayList;

// import java.time.LocalTime;

public class AppCelular implements MovementSensor {
	private String numeroCel;
	private String patente;
	private double creditoDisponible = 0;
	private ModoApp modoApp;
	private EstadoApp estado;
	// private EstViaApp estacionamiento;
	// private ZonaDeEstacionamiento localizacion;
	private ArrayList<String> notificaciones;
	
	/** Cuando se crea una AppCelular se indica el número de celular
	 * y la patente del usuario junto con el modo de inicio 
	 * (manual o automático) que luego puede ser modificado. */
	public AppCelular(String nroCel, String patente, ModoApp modo) {
		this.setNumeroCel(nroCel);
		this.setPatente(patente);
		this.cambiarModo(modo);
		this.notificaciones = new ArrayList<String>();
	}
	
	public String inicioDeEstacionamiento() {
		String notificacion;
		if (this.getCreditoDisponible() > 0) {
			/** EstViaApp nuevoEstacionamiento = new EstViaApp(
			 * this.getPatente(), LocalTime.now(), this.getNumeroCel(), this.getCreditoDisponible());
			 * 
			 * */
			// sem.habilitarEstacionamiento(nuevoEstacionamiento);
			// this.asociarEstacionamiento(nuevoEstacionamiento);
			notificacion = "Datos relevantes con respecto al estacionamiento generado";
		} else {
			notificacion = "Saldo insuficiente. Estacionamiento no permitido";
		}
		return notificacion;
	}
	
	public String finDeEstacionamiento() {
		// sem.finalizarEstacionamiento(this.getEstacionamiento);
		return "combinacion de atributos correspondientes al estacionamiento";
	}
	
	public String consultaDeSaldo() {
		return "El crédito de estacionamiento disponible para este "
				+ "celular (" + this.getNumeroCel() + ") es de $"
				+ this.getCreditoDisponible();
	}
	
	public void cargarCredito(double monto) {
		this.creditoDisponible =+ monto;
	}
	
	public double getCreditoDisponible() {
		return this.creditoDisponible;
	}
 
	private void setNumeroCel(String nroCel) {
		this.numeroCel = nroCel;
	}
	
	public String getNumeroCel() {
		return this.numeroCel;
	}
	
	private void setPatente(String patente) {
		this.patente = patente;
	}
	
	public String getPatente() {
		return this.patente;
	}
	
	protected void cambiarModo(ModoApp modoNuevo) {
		this.modoApp = modoNuevo;
	}

	/** public boolean tieneEstacionamientoVigente() {
	 * return this.getEstacionamiento() != null || this.getEstacionamiento.estaVigente(); } */
	
	/** public boolean seEncuentraEnZonaEst() {
	 * return this.localizacion != null;
	 * } */
	
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

	@Override
	public void walking() {
		this.getEstado().walking();
		
	}
	
	public void cambiarEstado(EstadoApp nuevoEstado) {
		this.estado = nuevoEstado;
	}

	public void posibleInicioDeEstacionamiento() {
		this.getModoApp().posibleInicioDeEstacionamiento();
		
	}

	public void posibleFinDeEstacionamiento() {
		this.getModoApp().posibleFinDeEstacionamiento();
		
	}
	
	public ModoApp getModoApp() {
		return this.modoApp;
	}
	
	public EstadoApp getEstado() {
		return this.estado;
	}
	
	public void agregarNotificacion(String notificacion) {
		this.notificaciones.add(0, notificacion);
	}
	
	public String getUltimaNotificacion() {
		return this.notificaciones.get(0);
	}
	
	public void borrarNotificaciones() {
		this.notificaciones.clear();
	}
	
	public ArrayList<String> getNotificaciones() {
		return this.notificaciones;
	}
}