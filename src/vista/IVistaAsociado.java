package vista;

import java.awt.event.ActionListener;
import java.util.HashMap;

import personas.Asociado;

public interface IVistaAsociado {

	public void setActionListenerAsociado(ActionListener actionListener);
	public String getDNI();
	public String getNombre();
	public String getApellido();
	public String getTelefono();
	public String getDomicilio();
	public Asociado getAsociadoSeleccionado();
	public void agregarAsociado(Asociado asociado);
	public void actualizaAsociados(HashMap<Integer,Asociado> asociados);
	public void borraListaAsociados();
	public void mensaje(String msj);
}
