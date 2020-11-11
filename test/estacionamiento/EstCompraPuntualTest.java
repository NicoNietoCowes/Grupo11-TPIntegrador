package estacionamiento;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sistemaEstacionamientoMedido.SEM;
import zonaDeEstacionamiento.ZonaDeEstacionamiento;

class EstCompraPuntualTest {
	private EstCompraPuntual estCompraPuntual;
	private SEM sem = mock(SEM.class);
	private ZonaDeEstacionamiento zona1 = mock(ZonaDeEstacionamiento.class);

	@BeforeEach
	void setUp() throws Exception {
	estCompraPuntual = new EstCompraPuntual("ABC123",3 , LocalTime.of(15,00), zona1, sem);
	}

	@Test
	void testGetCantHoras() {
		assertEquals(3, estCompraPuntual.getCantHoras());
	}
	
	@Test
	void testGetHoraFin() {
		assertEquals(LocalTime.of(18,00), estCompraPuntual.horaFin());
	}
	
	@Test
	void testEstaVigente() {
		assertTrue(estCompraPuntual.estaVigente(LocalTime.of(17,00)));
	}
	
	@Test
	void testNoEstaVigente() {
		assertFalse(estCompraPuntual.estaVigente(LocalTime.of(19,00)));
	}

}
