package modelo;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeSet;

import personas.Paciente;
import personas.Asociado;
import infraestructura.SalaDeEspera;
import infraestructura.Factura;
import infraestructura.Habitacion;
import infraestructura.Prestacion;



/**
 * 
 *<br>
 * Clase que representa una clinica. Contiene la totalidad de los pacientes. Tambien contine un patio, una sala de espera y una lista de facturas correspondientes a los pacientes.
 *
 */
public class Clinica {

	//Atributos
	private static Clinica instance = null;  // aplico patron singleton

    private String nombre;
    private String direccion;
    /**
     * @aggregation composite
     */
    private SalaDeEspera salaEspera = new SalaDeEspera();

    /**
     * @aggregation composite
     */
    private ArrayList<Paciente> patio= new ArrayList<Paciente>();

    /**
     * @aggregation composite
     */
    private Queue<Paciente> listaEspera= new LinkedList<Paciente>();

    /**
     * @aggregation composite
     */
    private Queue<Paciente> listaAtencion= new LinkedList<Paciente>();

    /**
     * @aggregation composite
     */
    private TreeSet<Factura> facturas= new TreeSet<>();

    /**
     * @aggregation composite
     */
    private BDdePacientes pacientes = new BDdePacientes();
    private HashMap<Integer,Habitacion> habitaciones = new HashMap<Integer,Habitacion>();
    //Clave = Nro de habitacion
    private HashMap<Integer,IMedico> medicos = new HashMap<Integer,IMedico>();
    // Clave  = DNI de los medicos
    private HashMap<Integer,Asociado> asociados = new HashMap<Integer,Asociado>();
    //Clave  = DNI de los Asociados
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
	
	/**Deriva al paciente a el patio o sala de espera de acuerdo a su prioridad
	 * <b> Pre: El parametro paciente debe ser distinto de null.</b>
	 * <b> Post: Se agrega al paciente al patio o sala de espera segun corresponda.</b>
	 * 
	 * 
	 * @param paciente: Parametro de tipo paciente, que es derivado.
	 */
	public void derivarPaciente(Paciente paciente) {
		nroOrden++;
		paciente.setNroOrden(nroOrden);
		this.listaEspera.add(paciente);
		
		if(this.salaEspera.isOcupada()) {
			if(!this.salaEspera.getPaciente().prioridad(paciente)) {//si cumple, entonces entra this.salaEspera.paciente.prioridad(paciente)==false
				this.patio.add(this.salaEspera.getPaciente());
				this.salaEspera.ocupaSalaDeEspera(paciente);
			}
			else
				this.patio.add(paciente);
		}
		else 
			this.salaEspera.ocupaSalaDeEspera(paciente);	
	}
	
	/**Se quita a los pacientes del patio o sala de espera, y los introduce dentro de la lista de atencion.
	 * <b> Pre: El parametro paciente debe ser distinto de null.</b>
	 * <b> Post: Se agrega al paciente a la lista de atencion</b>
	 * @param paciente: Parametro de tipo paciente, que es atendido.
	 */
	public void atenderPaciente(Paciente paciente){
		
		this.listaEspera.remove(paciente);
        
        if(this.patio.contains(paciente)) // si esta en el patio lo elimino
            this.patio.remove(paciente);
        else                                   // esta en la sala privada
            this.salaEspera.desocupar();
        
        this.listaAtencion.add(paciente);                
    }
	public void facturacion(Factura factura) {
		this.facturas.add(factura); // agrega la factura a la lista
	}
	/**Se toma al primer paciente de la lista de atencion, y se le confecciona la factura correspondiente. Luego , esa factura es mostrada.
	 * <b> Pre: El parametro paciente y factura debe ser distinto de null.</b>
	 * <b> Post: Se elimina al paciente de la lista de atencion y se muestra su factura.</b>
	 * @param paciente: Parametro de tipo paciente.
	 * @param factura: Parametro de tipo factura.
	 */
	
	//pasar paciente y fecha de la factura --> buscar factura y mostrarla
	public void egreso(Paciente paciente,Factura factura) {
		if(this.listaAtencion.contains(paciente)) {
			this.listaAtencion.remove(paciente);
			System.out.println(factura.toString());
			System.out.println("Nombre        Valor       Cantidad      Subtotal");
			factura.muestraFactura();
			this.facturas.add(factura);
		}
	}
	// Metodo que agrega el medico elegido por el paciente a la factura 
	public void agregarMedico(IMedico medico){
		this.medicos.put(Integer.parseInt(medico.getMatricula()) , medico);
	}
	
	public void asignarHabitacion(Habitacion habitacion) {
		this.habitaciones.put(habitacion.getNroHabitacion(), habitacion);
	}
	// agrega medico a la factura 
	public void derivarMedico(Factura factura,IMedico medico) {
		if(medico!=null)
		factura.asignarMedico(medico);		
	}
	//agrega paciente a la factura
	public void derivarHabitacion(Factura factura,Habitacion habitacion) {
		if(habitacion.getCantPersonas()!=0 && habitacion!=null) // si esta en 0 significa que no hay espacio 
	          factura.asignarHabitacion(habitacion);
	}
	public IMedico buscaMedico(int matricula) {
		return this.medicos.get(matricula);
	}
	
	public Habitacion buscaHabitacion(int nro) {
		return this.habitaciones.get(nro);
	}
	
	/**Se realiza un reporte de los pacientes atendidos, dentro de un periodo de fechas determinado.
	 * <b> Pre: El parametro medico, fecha1 y fecha2 debe ser distinto de null.</b>
	 * <b> Post:Se muestra el reporte de pacientes del medico introducido.</b>
	 * @param medico:Parametro de tipo medico.
	 * @param fecha1: Parametro de tipo GregorianCalendar.
	 * @param fecha2  Parametro de tipo GregorianCalendar.
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
	//dni, nombre y apellido, domicilio, teléfono.
/*	public void altaAsociado(int DNI,String nombre,String apellido,String domicilio,String telefono) {
		Asociado a=null;
		a = asociados.get(DNI);
		if(a==null) {  // no existe el asociado
			Asociado a = new Asociado(DNI,nombre,apellido,domicilio,telefono);
			this.asociados.put(DNI,a);
		}
		//else
		       //Lanzar Excepcion de que ya existe
			
		
		
	}*/
	public void eliminarAsociado(int DNI) {
		Asociado a=null;
		a = asociados.get(DNI);
		if(a!=null) {  // estaba en el HashMap
			
			asociados.remove(DNI);
			
		}
		// Lanzar Excepcion ya que no se encontraba en el HashMap
	}
	
	public SalaDeEspera getSalaEspera() {
		return salaEspera;
	}
	public ArrayList<Paciente> getPatio() {
		return patio;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Queue<Paciente> getListaEspera() {
		return listaEspera;
	}
	public void setListaEspera(Queue<Paciente> listaEspera) {
		this.listaEspera = listaEspera;
	}
	public Queue<Paciente> getListaAtencion() {
		return listaAtencion;
	}
	public void setListaAtencion(Queue<Paciente> listaAtencion) {
		this.listaAtencion = listaAtencion;
	}
	public TreeSet<Factura> getFacturas() {
		return facturas;
	}
	public void setFacturas(TreeSet<Factura> facturas) {
		this.facturas = facturas;
	}
	public BDdePacientes getPacientes() {
		return pacientes;
	}
	public void setPacientes(BDdePacientes pacientes) {
		this.pacientes = pacientes;
	}
	public HashMap<Integer, Habitacion> getHabitaciones() {
		return habitaciones;
	}
	public void setHabitaciones(HashMap<Integer, Habitacion> habitaciones) {
		this.habitaciones = habitaciones;
	}
	public HashMap<Integer, IMedico> getMedicos() {
		return medicos;
	}
	public void setMedicos(HashMap<Integer, IMedico> medicos) {
		this.medicos = medicos;
	}
	public HashMap<Integer, Asociado> getAsociados() {
		return asociados;
	}
	public void setAsociados(HashMap<Integer, Asociado> asociados) {
		this.asociados = asociados;
	}
	public int getNroOrden() {
		return nroOrden;
	}
	public void setNroOrden(int nroOrden) {
		this.nroOrden = nroOrden;
	}
	public void setSalaEspera(SalaDeEspera salaEspera) {
		this.salaEspera = salaEspera;
	}
	public void setPatio(ArrayList<Paciente> patio) {
		this.patio = patio;
	}
	
					
	}