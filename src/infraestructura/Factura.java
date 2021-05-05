package infraestructura;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import personas.Paciente;

public class Factura {
	
	private int nroFactura;
	private GregorianCalendar fecha;
	private Paciente paciente;
	private double importeTotal;
	private ArrayList <Prestacion> listaEspera = new ArrayList <Prestacion>();
	
	
}
