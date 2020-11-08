package puntoDeVenta;

import ZonEstacionamiento;
import compra;

public class PuntoDeVenta {

	private String nombreComercio;
	
	public void registrarCompra(Compra compra) {
		//
	}
	
	private String getZona(ZonaEstacionamiento zonaE) {
		return zonaE.nombre();
	}
}
