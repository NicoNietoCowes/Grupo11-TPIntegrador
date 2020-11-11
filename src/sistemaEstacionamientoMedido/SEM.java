package sistemaEstacionamientoMedido;

import java.time.LocalDateTime;
import java.util.ArrayList;

import infraccion.Infraccion;
import inspector.Inspector;

public class SEM {

	private ArrayList<Infraccion> infracciones = new ArrayList<Infraccion>();
	
	public Boolean consultarEstacionamientoVigente(String patente, Inspector inspector) {
		return true;
		
	}

	public void emitirAltaDeInfraccion(String patente, Inspector inspector, LocalDateTime fechaYHora) {
		Infraccion infraccion = new Infraccion(patente, fechaYHora, inspector);
		infracciones.add(infraccion);
	}
	

}
