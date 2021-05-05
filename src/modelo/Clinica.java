package modelo;

import java.util.ArrayList;
import personas.Paciente;
import infraestructura.SalaDeEspera;
import infraestructura.ListadeAtencion;
import infraestructura.ListaDeEspera;
import infraestructura.Patio;


public class Clinica {

	//Atributos
	private static Clinica instance = null;  // aplico patron singleton
	private SalaDeEspera salaEspera = new SalaDeEspera();       
	private Patio patio = new Patio(new ArrayList<Paciente>());
	private ListaDeEspera listaEspera = new ListaDeEspera(new ArrayList<Paciente>());
	private ListadeAtencion listaAtencion = new ListadeAtencion(new ArrayList<Paciente>());
    
	//Constructores
	private Clinica() {}
	public static Clinica getInstance() {
		if(Clinica.instance==null) {
			Clinica.instance=new Clinica();		
		}
		return instance;
	}
	//Metodos
	public void buscarHistoria(Paciente paciente) {
		// busca en la lista pacientes y chequea si ya existe para ver si lo agrega o elimina objeto
	
	
	// se lo deriva al paciente de acuerdo a su prioridad
	}
	public void derivarPaciente(Paciente paciente) {
		
		this.listaEspera.addPaciente(paciente);
		
		if(this.salaEspera.isOcupada()) {
			if(this.salaEspera.paciente.prioridad(paciente)==false) {//si cumple, entonces entra
				this.patio.addPaciente(this.salaEspera.paciente);
				this.salaEspera.ocupaSalaDeEspera(paciente);
			}
			else
				this.patio.addPaciente(paciente);
		}
		else 
			this.salaEspera.ocupaSalaDeEspera(paciente);	
	}
	
	public void atenderPaciente(Paciente paciente){
		
				
	}
}
