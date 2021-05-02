package modelo;

import java.util.ArrayList;

import personas.Paciente;

public class Clinica {

	//Atributos
	private static Clinica instance = null;  // aplico patron singleton
	private Paciente salaEspera;       // prueba, hay q ver si esta bien
	private ArrayList<Paciente> patio = new ArrayList<Paciente>();  // prueba, hay q ver si esta bien

	//Constructores
	private Clinica() {}
	public static Clinica getInstance() {
		if(Clinica.instance==null) {
			Clinica.instance=new Clinica();
			//SalaDeEspera salaDeEspera = new SalaDeEspera();
		}
		return instance;
	}

	//Metodos
	public Paciente getSalaEspera() {
		return salaEspera;
	}
	/*public ArrayList<Paciente> getPatio() {
		return patio;
	}*/
	public void agregarSalaEspera(Paciente paciente) {
		//Metodo que compara prioridades y determina quien va a la sala y quien se lo agrega al patio
	}
	public void agregarPatio(Paciente paciente) {
		this.patio.add(paciente);	
	}
	/*public void setSalaEspera(Paciente salaEspera) { 
		this.salaEspera = salaEspera;
	}*/

}
