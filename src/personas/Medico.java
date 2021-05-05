package personas;

import modelo.IMedico;

public class Medico extends Persona implements IMedico{
private String matricula,especialidad;	
private double honorarioBasico=1000;

	//Constructores
	public Medico(String dNI, String nombre, String apellido, String ciudad, String telefono, String domicilio, String matricula, String especialidad) {
		super(dNI, nombre, apellido, ciudad, telefono, domicilio);
		this.matricula = matricula;
		this.especialidad = especialidad;
	}
	
	//Metodos
	@Override
	public double getHonorario() {
		if(this.getEspecialidad().equals("Clinica"))
			return this.honorarioBasico*1.05;
		else {
			if(this.getEspecialidad().equals("Cirugia"))
				return this.honorarioBasico*1.1;
			else 
				if(this.getEspecialidad().equals("Pediatria"))
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
	public String getEspecialidad() {
		return this.especialidad;
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return this.nombre;
	}

	

}
