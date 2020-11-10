package compra;

import java.time.chrono.ChronoLocalDate;

public class Compra extends puntoDeVenta.PuntoDeVenta {

	int nroControl;
	ChronoLocalDate fechaYHora;
	
	public Compra(int nroControl, ChronoLocalDate fechaYHora, String nombreComercio) {
		super(nombreComercio);
		this.fechaYHora = fechaYHora;
		this.nroControl = nroControl;
	}
	
	protected void realizarCompra(AppCelular celu) {
		//se delega a las subclases
	}
	
	public Boolean seRealizoConExito() {
		if (double monto = 0) { //chequear como poder ver el atributo de la subclase
			return true;
		}
		else {return false; }
	}
}
