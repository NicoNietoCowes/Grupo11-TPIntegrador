package infraccion;

import java.time.LocalDateTime;

import inspector.Inspector;

public class Infraccion {
	
	private LocalDateTime fechaYHora;
	private Inspector inspector;
	private String patente;
	
	/** Constructor de Infracción, se indica un String representando la patente, LocalDateTime representando la fecha y 
	 * la hora en la que se declara y el Inspector que la declaró. */
	public Infraccion(String pat, LocalDateTime fyh, Inspector insp) {
		patente = pat;
		fechaYHora = fyh;
		inspector = insp;
	}


	public String getPatente() {
		return patente;
	}


	public LocalDateTime getFechaYHora() {
		return fechaYHora;
	}


	public Inspector getInspector() {
		return inspector;
	}

}
