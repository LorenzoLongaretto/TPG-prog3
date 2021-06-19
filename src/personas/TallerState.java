package personas;

public class TallerState implements IState{
private Ambulancia ambulancia;

	public TallerState(Ambulancia ambulancia) {
	super();
	this.ambulancia = ambulancia;
}

	@Override
	public void solicitaAtencion() {
		System.out.println("No se puede");
		
	}

	@Override
	public void solicitaTraslado() {
		System.out.println("No se puede");
	}

	@Override
	public void volverClinica() {
		this.ambulancia.setEstado(new RegresaTallerState(this.ambulancia));
		
	}

	@Override
	public void solicitaReparacion() {
		System.out.println("Ya estoy en el taller");
		
	}


}
