package sistemaEstacionamientoMedido;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import compra.Compra;
import estacionamiento.Estacionamiento;
import infraccion.Infraccion;
import inspector.Inspector;
import zonaDeEstacionamiento.ZonaDeEstacionamiento;

class SEMTest {

	private SEM sem;
	private Estacionamiento estacionamiento = mock(Estacionamiento.class);
	private Compra compra = mock(Compra.class);
	private Infraccion infraccion = mock(Infraccion.class);
	private ZonaDeEstacionamiento zona1 = mock(ZonaDeEstacionamiento.class);
	private Inspector inspector = mock(Inspector.class);
	
	@BeforeEach
	void setUp() throws Exception {
		sem = new SEM(LocalTime.of(07,00), LocalTime.of(20,00), 40.00);
		sem.registrarEstacionamiento(estacionamiento);
		
		// SetUp del mock de estacionamientos para hacer las consultas por vigencia
		when(estacionamiento.getPatente()).thenReturn("MYX520");
		when(estacionamiento.getZona()).thenReturn(zona1);
		when(estacionamiento.estaVigente(LocalTime.of(8, 30))).thenReturn(true);
		when(estacionamiento.estaVigente(LocalTime.of(17, 30))).thenReturn(false);
		
		// SetUp del mock de inspector de la zona1
		when(inspector.getZonaACargo()).thenReturn(zona1);
	}

	@Test
	void testGetComienzoFranjaHoraria() {
		assertEquals(LocalTime.of(07,00),sem.getComienzoFranjaHoraria());
	}
	
	@Test
	void testGetFinFranjaHoraria() {
		assertEquals(LocalTime.of(20,00),sem.getFinFranjaHoraria());
	}
	
	@Test
	void testGetPrecioPorHora() {
		assertEquals(40.00, sem.getPrecioPorHora());
	}
	
	@Test
	void testRegistrarInfraccionYGetInfraccion() {
		sem.registrarInfraccion(infraccion);
		
		assertEquals(1, sem.getInfracciones().size());
	}

	@Test 
	void testAgregarCompra() {
		sem.registrarCompra(compra);
		assertEquals(1, sem.getCompras().size());
	}
	
	@Test 
	void testPatenteConEstacionamientoVigente() {
		assertTrue(sem.tieneEstacionamientoVigente("MYX520", inspector, LocalTime.of(8, 30)));
	}
	
	@Test 
	void testPatenteSinEstacionamientoVigente() {
		assertFalse(sem.tieneEstacionamientoVigente("MYX520", inspector, LocalTime.of(17, 30)));
	}
	
	@Test 
	void testPatenteNoRegistradaConEstacionamiento() {
		assertFalse(sem.tieneEstacionamientoVigente("ABC123", inspector, LocalTime.of(14, 30)));
	}
	
}
