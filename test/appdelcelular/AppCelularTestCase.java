package appdelcelular;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AppCelularTestCase {
	private ModoApp manual = mock(ModoManual.class);
	private ModoApp automatico = mock(ModoAutomatico.class);
	private EstadoApp manejando = mock(Manejando.class);
	private AppCelular app = new AppCelular("1130949597", "MYX520", manual);
	
	@BeforeEach
	public void setUp() {
		app.cambiarEstado(manejando);
	}
	
	@Test
	void testGettersBasicosAppNroCelular() {
		assertEquals("1130949597", app.getNumeroCel());
	}

	@Test
	void testGettersBasicosAppPatente() {
		assertEquals("MYX520", app.getPatente());
	}
	
	@Test
	void testCargaDeCredito() {
		assertEquals(0d, app.getCreditoDisponible());
		app.cargarCredito(400d);
		assertEquals(400d, app.getCreditoDisponible());
	}
	
	@Test
	void testConsultaCredito() {
		app.cargarCredito(40d);
		assertEquals("El crédito de estacionamiento disponible para este celular (1130949597) es de $40.0", app.consultaDeSaldo());
	}
	
	@Test
	void testGetModoApp() {
		assertEquals(manual, app.getModoApp());
	}
	
	@Test
	void testCambioDeModo() {
		app.cambiarModo(automatico);
		assertEquals(automatico, app.getModoApp());
	}
	
	@Test 
	void testManejoNotificacionesCon1Notificacion() {
		app.agregarNotificacion("NotificacionDePrueba");
		assertEquals("NotificacionDePrueba", app.getUltimaNotificacion());
	}
	
	@Test 
	void testManejoNotificacionesCon2Notificaciones() {
		app.agregarNotificacion("NotificacionDePrueba");
		app.agregarNotificacion("NotificacionDePrueba2");
		assertEquals("NotificacionDePrueba2", app.getUltimaNotificacion());
	}
	
	@Test
	void testEliminadoDeNotificaciones() {
		app.agregarNotificacion("NotificacionDePrueba");
		app.agregarNotificacion("NotificacionDePrueba2");
		assertEquals(2, app.getNotificaciones().size());
		app.borrarNotificaciones();
		assertEquals(0, app.getNotificaciones().size());
	}
	
	@Test
	void testEnvioDeMensajePosibleInicioEst() {
		app.posibleInicioDeEstacionamiento();
		verify(manual).posibleInicioDeEstacionamiento();
	}
	
	@Test
	void testEnvioDeMensajePosibleFinEst() {
		app.posibleFinDeEstacionamiento();
		verify(manual).posibleFinDeEstacionamiento();
	}
	
	@Test
	void testGetEstadoAppLuegoDeCambiarlo() {
		assertEquals(manejando, app.getEstado());
	}
	
	@Test
	void testDriving() {
		app.driving();
		verify(manejando).driving();
	}
	
	@Test
	void testWalking() {
		app.walking();
		verify(manejando).walking();
	}
	
	
	/** TESTS INCOMPLETOS, FALTAN IMPLEMENTAR LOS ESTACIONAMIENTOS */
	@Test
	void testInicioDeEstacionamientoSinCredito() {
		assertEquals("Saldo insuficiente. Estacionamiento no permitido", app.inicioDeEstacionamiento());
	}
	
	@Test
	void testInicioDeEstacionamientoConCredito() {
		app.cargarCredito(400d);
		assertEquals("Datos relevantes con respecto al estacionamiento generado", app.inicioDeEstacionamiento());
	}
	
	@Test
	void testFinDeEstacionamiento() {
		assertEquals("combinacion de atributos correspondientes al estacionamiento", app.finDeEstacionamiento());
	}
}
