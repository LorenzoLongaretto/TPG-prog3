package infraestructura;

public class HabitacionCompartida extends Habitacion {

	private static double costoExtra=200;//PREGUNTAR
	
	//Constructores
	public HabitacionCompartida(int nroHabitacion,int cantDias,double costoAsignacion) {
		super(nroHabitacion,cantDias,costoAsignacion);
		this.cantPersonas=2; // cantidad de personas en una habitacion
		this.cantActual=0;
		
	}

	//Metodos
	@Override
	public double costoDeHabitacion(int cantDias) {
		return (this.getCantDias() * HabitacionCompartida.costoExtra)+this.getCostoAsignacion();
	}

	@Override
	public String toString() {
		return super.toString()+ "---Tipo:Habitacion Compartida";
	}

}
