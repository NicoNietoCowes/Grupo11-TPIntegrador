package appdelcelular;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import estacionamiento.EstViaApp;
import sistemaEstacionamientoMedido.SEM;
import zonaDeEstacionamiento.ZonaDeEstacionamiento;

class AppCelularTestCase {
	private ModoApp manual = mock(ModoManual.class);
	private ModoApp automatico = mock(ModoAutomatico.class);
	private EstadoApp manejando = mock(Manejando.class);
	private EstadoApp caminando = mock(Caminando.class);
	private SEM sem = mock(SEM.class);
	private EstViaApp estacionamientoApp = mock(EstViaApp.class);
	private AppCelular app = new AppCelular("1130949597", "MYX520", manual, sem);
	private ZonaDeEstacionamiento zona1 = mock(ZonaDeEstacionamiento.class);
	private ZonaDeEstacionamiento zona2 = mock(ZonaDeEstacionamiento.class);
	
	@BeforeEach
	public void setUp() {
		app.cambiarEstado(manejando);
		
		// SetUp del estacionamientoApp mockeado:
		when(estacionamientoApp.getZona()).thenReturn(zona1);
		when(sem.getFinFranjaHoraria()).thenReturn(LocalTime.of(20, 00));
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
		assertEquals(0, app.getCreditoDisponible());
		app.cargarCredito(400);
		assertEquals(400, app.getCreditoDisponible());
	}
	
	@Test
	void testConsultaCredito() {
		app.cargarCredito(40);
		assertEquals("Este celular (1130949597) cuenta con 40 créditos de estacionamiento", app.consultaDeSaldo());
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
	
	@Test
	void testGetEstado() {
		assertEquals(manejando, app.getEstado());
	}
	
	@Test
	void testCambioDeEstado() {
		app.cambiarEstado(caminando);
		assertEquals(caminando, app.getEstado());
	}
	
	@Test
	void testInicioDeEstacionamientoSinCredito() {
		assertEquals("Saldo insuficiente. Estacionamiento no permitido", app.inicioDeEstacionamiento(LocalTime.of(18, 00)));
	}
	
	@Test
	void testInicioDeEstacionamientoConCredito() {
		app.cargarCredito(120);
		assertEquals("¡Estacionamiento iniciado! Hora de comienzo: 11:00, Hora máxima de finalización: 13:00", app.inicioDeEstacionamiento(LocalTime.of(11, 00)));
	}
	
	@Test
	void testInicioDeEstacionamientoConCreditoPasandoLaFranjaHoraria() {
		app.cargarCredito(120);
		assertEquals("¡Estacionamiento iniciado! Hora de comienzo: 19:30, Hora máxima de finalización: 20:00", app.inicioDeEstacionamiento(LocalTime.of(19, 30)));
	}
	
	@Test
	void testFinDeEstacionamiento() {
		app.asociarEstacionamiento(estacionamientoApp);
		app.finDeEstacionamiento(LocalTime.of(17, 00));
		verify(estacionamientoApp).finalizarEstacionamiento(LocalTime.of(17, 00));
		verify(estacionamientoApp).getHoraInicio();
		verify(estacionamientoApp).horasTranscurridas(LocalTime.of(17, 00));
		verify(estacionamientoApp).costoActual(LocalTime.of(17, 00));
	}
	
	@Test
	void testCambioDeLocalizacionAZonaDeEst() {
		assertFalse(app.seEncuentraEnZonaEst());
		app.actualizarLocalizacion(zona1);
		assertTrue(app.seEncuentraEnZonaEst());
	}
	
	@Test 
	void testTieneEstacionamientoAsociado() {
		assertFalse(app.tieneEstacionamientoAsociado());
		app.asociarEstacionamiento(estacionamientoApp);
		assertTrue(app.tieneEstacionamientoAsociado());
	}
	
	@Test
	void getEstacionamiento() {
		app.asociarEstacionamiento(estacionamientoApp);
		assertEquals(estacionamientoApp, app.getEstacionamiento());
	}
	
	@Test
	void testSeEncuentraEnlaMismaZonaQueEstacionó() {
		app.actualizarLocalizacion(zona1);
		app.asociarEstacionamiento(estacionamientoApp);
		assertTrue(app.seEncuentraEnLaZonaDeSuEstacionamiento());
	}
	
	@Test
	void testNoSeEncuentraEnlaMismaZonaQueEstacionó() {
		app.actualizarLocalizacion(zona2);
		app.asociarEstacionamiento(estacionamientoApp);
		assertFalse(app.seEncuentraEnLaZonaDeSuEstacionamiento());
	}
	
}
