package vista;

import java.awt.event.ActionListener;
import java.util.HashMap;

import personas.Asociado;

public interface IVistaAmbulancia {
	void setActionListenerAmbulancia(ActionListener actionListener);
	Asociado getAsociadoSeleccionadoSimulacion();
	String getCantidad();
	String getTipo();
	void simulacion(HashMap<Integer, Asociado> asociados);
	void anularSimulacion();
	void mensaje(String msj);
    void borrarPanel();
	
}
