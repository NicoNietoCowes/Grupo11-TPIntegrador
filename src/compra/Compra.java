package compra;

import java.time.chrono.ChronoLocalDate;

public class Compra extends puntoDeVenta.PuntoDeVenta {

	private int nroControl;
	private ChronoLocalDate fechaYHora;
	
	protected void realizarCompra() {
		//se delega a las subclases
	}
}
