package infraestructura;

public class HabitacionCompartida extends Habitacion {

	private static double costoExtra=200;//PREGUNTAR
	
	//Constructores
	public HabitacionCompartida(int nroHabitacion, double costoAsignacion) {
		super(nroHabitacion);
		this.costoAsignacion = costoAsignacion;
	}

	//Metodos
	@Override
	public double costoDeHabitacion(int cantDias) {
		return (this.getCantDias() * HabitacionCompartida.costoExtra)+this.getCostoAsignacion();
	}

}
