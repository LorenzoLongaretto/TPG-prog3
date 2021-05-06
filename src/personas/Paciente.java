package personas;

public abstract class Paciente extends Persona implements Comparable<Object>{
private String rangoEtario;
private int numeroHistoria,nroOrden;


	//Constructores
	public Paciente(String dNI, String nombre, String apellido, String ciudad, String telefono, String domicilio,String rangoEtario,int nroOrden) {
		super(dNI, nombre, apellido, ciudad, telefono, domicilio);
		// TODO Auto-generated constructor stub
		this.rangoEtario=rangoEtario;
		this.nroOrden = nroOrden;
	}
	
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
	
	public void asignarMedico(Medico medico) {
		
		
	}

	public int getNumeroHistoria() {
		return numeroHistoria;
	}

	public void setNumeroHistoria(int numeroHistoria) {
		this.numeroHistoria = numeroHistoria;
	}

	@Override
	public int compareTo(Object o) {
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
		return " nombre=" + nombre+", apellido=" + apellido+" nro historia " + numeroHistoria +" es " + rangoEtario;
		
}
	
}


