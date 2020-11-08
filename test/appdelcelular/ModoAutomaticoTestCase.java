package appdelcelular;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;

@SuppressWarnings("unused")
class ModoAutomaticoTestCase {
	private AppCelular appRef = mock(AppCelular.class);
	private ModoApp modoAutomatico = new ModoAutomatico(appRef);
	
	@Test
	void testPosibleInicioDeEstacionamiento() {
		modoAutomatico.posibleInicioDeEstacionamiento();
		verify(appRef).agregarNotificacion("Estás en modo automático por lo que se inicia un estacionamiento");
		verify(appRef).inicioDeEstacionamiento();
	}
	
	@Test
	void testPosibleFinDeEstacionamiento() {
		modoAutomatico.posibleFinDeEstacionamiento();
		verify(appRef).agregarNotificacion("Estás en modo automático por lo que se finaliza el estacionamiento vigente");
		verify(appRef).finDeEstacionamiento();
	}

}
