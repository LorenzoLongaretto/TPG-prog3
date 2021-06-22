package vista;
import java.awt.event.ActionListener;
import java.util.Queue;

import infraestructura.Factura;
import personas.Paciente;



public interface IVistaPaciente{

	
	public void setActionListener(ActionListener actionListener);
	public Paciente getPacienteSeleccionado(); // devuelve el paciente seleccionado
	public void borraLista();
	public void actualizaLista(Queue<Paciente> atencion);// actualiza la lista de pacientes en la lista
	public void agregaPaciente(Paciente paciente);
	
	public void actualizaFactura(Factura factura);
	
	
	public void mensaje(String msj);
	
}
