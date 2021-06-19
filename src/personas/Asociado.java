package personas;

public class Asociado extends Persona implements Runnable{

	public Asociado(String dNI, String nombre, String apellido, String ciudad, String telefono, String domicilio) {
		super(dNI, nombre, apellido, ciudad, telefono, domicilio);
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
