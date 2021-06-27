package personas;

public class AtendiendoState implements IState{
private Ambulancia ambulancia;
	public AtendiendoState(Ambulancia ambulancia) {
	this.ambulancia=ambulancia;
}

	@Override
	public void solicitaAtencion() {
		System.out.println("No se puede solicitar atencion");
		
	}

	@Override
	public void solicitaTraslado() {
		System.out.println("No se puede");
		
	}

	@Override
	public void volverClinica() {
		this.ambulancia.setEstado(new RegresaAtencionState(this.ambulancia));
		//this.ambulancia.setEstado(new TrasladandoState(this.ambulancia));
		
	}

	@Override
	public void solicitaReparacion() {
		System.out.println("No se puede");
		
		
	}

	@Override
	public String actual() {
		
		return "Atendiendo en domicilio";
	}


}
