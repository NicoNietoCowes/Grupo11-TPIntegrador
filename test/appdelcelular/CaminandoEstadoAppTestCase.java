package appdelcelular;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CaminandoEstadoAppTestCase {
	private AppCelular appRef = mock(AppCelular.class);
	private AppCelular appRef2 = mock(AppCelular.class);
	private EstadoApp caminando = new Caminando(appRef);
	
	@BeforeEach
	public void setUp() {
		// SetUp de las apps mockeadas
		when(appRef.tieneEstacionamientoAsociado()).thenReturn(true);
		when(appRef.seEncuentraEnLaZonaDeSuEstacionamiento()).thenReturn(true);
		
		when(appRef2.tieneEstacionamientoAsociado()).thenReturn(true);
		when(appRef2.seEncuentraEnLaZonaDeSuEstacionamiento()).thenReturn(false);
	}
	
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
	
	@Test
	void testInteraccionConLaApp2CuandoSeActualizaElEstadoAManejando() {
		caminando.setAppDeReferencia(appRef2);
		caminando.driving();
		verify(appRef2).tieneEstacionamientoAsociado();
		verify(appRef2).seEncuentraEnLaZonaDeSuEstacionamiento();
		/** En este caso solo le llegan los mensajes de consulta a la appRef2, pero como no cumple las condiciones
		 *  para un posibleFinDeEstacionamiento no se le manda nada. */
	}
	
}
