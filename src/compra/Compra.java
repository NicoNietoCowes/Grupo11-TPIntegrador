package compra;

import java.time.chrono.ChronoLocalDate;

import sistemaEstacionamientoMedido.SEM;

public class Compra extends puntoDeVenta.PuntoDeVenta {

	protected int nroControl;
	protected ChronoLocalDate fechaYHora;
	
	public Compra(int nroControl, ChronoLocalDate fechaYHora, String nombreComercio) {
		super(nombreComercio);
		this.fechaYHora = fechaYHora;
		this.nroControl = nroControl;
	}
	
	protected void realizarCompra() {
	 SEM.registrarCompra(this);
	}
	
	public void setNroControl(int nuevoNumero) {
		this.nroControl = nuevoNumero;
	}
	
	public void cambiarFechaYHora(ChronoLocalDate fechaYHoraNuevo) {
		this.fechaYHora = fechaYHoraNuevo;
	}
	
	public int getNroControl() {
		return nroControl;
	}
	
	public ChronoLocalDate getFechaYHora() {
		return fechaYHora;
	}
}
