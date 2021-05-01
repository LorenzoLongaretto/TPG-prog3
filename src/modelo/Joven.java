package modelo;

public class Joven extends Paciente implements IRangoEtario{

	public Joven(String dNI, String nombre, String apellido, String ciudad, String telefono, String domicilio,
			String numerohistoria, String rangoEtario) {
		super(dNI, nombre, apellido, ciudad, telefono, domicilio, numerohistoria, rangoEtario);
		
	}

	@Override
	public boolean prioridad(IRangoEtario i) {
		
		return i.prioridadJoven();
	}

	@Override
	public boolean prioridadNiño() {
		
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
