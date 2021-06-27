package vista;

import java.awt.event.ActionListener;
import java.util.HashMap;

import personas.Asociado;
import personas.Operario;

public interface IVistaAmbulancia {
	void setActionListenerAmbulancia(ActionListener actionListener);
	Asociado getAsociadoSeleccionadoSimulacion();
	String getCantidad();
	String getTipo();
	void simulacion(HashMap<Integer, Asociado> asociados,Operario operario);
	void mensaje(String msj);
    void borrarPanel();
	
}
