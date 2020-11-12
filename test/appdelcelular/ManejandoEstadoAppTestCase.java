package appdelcelular;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ManejandoEstadoAppTestCase {
	private AppCelular appRef = mock(AppCelular.class);
	private AppCelular appRef2 = mock(AppCelular.class);
	private EstadoApp manejando = new Manejando(appRef);
	
	@BeforeEach
	public void setUp() {
		// SetUp de las apps mockeadas
		when(appRef.tieneEstacionamientoVigente()).thenReturn(false);
		when(appRef.seEncuentraEnZonaEst()).thenReturn(true);
		
		when(appRef2.tieneEstacionamientoVigente()).thenReturn(false);
		when(appRef2.seEncuentraEnZonaEst()).thenReturn(false);
	}
	
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
	
	@Test
	void testInteraccionConLaApp2CuandoSeActualizaElEstadoACaminando() {
		manejando.setAppDeReferencia(appRef2);
		manejando.walking();
		verify(appRef2).tieneEstacionamientoVigente();
		verify(appRef2).seEncuentraEnZonaEst();
		/** En este caso solo le llegan los mensajes de consulta a la appRef2, pero como no cumple las condiciones
		 *  para un posibleInicioDeEstacionamiento no se le manda nada. */
	}
	
}
