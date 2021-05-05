package infraestructura;

import java.util.ArrayList;

import personas.Paciente;

public class Patio {
	
	//Atributos
	private ArrayList <Paciente> pacientesEsperaPatio = new ArrayList <Paciente>();
	
	//Constructores
	public Patio(ArrayList<Paciente> pacientesEsperaPatio) {
		this.pacientesEsperaPatio = pacientesEsperaPatio;
	}
	
	//Metodos
	public void addPaciente(Paciente paciente) {
		pacientesEsperaPatio.add(paciente);
	}
	public void removePaciente(Paciente paciente) {
		pacientesEsperaPatio.remove(paciente);
	}

	public ArrayList<Paciente> getPacientesEsperaPatio() {
		
		return this.pacientesEsperaPatio;
	}
	
}
