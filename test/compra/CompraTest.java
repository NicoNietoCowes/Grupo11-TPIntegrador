package compra;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;


public class CompraTest {

	//clases
	private Compra recarga = mock(RecargaCelular.class);
	private Compra horasPuntuales = mock(HorasPuntuales.class);
	
	//instancias
	private Compra recargando = new RecargaCelular(0, null, "1169540055", null, 200);
	private Compra compraPuntual = new HorasPuntuales(0, null, "LYK887", null, 4);
	
}
