package appdelcelular;

public abstract class EstadoApp {
	private AppCelular appDeReferencia;
	
	public EstadoApp(AppCelular appRef) {
		this.setAppDeReferencia(appRef);
	}
	
	protected void setAppDeReferencia(AppCelular app) {
		this.appDeReferencia = app;
	}
	
	public AppCelular getAppDeReferencia() {
		return this.appDeReferencia;
	}
		
	public abstract void driving();
	public abstract void walking();
}
