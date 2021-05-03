package personas;

public class Ni�o extends Paciente{

	//Constructores
	public Ni�o(String dNI, String nombre, String apellido, String ciudad, String telefono, String domicilio,
			String numerohistoria,int nroOrden) {
		super(dNI, nombre, apellido, ciudad, telefono, domicilio, numerohistoria,"Nino",nroOrden);
		
	}

	//Metodos
	@Override
	public boolean prioridad(Paciente paciente) {
		return paciente.prioridadNino();
	}
	@Override
	public boolean prioridadNino() {
		return false;
	}
	@Override
	public boolean prioridadJoven() {	
		return true;
	}
	@Override
	public boolean prioridadMayor() {
		return false;
	}

}
