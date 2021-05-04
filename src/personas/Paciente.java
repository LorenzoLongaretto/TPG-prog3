package personas;

public abstract class Paciente extends Persona {
private String numeroHistoria,rangoEtario;
private int nroOrden;

	//Constructores
	public Paciente(String dNI, String nombre, String apellido, String ciudad, String telefono, String domicilio,String numerohistoria,String rangoEtario,int nroOrden) {
		super(dNI, nombre, apellido, ciudad, telefono, domicilio);
		// TODO Auto-generated constructor stub
		this.numeroHistoria=numerohistoria;
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

}
