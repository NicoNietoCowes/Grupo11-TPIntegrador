package estacionamiento;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sistemaEstacionamientoMedido.SEM;
import zonaDeEstacionamiento.ZonaDeEstacionamiento;

class EstViaAppTestCase {
	private EstViaApp estacionamientoApp1;
	private EstViaApp estacionamientoApp2;
	private ZonaDeEstacionamiento bernal = mock(ZonaDeEstacionamiento.class);
	private SEM sem = mock(SEM.class);
	
	@BeforeEach
	void setUp() throws Exception {
	 estacionamientoApp1 = new EstViaApp("MYX520", "1130949597", LocalTime.of(15, 00), bernal, 120, sem);
	 estacionamientoApp2 = new EstViaApp("ABD123", "1130949592", LocalTime.of(19, 00), bernal, 90, sem);
	 // 40 pesos es equivalente a 60 cr�ditos ($1:1.5cr�dito)
	}
	
	@Test
	void testGetPatente() {
		assertEquals("MYX520", estacionamientoApp1.getPatente());
	}
	
	@Test
	void testGetNroCelular() {
		assertEquals("1130949597", estacionamientoApp1.getNroCelular());
	}

	@Test
	void testGetHoraInicio() {
		assertEquals(LocalTime.of(15, 00), estacionamientoApp1.getHoraInicio());
	}
	
	@Test
	void testGetZona() {
		assertEquals(bernal, estacionamientoApp1.getZona());
	}
	
	@Test
	void testGetSEM() {
		assertEquals(sem, estacionamientoApp1.getSEM());
	}
	
	@Test
	void testHoraFinConCredito() {
		assertEquals(LocalTime.of(17, 00), estacionamientoApp1.horaFin());
	}
	
	@Test
	void testHoraFinConFranjaHoraria() {
		assertEquals(LocalTime.of(20, 00), estacionamientoApp2.horaFin());
	}
}
