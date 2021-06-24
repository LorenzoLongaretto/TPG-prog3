package infraestructura;

public abstract class Habitacion {
//aplicar Factory para las habitaciones
	
	//Atributos
	private int nroHabitacion, cantDias;//VERIFICAR nroHabitacion
    /**
     * @aggregation shared
     */
	private double costoAsignacion;//El de cada habitacion particular
    protected int  cantPersonas; // cantidad de personas que entran en la habitacion
    protected int cantActual; // cantidad de personas que hay actualmente en la habitacion
	
	//Constructores
	public Habitacion(int nroHabitacion,int cantdias,double costoAsignacion) {
		
		this.nroHabitacion = nroHabitacion;
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

	public double getCostoAsignacion() {
		return costoAsignacion;
	}

	@Override
	public String toString() {
		return "Habitacion nro " + nroHabitacion;
	}

	public int getCantPersonas() {
		return cantPersonas;
	}

	public int getCantActual() {
		return cantActual;
	}

	public void setCantPersonas(int cantPersonas) {
		this.cantPersonas = cantPersonas;
	}

	public void setCantActual(int cantActual) {
		this.cantActual = cantActual;
	}
	
	
}
