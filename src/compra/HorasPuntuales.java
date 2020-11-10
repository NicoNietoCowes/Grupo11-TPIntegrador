package compra;

public class HorasPuntuales extends Compra {
	
	private String patenteAuto;
	int cantHoras;
	
	@Override
	public void realizarCompra() {
		
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
