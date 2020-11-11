package sistemaEstacionamientoMedido;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalTime;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import compra.Compra;
import estacionamiento.Estacionamiento;
import infraccion.Infraccion;
import zonaDeEstacionamiento.ZonaDeEstacionamiento;

class SEMTest {

	private SEM sem;
	private Estacionamiento estacionamiento = mock(Estacionamiento.class);
	private Compra compra = mock(Compra.class);
	private Infraccion infraccion = mock(Infraccion.class);
	private ZonaDeEstacionamiento zona1 = mock(ZonaDeEstacionamiento.class);
	
	@BeforeEach
	void setUp() throws Exception {
		sem = new SEM(LocalTime.of(07,00), LocalTime.of(20,00), 40.00);
		
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

}
