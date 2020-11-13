package estacionamiento;

import java.time.LocalTime;

import compra.CompraHorasPuntuales;
import sistemaEstacionamientoMedido.SEM;
import zonaDeEstacionamiento.ZonaDeEstacionamiento;

public class EstCompraPuntual extends Estacionamiento {

	private Integer cantHoras;
	private CompraHorasPuntuales compraReferencia;
	
	public EstCompraPuntual(String pat, Integer horas, LocalTime horaIni, ZonaDeEstacionamiento zona, 
			SEM s, CompraHorasPuntuales compraRef) {
		super(pat, horaIni, zona, s);
		cantHoras = horas;
		compraReferencia = compraRef;
	}

	@Override
	public LocalTime horaFin() {
		LocalTime horaFin = this.getHoraInicio().plusHours(this.getCantHoras());
		return horaFin;
	}

	@Override
	public Boolean estaVigente(LocalTime horaActual) {
		return horaActual.isBefore(this.horaFin());
	}

	public Integer getCantHoras() {
		return cantHoras;
	}

	public CompraHorasPuntuales getCompraReferencia() {
		return this.compraReferencia;
	}
}
