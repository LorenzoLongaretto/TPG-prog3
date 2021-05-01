package modelo;

public class Niño extends Paciente implements IRangoEtario {

	public Niño(String dNI, String nombre, String apellido, String ciudad, String telefono, String domicilio,
			String numerohistoria, String rangoEtario) {
		super(dNI, nombre, apellido, ciudad, telefono, domicilio, numerohistoria, rangoEtario);
		
	}

	@Override
	public boolean prioridad(IRangoEtario i) {
		return i.prioridadNiño();
	}

	@Override
	public boolean prioridadNiño() {
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
