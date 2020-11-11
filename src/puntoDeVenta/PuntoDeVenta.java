package puntoDeVenta;

import static org.mockito.Mockito.*;
import compra.Compra;
import sistemaEstacionamientoMedido.SEM;
import zonaDeEstacionamiento.ZonaDeEstacionamiento;

import static org.junit.jupiter.api.Assertions.*;

public class PuntoDeVenta {

	private String nombreComercio;
	
	public PuntoDeVenta(String nombreComercio) {
		this.nombreComercio = nombreComercio;
	}
	
	public void registrarCompra(Compra compra) {
		SEM.registrarCompra(compra);
	}
	
	private String getZona(ZonaDeEstacionamiento zonaE) {
		return zonaE.nombre();
	}
	
	public String getComercio() {
		return nombreComercio;
	}
	
	public void setComercio(String comercio) {
		this.nombreComercio = comercio;
	}
}
