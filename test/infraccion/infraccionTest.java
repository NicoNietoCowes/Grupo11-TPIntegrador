package infraccion;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import inspector.Inspector;

class infraccionTest {
	private Infraccion infraccion;
	private Inspector inspectorZona1 = mock(Inspector.class);

	@BeforeEach
	void setUp() throws Exception {
		infraccion = new Infraccion("ABC123", LocalDateTime.of(2020, 11, 10, 19, 05), inspectorZona1);
	}

	@Test
	void testgetPatente() {
		assertEquals("ABC123", infraccion.getPatente());
	}
	
	@Test
	void testgetFechaYHora() {
		assertEquals(LocalDateTime.of(2020, 11, 10, 19, 05), infraccion.getFechaYHora());
	}

	@Test
	void testgetInspector() {
		assertEquals(inspectorZona1, infraccion.getInspector());
	}

}
