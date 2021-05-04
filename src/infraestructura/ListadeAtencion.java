package infraestructura;
import java.util.ArrayList;

import personas.Paciente;

public class ListadeAtencion {
	//Atributos
	ArrayList <Paciente> listaAtencion = new ArrayList <Paciente>();

	//Metodos
	public ListadeAtencion(ArrayList<Paciente> listaAtencion) {
		this.listaAtencion = listaAtencion;
	}
	public void addPaciente(Paciente paciente) {
		this.listaAtencion.add(paciente);
	}
	public void removePaciente(Paciente paciente) {
		this.listaAtencion.remove(paciente);
	}
	
}
