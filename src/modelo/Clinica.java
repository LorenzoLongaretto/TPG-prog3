package modelo;

import java.util.ArrayList;

public class Clinica {

	private static Clinica instance = null;  // aplico patron singleton
	private Paciente salaEspera;       // prueba, hay q ver si esta bien
	private ArrayList<Paciente> patio = new ArrayList<Paciente>();  // prueba, hay q ver si esta bien


	private Clinica() {}


	public static Clinica getInstance() {
		if(Clinica.instance==null)
			Clinica.instance=new Clinica();
		return instance;
	}


	public Paciente getSalaEspera() {
		return salaEspera;
	}


	public ArrayList<Paciente> getPatio() {
		return patio;
	}

	public void agregarSalaEspera(Persona p) {
		//Metodo que compara prioridades y determina quien va a la sala y quien se lo agrega al patio
		
	}
	
	public void agregarPatio(Paciente p) {
		
		this.patio.add(p);	
		
	}

	public void setSalaEspera(Paciente salaEspera) {
		this.salaEspera = salaEspera;
	}



}
