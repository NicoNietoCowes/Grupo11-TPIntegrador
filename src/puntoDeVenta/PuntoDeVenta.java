package puntoDeVenta;

import compra.Compra;
import sistemaEstacionamientoMedido.SEM;
import zonaDeEstacionamiento.ZonaDeEstacionamiento;

public class PuntoDeVenta {

	private String nombreComercio;
	private ZonaDeEstacionamiento zonaEstacionamiento;
	private SEM sem;
	
	public PuntoDeVenta(String nombre, ZonaDeEstacionamiento zona, SEM s) {
		nombreComercio = nombre;
		zonaEstacionamiento = zona;
		sem = s;
	}
	
	
	public ZonaDeEstacionamiento getZonaDeEstacionamiento() {
		return zonaEstacionamiento;
	}
	
	public String getNombreComercio() {
		return nombreComercio;
	}
	
	public void registrarCompra(Compra compra) {
		compra.efectuarCompra();
		sem.registrarCompra(compra);
	}


	public SEM getSEM() {
		return sem;
	}

}
