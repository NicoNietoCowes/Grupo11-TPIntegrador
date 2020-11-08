package appdelcelular;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

@SuppressWarnings("unused")
class ManejandoEstadoAppTestCase {
	private AppCelular appRef = mock(AppCelular.class);
	private EstadoApp manejando = new Manejando(appRef);
	
	@SuppressWarnings("deprecation")
	@Test
	void testNoPasaNadaCuandoElEstadoSigueSiendoManejando() {
		manejando.driving();
		verifyZeroInteractions(appRef);
	}
	
	@Test
	void testInteraccionConLaAppCuandoSeActualizaElEstadoACaminando() {
		manejando.walking();
		verify(appRef).posibleInicioDeEstacionamiento();
		// TODO: como puedo testear la interaccion con el cambio de estado si no tengo referencia a la nueva instancia de EstadoApp que se genera?
	}
	
}
