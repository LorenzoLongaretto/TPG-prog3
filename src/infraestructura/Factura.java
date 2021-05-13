package infraestructura;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import personas.Paciente;

import modelo.IMedico;

public class Factura implements Comparable{
	
	private int nroFactura;
	private GregorianCalendar fecha;
	private Paciente paciente;
	private double importeTotal;
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
			Prestacion nueva = new Prestacion(medico.getNombre()+" "+medico.getMatricula(),medico.getHonorario()*1.2,1);
			
			nueva.setSubtotal(nueva.getCantidad()*nueva.getValor());
			this.prestaciones.add(nueva);
			
		}		 
	}
	 
	 public void asignarHabitacion(Habitacion habitacion) {
		 Prestacion nueva = new Prestacion(habitacion.toString(),habitacion.getCostoAsignacion(),habitacion.getCantDias());
		 nueva.setSubtotal(habitacion.costoDeHabitacion(habitacion.getCantDias()));	
		 this.prestaciones.add(nueva);
			
		}

	 
	 
	public Paciente getPaciente() {
		return paciente;
	}

	public GregorianCalendar getFecha() {
		return fecha;
	}

	@Override
	public String toString() {
		return "Factura Nro: "+nroFactura +" Fecha: "+fecha.getTime() +" Paciente: "+this.paciente.getNombre() +" "+this.paciente.getApellido();   // Hay que cambiar esto para que muestre bien la fecha
	 
	}
	
	public void muestraFactura() {
		for (Prestacion prestaciones : this.prestaciones) {
			System.out.println(prestaciones.toString());
		}
	
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
		return this.fecha.compareTo(factura.fecha);
	}
}
