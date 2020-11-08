package appdelcelular;

public abstract class ModoApp {
	private AppCelular appDeReferencia;
	
	public ModoApp(AppCelular appRef) {
		this.setAppDeReferencia(appRef);
	}
	
	private void setAppDeReferencia(AppCelular app) {
		this.appDeReferencia = app;
	}
	
	public AppCelular getAppDeReferencia() {
		return this.appDeReferencia;
	}
	
	protected abstract void posibleInicioDeEstacionamiento();
	protected abstract void posibleFinDeEstacionamiento();
}