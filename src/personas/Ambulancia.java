package personas;

import java.io.Serializable;
import java.util.Observable;

import util.Util;
/** Clase que representa a una Ambulancia.
 *
 */
public class Ambulancia extends Observable{
	private static Ambulancia instancia = null;
	private IState estado;
	private boolean disponible,regresandoSinP,ocupadoTaller,ocupadoDom,regresandoOcupado; //regeresando sin paciente
	
	private Ambulancia() {
		this.estado = new DisponibleState(this);
		this.disponible=true;
		this.regresandoSinP=false;
		this.ocupadoTaller=false;
		this.ocupadoDom=false;
		this.regresandoOcupado=false;
	}
	public static Ambulancia getInstancia() {
		if (instancia == null)
			instancia = new Ambulancia();
		return instancia;
	}
	
	
	public IState getEstado() {
		return estado;
	}
	
	public void setEstado(IState estado) {
		this.estado = estado;
	}

	/**
	 * <b> Pre: El parametro nombreAsociado debe ser distinto de null</b>
	 * <b> Post : Se  ejecuta la peticion o se pone a "dormir" hasta que pueda ejecutarse, y cambia el estado de la ambulancia. </b>
	 * @param nombreAsociado nombre del asociado que solicita atencion a domicilio.
	 * 
	 */
	public synchronized void solicitaAtencion(String nombreAsociado){ //a domicilio
		
		while ( !(this.disponible || this.regresandoSinP)) {
			try {
				this.setChanged();
				this.notifyObservers(nombreAsociado+" solicita atencion y no puede");
				System.out.println(nombreAsociado+" solicita atencion y no puede"); //poner otro notifyobs para asociados
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		this.disponible=false;
		this.regresandoSinP=false;
		this.ocupadoDom=true;
		
		this.estado.solicitaAtencion();
		this.setChanged();
		this.notifyObservers("La ambulancia esta "+this.estado.actual()+" a "+ nombreAsociado);
		notifyAll();
		
	}
	
	/**
	 * <b> Pre: El parametro nombreAsociado debe ser distinto de null</b>
	 * <b> Post : Se  ejecuta la peticion o se pone a "dormir" hasta que pueda ejecutarse, y cambia el estado de la ambulancia. </b>
	 * @param nombreAsociado nombre del asociado que solicita traslado.
	 * 
	 */
	public synchronized void solicitaTraslado(String nombreAsociado){
		while(!this.disponible) {
			try {
				this.setChanged();
				this.notifyObservers(nombreAsociado+" solicita traslado y no puede");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.estado.solicitaTraslado();
		this.regresandoOcupado=true;
		this.disponible=false;
		this.setChanged();
		this.notifyObservers("La ambulancia esta "+this.estado.actual()+" a "+ nombreAsociado);
		notifyAll();
		
	}
	/**
	 * Metodo que reprenta el pedido de un operario a la ambulancia.
	 * <b> Post : Cambia de estado a la ambulancia. </b>
	 *
	 */
		public synchronized void solicitaReparacion(){
		while(!this.disponible)
			try {
				this.setChanged();
				this.notifyObservers("El operario solicita reparacion y no puede");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		this.disponible=false;
		this.ocupadoTaller=true;
		this.estado.solicitaReparacion();
		this.setChanged();
		this.notifyObservers("La ambulancia esta "+ this.estado.actual());
		notifyAll();
	
	}
		
		
	/**
	 * Luego de un tiempo,que simboliza lo que la ambulancia tardo en llevar a cabo una peticion, se ejecuta este metodo
	 * que cambia de estado a la ambulancia.
	 * <b> Post : Cambia de estado a la ambulancia. </b>
	 * 
	 */
	public synchronized void volverClinica(){
		this.estado.volverClinica();
		if(!this.disponible) { //para que no notifique disponible 2 veces seguidas
			this.setChanged();
			this.notifyObservers("La ambulancia esta "+ this.estado.actual());
		}
		
		if(this.ocupadoDom) {
			this.ocupadoDom=false;
			this.regresandoSinP=true;
		}
		else if(this.ocupadoTaller) {
			this.regresandoOcupado=true;
			this.ocupadoTaller=false;
			}
		else if(this.regresandoOcupado) {
			this.regresandoOcupado=false;
			this.disponible=true;
		}
		else if(this.regresandoSinP) {
			this.disponible=true;
			this.regresandoSinP=false;
		}
		notifyAll();
		
	}
	
}
