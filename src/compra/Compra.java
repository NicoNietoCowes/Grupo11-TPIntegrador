package compra;

import static org.mockito.Mockito.*;
import java.time.chrono.ChronoLocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class Compra extends puntoDeVenta.PuntoDeVenta {

	protected int nroControl;
	protected ChronoLocalDate fechaYHora;
	
	public Compra(int nroControl, ChronoLocalDate fechaYHora, String nombreComercio) {
		super(nombreComercio);
		this.fechaYHora = fechaYHora;
		this.nroControl = nroControl;
	}
	
	protected void realizarCompra() {
	 //delegado a las subclases
	}
}
