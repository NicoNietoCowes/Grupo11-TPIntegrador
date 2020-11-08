package appdelcelular;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

class CaminandoEstadoAppTestCase {
	private AppCelular appRef = mock(AppCelular.class);
	private EstadoApp caminando = new Caminando(appRef);
	
	@Test
	void testGetApp() {
		assertEquals(appRef, caminando.getAppDeReferencia());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	void testNoPasaNadaCuandoElEstadoSigueSiendoCaminando() {
		caminando.walking();
		verifyZeroInteractions(appRef);
	}
	
	@Test
	void testInteraccionConLaAppCuandoSeActualizaElEstadoAManejando() {
		caminando.driving();
		verify(appRef).posibleFinDeEstacionamiento();
		// TODO: como puedo testear la interaccion con el cambio de estado si no tengo referencia a la nueva instancia de EstadoApp que se genera?
	}
	
}
