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
		
		
   
		//cuando copien y pegen para hacer mas pacientes recuerden cambiarles el DNI
		Paciente paciente=null,paciente2=null,paciente3=null,paciente4=null;
		try {
			paciente = PacienteFactory.getPaciente("111", "fa", "lop", "fds","fsdf", "","Nino");
			paciente2  = PacienteFactory.getPaciente("222", "lop", "fa", "fds","fsdf", "fsdfs", "Mayor");
		     paciente3  = PacienteFactory.getPaciente("333", "32", "lop", "fds","fsdf", "fsdfs","Nino");
		    paciente4  = PacienteFactory.getPaciente("444", "negro", "blanco", "fds","fsdf", "fsdfs","Joven");
		       
		} catch (NoExisteRangoEtarioException e1) {
			System.out.println(e1.getMessage());
		}
            
        Clinica.getInstance().ingresoPaciente(paciente); //busca o genera la historia
        Clinica.getInstance().ingresoPaciente(paciente4);
        Clinica.getInstance().ingresoPaciente(paciente2);
        Clinica.getInstance().ingresoPaciente(paciente3);
       
        // Creacion de medicos
        IMedico medico =null;
        try {
			 medico = MedicoFactory.getMedico("25900987","Luis","Montini","MDP","2234565","Independencia","1234","Cirujia","Permanente","Magister");
		} catch (NoExisteEspecialidadException | NoExisteContratacionException e) {
            System.out.println(e.getMessage());
        }
        GregorianCalendar fecha1 = new GregorianCalendar(2020,1,1);
        GregorianCalendar fecha2 = new GregorianCalendar(2020,2,1);
        
        System.out.println("------------------------");
        Clinica.getInstance().derivarPaciente(paciente);
        Clinica.getInstance().atenderPaciente(paciente);
       
        //System.out.println("esta en la sala de espera "+ Clinica.getInstance().getSalaEspera().getPaciente());
        //System.out.println("LOS PACIENTES QUE ESTAN EN EL PATIO   "+Clinica.getInstance().getPatio());
        Clinica.getInstance().atenderPaciente(paciente);
        
        // Prueba Factura
       
        //System.out.println(paciente);
        Factura factura = new Factura(1,fecha1,paciente);
        factura.asignarMedico(medico);
        System.out.println("FACTURA:");
        factura.asignarMedico(medico);
        factura.asignarHabitacion(new HabitacionCompartida(32,21,200));
      
       
        Clinica.getInstance().egreso(paciente,factura);
        System.out.println("REPORTE:");
        Clinica.getInstance().reporteMedico(medico, fecha1, fecha2);
        
       
	}
 
}
