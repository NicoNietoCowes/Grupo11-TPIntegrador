package compra;


import java.time.LocalDateTime;

import appdelcelular.AppCelular;
import puntoDeVenta.PuntoDeVenta;
import sistemaEstacionamientoMedido.SEM;

public class RecargaCelular extends Compra {

	private String numeroCel;
	private Double monto;
	
	public RecargaCelular(Integer nroControl, LocalDateTime fechaYHora, PuntoDeVenta pdv,
						  String numeroCel, Double monto) {
		super(nroControl, fechaYHora, pdv);
		this.setNumeroCelular(numeroCel);
		this.setMonto(monto);
	}
	
	
	public String getNumeroCelular() {
		return numeroCel;
	}
	
	public void setNumeroCelular(String numero) {
		this.numeroCel = numero;
	}
	
	public double getMonto() {
		return monto;
	}
	
	public void setMonto(double nuevoMonto) {
		this.monto = nuevoMonto;
	}

	@Override
	protected void efectuarCompra() {
		// TODO Auto-generated method stub
		
	}
}
