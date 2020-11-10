package compra;

import appdelcelular.AppCelular;

public class RecargaCelular extends Compra {

	private String numeroCel;
	double monto;
	
	@Override
	public realizarCompra() {
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
