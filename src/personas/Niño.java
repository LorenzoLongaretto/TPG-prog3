package personas;

public class Ni�o extends Paciente{

	//Constructores
	public Ni�o(String dNI, String nombre, String apellido, String ciudad, String telefono, String domicilio) {
		super(dNI, nombre, apellido, ciudad, telefono, domicilio, "Nino");
		
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
