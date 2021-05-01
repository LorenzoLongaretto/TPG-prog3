package modelo;

public class Mayor extends Paciente implements IRangoEtario{

	public Mayor(String dNI, String nombre, String apellido, String ciudad, String telefono, String domicilio,
			String numerohistoria, String rangoEtario) {
		super(dNI, nombre, apellido, ciudad, telefono, domicilio, numerohistoria, rangoEtario);
	}
	@Override
	public boolean prioridad(IRangoEtario i) {
		
		return i.prioridadMayor();
	}
	@Override
	public boolean prioridadNiño() {
		return true;
	}
    @Override
	public boolean prioridadJoven() {
		
		return false;
	}
	@Override
	public boolean prioridadMayor() {
		return false;
	}

}
