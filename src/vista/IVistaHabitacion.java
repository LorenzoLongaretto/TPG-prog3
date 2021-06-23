package vista;

import java.awt.event.ActionListener;
import java.util.HashMap;

import infraestructura.Habitacion;



public interface IVistaHabitacion {

	public void setActionListenerHabitacion(ActionListener actionListener);
	public Habitacion getHabitacionSeleccionada();
	public void actualizaListaHabitaciones(HashMap<Integer,Habitacion> habitaciones);
	public void agregarHabitacion(Habitacion habitacion);
	
}
