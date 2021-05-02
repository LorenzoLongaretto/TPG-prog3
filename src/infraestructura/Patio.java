package infraestructura;

import java.util.ArrayList;

import personas.Paciente;

public class Patio {
	
	//Atributos
	ArrayList <Paciente> pacientesEsperaPatio = new ArrayList <Paciente>();
	
	//Constructor Esto esta raro, ¡No tiene constructor, bob el constructor¡
	
	
	//Metodos
	public void addPaciente(Paciente paciente) {
		pacientesEsperaPatio.add(paciente);
	}
	public void removePaciente(Paciente paciente) {
		pacientesEsperaPatio.remove(paciente);
	}
	
}
