package personas;

public class Joven extends Paciente{

	//Constructores
	public Joven(String dNI, String nombre, String apellido, String ciudad, String telefono, String domicilio,
			int  numerohistoria,int nroOrden) {
		super(dNI, nombre, apellido, ciudad, telefono, domicilio, numerohistoria,"Joven",nroOrden);
		
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
