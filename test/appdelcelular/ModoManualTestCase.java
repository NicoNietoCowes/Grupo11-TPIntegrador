package appdelcelular;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

@SuppressWarnings("unused")
class ModoManualTestCase {
	private AppCelular appRef = mock(AppCelular.class);
	private ModoApp modoManual = new ModoManual(appRef);
	
	@Test
	void testPosibleInicioDeEstacionamiento() {
		modoManual.posibleInicioDeEstacionamiento();
		verify(appRef).agregarNotificacion("Posible inicio de estacionamiento");
	}
	
	@Test
	void testPosibleFinDeEstacionamiento() {
		modoManual.posibleFinDeEstacionamiento();
		verify(appRef).agregarNotificacion("Posible fin de estacionamiento");
	}
	
}
