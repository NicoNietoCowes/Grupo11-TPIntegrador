package inspector;

import java.time.LocalDateTime;
import java.time.LocalTime;

import infraccion.Infraccion;
import sistemaEstacionamientoMedido.SEM;
import zonaDeEstacionamiento.ZonaDeEstacionamiento;

public class Inspector {
	
	private String nombre;
	private String matricula;
	private ZonaDeEstacionamiento zonaACargo;
	
	/** Constructor de un Inspector, se necesita un String representando nombre, un String representando nro de matrícula
	 * y la ZonaDeEstacionamiento que tiene a cargo. */
	public Inspector(String n, String m, ZonaDeEstacionamiento zona) {
		nombre = n;
		matricula = m;
		zonaACargo = zona; 
	}

	public String getNombre() {
		return nombre;
	}

	public String getMatricula() {
		return matricula;
	}

	public ZonaDeEstacionamiento getZonaACargo() {
		return zonaACargo;
	}

	/** Consulta en el SEM si hay un estacionamiento con la patente indicada que se encuentra
	 * vigente a la hora de la consulta. */
	public Boolean tieneEstacionamientoVigente(String patente, SEM sem, LocalTime horaConsulta) {
		return sem.tieneEstacionamientoVigente(patente, this, horaConsulta);	
	}

	/** Si la consulta por vigencia de estacionamiento de la patente indicada devuelve false entonces se 
	 * da de alta una nueva infraccion con los datos correspondientes a esa patente y se envia al SEM para
	 * que sea registrada. */
	public void emitirAltaDeInfraccion(String patente, SEM sem, LocalDateTime fechaYHora) {
		if (! this.tieneEstacionamientoVigente(patente, sem, fechaYHora.toLocalTime())) {
			Infraccion infraccion = new Infraccion(patente, fechaYHora, this);
			sem.registrarInfraccion(infraccion);
		}
	}
}
