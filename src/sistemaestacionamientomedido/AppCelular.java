package sistemaestacionamientomedido;

public class AppCelular {
	private String numeroCel;
	private double creditoDisponible = 0;
	private ModoApp modoApp;
	// private EstViaApp estacionamiento;
	
	/** Cuando se crea una AppCelular se indica el n�mero de celular
	 * del usuario y el modo de inicio (manual o autom�tico) que 
	 * luego puede ser modificado. */
	public AppCelular(String nroCel, ModoApp modo) {
		this.setNumeroCel(nroCel);
		this.cambiarModo(modo);
	}
	
	public String consultaDeSaldo() {
		return "El cr�dito de estacionamiento disponible para este "
				+ "celular (" + this.getNumeroCel() + "), es de $"
				+ this.getCreditoDisponible();
	}
	
	// m�todo a implementar en base al observer y observable
	
	public void cargarCredito(double monto) {
		this.creditoDisponible =+ monto;
	}
	
	public double getCreditoDisponible() {
		return this.creditoDisponible;
	}
 
	private void setNumeroCel(String nroCel) {
		this.numeroCel = nroCel;
	}
	
	public String getNumeroCel() {
		return this.numeroCel;
	}
	
	private void cambiarModo(ModoApp modoNuevo) {
		this.modoApp = modoNuevo;
	}
}
