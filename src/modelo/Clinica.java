package modelo;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeSet;

import personas.Paciente;
import infraestructura.SalaDeEspera;
import infraestructura.Factura;
import infraestructura.Prestacion;



/**
 * @author Lisandro DAlu
 *<br>
 * Clase que representa una clinica. Contiene la totalidad de los pacientes. Tambien contine un patio, una sala de espera y una lista de facturas correspondientes a los pacientes.
 *
 */
public class Clinica {

	//Atributos
	private static Clinica instance = null;  // aplico patron singleton
	private SalaDeEspera salaEspera = new SalaDeEspera();       
	private ArrayList<Paciente> patio= new ArrayList<Paciente>();
	private Queue<Paciente> listaEspera= new LinkedList<Paciente>();
	private Queue<Paciente> listaAtencion= new LinkedList<Paciente>();
	private TreeSet<Factura> facturas= new TreeSet<>();
	private BDdePacientes pacientes = new BDdePacientes();
	private int nroOrden=0;
	
	
	//Constructores
	/**
	 * 
	 */
	private Clinica() {}
	public static Clinica getInstance() {
		if(Clinica.instance==null) {
			Clinica.instance=new Clinica();		
		}
		return instance;
	}
	
	//Metodos
	
	/**Da de alta a un paciente si no esta dentro de la Base de Datos de la clinica, luego lo deriva al patio o sala de espera de acuerdo a su prioridad.<br>
	 * <b> Pre: El parametro paciente debe ser distinto de null</b>
	 * <b> Post : Se  ingresa el paciente a la clinica. </b>
	 * @param paciente : Parametro de tipo paciente que ingresa a la clinica.
	 */
	public void ingresoPaciente(Paciente paciente) {
		// busca en la lista pacientes y chequea si ya existe para ver si lo agrega 
		
	       if(!this.pacientes.buscarPaciente(paciente)) //this.pacientes.buscarPaciente(paciente)!=true
	    	   this.pacientes.altaDePaciente(paciente);	
	       this.derivarPaciente(paciente);
	}
	
	/**
	 * @param paciente
	 */
	public void derivarPaciente(Paciente paciente) {
		nroOrden++;
		paciente.setNroOrden(nroOrden);
		this.listaEspera.add(paciente);
		
		if(this.salaEspera.isOcupada()) {
			if(!this.salaEspera.paciente.prioridad(paciente)) {//si cumple, entonces entra this.salaEspera.paciente.prioridad(paciente)==false
				this.patio.add(this.salaEspera.paciente);
				this.salaEspera.ocupaSalaDeEspera(paciente);
			}
			else
				this.patio.add(paciente);
		}
		else 
			this.salaEspera.ocupaSalaDeEspera(paciente);	
	}
	
	/**
	 * @param paciente
	 */
	public void atenderPaciente(Paciente paciente){
		
		this.listaEspera.remove(paciente);
        
        if(this.patio.contains(paciente)) // si esta en el patio lo elimino
            this.patio.remove(paciente);
        else                                   // esta en la sala privada
            this.salaEspera.desocupar();
        
        this.listaAtencion.add(paciente);                
    }
	
	/**
	 * @param paciente
	 * @param factura
	 */
	public void egreso(Paciente paciente,Factura factura) {
		if(this.listaAtencion.contains(paciente)) {
			this.listaAtencion.remove(paciente);
			System.out.println(factura.toString());
			System.out.println("Nombre        Valor       Cantidad      Subtotal");
			factura.muestraFactura();
			this.facturas.add(factura);
		}
	}
	
	/**
	 * @param medico
	 * @param fecha1
	 * @param fecha2
	 */
	public void reporteMedico(IMedico medico, GregorianCalendar fecha1,GregorianCalendar fecha2) {
		 double importeTotal = 0;
          Iterator<Factura> it = this.facturas.iterator();
		  
		   while(it.hasNext()) {
			Factura actual = it.next(); // nodo de la lista
		    Iterator<Prestacion> prestaciones = actual.getPrestaciones().iterator();  // sublista
		    while(prestaciones.hasNext()) {
		    	Prestacion prestacionActual = prestaciones.next(); // nodo de sublista
		    	if(actual.getFecha().compareTo(fecha1)>=0 && actual.getFecha().compareTo(fecha2)<=0 && prestacionActual.getPrestacion().equals(medico.getNombre()+" "+medico.getMatricula())) {
		    		System.out.println("Paciente: "+actual.getPaciente().getNombre()+" "+ actual.getPaciente().getApellido()+" -Cantidad: "+prestacionActual.getCantidad()+" -Subtotal: "+prestacionActual.getSubtotal());
		    		importeTotal+=prestacionActual.getSubtotal();
		    	}	
		    }			
		   }
		   System.out.println("Importe Total: "+importeTotal);
	}
	public SalaDeEspera getSalaEspera() {
		return salaEspera;
	}
	public ArrayList<Paciente> getPatio() {
		return patio;
	}
	
					
	}