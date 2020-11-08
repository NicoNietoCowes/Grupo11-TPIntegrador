package appdelcelular;

public class ModoAutomatico extends ModoApp {

	public ModoAutomatico(AppCelular appRef) {
		super(appRef);
	}

	@Override
	protected void posibleInicioDeEstacionamiento() {
		this.getAppDeReferencia().agregarNotificacion("Est�s en modo autom�tico por lo que se inicia un estacionamiento");
		this.getAppDeReferencia().inicioDeEstacionamiento();
	}

	@Override
	protected void posibleFinDeEstacionamiento() {
		this.getAppDeReferencia().agregarNotificacion("Est�s en modo autom�tico por lo que se finaliza el estacionamiento vigente");
		this.getAppDeReferencia().finDeEstacionamiento();
	}
}
