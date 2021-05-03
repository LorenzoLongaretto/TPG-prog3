package infraestructura;
import java.util.ArrayList;

import personas.Paciente;

public class ListaDeEspera {
	//Atributos
	ArrayList <Paciente> listaEspera = new ArrayList <Paciente>();

	public ListaDeEspera(ArrayList<Paciente> listaEspera) {
		
		this.listaEspera = listaEspera;
	}
	
	public void addPaciente(Paciente paciente) {
		this.listaEspera.add(paciente);
	}
	
	
}
