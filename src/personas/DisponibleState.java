package personas;

public class DisponibleState implements IState{

	private Ambulancia ambulancia;

	public DisponibleState(Ambulancia ambulancia) {
		super();
		this.ambulancia = ambulancia;
	}

	@Override
	public void solicitaAtencion() {
		this.ambulancia.setEstado(new AtendiendoState(this.ambulancia));
		
	}

	@Override
	public void solicitaTraslado() {
		this.ambulancia.setEstado(new RegresaTallerState(this.ambulancia));
	}

	@Override
	public void volverClinica() {
		System.out.println("Ya estoy en la clinica rey");
		
	}

	@Override
	public void solicitaReparacion() {
		this.ambulancia.setEstado(new TallerState(this.ambulancia));
		
	}


}
