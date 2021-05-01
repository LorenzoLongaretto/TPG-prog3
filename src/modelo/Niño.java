package modelo;

public class Ni�o extends Paciente implements IRangoEtario {

	public Ni�o(String dNI, String nombre, String apellido, String ciudad, String telefono, String domicilio,
			String numerohistoria, String rangoEtario) {
		super(dNI, nombre, apellido, ciudad, telefono, domicilio, numerohistoria, rangoEtario);
		
	}

	@Override
	public boolean prioridad(IRangoEtario i) {
		return i.prioridadNi�o();
	}

	@Override
	public boolean prioridadNi�o() {
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
