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
		// Corroboro que la app de referencia que tiene el estado es la pasada por parámetro.
	}
	
	@SuppressWarnings("deprecation")
	@Test
	void testNoPasaNadaCuandoElEstadoSigueSiendoCaminando() {
		caminando.walking();
		verifyZeroInteractions(appRef);
		/** Como el estado ya es "caminando", cuando procesa el mensaje .walking no hace nada, por lo tanto 
		 * no interactúa en ningún punto con la app. */
	}
	
	@Test
	void testInteraccionConLaAppCuandoSeActualizaElEstadoAManejando() {
		caminando.driving();
		verify(appRef).posibleFinDeEstacionamiento();
		/** Cuando el estado "caminando" procesa el mensaje .driving corroboro que la app de referencia 
		 * recibe el mensaje .posibleFinDeEstacionamiento. Además, el estado de la app se modifica, no tengo forma de referenciar
		 * este nuevo estado que va a ser del tipo EstadoApp, especificamente Manejando (no se me ocurre como hacerlo con mocks, pero
		 * el .cambiarEstado(nuevoEstado) de la app está testeado en la app propiamente). */
	}
	
}
