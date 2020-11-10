package compra;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class CompraTest {

	//clases
	private Compra recarga = mock(RecargaCelular.class);
	private Compra horasPuntuales = mock(HorasPuntuales.class);
	
	//instancias
	private Compra recargando = new RecargaCelular("1169540055", 200);
	private Compra compraPuntual = new HorasPuntuales("LYK887", 4);
	
}
