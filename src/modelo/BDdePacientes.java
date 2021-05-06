package modelo;

import java.util.Iterator;
import java.util.TreeSet;
import personas.Paciente;

public class BDdePacientes {	
	TreeSet<Paciente> pacientesBD= new TreeSet<>();

	public BDdePacientes() {

	}
	public boolean buscarPaciente(Paciente paciente) {
		Iterator<Paciente> it = this.pacientesBD.iterator();
		boolean existe=false;
		while(it.hasNext() && existe==false) {
			Paciente pacienteActual = it.next();
			if(pacienteActual.getNumeroHistoria() == paciente.getNumeroHistoria()) 
				existe=true;		
		}
		return existe;
	}
	public void altaDePaciente(Paciente nuevo) {
		this.pacientesBD.add(nuevo);		
	}	
}
