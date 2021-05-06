package prueba;
import personas.Persona;
import personas.Paciente;
import personas.Medico;
import modelo.Clinica;
import modelo.IMedico;
import modelo.MedicoFactory;
import modelo.PacienteFactory;

import java.util.GregorianCalendar;

import excepciones.NoExisteContratacionException;
import excepciones.NoExisteEspecialidadException;
import excepciones.NoExisteRangoEtarioException;
import infraestructura.Factura;
import infraestructura.HabitacionCompartida;
public class Prueba {

	public static void main(String[] args) {
		
		
		
		IMedico medico;
		try {
			medico = MedicoFactory.getMedico("25900987","Luis","Montini","MDP","2234565","Independencia","1234","Cirugia","Permanente","Magister");
	        System.out.println("Honorario: "+medico.getHonorario());
	        System.out.println(medico.toString());   	
		} catch (NoExisteEspecialidadException e) {
			System.out.println(e.getMessage()+e.getEspecialidad());
		} catch (NoExisteContratacionException e) {
			System.out.println(e.getMessage()+e.getContratacion());
		}
		
		
		
        try {
			Paciente paciente  = PacienteFactory.getPaciente("321", "fa", "lop", "fds","fsdf", "fsdfs", "", "Nino", 0);
		} catch (NoExisteRangoEtarioException e) {
			System.out.println(e.getMessage() + e.getRango());
		}
        //Paciente paciente2  = PacienteFactory.getPaciente("321", "lop", "fa", "fds","fsdf", "fsdfs", "", "Mayor", 0);
        //Paciente paciente3  = PacienteFactory.getPaciente("321", "32", "lop", "fds","fsdf", "fsdfs", "", "Nino", 0);
        //Paciente paciente4  = PacienteFactory.getPaciente("321", "negro", "blanco", "fds","fsdf", "fsdfs", "", "Joven", 0);
       
        
        
        /*
        Clinica.getInstance().derivarPaciente(paciente);
        Clinica.getInstance().derivarPaciente(paciente2);
        Clinica.getInstance().derivarPaciente(paciente3);
        Clinica.getInstance().derivarPaciente(paciente4);//double dispach 10/10
        System.out.println(Clinica.getInstance().getSalaEspera().getPaciente());
        System.out.println("LOS PACIENTES QUE ESTAN EN EL PATIO   "+Clinica.getInstance().getPatio());
        Clinica.getInstance().atenderPaciente(paciente);
        
        // Prueba Factura
      
        System.out.println(paciente);
        Factura factura = new Factura(1,null,paciente);
        factura.asignarMedico(medico);
        System.out.println("FACTURA:");
        factura.asignarMedico(medico);
        factura.asignarHabitacion(new HabitacionCompartida(32,21,200));
        System.out.println(factura.toString());
       */
        
        
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
