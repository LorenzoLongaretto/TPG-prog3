package modelo;

import java.util.GregorianCalendar;

import excepciones.ImposibleCrearMedicoException;
import excepciones.NoExisteRangoEtarioException;
import infraestructura.Factura;
import infraestructura.HabitacionCompartida;
import personas.Paciente;

public class ModeloCargaClinica {


	public void cargaClinica() {
		Paciente paciente=null,paciente2=null;
		
		//cuando copien y pegen para hacer mas pacientes recuerden cambiarles el DNI
		try {
			paciente = PacienteFactory.getPaciente("41927911", "Juan Jose   ", "Java", "MDP    ","2235673421", "San Juan 2140","Nino");
			paciente2 = PacienteFactory.getPaciente("41822123", "Ximena		", "ConX", "MDP    ","2235673421", "San Juan 2140","Mayor");
		 
		} catch (NoExisteRangoEtarioException e) {
			System.out.println(e.getMessage()+e.getRango());
		}
	    // Creacion de medicos
	    IMedico medico=null;
	    try {
			 medico = MedicoFactory.getMedico("25900987","Luis","Montini","MDP","2234565","Independencia","1111","Cirujia","Permanente","Magister");
			 Clinica.getInstance().agregarMedico(medico);
			 medico = MedicoFactory.getMedico("25980987","Luis","Montini","MDP","2234565","Independencia","2222","Clinica","Permanente","Doctor");
			 Clinica.getInstance().agregarMedico(medico);
			 medico = MedicoFactory.getMedico("2565657","Luis","Montini","MDP","2234565","Independencia","3333","Pediatria","Permanente","Magister");
			 Clinica.getInstance().agregarMedico(medico);
		} catch (ImposibleCrearMedicoException e) {
	        System.out.println(e.getMessage()+e.getDato());
	    }
	    
	    GregorianCalendar fecha1 = new GregorianCalendar(2020,1,1);
	    GregorianCalendar fecha2 = new GregorianCalendar(2020,2,1);
	    
	    //MODULO DE INGRESO
	    Clinica.getInstance().ingresoPaciente(paciente); //busca o genera la historia
	    Clinica.getInstance().ingresoPaciente(paciente2);
	
	    //ATENCION
	    Clinica.getInstance().atenderPaciente(paciente);
	    Factura factura = new Factura(1,fecha1,paciente);
	    
	    Clinica.getInstance().atenderPaciente(paciente2);
	    Factura factura2 = new Factura(2,fecha1,paciente2);
	    
	    // Paciente1
	    Clinica.getInstance().derivarMedico(factura, Clinica.getInstance().buscaMedico(Integer.parseInt(medico.getMatricula())));
	    Clinica.getInstance().asignarHabitacion(new HabitacionCompartida(32,21,200)); 
	    Clinica.getInstance().derivarHabitacion(factura,Clinica.getInstance().buscaHabitacion(32));
	  
	    // Paciente2 
	    Clinica.getInstance().derivarMedico(factura2,Clinica.getInstance().buscaMedico(Integer.parseInt(medico.getMatricula())));
	    
	    //MODULO DE EGRESO Y FACTURACION
	    Clinica.getInstance().facturacion(factura);// se agregan al sistema
	    Clinica.getInstance().facturacion(factura2);// se agregan al sistema
	    Clinica.getInstance().egreso(paciente,factura);
	    Clinica.getInstance().egreso(paciente2,factura2);
	   
	    Clinica.getInstance().reporteMedico(medico,fecha1,fecha2);    
	}
	
}
