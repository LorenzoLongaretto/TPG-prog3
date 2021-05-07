package personas;

import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.TreeSet;

import modelo.IMedico;

public class Medico extends Persona implements IMedico{
private String matricula,especialidad;	
private double honorarioBasico=1000;
private TreeSet<PacienteAtendido> pacientesAtendidos= new TreeSet<>();

	//Constructores
	public Medico(String dNI, String nombre, String apellido, String ciudad, String telefono, String domicilio, String matricula, String especialidad) {
		super(dNI, nombre, apellido, ciudad, telefono, domicilio);
		this.matricula = matricula;
		this.especialidad = especialidad;
	}
	
	public void asignarPaciente(Paciente paciente,GregorianCalendar fecha) {
		Iterator<PacienteAtendido> it = this.pacientesAtendidos.iterator();
		boolean existe=false;
		while(it.hasNext() && existe==false) {
			PacienteAtendido pacienteActual = it.next();
			if(fecha.equals(pacienteActual.getFecha()) &&  pacienteActual.getNombre().equals(paciente.getNombre()) && pacienteActual.getApellido().equals(paciente.getApellido())) {//haces la busqueda por dni y si no encontras generas un nro de historia
				existe=true;						
			}
			
			if(existe) {
				pacienteActual.setCantConsultas(pacienteActual.getCantConsultas()+1);
				pacienteActual.setSubtotal(pacienteActual.getCantConsultas()*this.getHonorario());
			}
			else {
				PacienteAtendido nuevo = new PacienteAtendido(paciente.getNombre(),paciente.getApellido(),1,this.getHonorario(),fecha);
				this.pacientesAtendidos.add(nuevo);
			}		
		}
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

	

}




