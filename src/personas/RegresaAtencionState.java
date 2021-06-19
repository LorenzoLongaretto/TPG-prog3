package personas;

public class RegresaAtencionState implements IState{
private Ambulancia ambulancia;
	

public RegresaAtencionState(Ambulancia ambulancia) {
	super();
	this.ambulancia = ambulancia;
}

@Override
	public void solicitaAtencion() {
		this.ambulancia.setEstado(new AtendiendoState(this.ambulancia));
		
	}

	@Override
	public void solicitaTraslado() {
		System.out.println("No se puede");
		
	}

	@Override
	public void volverClinica() {
		this.ambulancia.setEstado(new DisponibleState(this.ambulancia));
		
	}

	@Override
	public void solicitaReparacion() {
		System.out.println("No se puede");
		
	}


}
