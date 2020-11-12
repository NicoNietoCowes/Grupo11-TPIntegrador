package compra;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

public class HorasPuntualesTest {

	//instancia mock
	private Compra horasPuntuales = mock(HorasPuntuales.class);
	
	//instancias
	private HorasPuntuales compraPuntual = new HorasPuntuales(0, null, "Ciber Soul", "LYK887", 4);
	

	@Test
	
	void testCompraEnLugarCorrecto() {
		assertEquals("Ciber Soul", compraPuntual.getComercio());
	}
	
	@Test
	
	void testComprueboCompraEnAutoCorrecto() {
		assertEquals("LYK887", compraPuntual.getPatenteAuto());
	}
}
