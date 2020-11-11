package compra;

import static org.mockito.Mockito.*;
import java.time.chrono.ChronoLocalDate;
import static org.junit.jupiter.api.Assertions.*;

import appdelcelular.AppCelular;

public class RecargaCelular extends Compra {

	private String numeroCel;
	private double monto;
	
	public RecargaCelular(int nroControl, ChronoLocalDate fechaYHora, String nombreComercio,
						  String numeroCel, double monto) {
		super(nroControl, fechaYHora, nombreComercio);
		this.cambiarNumeroCelu(numeroCel);
		this.cambiaMonto(monto);
	}
	
	@Override
	public void realizarCompra() {
		RecargaCelular recarga = new RecargaCelular(nroControl, fechaYHora, numeroCel, numeroCel, monto);
		this.cambiaMonto(0);
		//hay que elevarlo a la superclase
	}
	
	public String getNumeroCelular() {
		return numeroCel;
	}
	
	public void cambiarNumeroCelu(String nuevoNumero) {
		this.numeroCel = nuevoNumero;
	}
	
	public double getMonto() {
		return monto;
	}
	
	public void cambiaMonto(double nuevoMonto) {
		this.monto = nuevoMonto;
	}
}
