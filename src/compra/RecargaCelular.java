package compra;

import java.time.chrono.ChronoLocalDate;

import appdelcelular.AppCelular;

public class RecargaCelular extends Compra {

	private String numeroCel;
	double monto;
	
	public RecargaCelular(int nroControl, ChronoLocalDate fechaYHora, String nombreComercio,
						  String numeroCel, double monto) {
		super(nroControl, fechaYHora, nombreComercio);
		this.numeroCel = numeroCel;
		this.monto = monto;
	}
	
	@Override
	public void realizarCompra(AppCelular celu) {
		celu.cargarCredito(monto);
		this.monto = 0;
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
