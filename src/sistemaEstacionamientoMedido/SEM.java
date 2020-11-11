package sistemaEstacionamientoMedido;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

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
	
	public Boolean tieneEstacionamientoVigente(String patente, Inspector inspector) {
		return true;
	}

	public void registrarInfraccion(Infraccion infraccion) {
		infracciones.add(infraccion);
	}

	public ArrayList<Infraccion> getInfracciones() {
		return infracciones;
	}

}
