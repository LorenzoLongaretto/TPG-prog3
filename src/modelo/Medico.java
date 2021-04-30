package modelo;

public class Medico extends Persona implements IMedico{
private String matricula,especialidad;	
private double honorarioBasico=1000;

public Medico(String dNI, String nombre, String apellido, String ciudad, String telefono, String domicilio) {
		super(dNI, nombre, apellido, ciudad, telefono, domicilio);
		// TODO Auto-generated constructor stub
	}

@Override
public double getHonorario() {
	if(this.getEspacialidad().equals("Clinica"))
		return this.honorarioBasico*1.05;
	else {
		if(this.getEspacialidad().equals("Cirugia"))
			return this.honorarioBasico*1.1;
		else 
			if(this.getEspacialidad().equals("Pediatria"))
				return this.honorarioBasico*1.07;
			else
				return 30.21;//AGREGAR EXCEPCION
	}
			
}

@Override
public String getMatricula() {
	return this.matricula;
}

@Override
public String getEspacialidad() {
	return this.especialidad;
}




}
