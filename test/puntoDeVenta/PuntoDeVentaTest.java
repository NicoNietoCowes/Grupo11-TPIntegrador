package puntoDeVenta;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sistemaEstacionamientoMedido.SEM;
import zonaDeEstacionamiento.ZonaDeEstacionamiento;

public class PuntoDeVentaTest {

	private PuntoDeVenta puntoDeVenta;
	private ZonaDeEstacionamiento zona1 = mock(ZonaDeEstacionamiento.class);
	private SEM sem = mock(SEM.class);
	
	
	@BeforeEach
	void setUp() throws Exception {
		puntoDeVenta = new PuntoDeVenta("Maxikiosco", zona1, sem);
	}
	
	@Test
	void testGetNombreComercio() {
		assertEquals("Maxikiosco", puntoDeVenta.getNombreComercio());
	}
	
	@Test
	void testGetZonaDeEstacionamiento() {
		assertEquals(zona1, puntoDeVenta.getZonaDeEstacionamiento());
	}
	
	@Test
	void testGetSEM() {
		assertEquals(sem, puntoDeVenta.getSEM());
	}

	

}