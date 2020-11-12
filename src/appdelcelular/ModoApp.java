package appdelcelular;

/** Representa el modo de una app de celular, el mismo puede ser seleccionado por el usuario de la 
 * app en cualquier momento deseado. */
public abstract class ModoApp {
	private AppCelular appDeReferencia;
	// La app que asocia este modo app.
	
	public ModoApp(AppCelular appRef) {
		this.setAppDeReferencia(appRef);
	}
	
	private void setAppDeReferencia(AppCelular app) {
		this.appDeReferencia = app;
	}
	
	public AppCelular getAppDeReferencia() {
		return this.appDeReferencia;
	}
	
	/** Métodos abstractos que deben implementar los distintos modos de app disponibles. */
	protected abstract void posibleInicioDeEstacionamiento();
	protected abstract void posibleFinDeEstacionamiento();
}
