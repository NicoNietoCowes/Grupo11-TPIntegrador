package appdelcelular;

public class Caminando extends EstadoApp {

	public Caminando(AppCelular appRef) {
		super(appRef);
	}

	@Override
	public void driving() {
		// TODO: controlar si tiene estacionamiento vigente y se encuentra en la misma zonaEST del estacionamiento
		this.getAppDeReferencia().cambiarEstado(new Manejando(this.getAppDeReferencia()));
		this.getAppDeReferencia().posibleFinDeEstacionamiento();			
	}

	/** Si en la app el estado ya es "caminando" y le siguen
	 * llegando mensajes .walking() no debe hacer nada */
	@Override
	public void walking() {}
}
