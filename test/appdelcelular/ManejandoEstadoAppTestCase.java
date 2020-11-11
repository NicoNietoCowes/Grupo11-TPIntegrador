package appdelcelular;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

class ManejandoEstadoAppTestCase {
	private AppCelular appRef = mock(AppCelular.class);
	private EstadoApp manejando = new Manejando(appRef);
	
	@Test
	void testGetApp() {
		assertEquals(appRef, manejando.getAppDeReferencia());
		// Corroboro que la app de referencia que tiene el estado es la pasada por parámetro.
	}
	
	@SuppressWarnings("deprecation")
	@Test
	void testNoPasaNadaCuandoElEstadoSigueSiendoManejando() {
		manejando.driving();
		verifyZeroInteractions(appRef);
		/** Como el estado ya es "manejando", cuando procesa el mensaje .driving no hace nada, por lo tanto 
		 * no interactúa en ningún punto con la app. */
	}
	
	@Test
	void testInteraccionConLaAppCuandoSeActualizaElEstadoACaminando() {
		manejando.walking();
		verify(appRef).posibleInicioDeEstacionamiento();
		/** Pasa lo mismo que con el test de Caminando, solo que en este caso corroboro que a la app le llegue el mensaje
		 * .posibleInicioDeEstacionamiento.  */
	}
	
}
