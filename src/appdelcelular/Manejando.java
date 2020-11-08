package appdelcelular;

public class Manejando extends EstadoApp {

	public Manejando(AppCelular appRef) {
		super(appRef);
	}

	/** Si en la app el estado ya es "manejando" y le siguen
	 * llegando mensajes .driving() no debe hacer nada */
	@Override
	public void driving() {}

	@Override
	public void walking() {
		// controlar si no tiene estacionamiento vigente y se encuentra en una zonaEST
		this.getAppDeReferencia().cambiarEstado(new Caminando(this.getAppDeReferencia()));
		this.getAppDeReferencia().posibleInicioDeEstacionamiento();	
	}

}
