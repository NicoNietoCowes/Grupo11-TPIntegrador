package puntoDeVenta;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import compra.Compra;
import compra.HorasPuntuales;
import compra.RecargaCelular;
import zonaDeEstacionamiento.ZonaDeEstacionamiento;

public class PuntoDeVentaTest {

	//clases
	private PuntoDeVenta puntoDeV = mock(PuntoDeVenta.class);
	
	//instancias
	private PuntoDeVenta lugar = new PuntoDeVenta("Maxikiosco Pepe");
	
	@BeforeEach
	void setUp() throws Exception {
		zona1 = new ZonaDeEstacionamiento();
//		zona1.añadirPuntoDeVenta(puntoDeVenta1);
//		zona1.añadirPuntoDeVenta(puntoDeVenta2);
	}
	
	
	@Test
	void test() {
		assertEquals();
	}

/*	@Test
	void test() {
	}
*/
}
