package modelo;

public class Joven extends Paciente{

	//Constructores
	public Joven(String dNI, String nombre, String apellido, String ciudad, String telefono, String domicilio,
			String numerohistoria, String rangoEtario) {
		super(dNI, nombre, apellido, ciudad, telefono, domicilio, numerohistoria, rangoEtario);
		
	}
	
	//Metodos
	@Override
	public boolean prioridad(Paciente paciente) {
		return paciente.prioridadJoven();
	}
	@Override
	public boolean prioridadNino() {	
		return false;
	}
	@Override
	public boolean prioridadJoven() {	
		return false;
	}
	@Override
	public boolean prioridadMayor() {
		return true;
	}

}
