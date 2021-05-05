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
		
		
		
		IMedico medico = MedicoFactory.getMedico("25900987","Luis","Montini","MDP","2234565","Independencia","1234","Cirujia","Permanente","Magister");
		
        Paciente paciente  = PacienteFactory.getPaciente("321", "fa", "lop", "fds","fsdf", "fsdfs", "", "Nino", 0);
        Paciente paciente2  = PacienteFactory.getPaciente("321", "lop", "fa", "fds","fsdf", "fsdfs", "", "Mayor", 0);
        Paciente paciente3  = PacienteFactory.getPaciente("321", "32", "lop", "fds","fsdf", "fsdfs", "", "Nino", 0);
        Paciente paciente4  = PacienteFactory.getPaciente("321", "negro", "blanco", "fds","fsdf", "fsdfs", "", "Joven", 0);
       
        System.out.println(medico.getHonorario());
        System.out.println(medico);
        Clinica.getInstance().derivarPaciente(paciente);
        Clinica.getInstance().derivarPaciente(paciente2);
        Clinica.getInstance().derivarPaciente(paciente3);
        Clinica.getInstance().derivarPaciente(paciente4);//double dispach 10/10
        System.out.println(Clinica.getInstance().getSalaEspera().getPaciente());
        System.out.println("LOS PACIENTES QUE ESTAN EN EL PATIO   "+Clinica.getInstance().getPatio());
        Clinica.getInstance().atenderPaciente(paciente);
        
        System.out.println(paciente);
        /*
         * falta 
         * hacer las historias clinicas
         * implementar la facturacion
         * excepciones
         * arrancar la segunda parte de la mv
         * 
         */
	}
 
}
