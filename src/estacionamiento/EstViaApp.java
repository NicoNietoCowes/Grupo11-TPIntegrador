package estacionamiento;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import sistemaEstacionamientoMedido.SEM;
import zonaDeEstacionamiento.ZonaDeEstacionamiento;

public class EstViaApp extends Estacionamiento {
	private String nroCelular;
	private Integer creditoEst;
	private Boolean vigencia;
	
	public EstViaApp(String patente, String celular, LocalTime horaInicio, ZonaDeEstacionamiento zona, Integer credito, SEM sem) {
		super(patente, horaInicio, zona, sem);
		this.setNroCelular(celular);
		this.setCredito(credito);
		vigencia = true;
	}

	private void setNroCelular(String nroCelu) {
		this.nroCelular = nroCelu;
	}
	
	private void setCredito(Integer credito) {
		this.creditoEst = credito;
	}
	
	@Override
	public LocalTime horaFin() {
		LocalTime horaCalculada = this.getHoraInicio().plusMinutes(creditoEst);
		LocalTime horaMaxima;
		if (horaCalculada.isAfter(this.getSEM().getFinFranjaHoraria())) {
			horaMaxima = this.getSEM().getFinFranjaHoraria();
		}
		else horaMaxima = horaCalculada;
		return horaMaxima;
	}

	public String getNroCelular() {
		return this.nroCelular;
	}

	public void finalizarEstacionamiento(LocalTime horaActual) {
		Integer i = (int) (long) ChronoUnit.MINUTES.between(this.getHoraInicio(), horaActual);
		creditoEst -= i;
		vigencia = false;
	}

	@Override
	public Boolean estaVigente(LocalTime horaActual) {
		
		return vigencia && !this.excedeHoraFinal(horaActual);
	}

	private Boolean excedeHoraFinal(LocalTime horaActual) {
		
		return horaActual.isAfter(this.horaFin());
	}

}
