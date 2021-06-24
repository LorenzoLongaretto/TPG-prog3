package infraestructura;

public class TerapiaIntensiva extends Habitacion {

	//Atributos
	private static double costoExtra=600;
	
	//Constructores
	public TerapiaIntensiva(int nroHabitacion,int cantDias,double costoAsignacion) {
		super(nroHabitacion, cantDias,costoAsignacion);
		this.cantActual=0;
	}

	//Metodos
	@Override
	public double costoDeHabitacion(int cantDias) {
		return Math.pow(TerapiaIntensiva.costoExtra, cantDias) +this.getCostoAsignacion();
	}

	@Override
	public String toString() {
		return super.toString()+ "---Tipo: Terapia Intensiva";
	}

}
