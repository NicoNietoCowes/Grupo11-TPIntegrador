package appdelcelular;

import java.time.LocalTime;

public class ModoAutomatico extends ModoApp {
	private LocalTime reloj;
	/** Atributo provisorio que provee el modo automático para poder 
	 * enviarle a la app distintos mensajes que requieren de un horario específico. */
	
	public ModoAutomatico(AppCelular appRef) {
		super(appRef);
	}

	/** Si la app recibe un mensaje de posibleInicioDeEstacionamiento y se encuentra actualmente en modo Automatico
	 * va a recibir la notificacion de este inicio y se inicia el estacionamiento con la hora del reloj que acompaña al modo automático. */
	@Override
	protected void posibleInicioDeEstacionamiento() {
		this.getAppDeReferencia().agregarNotificacion("Estás en modo automático por lo que se inicia un estacionamiento");
		this.getAppDeReferencia().inicioDeEstacionamiento(this.getReloj());
	}

	/** Si la app recibe un mensaje de posibleFinDeEstacionamiento y se encuentra en modo Automatico
	 * va a recibir una notificación de finalización del estacionamiento vigente y va a finalizar dicho estacionamiento con la hora del reloj. */
	@Override
	protected void posibleFinDeEstacionamiento() {
		this.getAppDeReferencia().agregarNotificacion("Estás en modo automático por lo que se finaliza el estacionamiento vigente");
		this.getAppDeReferencia().finDeEstacionamiento(this.getReloj());
	}
	
	public LocalTime getReloj() {
		return this.reloj;
	}
}
