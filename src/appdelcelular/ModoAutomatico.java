package appdelcelular;

import java.time.LocalTime;

public class ModoAutomatico extends ModoApp {
	private LocalTime reloj;
	/** Atributo provisorio que provee el modo autom�tico para poder 
	 * enviarle a la app distintos mensajes que requieren de un horario espec�fico. */
	
	public ModoAutomatico(AppCelular appRef) {
		super(appRef);
	}

	/** Si la app recibe un mensaje de posibleInicioDeEstacionamiento y se encuentra actualmente en modo Automatico
	 * va a recibir la notificacion de este inicio y se inicia el estacionamiento con la hora del reloj que acompa�a al modo autom�tico. */
	@Override
	protected void posibleInicioDeEstacionamiento() {
		this.getAppDeReferencia().agregarNotificacion("Est�s en modo autom�tico por lo que se inicia un estacionamiento");
		this.getAppDeReferencia().inicioDeEstacionamiento(this.getReloj());
	}

	/** Si la app recibe un mensaje de posibleFinDeEstacionamiento y se encuentra en modo Automatico
	 * va a recibir una notificaci�n de finalizaci�n del estacionamiento vigente y va a finalizar dicho estacionamiento con la hora del reloj. */
	@Override
	protected void posibleFinDeEstacionamiento() {
		this.getAppDeReferencia().agregarNotificacion("Est�s en modo autom�tico por lo que se finaliza el estacionamiento vigente");
		this.getAppDeReferencia().finDeEstacionamiento(this.getReloj());
	}
	
	public LocalTime getReloj() {
		return this.reloj;
	}
}
