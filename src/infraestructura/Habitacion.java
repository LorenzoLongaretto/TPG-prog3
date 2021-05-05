package infraestructura;
import personas.Paciente;

public abstract class Habitacion {
//aplicar Factory para las habitaciones
	
	//Atributos
	private int nroHabitacion, cantDias;//VERIFICAR nroHabitacion
	private boolean ocupada;
	private Paciente paciente;
	private double costoAsignacion;//El de cada habitacion particular

	
	//Constructores
	public Habitacion(int nroHabitacion,int cantdias,double costoAsignacion) {
		super();
		this.nroHabitacion = nroHabitacion;
		this.ocupada = false;
		this.paciente = null;
		this.cantDias=cantdias;
		this.costoAsignacion=costoAsignacion;
	}

	//Metodos
	public abstract double costoDeHabitacion(int cantDias);
	public int getNroHabitacion() {
		return nroHabitacion;
	}
	public int getCantDias() {
		return cantDias;
	}
	public boolean isOcupada() {
		return ocupada;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public double getCostoAsignacion() {
		return costoAsignacion;
	}

	@Override
	public String toString() {
		return "Habitacion nroHabitaci=" + nroHabitacion;
	}
	
	
}
