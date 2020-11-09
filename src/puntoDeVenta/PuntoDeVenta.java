package puntoDeVenta;

import compra.Compra;

public class PuntoDeVenta {

	private String nombreComercio;
	
	public void registrarCompra(Compra compra) {
		SEM.registrarCompra(compra);
	}
	
	private String getZona(ZonaEstacionamiento zonaE) {
		return zonaE.nombre();
	}
}
