package esquemaMonitoreo;

import java.util.ArrayList;

import estacionamiento.Estacionamiento;
import sistemaEstacionamientoMedido.SEM;

/** La propuesta de esta interfaz es que sea implementada junto con la interfaz Observer y de esta forma poder
 * manejar estados en base a las notificaciones que envía el SEM. */
public interface IMonitoreoEstacionamiento {
	
	/** La clase que implemente esta interfaz puede tener como colaborador interno a la clase observable
	 * SEM para recibir las notificaciones que este manda. */
	public void configurarSEM(SEM semAObservar);
	
	/** Idealmente este método se utiliza para que la clase que implemente la
	 * interfaz se agregue como observer del SEM para poder recibir sus notificaciones. */
	public void suscribirse();
	
	/** En este caso la clase ya suscrita debe removerse de los observers del SEM. */
	public void desuscribirse();
	
	/** Se corresponde con el listado de estacionamientos registrados por el SEM, para poder
	 * consultar cualquier dato deseado siempre y cuando sea accesible. */
	public ArrayList<Estacionamiento> obtenerEstacionamientos();
}
