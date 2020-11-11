package sistemaEstacionamientoMedido;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import compra.Compra;
import estacionamiento.Estacionamiento;
import infraccion.Infraccion;
import inspector.Inspector;
import zonaDeEstacionamiento.ZonaDeEstacionamiento;

public class SEM {

	private LocalTime comienzoFranjaHoraria;
	private LocalTime finFranjaHoraria;
	private Double precioPorHora;
	private ArrayList<Infraccion> infracciones;
	private ArrayList<ZonaDeEstacionamiento> zonasDeEstacionamiento;
	private ArrayList<Compra> compras;
	private ArrayList<Estacionamiento> estacionamientos;
	
	
	public SEM(LocalTime cfh, LocalTime ffh, Double p) {
		comienzoFranjaHoraria = cfh;
		finFranjaHoraria = ffh;
		precioPorHora = p;
		infracciones = new ArrayList<Infraccion>();
		zonasDeEstacionamiento = new ArrayList<ZonaDeEstacionamiento>();
		compras = new ArrayList<Compra>();
		estacionamientos = new ArrayList<Estacionamiento>();
		
	}

	public void registrarCompra(Compra compra) {
		compras.add(compra);
	}

	public LocalTime getComienzoFranjaHoraria() {
		return comienzoFranjaHoraria;
	}

	public LocalTime getFinFranjaHoraria() {
		return finFranjaHoraria;
	}

	public Double getPrecioPorHora() {
		return precioPorHora;
	}
	
	public Boolean tieneEstacionamientoVigente(String patente, Inspector inspector, LocalTime horaDeConsulta) {
		List<Estacionamiento> estacionamientosZonaInspector = 
				estacionamientos.stream().filter(estacionamiento -> estacionamiento.getZona() == inspector.getZonaACargo()).collect(Collectors.toList());
		// Se filtran los estacionamientos que corresponden a la zona que tiene el inspector a cargo.
		return estacionamientosZonaInspector.stream().anyMatch(estacionamiento -> estacionamiento.getPatente() == patente)
				&& estacionamientosZonaInspector.stream().filter(estacionamiento -> estacionamiento.getPatente() == patente).collect(Collectors.toList()).get(0).estaVigente(horaDeConsulta);
		/** Se controlan los dos casos, uno en el que la patente de un auto no tenga estacionamientos registrados en el SEM, y otro en el que si lo tiene
		 * pero debe responder si está vigente en el horario en el que el inspector consultó. */
	}
	
	public void registrarInfraccion(Infraccion infraccion) {
		infracciones.add(infraccion);
	}

	public ArrayList<Infraccion> getInfracciones() {
		return infracciones;
	}

	public void registrarEstacionamiento(Estacionamiento estacionamiento) {
		this.estacionamientos.add(estacionamiento);		
	}

	public ArrayList<Compra> getCompras() {
		return this.compras;
	}

}
