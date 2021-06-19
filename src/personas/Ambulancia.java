package personas;



public class Ambulancia {
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
	
	public synchronized void solicitar(Persona persona){
		
	}
	public IState getEstado() {
		return estado;
	}
	public void setEstado(IState estado) {
		this.estado = estado;
	}

	
	
}
