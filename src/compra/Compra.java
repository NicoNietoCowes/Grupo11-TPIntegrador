package compra;

import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;

import puntoDeVenta.PuntoDeVenta;
import sistemaEstacionamientoMedido.SEM;

public abstract class Compra {

	private Integer nroControl;
	private LocalDateTime fechaYHora;
	private PuntoDeVenta puntoDeVenta;
	
	public Compra(Integer nroControl, LocalDateTime fechaYHora, PuntoDeVenta pdv) {
		this.setNroControl(nroControl);
		this.setFechaYHora(fechaYHora);
		this.setPuntoDeVenta(pdv);
	}
	
	public void setNroControl(Integer numero) {
		nroControl = numero;
	}
	
	public void setFechaYHora(LocalDateTime fyh) {
		fechaYHora = fyh;
	}
	
	private void setPuntoDeVenta(PuntoDeVenta pdv) {
		puntoDeVenta = pdv;	
	}
	
	public Integer getNroControl() {
		return nroControl;
	}
	
	public LocalDateTime getFechaYHora() {
		return fechaYHora;
	}
	
	public PuntoDeVenta getPuntoDeVenta() {
		return puntoDeVenta;
	}

	protected abstract void efectuarCompra();
}
