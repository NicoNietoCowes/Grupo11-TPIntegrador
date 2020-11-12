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
		creditoEst -= this.costoActual(horaActual);
		vigencia = false;
	}

	/** Devuelve el costo en créditos de estacionamiento que tiene este estacionamiento 
	 * en un momento determinado. */
	public Integer costoActual(LocalTime horaConsulta) {
		return (int) (long) ChronoUnit.MINUTES.between(this.getHoraInicio(), horaConsulta);
	}
	
	@Override
	public Boolean estaVigente(LocalTime horaActual) {
		
		return vigencia && !this.excedeHoraFinal(horaActual);
	}

	private Boolean excedeHoraFinal(LocalTime horaActual) {
		
		return horaActual.isAfter(this.horaFin());
	}

	/** Devuelve la cantidad de horas que transcurrieron desde el inicio del estacionamiento
	 * hasta el momento en el que se le hace la consulta. */
	public Integer horasTranscurridas(LocalTime horaConsulta) {
		return (int) (long) ChronoUnit.HOURS.between(this.getHoraInicio(), horaConsulta);
	}

}
