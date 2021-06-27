package personas;

import java.io.Serializable;
import java.util.Observable;

import util.Util;

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

	public synchronized void solicitaAtencion(String nombreAsociado){ //a domicilio
		System.out.println("estimulo de atencion");
		
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
		
		System.out.println("estaba  "+this.estado.actual());
		this.estado.solicitaAtencion();
		System.out.println("ahora esta "+this.estado.actual());
		this.setChanged();
		this.notifyObservers("La ambulancia esta "+this.estado.actual()+" a "+ nombreAsociado);
		notifyAll();
		System.out.println("-------------");
		
	}
	
	public synchronized void solicitaTraslado(String nombreAsociado){
		System.out.println("estimulo de traslado");
		while(!this.disponible) {
			try {
				this.setChanged();
				this.notifyObservers(nombreAsociado+" solicita traslado y no puede");
				System.out.println(nombreAsociado+" solicita traslado y no puede");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.regresandoOcupado=true;
		this.disponible=false;
		
		
		System.out.println("estaba "+this.estado.actual());
		this.estado.solicitaTraslado();
		System.out.println("ahora esta "+this.estado.actual());
		this.setChanged();
		this.notifyObservers("La ambulancia esta "+this.estado.actual()+" a"+ nombreAsociado);
		notifyAll();
		System.out.println("-------------");
		
	}
	
		public synchronized void solicitaReparacion(){
		System.out.println("estimulo de reparacion");
		while(!this.disponible)
			try {
				System.out.println("solicita reparacion y no puede");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		this.disponible=false;
		this.ocupadoTaller=true;
		
		System.out.println("estaba"+this.estado.actual());
		this.estado.solicitaReparacion();
		System.out.println("ahora esta "+this.estado.actual());
		this.setChanged();
		this.notifyObservers("La ambulancia esta "+ this.estado.actual());
		notifyAll();
		System.out.println("-------------");
	
	}
		
	public synchronized void volverClinica(){
		System.out.println("estaba "+this.estado.actual());
		this.estado.volverClinica();
		System.out.println("ahora esta "+this.estado.actual());
		this.setChanged();
		this.notifyObservers("La ambulancia esta "+ this.estado.actual());
		
		
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
		System.out.println("-------------");
		
	}
	
}
