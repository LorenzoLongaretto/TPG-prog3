package personas;

import java.util.GregorianCalendar;

public class PacienteAtendido implements Comparable{
  // Para el TreeSet de pacientes Atendidos que tiene el medico
	private String nombre,apellido;
	private int cantConsultas;
	private double subtotal;
	private GregorianCalendar fecha;

	
	public PacienteAtendido(String nombre, String apellido, int cantConsultas, double subtotal, GregorianCalendar fecha) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.cantConsultas = cantConsultas;
		this.subtotal = subtotal;
		this.fecha = fecha;
	}


	public GregorianCalendar getFecha() {
		return fecha;
	}


	public String getNombre() {
		return nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public int getCantConsultas() {
		return cantConsultas;
	}


	public double getSubtotal() {
		return subtotal;
	}


	public void setCantConsultas(int cantConsultas) {
		this.cantConsultas = cantConsultas;
	}


	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}


	// Esta ordenado por fecha
	@Override
	public int compareTo(Object o) {
		PacienteAtendido paciente = (PacienteAtendido) o; 
		return this.fecha.compareTo(fecha);
	}
	
	
}
