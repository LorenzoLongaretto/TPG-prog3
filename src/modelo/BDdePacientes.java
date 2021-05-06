package modelo;

import java.util.Iterator;
import java.util.TreeSet;
import personas.Paciente;

public class BDdePacientes {	
	private int generaNumHist=0;
	TreeSet<Paciente> pacientesBD= new TreeSet<>();

	public BDdePacientes() {

	}
	
	public boolean buscarPaciente(Paciente paciente) {
		Iterator<Paciente> it = this.pacientesBD.iterator();
		boolean existe=false;
		while(it.hasNext() && existe==false) {
			Paciente pacienteActual = it.next();
			if(pacienteActual.getDNI() == paciente.getDNI()) //haces la busqueda por dni y si no encontras generas un nro de historia
				existe=true;
		}
		return existe;
	}
	public void altaDePaciente(Paciente nuevo) {
		generaNumHist++;
		nuevo.setNumeroHistoria(generaNumHist);
		this.pacientesBD.add(nuevo);	
	}	
}
