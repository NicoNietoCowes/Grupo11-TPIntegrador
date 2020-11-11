package estacionamiento;

import java.time.LocalTime;

import sistemaEstacionamientoMedido.SEM;
import zonaDeEstacionamiento.ZonaDeEstacionamiento;

public class EstViaApp extends Estacionamiento {
	private String nroCelular;
	private Integer creditoEst;
	
	public EstViaApp(String patente, String celular, LocalTime horaInicio, ZonaDeEstacionamiento zona, Integer credito, SEM sem) {
		super(patente, horaInicio, zona, sem);
		this.setNroCelular(celular);
		this.setCredito(credito);
	}

	private void setNroCelular(String nroCelu) {
		this.nroCelular = nroCelu;
	}
	
	private void setCredito(Integer credito) {
		this.creditoEst = credito;
	}
	
	@Override
	public LocalTime horaFin() {
		
		return null;
	}

	@Override
	public Boolean estaVigente() {
		// TODO Auto-generated method stub
		return false;
	}

	public String getNroCelular() {
		return this.nroCelular;
	}

}
