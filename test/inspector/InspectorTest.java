package inspector;

import static org.mockito.Mockito.*;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import infraccion.Infraccion;
import sistemaEstacionamientoMedido.SEM;
import zonaDeEstacionamiento.ZonaDeEstacionamiento;

class InspectorTest {
	private Inspector inspector;
	private SEM sem = mock(SEM.class);
	private Infraccion infraccion = mock(Infraccion.class);
	private ZonaDeEstacionamiento zona1 = mock(ZonaDeEstacionamiento.class);
	
	
	@BeforeEach
	void setUp() throws Exception {
		inspector = new Inspector("Gadget", "A21000", zona1);
	}

	@Test
	void testgetNombre() {
		assertEquals("Gadget", inspector.getNombre());
	}
	
	@Test
	void testgetMatricula() {
		assertEquals("A21000", inspector.getMatricula());
	}
	
	@Test
	void testgetZonaACargo() {
		assertEquals(zona1, inspector.getZonaACargo());
	}
	
	@Test
	void testconsultarEstacionamientoVigente() {
		inspector.tieneEstacionamientoVigente("ABC123", sem);
		verify(sem).tieneEstacionamientoVigente("ABC123", inspector);
	}
	
	@Test
	void testemitirAltaDeInfraccion() {
		inspector.emitirAltaDeInfraccion("ABC123", sem, LocalDateTime.of(2020, 11, 10, 19, 05));
		verify(sem).tieneEstacionamientoVigente("ABC123", inspector);
	}
	

}
