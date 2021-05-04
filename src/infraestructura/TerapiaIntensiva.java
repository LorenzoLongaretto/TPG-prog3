package infraestructura;

public class TerapiaIntensiva extends Habitacion {

	//Atributos
	private static double costoExtra=600;
	
	//Constructores
	public TerapiaIntensiva(int nroHabitacion) {
		super(nroHabitacion);
	}

	//Metodos
	@Override
	public double costoDeHabitacion(int cantDias) {
		return Math.pow(TerapiaIntensiva.costoExtra, cantDias) +this.getCostoAsignacion();
	}

}
