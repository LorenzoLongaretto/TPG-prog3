package infraestructura;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import personas.Paciente;

public class ListaDeEspera {
	//Atributos
	//ArrayList <Paciente> listaEspera = new ArrayList <Paciente>();
	Queue<Paciente> cola=new LinkedList();
/*
	//Metodos
	public ListaDeEspera(ArrayList<Paciente> listaEspera) {
		this.listaEspera = listaEspera;
	}
	public void addPaciente(Paciente paciente) {
		this.listaEspera.add(paciente);
	}
	public void removePaciente(Paciente paciente) {
		this.listaEspera.remove(paciente);
	}*/
	
	
	public ListaDeEspera(Queue<Paciente> cola) {
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
