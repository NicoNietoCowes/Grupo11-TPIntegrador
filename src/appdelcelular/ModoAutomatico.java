package appdelcelular;

import java.time.LocalTime;

public class ModoAutomatico extends ModoApp {
	private LocalTime reloj;
	/** Atributo provisorio que provee el modo automático para poder 
	 * enviarle a la app distintos mensajes que requieren de un horario específico. */
	
	public ModoAutomatico(AppCelular appRef) {
		super(appRef);
	}

	@Override
	protected void posibleInicioDeEstacionamiento() {
		this.getAppDeReferencia().agregarNotificacion("Estás en modo automático por lo que se inicia un estacionamiento");
		this.getAppDeReferencia().inicioDeEstacionamiento(reloj);
	}

	@Override
	protected void posibleFinDeEstacionamiento() {
		this.getAppDeReferencia().agregarNotificacion("Estás en modo automático por lo que se finaliza el estacionamiento vigente");
		this.getAppDeReferencia().finDeEstacionamiento(reloj);
	}
	
	public LocalTime getReloj() {
		return this.reloj;
	}
}
