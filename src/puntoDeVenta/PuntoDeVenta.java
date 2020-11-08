package puntoDeVenta;

import ZonEstacionamiento;
import Compra;

public class PuntoDeVenta {

	private String nombreComercio;
	
	public void registrarCompra(Compra compra) {
		//
	}
	
	private String getZona(ZonaEstacionamiento zonaE) {
		return zonaE.nombre();
	}
}
