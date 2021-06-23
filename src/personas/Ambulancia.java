package personas;

import java.util.Observable;

import util.Util;

public class Ambulancia extends Observable{
	private static Ambulancia instancia = null;
	private IState estado;
	private boolean disponible,regresandoSinP,ocupado,regresandoOcupado; //regeresando sin paciente
	
	private Ambulancia() {
		this.estado = new DisponibleState(this);
		this.disponible=true;
		this.regresandoSinP=false;
		this.ocupado=false;
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

	public synchronized void solicitaAtencion(){ //a domicilio
		System.out.println("estimulo de atencion");
		
		while ( !(this.disponible || this.regresandoSinP)) {
			try {
				System.out.println("solicita atencion y no puede");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		this.disponible=false;
		this.regresandoSinP=false;
		this.ocupado=true;
		
		System.out.println("estaba  "+this.estado.actual());
		this.estado.solicitaAtencion();
		System.out.println("ahora esta "+this.estado.actual());
		this.notifyObservers(this.estado.actual());
		notifyAll();
		System.out.println("-------------");
		
	}
	
	public synchronized void solicitaTraslado(){
		System.out.println("estimulo de traslado");
		while(!this.disponible) {
			try {
				System.out.println("solicita traslado y no puede");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.regresandoSinP=true;
		this.disponible=false;
		
		
		System.out.println("estaba "+this.estado.actual());
		this.estado.solicitaTraslado();
		System.out.println("ahora esta "+this.estado.actual());
		this.notifyObservers(this.estado.actual());
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
		this.ocupado=true;
		
		System.out.println("estaba"+this.estado.actual());
		this.estado.solicitaReparacion();
		System.out.println("ahora esta "+this.estado.actual());
		this.notifyObservers(this.estado.actual());
		notifyAll();
		System.out.println("-------------");
	
	}
		
	public synchronized void volverClinica(){
		System.out.println("estaba "+this.estado.actual());
		this.estado.volverClinica();
		System.out.println("ahora esta "+this.estado.actual());
		this.notifyObservers(this.estado.actual());
		
		if(this.ocupado) {
			this.regresandoOcupado=true;
			this.ocupado=false;
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
