package compra;


import java.time.LocalDateTime;

import appdelcelular.AppCelular;
import puntoDeVenta.PuntoDeVenta;
import sistemaEstacionamientoMedido.SEM;

public class RecargaCelular extends Compra {

	private String numeroCel;
	private Double monto;
	private AppCelular appCel;
	
	public RecargaCelular(Integer nroControl, LocalDateTime fechaYHora, PuntoDeVenta pdv,
						  String numeroCel, Double monto, AppCelular app) {
		super(nroControl, fechaYHora, pdv);
		this.setNumeroCelular(numeroCel);
		this.setMonto(monto);
		this.setApp(app);
	}
	
	
	private void setApp(AppCelular app) {
		appCel = app;
	}


	public AppCelular getApp() {
		return appCel;
	}
	
	public String getNumeroCelular() {
		return numeroCel;
	}
	
	private void setNumeroCelular(String numero) {
		numeroCel = numero;
	}
	
	public Double getMonto() {
		return monto;
	}
	
	private void setMonto(Double m) {
		monto = m;
	}

	@Override
	public void efectuarCompra() {
		
		appCel.cargarCredito(this.calcularCredito());
		
	}
	
	public Integer calcularCredito() {
		Double precioPorHoraDelSem = this.getPuntoDeVenta().getSEM().getPrecioPorHora(); 
		Double creditoACargar = (monto * 60) / precioPorHoraDelSem;
		Integer c = new Integer(creditoACargar.intValue());
		return c;
	}


}
