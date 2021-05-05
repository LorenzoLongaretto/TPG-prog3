package infraestructura;
import personas.Paciente;

public abstract class Habitacion {
//aplicar Factory para las habitaciones
	
	//Atributos
	protected int nroHabitacion, cantDias;//VERIFICAR nroHabitacion
	protected boolean ocupada;
	protected Paciente paciente;
	protected double costoAsignacion;//El de cada habitacion particular
	
	
	//Constructores
	public Habitacion(int nroHabitacion) {
		super();
		this.nroHabitacion = nroHabitacion;
		this.ocupada = false;
		this.paciente = null;
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
