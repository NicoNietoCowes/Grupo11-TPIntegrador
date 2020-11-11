package compra;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import zonaDeEstacionamiento.ZonaDeEstacionamiento;

public class RecargaCelularTest {

	//clases
	private Compra recarga = mock(RecargaCelular.class);
	
	//instancias
	private Compra recargando = new RecargaCelular(0, null, "1169540055", null, 200);
	
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
