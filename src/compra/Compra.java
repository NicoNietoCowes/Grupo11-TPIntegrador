package compra;

import java.time.chrono.ChronoLocalDate;

public class Compra extends puntoDeVenta.PuntoDeVenta {

	int nroControl;
	ChronoLocalDate fechaYHora;
	
	protected void realizarCompra() {
		//se delega a las subclases
	}
	
	public Boolean seRealizoConExito() {
		if (double monto = 0) { //chequear como poder ver el atributo de la subclase
			return true;
		}
		else {return false; }
	}
}
