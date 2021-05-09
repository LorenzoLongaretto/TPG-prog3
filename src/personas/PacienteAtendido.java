package personas;

import java.util.GregorianCalendar;

public class PacienteAtendido implements Comparable{
  // Para el TreeSet de pacientes Atendidos que tiene el medico
	private String nombre,apellido,DNI;
	private int cantConsultas;
	private double subtotal;
	private GregorianCalendar fecha;

	
	public PacienteAtendido(String nombre, String apellido, int cantConsultas, double subtotal, GregorianCalendar fecha, String DNI) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.cantConsultas = cantConsultas;
		this.subtotal = subtotal;
		this.fecha = fecha;
		this.DNI=DNI;
	}

	 
	public String getDNI() {
		return DNI;
	}


	public void setDNI(String dNI) {
		DNI = dNI;
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


	@Override
	public int compareTo(Object o) {// Esta ordenado por fecha
		PacienteAtendido paciente = (PacienteAtendido) o; 
		return this.fecha.compareTo(paciente.fecha);
	}


	@Override
	public String toString() {
		return " [nombre=" + nombre + ", apellido=" + apellido + ", DNI=" + DNI + ", cantConsultas="
				+ cantConsultas + ", subtotal=" + subtotal + ", fecha=" + fecha.getFirstDayOfWeek() + "]";
	}
	
	
}
