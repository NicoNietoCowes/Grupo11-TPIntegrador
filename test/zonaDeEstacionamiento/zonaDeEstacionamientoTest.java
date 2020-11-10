package zonaDeEstacionamiento;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import inspector.Inspector;
import puntoDeVenta.PuntoDeVenta;

class zonaDeEstacionamientoTest {
	private ZonaDeEstacionamiento zona1;
	private Inspector inspectorZona1 = mock(Inspector.class);
//	private PuntoDeVenta puntoDeVenta1 = mock(PuntoDeVenta.class);
//	private PuntoDeVenta puntoDeVenta2 = mock(PuntoDeVenta.class);
	
	
	@BeforeEach
	void setUp() throws Exception {
		zona1 = new ZonaDeEstacionamiento("Zona 1", inspectorZona1);
//		zona1.añadirPuntoDeVenta(puntoDeVenta1);
//		zona1.añadirPuntoDeVenta(puntoDeVenta2);
	}
	
	
	@Test
	void test() {
		assertEquals(inspectorZona1, zona1.getInspector());
	}

/*	@Test
	void test() {
		assertEquals(2, zona1.getPuntosDeVenta().size());
	}
*/
}
