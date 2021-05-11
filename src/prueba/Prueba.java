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
		
		
		
	/*	IMedico medico;
		try {
			medico = MedicoFactory.getMedico("25900987","Luis","Montini","MDP","2234565","Independencia","1234","Cirujia","Permanente","Magister");
	        System.out.println("Honorario: "+medico.getHonorario());
	        System.out.println(medico.toString());   	
		} catch (NoExisteEspecialidadException e) {
			System.out.println(e.getMessage()+e.getEspecialidad());
		} catch (NoExisteContratacionException e) {
			System.out.println(e.getMessage()+e.getContratacion());
		}
		*/
		
		
   /*     try {
			Paciente paciente  = PacienteFactory.getPaciente("321", "fa", "lop", "fds","fsdf", "",123,"Nino", 0);
			Clinica.getInstance().buscarHistoria(paciente);
		} catch (NoExisteRangoEtarioException e) {
			System.out.println(e.getMessage() + e.getRango());
		}
        */
		//cuando copien y pegen para hacer mas pacientes recuerden cambiarles el DNI
		Paciente paciente  = PacienteFactory.getPaciente("111", "fa", "lop", "fds","fsdf", "","Nino");
        Paciente paciente2  = PacienteFactory.getPaciente("222", "lop", "fa", "fds","fsdf", "fsdfs", "Mayor");
        Paciente paciente3  = PacienteFactory.getPaciente("333", "32", "lop", "fds","fsdf", "fsdfs","Nino");
        Paciente paciente4  = PacienteFactory.getPaciente("444", "negro", "blanco", "fds","fsdf", "fsdfs","Joven");
       
        
        Clinica.getInstance().ingresoPaciente(paciente); //busca o genera la historia
        Clinica.getInstance().ingresoPaciente(paciente4);
        Clinica.getInstance().ingresoPaciente(paciente2);
        Clinica.getInstance().ingresoPaciente(paciente3);
        //System.out.println(paciente);
        //System.out.println(paciente4);
        //System.out.println(paciente2);
        //System.out.println(paciente3);
        IMedico medico =null;
        try {
			 medico = MedicoFactory.getMedico("25900987","Luis","Montini","MDP","2234565","Independencia","1234","Cirujia","Permanente","Magister");
		} catch (NoExisteEspecialidadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoExisteContratacionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        GregorianCalendar fecha1 = new GregorianCalendar(2020,1,1);
        GregorianCalendar fecha2 = new GregorianCalendar(2020,2,1);
        paciente.setFactura(new Factura(12,fecha1));
        paciente.asignarMedico(medico);
        paciente.asignarMedico(medico);
        paciente.asignarHabitacion(new HabitacionCompartida(10,2,1200));
        medico.reporte(fecha1,fecha2);
        System.out.println("------------------------");
        Clinica.getInstance().derivarPaciente(paciente);
        Clinica.getInstance().atenderPaciente(paciente);
        Clinica.getInstance().egreso(paciente);
        
 
        //System.out.println("esta en la sala de espera "+ Clinica.getInstance().getSalaEspera().getPaciente());
        //System.out.println("LOS PACIENTES QUE ESTAN EN EL PATIO   "+Clinica.getInstance().getPatio());
        Clinica.getInstance().atenderPaciente(paciente);
        
        // Prueba Factura
      
   /*     System.out.println(paciente);
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
