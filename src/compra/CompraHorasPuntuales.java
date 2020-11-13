package compra;

import java.time.LocalDateTime;

import estacionamiento.EstCompraPuntual;
import puntoDeVenta.PuntoDeVenta;

public class CompraHorasPuntuales extends Compra {
	
	private String patente;
	private Integer cantHoras;
	
	public CompraHorasPuntuales(Integer nroControl, LocalDateTime fechaYHora, String patente, Integer cantHoras, PuntoDeVenta pdv) {
		super(nroControl, fechaYHora, pdv);
		this.setPatente(patente);
		this.setCantidadDeHoras(cantHoras);
	}

	public void setPatente(String pat) {
		patente = pat;
	}
	
	public void setCantidadDeHoras(Integer horas) {
		cantHoras = horas;
	}
	
	public Integer getCantidadDeHoras() {
		return cantHoras;
	}
	
	public String getPatente() {
		return patente;
	}

	public EstCompraPuntual getEstacionamiento() {
		EstCompraPuntual estacionamiento = 
				new EstCompraPuntual(this.getPatente(), this.getCantidadDeHoras(), this.getFechaYHora().toLocalTime(), 
						getPuntoDeVenta().getZonaDeEstacionamiento(), this.getPuntoDeVenta().getSEM(), this);
		return estacionamiento;
	}

	@Override
	public void efectuarCompra() {
		this.getPuntoDeVenta().getSEM().registrarEstacionamiento(this.getEstacionamiento());
		
	}


}
