package modelo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import personas.Paciente;
import infraestructura.SalaDeEspera;
import infraestructura.Factura;



public class Clinica {

	//Atributos
	private static Clinica instance = null;  // aplico patron singleton
	private SalaDeEspera salaEspera = new SalaDeEspera();       
	private ArrayList<Paciente> patio= new ArrayList<Paciente>();
	private Queue<Paciente> listaEspera= new LinkedList<Paciente>();
	private Queue<Paciente> listaAtencion= new LinkedList<Paciente>();
	
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
		
		this.listaEspera.add(paciente);
		
		if(this.salaEspera.isOcupada()) {
			if(this.salaEspera.paciente.prioridad(paciente)==false) {//si cumple, entonces entra
				this.patio.add(this.salaEspera.paciente);
				this.salaEspera.ocupaSalaDeEspera(paciente);
			}
			else
				this.patio.add(paciente);
		}
		else 
			this.salaEspera.ocupaSalaDeEspera(paciente);	
	}
	
	public void atenderPaciente(Paciente paciente){
		
		this.listaEspera.remove(paciente);
        
        if(this.patio.contains(paciente)) // si esta en el patio lo elimino
            this.patio.remove(paciente);
        else                                   // esta en la sala privada
            this.salaEspera.desocupar();
        
        this.listaAtencion.add(paciente);                
    }
	
	
	public SalaDeEspera getSalaEspera() {
		return salaEspera;
	}
		
				
	}