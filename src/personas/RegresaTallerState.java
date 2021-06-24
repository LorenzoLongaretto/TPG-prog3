package personas;

public class RegresaTallerState implements IState{
private Ambulancia ambulancia;

	public RegresaTallerState(Ambulancia ambulancia) {
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
		this.ambulancia.setEstado(new DisponibleState(this.ambulancia));
		
	}

	@Override
	public void solicitaReparacion() {
		System.out.println("No se puede");
		
	}

	@Override
	public String actual() {
		return "Regresando del Taller";
	}

}
