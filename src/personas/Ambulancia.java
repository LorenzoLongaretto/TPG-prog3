package personas;

import java.util.Observable;

import util.Util;

public class Ambulancia extends Observable{
	private static Ambulancia instancia = null;
	private IState estado;
	private boolean disponible,trasladandoP,atendiendoDom,regresandoSinP,enTaller,regresandoTaller; //regeresando sin paciente
	
	public Ambulancia() {
		this.estado = new DisponibleState(this);
		this.disponible=true;
		this.regresandoSinP=false;
		this.enTaller=false;
		this.regresandoTaller=false;
		this.trasladandoP=false;
		this.atendiendoDom=false;
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
		this.atendiendoDom=true;
		
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
		this.enTaller=true;
		
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
		
		/*while (this.disponible) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}*/
		
		if(this.enTaller) {
			this.regresandoTaller=true;
			this.enTaller=false;
		//	this.volverClinica();
		}
		else if(this.regresandoTaller) {
			this.disponible=true;
			this.regresandoTaller=false;
		}
		else if(this.regresandoSinP) {
			this.regresandoSinP=false;
			this.disponible=true;
		}else if(this.atendiendoDom) {
			this.atendiendoDom=false;
			this.trasladandoP=true;
		//	this.volverClinica();
			
		}
		else if(this.trasladandoP) {
			this.trasladandoP=false;
			this.disponible=true;
		}
			
		notifyAll();
		System.out.println("-------------");
		
	}
	


	

	
	
}
