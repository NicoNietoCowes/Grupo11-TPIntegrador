package estacionamiento;

import java.time.LocalTime;

import zonaDeEstacionamiento.ZonaDeEstacionamiento;

public class EstViaApp extends Estacionamiento {
	private String nroCelular;
	private double creditoEst;
	
	public EstViaApp(String patente, String celular, LocalTime horaInicio, ZonaDeEstacionamiento zona, double credito) {
		super(patente, horaInicio, zona);
		this.setNroCelular(celular);
		this.setCredito(credito);
	}

	private void setNroCelular(String nroCelu) {
		this.nroCelular = nroCelu;
	}
	
	private void setCredito(double credito) {
		this.creditoEst = credito;
	}

	@Override
	public LocalTime horaFin() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean estaVigente() {
		// TODO Auto-generated method stub
		return false;
	}

}
