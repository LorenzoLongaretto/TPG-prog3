package personas;

public class Operario extends Persona implements Runnable{

	public Operario(String dNI, String nombre, String apellido, String ciudad, String telefono, String domicilio) {
		super(dNI, nombre, apellido, ciudad, telefono, domicilio);
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
