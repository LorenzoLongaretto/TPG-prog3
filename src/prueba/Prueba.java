package prueba;
import personas.Paciente;
import modelo.Clinica;
import modelo.IMedico;
import modelo.MedicoFactory;
import modelo.PacienteFactory;

import java.util.GregorianCalendar;

import excepciones.ImposibleCrearMedicoException;
import excepciones.NoExisteRangoEtarioException;
import infraestructura.Factura;
import infraestructura.HabitacionCompartida;
public class Prueba {

	public static void main(String[] args) {
		
		
   
		
		Paciente paciente=null,paciente2=null,paciente3=null,paciente4=null;
		//cuando copien y pegen para hacer mas pacientes recuerden cambiarles el DNI
		try {
			paciente = PacienteFactory.getPaciente("41927911", "Juan Jose", "Java", "MDP","2235673421", "San Juan 2140","Nino");
			paciente2 = PacienteFactory.getPaciente("41822123", "Guillermo", "Lazurri", "MDP","2235673421", "San Juan 2140","Mayor");
		    paciente3  = PacienteFactory.getPaciente("333", "32", "lop", "fds","fsdf", "fsdfs","Nino");
		    paciente4  = PacienteFactory.getPaciente("444", "negro", "blanco", "fds","fsdf", "fsdfs","Joven");
		       
		} catch (NoExisteRangoEtarioException e) {
			System.out.println(e.getMessage()+e.getRango());
		}
            
        Clinica.getInstance().ingresoPaciente(paciente); //busca o genera la historia
        Clinica.getInstance().ingresoPaciente(paciente4);
        Clinica.getInstance().ingresoPaciente(paciente2);
        Clinica.getInstance().ingresoPaciente(paciente3);
       
        // Creacion de medicos
        IMedico medico =null;
        try {
			 medico = MedicoFactory.getMedico("25900987","Luis","Montini","MDP","2234565","Independencia","1234","Cirujia","Permanente","Magister");
		} catch (ImposibleCrearMedicoException e) {
            System.out.println(e.getMessage()+e.getDato());
        }
        GregorianCalendar fecha1 = new GregorianCalendar(2020,1,1);
        GregorianCalendar fecha2 = new GregorianCalendar(2020,2,1);
        
        System.out.println("------------------------");
        Clinica.getInstance().derivarPaciente(paciente);
        Clinica.getInstance().atenderPaciente(paciente);
        
        Clinica.getInstance().derivarPaciente(paciente2);
        Clinica.getInstance().atenderPaciente(paciente2);
        
        Factura factura = new Factura(1,fecha1,paciente);
        factura.asignarMedico(medico);
        System.out.println("FACTURA:");
        factura.asignarMedico(medico);
        factura.asignarHabitacion(new HabitacionCompartida(32,21,200));
      
        Factura factura2 = new Factura(2,fecha1,paciente2);
        factura2.asignarMedico(medico);
        
        Clinica.getInstance().egreso(paciente,factura);
        Clinica.getInstance().egreso(paciente2,factura2);
        
        System.out.println("--------------------");
        System.out.println("REPORTE:");
        Clinica.getInstance().reporteMedico(medico, fecha1, fecha2);    
	}
 
}
