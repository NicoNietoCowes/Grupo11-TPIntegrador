package puntoDeVenta;

import compra.Compra;

public class PuntoDeVenta {

	private String nombreComercio;
	
	public void registrarCompra(Compra compra) {
		this.registrarCompraSiYaFueHecha(compra);
	}
	
	private String getZona(ZonaEstacionamiento zonaE) {
		return zonaE.nombre();
	}
	
	public String getComercio() {
		return nombreComercio;
	}
	
	public void setComercio(String comercio) {
		this.nombreComercio = comercio;
	}
	
	public registrarCompraSiYaFueHecha(Compra compra) {
		return compra.seRealizoConExito();
	}
}
