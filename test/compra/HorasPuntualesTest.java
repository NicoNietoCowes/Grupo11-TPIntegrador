package compra;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import zonaDeEstacionamiento.ZonaDeEstacionamiento;

public class HorasPuntualesTest {

	//clases
	private Compra horasPuntuales = mock(HorasPuntuales.class);
	
	//instancias
	private Compra compraPuntual = new HorasPuntuales(0, null, "LYK887", null, 4);
	
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
