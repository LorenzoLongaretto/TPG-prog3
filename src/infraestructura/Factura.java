package infraestructura;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;

import personas.Medico;
import personas.Paciente;
import infraestructura.Habitacion;

public class Factura {
	
	private int nroFactura;
	private GregorianCalendar fecha;
	private Paciente paciente;
	private double importeTotal;
	private ArrayList <Prestacion> prestaciones = new ArrayList <Prestacion>();
	
	
	 public Factura(int nroFactura, GregorianCalendar fecha, Paciente paciente) {
		this.nroFactura = nroFactura;
		this.fecha = fecha;
		this.paciente = paciente;
	}

	public void asignarMedico(Medico medico) {
		Iterator<Prestacion> it = this.prestaciones.iterator();
		int existe=0;
		while(it.hasNext()) {
			Prestacion prestacionActual = it.next();
			if(medico.getNombre().equals(prestacionActual.getPrestacion())) {
				existe=1;
				prestacionActual.setCantidad(prestacionActual.getCantidad() + 1);
				prestacionActual.setSubtotal(prestacionActual.getValor()*prestacionActual.getCantidad());
			}
				
		}
		if(existe==0) {
			Prestacion nueva = new Prestacion(medico.getNombre(),medico.getHonorario()*1.2,1);
			nueva.setSubtotal(nueva.getCantidad()*nueva.getValor());
			this.prestaciones.add(nueva);
			
		}		 
	}
	 
	 public void asignarHabitacion(Habitacion habitacion) {
		 Prestacion nueva = new Prestacion(habitacion.toString(),habitacion.costoDeHabitacion(habitacion.getCantDias()),habitacion.getCantDias());
			this.prestaciones.add(nueva);
			
		}
	 
}
