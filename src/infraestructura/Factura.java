package infraestructura;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import personas.Paciente;

import modelo.IMedico;

public class Factura implements Comparable{
	
	private int nroFactura;
	private GregorianCalendar fecha;
	private Paciente paciente;
	private double importeTotal=0;
	private ArrayList <Prestacion> prestaciones = new ArrayList <Prestacion>();
	
	
	 public Factura(int nroFactura, GregorianCalendar fecha,Paciente paciente) {
		 this.paciente=paciente;
		this.nroFactura = nroFactura;
		this.fecha = fecha;
	}

	public void asignarMedico(IMedico medico) {
		Iterator<Prestacion> it = this.prestaciones.iterator();
		int existe=0;
		while(it.hasNext()) {
			Prestacion prestacionActual = it.next();
			if((medico.getNombre()+" "+medico.getMatricula()).equals(prestacionActual.getPrestacion())) {
				existe=1;
				prestacionActual.setCantidad(prestacionActual.getCantidad() + 1);
				prestacionActual.setSubtotal(prestacionActual.getValor()*prestacionActual.getCantidad());
			}
				
		}
		if(existe==0) {
			Prestacion nueva = new Prestacion(medico.getNombre()+" "+medico.getMatricula(),medico.getHonorario()*1.2,1);  // Ponemos nombre y matricula por si hay dos medicos con el mismo nombre
			nueva.setSubtotal(nueva.getCantidad()*nueva.getValor());
			this.prestaciones.add(nueva);
			
		}
		this.importeTotal+=medico.getHonorario()*1.2;
	}
	 
	 public void asignarHabitacion(Habitacion habitacion) {
		 Prestacion nueva = new Prestacion(habitacion.toString(),habitacion.getCostoAsignacion(),habitacion.getCantDias());
		 nueva.setSubtotal(habitacion.costoDeHabitacion(habitacion.getCantDias()));	
		 this.prestaciones.add(nueva);
		 this.importeTotal+=habitacion.costoDeHabitacion(habitacion.getCantDias());
			
		}

	 
	 
	public Paciente getPaciente() {
		return paciente;
	}

	public GregorianCalendar getFecha() {
		return fecha;
	}
	
	@Override
	public String toString() {
		SimpleDateFormat sdf =
				new SimpleDateFormat("EEEEE dd 'de' MMMMMMMMM 'de' yyyy");
		return "--Factura Nro: "+nroFactura +"--Fecha: "+sdf.format(fecha.getTime()) +"--Paciente: "+this.paciente.getNombre() +" "+this.paciente.getApellido();   // Hay que cambiar esto para que muestre bien la fecha
	 
	}
	
	public void muestraFactura() {
		
		for (Prestacion prestaciones : this.prestaciones) 
		       System.out.println(prestaciones.toString());
		
		System.out.println("Importe Total: "+this.importeTotal);
		
	
	}

	public ArrayList<Prestacion> getPrestaciones() {
		return prestaciones;
	}

	public void setPrestaciones(ArrayList<Prestacion> prestaciones) {
		this.prestaciones = prestaciones;
	}

	@Override
	public int compareTo(Object o) {
		
		Factura factura = (Factura) o; 
		int respuesta;
		
		if(this.fecha.compareTo(factura.fecha)!=0)
			respuesta = this.fecha.compareTo(factura.fecha);
		else {
			respuesta = this.paciente.getNumeroHistoria() - factura.paciente.getNumeroHistoria();
		}
			
		return respuesta;
	}
}
