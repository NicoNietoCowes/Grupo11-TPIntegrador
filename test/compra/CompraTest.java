package compra;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import zonaDeEstacionamiento.ZonaDeEstacionamiento;

import static org.junit.jupiter.api.Assertions.*;


public class CompraTest {

	//instancias mock
	private Compra recarga = mock(RecargaCelular.class);
	private Compra horasPuntuales = mock(HorasPuntuales.class);
	
	//instancias
	private RecargaCelular recargando = new RecargaCelular(0, null, "desde App", "1169540055", 200);
	private HorasPuntuales compraPuntual = new HorasPuntuales(0, null, "Maxikiosco Pepe", "LYK887", 4);
	
	
	@Test
	void testRecargoMiCelu() {
		assertEquals(recargando.getMonto(), 200);
	}

	@Test
	
	void testeoNumeroCel() {
		assertEquals("1169540055", recargando.getNumeroCelular());
	}
	
	@Test
	
	void testProbandoCambioDeNumero() {
		assertEquals("1169540055", recargando.getNumeroCelular());
		recargando.cambiarNumeroCelu("1122334455");
		assertEquals("1122334455", recargando.getNumeroCelular());
	}
	
	@Test
	
	void testVerificandoCompraEnAutoCorrectoYLocalCorrecto() {
		assertEquals("LYK887", compraPuntual.getPatenteAuto());
		assertEquals("Maxikiosco Pepe", compraPuntual.getComercio());
	}
	
	@Test
	
	void testeoCantidadDeHorasPuntuales() {
		assertEquals(4, compraPuntual.getHoras());
	}
}
