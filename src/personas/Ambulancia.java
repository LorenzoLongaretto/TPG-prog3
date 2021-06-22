package personas;

import java.util.Observable;

import util.Util;

public class Ambulancia extends Observable{
	private static Ambulancia instancia = null;
	private IState estado;
	private boolean disponible,regresandoSinP; //regeresando sin paciente
	
	public Ambulancia() {
		this.estado = new DisponibleState(this);
		this.disponible=true;
		this.regresandoSinP=false;
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
		while ( !(this.disponible || this.regresandoSinP)) {
			try {
				System.out.println("solicita atencion y no puede");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		this.disponible=false;
		//System.out.println(this.estado.actual());
		
		this.estado.solicitaAtencion();
		System.out.println(this.estado.actual());
		this.notifyObservers(this.estado.actual());
		notifyAll();
		
	}
	
	public synchronized void solicitaTraslado(){
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
		
		//System.out.println(this.estado.actual());
		this.estado.solicitaTraslado();
		System.out.println(this.estado.actual());
		this.notifyObservers(this.estado.actual());
		notifyAll();
		
		
	}
	
	public synchronized void volverClinica(){
		
		this.estado.volverClinica();
		System.out.println(this.estado.actual());
		this.notifyObservers(this.estado.actual());
		this.disponible=true;
		this.regresandoSinP=false;
		notifyAll();
		
	}
	
	public synchronized void solicitaReparacion(){
		
		while(!this.disponible)
			try {
				System.out.println("solicita reparacion y no puede");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		this.disponible=false;
		
		
		this.estado.solicitaReparacion();
		System.out.println(this.estado.actual());
		this.notifyObservers(this.estado.actual());
		notifyAll();
	
	}

	

	
	
}
