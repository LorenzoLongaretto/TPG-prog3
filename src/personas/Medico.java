package personas;

import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.TreeSet;

import modelo.IMedico;

public class Medico extends Persona implements IMedico{
private String matricula,especialidad;	
private double honorarioBasico=1000;
public TreeSet<PacienteAtendido> pacientesAtendidos= new TreeSet<>();

	//Constructores
	public Medico(String dNI, String nombre, String apellido, String ciudad, String telefono, String domicilio, String matricula, String especialidad) {
		super(dNI, nombre, apellido, ciudad, telefono, domicilio);
		this.matricula = matricula;
		this.especialidad = especialidad;
	}
	//Metodos

	@Override
	public double getHonorario() {
		return this.honorarioBasico;
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
		return this.nombre;
	}

	@Override
	public String toString() {
		return " nombre=" + nombre +", apellido=" + apellido+"matricula=" + matricula + ", especialidad=" + especialidad ;
				
	}
	@Override
	public void asignarPaciente(Paciente paciente, GregorianCalendar fecha) {
		Iterator<PacienteAtendido> it = this.pacientesAtendidos.iterator();
		boolean existe=false;
		while(it.hasNext() && existe==false) {
			PacienteAtendido pacienteActual = it.next();
			if(fecha.equals(pacienteActual.getFecha()) && pacienteActual.getDNI().equals(paciente.getDNI())) {
				existe=true;	
				pacienteActual.setCantConsultas(pacienteActual.getCantConsultas()+1);
				pacienteActual.setSubtotal(pacienteActual.getCantConsultas()*this.getHonorario());					
			}
			
			
		}
		if(!existe) {
			PacienteAtendido nuevo = new PacienteAtendido(paciente.getNombre(),paciente.getApellido(),1,this.getHonorario(),fecha,paciente.getDNI());
			this.pacientesAtendidos.add(nuevo);
		}
		
	}
	@Override
	public void reporte(GregorianCalendar fecha1, GregorianCalendar fecha2) {
        Iterator<PacienteAtendido> it = this.pacientesAtendidos.iterator();
		
		while(it.hasNext()) {
			PacienteAtendido actual = it.next();
			if(actual.getFecha().compareTo(fecha1)>=0 && actual.getFecha().compareTo(fecha2)<=0)
				System.out.println(actual.toString());
				}
	}

	

}




