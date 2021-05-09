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
	private BDdePacientes pacientes = new BDdePacientes();
	private int nroOrden=0;
	
	
	//Constructores
	private Clinica() {}
	public static Clinica getInstance() {
		if(Clinica.instance==null) {
			Clinica.instance=new Clinica();		
		}
		return instance;
	}
	
	//Metodos
	
	public void ingresoPaciente(Paciente paciente) {
		// busca en la lista pacientes y chequea si ya existe para ver si lo agrega 
		
	       if(this.pacientes.buscarPaciente(paciente)!=true)
	    	   this.pacientes.altaDePaciente(paciente);	
	       this.derivarPaciente(paciente);
	}
	
	public void derivarPaciente(Paciente paciente) {
		nroOrden++;
		paciente.setNroOrden(nroOrden);
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
	
	public void egreso(Paciente paciente) {
		if(this.listaAtencion.contains(paciente)) {
			this.listaAtencion.remove(paciente);
			System.out.println(paciente.getFactura().toString());
		}
	}
	public SalaDeEspera getSalaEspera() {
		return salaEspera;
	}
	public ArrayList<Paciente> getPatio() {
		return patio;
	}
	
					
	}