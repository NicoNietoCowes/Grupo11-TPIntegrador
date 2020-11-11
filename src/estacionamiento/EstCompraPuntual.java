package estacionamiento;

import java.time.LocalTime;

import sistemaEstacionamientoMedido.SEM;
import zonaDeEstacionamiento.ZonaDeEstacionamiento;

public class EstCompraPuntual extends Estacionamiento {

	private String patente;
	private Integer cantHoras;
	private LocalTime HoraInicio;
	private ZonaDeEstacionamiento zonaEst;
	private SEM sem;
	
	public EstCompraPuntual(String pat, Integer horas, LocalTime horaIni, ZonaDeEstacionamiento zona, SEM s) {
		super(pat, horaIni, zona, s);
		cantHoras = horas;
	}

	@Override
	public LocalTime horaFin() {
		LocalTime horaFin = this.getHoraInicio().plusHours(this.getCantHoras());
		
		return horaFin;
	}

	@Override
	public boolean estaVigente(LocalTime horaActual) {
		return horaActual.isBefore(this.horaFin());
	}

	public Integer getCantHoras() {
		return cantHoras;
	}

}
