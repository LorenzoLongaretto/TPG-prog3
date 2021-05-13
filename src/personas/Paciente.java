package personas;
import infraestructura.Factura;
import infraestructura.Habitacion;
import modelo.IMedico;

public abstract class Paciente extends Persona implements Comparable<Object>{
private String rangoEtario;
private int numeroHistoria,nroOrden;

	//Constructores
	public Paciente(String dNI, String nombre, String apellido, String ciudad, String telefono, String domicilio,String rangoEtario) {
		super(dNI, nombre, apellido, ciudad, telefono, domicilio);
		// TODO Auto-generated constructor stub
		this.rangoEtario=rangoEtario;
	}
	/*
	coleccion

	factura ord fecha

	paciente nro hist o dni
	medico matricula

	 */
	
	//Metodos
	public boolean ocuparSala() {
		return false;
	}
	public String getRangoEtario() {
		return rangoEtario;
	}
	public abstract boolean prioridad(Paciente paciente);
	public abstract boolean prioridadNino();	
	public abstract boolean prioridadJoven();	
	public abstract boolean prioridadMayor();


	public int getNroOrden() {
		return nroOrden;
	}

	public void setNroOrden(int nroOrden) {
		this.nroOrden = nroOrden;
	}

	public int getNumeroHistoria() {
		return numeroHistoria;
	}

	public void setNumeroHistoria(int numeroHistoria) {
		this.numeroHistoria = numeroHistoria;
	}

	@Override
	public int compareTo(Object o) {     // Para que la lista de pacientes este ordenada por Nro Historia
		Paciente paciente=(Paciente)o;
		if(this.numeroHistoria>paciente.numeroHistoria)
			
			return 1;
		else
			if(this.numeroHistoria<paciente.numeroHistoria)
				return -1;
			else
				return 0;
	}


	@Override
	public String toString() {
		return " nombre=" + nombre+", apellido=" + apellido+" nro historia " + numeroHistoria +" es " + rangoEtario+" nro de orden "+nroOrden;
		
}
	
}


