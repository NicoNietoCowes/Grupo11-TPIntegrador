package sistemaEstacionamientoMedido;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalTime;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import puntoDeVenta.PuntoDeVenta;

class SEMTest {

	private SEM sem;
	
	
	@BeforeEach
	void setUp() throws Exception {
		sem = new SEM(LocalTime.of(07,00), LocalTime.of(20,00), 40.00);
		
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
