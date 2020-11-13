package zonaDeEstacionamiento;

import java.util.ArrayList;

import inspector.Inspector;
import puntoDeVenta.PuntoDeVenta;

public class ZonaDeEstacionamiento {

	private String nombre;
	private Inspector inspector;
	private ArrayList<PuntoDeVenta> puntosDeVenta = new ArrayList<PuntoDeVenta>();
	
	public ZonaDeEstacionamiento(String s, Inspector insp) {
		this.setNombre(s);
		inspector = insp;
	}

	public void añadirPuntoDeVenta(PuntoDeVenta pdv) {
		puntosDeVenta.add(pdv);		
	}

	public ArrayList<PuntoDeVenta> getPuntosDeVenta() {
		return puntosDeVenta;
	}

	public Inspector getInspector() {
		return inspector;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}