package compra;

import java.time.chrono.ChronoLocalDate;

public class HorasPuntuales extends Compra {
	
	private String patenteAuto;
	int cantHoras;
	
	public HorasPuntuales(int nroControl, ChronoLocalDate fechaYHora, String nombreComercio,
			               String patenteAuto, int cantHoras) {
		super(nroControl, fechaYHora, nombreComercio);
		this.patenteAuto = patenteAuto;
		this.cantHoras = cantHoras;
	}
	
	@Override
	public void realizarCompra(AppCelular celu) {
		//ver como sacar esto y como no usar celu
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
