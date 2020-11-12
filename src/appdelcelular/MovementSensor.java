package appdelcelular;

/** Interfaz simple de sensor de movimiento, se da por sentado que quien implemente esta interfaz
 * "recibe" constantemente estos mensajes, depende de la clase determinar como comportarse ante estos mensajes. */
public interface MovementSensor {
	public void driving();
	public void walking();
}
