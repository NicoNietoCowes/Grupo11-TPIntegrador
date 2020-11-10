package compra;

import java.time.chrono.ChronoLocalDate;

public class HorasPuntuales extends Compra {
	
	private String patenteAuto;
	private int cantHoras;
	
	public HorasPuntuales(int nroControl, ChronoLocalDate fechaYHora, String nombreComercio,
			               String patenteAuto, int cantHoras) {
		super(nroControl, fechaYHora, nombreComercio);
		this.cambioPatente(patenteAuto);
		this.setHoras(cantHoras);
	}
	
	@Override
	public void realizarCompra() {
		public HorasPuntuales HPuntuales = new HorasPuntuales(patenteAuto, cantHoras);
		SEM.registrarCompra(HPuntuales);
	}
	
	public String getPatenteAuto() {
		return patenteAuto;
	}
	
	public void cambioPatente(String patenteNueva) {
		this.patenteAuto = patenteNueva;
	}
	
	public void setHoras(int horas) {
		this.cantHoras = horas;
	}
	
	public int getHoras() {
		return cantHoras;
	}
}
