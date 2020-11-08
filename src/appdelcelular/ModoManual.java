package appdelcelular;

public class ModoManual extends ModoApp {

	public ModoManual(AppCelular appRef) {
		super(appRef);
	}

	@Override
	protected void posibleInicioDeEstacionamiento() {
		this.getAppDeReferencia().agregarNotificacion("Posible inicio de estacionamiento");
	}

	@Override
	protected void posibleFinDeEstacionamiento() {
		this.getAppDeReferencia().agregarNotificacion("Posible fin de estacionamiento");
	}

}
