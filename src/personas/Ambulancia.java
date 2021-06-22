package personas;

import java.util.Observable;

import util.Util;

public class Ambulancia extends Observable{
	private static Ambulancia instancia = null;
	private IState estado;
	
	private Ambulancia() {
		this.estado = new DisponibleState(this);
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
		while (!(this.estado.actual().equals("Disponible")||(this.estado.actual().equals("RegresaAtencion")))) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		this.estado.solicitaAtencion();
		this.notifyObservers(this.estado.actual());
		notifyAll();
		
	}
	
	public synchronized void solicitaTraslado(){
		while(!(this.estado.actual().equals("Disponible"))) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		this.estado.solicitaTraslado();
		this.notifyObservers(this.estado.actual());
		notifyAll();
		
		
	}
	
	public synchronized void volverClinica(){
		
		this.estado.volverClinica();
		this.notifyObservers(this.estado.actual());
		notifyAll();
		
	}
	
	public synchronized void solicitaReparacion(){
		
		while(!this.estado.actual().equals("Disponible"))
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		
		this.estado.solicitaReparacion();
		this.notifyObservers(this.estado.actual());
		notifyAll();
	
	}

	

	
	
}
