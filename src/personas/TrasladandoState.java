package personas;

public class TrasladandoState implements IState{
private Ambulancia ambulancia;

	public TrasladandoState(Ambulancia ambulancia) {
	
	this.ambulancia = ambulancia;
}

	@Override
	public void solicitaAtencion() {
		System.out.println("No se puede solicitar Atencion");

	}

	@Override
	public void solicitaTraslado() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void volverClinica() {
		
		this.ambulancia.setEstado(new DisponibleState(this.ambulancia));
		
	}

	@Override
	public void solicitaReparacion() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String actual() {
		return "Trasladando ";
	}

}
