package estacionamiento;

import java.time.LocalTime;

import zonaDeEstacionamiento.ZonaDeEstacionamiento;

public abstract class Estacionamiento {
	private String patente;
	private LocalTime horaInicio;
	private ZonaDeEstacionamiento zona;
	
	public Estacionamiento(String patente, LocalTime horaInicio, ZonaDeEstacionamiento zona) {
		this.setPatente(patente);
		this.setHoraInicio(horaInicio);
		this.setZonaEst(zona);
	}
	
	private void setHoraInicio(LocalTime horaInicio) {
		this.horaInicio = horaInicio;
	}
	
	public LocalTime getHoraInicio() {
		return this.horaInicio;
	}

	private void setPatente(String patente) {
		this.patente = patente;
	}
	
	public String getPatente() {
		return this.patente;
	}
	
	private void setZonaEst(ZonaDeEstacionamiento zona) {
		this.zona = zona;
	}

	public ZonaDeEstacionamiento getZona() {
		return this.zona;
	}
	
	public abstract LocalTime horaFin();
	
	public abstract boolean estaVigente();
}
