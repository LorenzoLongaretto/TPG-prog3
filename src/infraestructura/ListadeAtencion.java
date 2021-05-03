package infraestructura;
import java.util.ArrayList;

import personas.Paciente;

public class ListadeAtencion {
	//Atributos
	ArrayList <Paciente> listaAtencion = new ArrayList <Paciente>();

	public ListadeAtencion(ArrayList<Paciente> listaAtencion) {
		this.listaAtencion = listaAtencion;
	}
	
	public void addPaciente(Paciente paciente) {
		this.listaAtencion.add(paciente);
	}
		
}
