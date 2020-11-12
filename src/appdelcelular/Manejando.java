package appdelcelular;

public class Manejando extends EstadoApp {

	public Manejando(AppCelular appRef) {
		super(appRef);
	}

	/** Si en la app el estado ya es "manejando" y le siguen
	 * llegando mensajes .driving() no debe hacer nada */
	@Override
	public void driving() {}

	/** Si en la app el estado es "manejando" y se recibe un mensaje .walking() 
	 * el estado corrobora si la app no tiene un estacionamiento asociado y si se encuentra actualmente
	 * en una zona de estacionamiento. De ser así, se cambia el estado de la app a "caminando" y se informa de un
	 * posible inicio de estacionamiento. */
	@Override
	public void walking() {
		if (!this.getAppDeReferencia().tieneEstacionamientoAsociado() && this.getAppDeReferencia().seEncuentraEnZonaEst()) {
			this.getAppDeReferencia().cambiarEstado(new Caminando(this.getAppDeReferencia()));
			this.getAppDeReferencia().posibleInicioDeEstacionamiento();	
		}
	}

}
