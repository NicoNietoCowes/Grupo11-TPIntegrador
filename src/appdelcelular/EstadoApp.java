package appdelcelular;

/** Clase abstracta que se divide en Caminando y Manejando, representa el estado adquirido por una app
 * con sensor de movimiento. */
public abstract class EstadoApp {
	private AppCelular appDeReferencia;
	// La appCelular que tiene asocia a este estado.
	
	/** Constructor, se le indica al estado con que app se esta referenciando. */
	public EstadoApp(AppCelular appRef) {
		this.setAppDeReferencia(appRef);
	}

	/** Setea la app de referencia al inicio. */
	protected void setAppDeReferencia(AppCelular app) {
		this.appDeReferencia = app;
	}
	
	/** Retorna la app que se referencia al inicio. */
	public AppCelular getAppDeReferencia() {
		return this.appDeReferencia;
	}
		
	/** Métodos abstractos que deriva a las subclases que extiendan de este estado genérico. */
	public abstract void driving();
	public abstract void walking();
}
