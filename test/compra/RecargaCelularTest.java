package compra;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;
import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import appdelcelular.AppCelular;
import estacionamiento.EstCompraPuntual;
import sistemaEstacionamientoMedido.SEM;
import puntoDeVenta.PuntoDeVenta;


public class RecargaCelularTest {

	private RecargaCelular recargaCel;
	private PuntoDeVenta puntoDeVenta = mock(PuntoDeVenta.class);
	private AppCelular app = mock(AppCelular.class);
	private SEM sem = mock(SEM.class);
	
	
	@BeforeEach
	void setUp() throws Exception {
		recargaCel = new RecargaCelular(123, LocalDateTime.of(2020, 11, 12, 15, 00), puntoDeVenta, "123456789", 80.5, app);
		when(puntoDeVenta.getSEM()).thenReturn(sem);
		when(sem.getPrecioPorHora()).thenReturn(40.00);
	}
	

	@Test
	void testGetNumeroCelular() {
		assertEquals("123456789",recargaCel.getNumeroCelular());
	}
	
	@Test
	void testGetMonto() {
		assertEquals(80.5, recargaCel.getMonto());
	}
	
	@Test
	void testGetApp() {
		assertEquals(app, recargaCel.getApp());
	}
	
	@Test
	void testCalcularCredito() {
		assertEquals(120, recargaCel.calcularCredito());
	}
	
	@Test
	void testeEfectuarCompra() {
		recargaCel.efectuarCompra();
		verify(app).cargarCredito(recargaCel.calcularCredito());
	}
	
}
