package compra;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;


public class RecargaCelularTest {

	//instancia mock
	private Compra recarga = mock(RecargaCelular.class);
	
	//instancias
	private RecargaCelular recargando = new RecargaCelular(0, null, "Desde App", "1169540055", 200);
	
	
	@Test
	void testeoQueRecargoDelCelu() {
		assertEquals("Desde App", recargando.getComercio());
	}

	@Test
	void testeoCargaCorrectamenteConElnumero() {
		assertEquals("1169540055",recargando.getNumeroCelular());
	}
	
	@Test
	void testeoCargaDeMontoCorrecta() {
		assertEquals(200, recargando.getMonto());
	}
}
