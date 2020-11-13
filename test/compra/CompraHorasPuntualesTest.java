package compra;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;
import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sistemaEstacionamientoMedido.SEM;
import puntoDeVenta.PuntoDeVenta;

public class CompraHorasPuntualesTest {

	private CompraHorasPuntuales compraHorasPuntuales;
	private PuntoDeVenta puntoDeVenta = mock(PuntoDeVenta.class);
	private SEM sem;

	@BeforeEach
	void setUp() throws Exception {
		compraHorasPuntuales = new CompraHorasPuntuales(123, LocalDateTime.of(2020, 11, 12, 15, 00), "ABC123", 3, puntoDeVenta);
		sem = new SEM(LocalTime.of(07,00), LocalTime.of(20,00), 40.00);
		when(puntoDeVenta.getSEM()).thenReturn(sem);
	}
	
	@Test
	void testGetNroControl() {
		assertEquals(123, compraHorasPuntuales.getNroControl());
	}
	
	@Test
	void testGetFechaYHora() {
		assertEquals(LocalDateTime.of(2020, 11, 12, 15, 00), compraHorasPuntuales.getFechaYHora());
	}
	
	@Test
	void testGetPatente() {
		assertEquals("ABC123", compraHorasPuntuales.getPatente());
	}
	
	@Test
	void testGetCantidadDeHorasCompradas() {
		assertEquals(3, compraHorasPuntuales.getCantidadDeHoras());
	}
	
	@Test
	void testGetPuntoDeVenta() {
		assertEquals(puntoDeVenta, compraHorasPuntuales.getPuntoDeVenta());
	}
	
	
	@Test
	void testEfectuarCompra() {
		compraHorasPuntuales.efectuarCompra();
		assertEquals(1, sem.getEstacionamientos().size());
	}
	
}
