package appdelcelular;

public class ModoManual extends ModoApp {

	public ModoManual(AppCelular appRef) {
		super(appRef);
	}

	/** Si la app recibe un mensaje de posibleInicioDeEstacionamiento y se encuentra actualmente en modo Manual solo
	 * va a recibir la notificacion de este inicio. */
	@Override
	protected void posibleInicioDeEstacionamiento() {
		this.getAppDeReferencia().agregarNotificacion("Posible inicio de estacionamiento");
	}

	/** Si la app recibe un mensaje de posibleFinDeEstacionamiento y se encuentra en modo Manual solo
	 * va a recibir una notificación de finalización del estacionamiento vigente. */
	@Override
	protected void posibleFinDeEstacionamiento() {
		this.getAppDeReferencia().agregarNotificacion("Posible fin de estacionamiento");
	}

}
