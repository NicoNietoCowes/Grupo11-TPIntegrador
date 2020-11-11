package inspector;

import java.time.LocalDateTime;

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

	public void consultarEstacionamientoVigente(String patente, SEM sem) {
		sem.consultarEstacionamientoVigente(patente, this);	
	}

	public void emitirAltaDeInfraccion(String patente, SEM sem, LocalDateTime fechaYHora) {
		if (sem.consultarEstacionamientoVigente(patente, this) == false) {
			sem.emitirAltaDeInfraccion(patente, this, fechaYHora);
		}
	}
}
