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

	public Boolean tieneEstacionamientoVigente(String patente, SEM sem, LocalTime horaConsulta) {
		return sem.tieneEstacionamientoVigente(patente, this, horaConsulta);	
	}

	public void emitirAltaDeInfraccion(String patente, SEM sem, LocalDateTime fechaYHora) {
		if (! this.tieneEstacionamientoVigente(patente, sem, fechaYHora.toLocalTime())) {
			Infraccion infraccion = new Infraccion(patente, fechaYHora, this);
			sem.registrarInfraccion(infraccion);
		}
	}
}
