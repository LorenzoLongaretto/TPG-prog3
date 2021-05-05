package infraestructura;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import personas.Paciente;

public class ListadeAtencion {
	//Atributos
	Queue<Paciente> cola=new LinkedList();
	/*ArrayList <Paciente> listaAtencion = new ArrayList <Paciente>();
	//Metodos
	public ListadeAtencion(ArrayList<Paciente> listaAtencion) {
		this.listaAtencion = listaAtencion;
	}
	public void addPaciente(Paciente paciente) {
		this.listaAtencion.add(paciente);
	}
	public void removePaciente(Paciente paciente) {
		this.listaAtencion.remove(paciente);
	}*/
	
	public ListadeAtencion(Queue<Paciente> cola) {
		this.cola=cola;
	}
	
	//Metodos
	public void addPaciente(Paciente paciente) {
		this.cola.add(paciente);
	}
	
	public void removePaciente(Paciente paciente) {
		this.cola.remove(paciente);
	}
	
}
