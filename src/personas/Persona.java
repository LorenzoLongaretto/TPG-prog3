package personas;

public abstract class Persona {
protected String DNI,nombre,apellido,ciudad,telefono,domicilio;

	//Constructores
	public Persona(String dNI, String nombre, String apellido, String ciudad, String telefono, String domicilio) {
		this.DNI = dNI;
		this.nombre = nombre;
		this.apellido = apellido;
		this.ciudad = ciudad;
		this.telefono = telefono;
		this.domicilio = domicilio;
	}
/**
 * preguntar por el sueldo base
 * 
 * 
 */

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

}
