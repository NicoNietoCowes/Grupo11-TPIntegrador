package estacionamiento;

import java.time.LocalTime;

import sistemaEstacionamientoMedido.SEM;
import zonaDeEstacionamiento.ZonaDeEstacionamiento;

public abstract class Estacionamiento {
	private String patente;
	private LocalTime horaInicio;
	private ZonaDeEstacionamiento zona;
	private SEM sem;
	
	public Estacionamiento(String patente, LocalTime horaInicio, ZonaDeEstacionamiento zona, SEM sem) {
		this.setPatente(patente);
		this.setHoraInicio(horaInicio);
		this.setZonaEst(zona);
		this.setSEM(sem);
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
	
	private void setSEM(SEM sem) {
		this.sem = sem;
	}
	
	public SEM getSEM() {
		return this.sem;
	}

	public ZonaDeEstacionamiento getZona() {
		return this.zona;
	}
	
	public abstract LocalTime horaFin();
	
	public abstract boolean estaVigente(LocalTime horaActual);
}
