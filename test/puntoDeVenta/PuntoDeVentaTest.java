package puntoDeVenta;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import compra.Compra;
import compra.HorasPuntuales;
import compra.RecargaCelular;
import zonaDeEstacionamiento.ZonaDeEstacionamiento;

public class PuntoDeVentaTest {

	//clase mock
	private PuntoDeVenta puntoDeV = mock(PuntoDeVenta.class);
	
	//instancias
	private PuntoDeVenta lugar = new PuntoDeVenta("Maxikiosco Pepe");
	private RecargaCelular recargando = new RecargaCelular(1, null, "ciber","1169540055", 200);
	
	
	@Test
	void testeandoNombreLocal() {
		assertEquals(lugar.getComercio(), "Maxikiosco Pepe");
	}

	@Test
	void testeandoLaRecargaSiEsEnMismoLugar() {
		assertEquals(recargando.getComercio(), "ciber");
	}
	
	@Test
	void testeandoCantidadDeRecarga() {
		assertEquals(recargando.getMonto(), 200);
	}
	
	@Test
	void testQuePasaSiCambioLugarDeRecarga() {
		assertEquals(lugar.getComercio(), "Maxikiosco Pepe");
		lugar.setComercio("ciber");
		assertEquals(lugar.getComercio(), "ciber");
	}
	
	@Test
	void testeandoPuntoDeV() {
		puntoDeV.setComercio("ciber soul");
		puntoDeV.setComercio(null);
		assertEquals(puntoDeV.getComercio(), null);
	}
}