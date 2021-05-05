package prueba;
import personas.Persona;
import personas.Paciente;
import personas.Medico;
import modelo.Clinica;
import modelo.IMedico;
import modelo.MedicoFactory;
import modelo.PacienteFactory;

public class Prueba {

	public static void main(String[] args) {
		
		
		
		IMedico medico = MedicoFactory.getMedico("25900987","Luis","Montini","MDP","2234565","Independencia","1234","Cirugia","Permanente","Magister");
		
        Paciente paciente  = PacienteFactory.getPaciente(null, null, null, null, null, null, null, null, 0);
	
        Clinica.getInstance().derivarPaciente(paciente);
        
	}
 
}
