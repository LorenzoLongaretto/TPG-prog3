package modelo;

public class Paciente extends Persona {
private String numeroHistoria,rangoEtario;	
public Paciente(String dNI, String nombre, String apellido, String ciudad, String telefono, String domicilio,String numerohistoria,String rangoEtario) {
		super(dNI, nombre, apellido, ciudad, telefono, domicilio);
		// TODO Auto-generated constructor stub
		this.numeroHistoria=numerohistoria;
		this.rangoEtario=rangoEtario;
	}

public boolean ocuparSala() {
	return false;
}

public String getRangoEtario() {
	return rangoEtario;
}
	



}
