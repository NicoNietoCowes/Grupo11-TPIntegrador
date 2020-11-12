package appdelcelular;

public class Caminando extends EstadoApp {

	public Caminando(AppCelular appRef) {
		super(appRef);
	}

	/** Si en la app el estado es "caminando" y llega el mensaje .walking() el estado corrobora
	 * si la app cuanta con un estacionamiento asociado y si está actualmente en la misma zona de estacionamiento
	 * en la que estacionó. De ser así, cambia el estado actual a "manejando" y avisa a la app de un posible fin de estacionamiento. */
	@Override
	public void driving() {
		if (this.getAppDeReferencia().tieneEstacionamientoAsociado() && this.getAppDeReferencia().seEncuentraEnLaZonaDeSuEstacionamiento()) {
			this.getAppDeReferencia().cambiarEstado(new Manejando(this.getAppDeReferencia()));
			this.getAppDeReferencia().posibleFinDeEstacionamiento();	
		}
	}

	/** Si en la app el estado ya es "caminando" y le siguen
	 * llegando mensajes .walking() no debe hacer nada */
	@Override
	public void walking() {}
}
