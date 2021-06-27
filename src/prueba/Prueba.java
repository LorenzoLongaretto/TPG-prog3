package prueba;
import personas.Ambulancia;
import personas.Asociado;
import personas.Operario;
import personas.Paciente;
import vista.Ventana;
import modelo.Clinica;
import modelo.IMedico;
import modelo.MedicoFactory;
import modelo.PacienteFactory;
import persistencia.ClinicaDTO;
import persistencia.IPersistencia;
import persistencia.Persistencia;

import util.Util;
import persistencia.ClinicaDTO;
import java.io.IOException;

import controlador.Controlador;
import excepciones.ExisteAsociadoException;
import excepciones.ImposibleCrearMedicoException;
import excepciones.NoExisteRangoEtarioException;

import infraestructura.HabitacionCompartida;
import infraestructura.HabitacionPrivada;
import infraestructura.TerapiaIntensiva;
public class Prueba {

	public static void main(String[] args) throws IOException {

		Paciente paciente=null,paciente2=null,paciente3=null,paciente4=null,paciente5=null;
		
		//cuando copien y pegen para hacer mas pacientes recuerden cambiarles el DNI
		try {
			paciente = PacienteFactory.getPaciente("41927911", "Juan Jose", "Java", "MDP","2235673421", "San Juan 2140","Nino");
			paciente2 = PacienteFactory.getPaciente("41822123", "Ximena", "ConX", "MDP","2235673421", "San Juan 2140","Mayor");
		    paciente3  = PacienteFactory.getPaciente("4656556", "Maestro", "Yoda", "Miramar","43256321", "Independencia 01","Joven");
			paciente4  = PacienteFactory.getPaciente("987456", "Rigoberto", "Rodriguez", "Tandil","2236545454", "Independencia 01","Nino");
			paciente5 = PacienteFactory.getPaciente("4123465", "Norberto", "Diaz", "Mar del sur", "4711569", "Independencia 01", "Joven");
		       
		} catch (NoExisteRangoEtarioException e) {
			System.out.println(e.getMessage()+e.getRango());
		}
            
        // Creacion de medicos
        IMedico medico=null;
        try {
			 medico = MedicoFactory.getMedico("25900987","Luis","Montini","MDP","2234565","Independencia","1111","Cirujia","Permanente","Magister");
			 Clinica.getInstance().agregarMedico(medico);
			 medico = MedicoFactory.getMedico("25980987","Guillermo","Copolla","MDP","2234565","Independencia","2222","Clinica","Permanente","Doctor");
			 Clinica.getInstance().agregarMedico(medico);
			 medico = MedicoFactory.getMedico("2565657","Marcelo","Gallardo","MDP","2234565","Independencia","3333","Pediatria","Permanente","Magister");
			 Clinica.getInstance().agregarMedico(medico);
		} catch (ImposibleCrearMedicoException e) {
            System.out.println(e.getMessage()+e.getDato());
        }
       Clinica.getInstance().asignarHabitacion(new HabitacionCompartida(1,2000));
       Clinica.getInstance().asignarHabitacion(new HabitacionPrivada(2,2000));
       Clinica.getInstance().asignarHabitacion(new TerapiaIntensiva(3,2000));
       Clinica.getInstance().asignarHabitacion(new HabitacionPrivada(4,2000));
       Clinica.getInstance().asignarHabitacion(new TerapiaIntensiva(5,2000));
        
        //MODULO DE INGRESO
        Clinica.getInstance().ingresoPaciente(paciente); //busca o genera la historia
        Clinica.getInstance().ingresoPaciente(paciente2);
        Clinica.getInstance().ingresoPaciente(paciente3);
		Clinica.getInstance().ingresoPaciente(paciente4);
		Clinica.getInstance().ingresoPaciente(paciente5);

        //DERIVACION Y ATENCION
        Clinica.getInstance().atenderPaciente(paciente);
        Clinica.getInstance().atenderPaciente(paciente2);
    	Asociado a1=new Asociado("41835435", "Juan", "Rodriguez", "223456789", "San Juan 1234",Ambulancia.getInstancia());
		a1.setPedido("Traslado");
		a1.setCantidad(0);
		Asociado a2=new Asociado("41927911", "Raul", "Chalop", "2236789012", "Independecia 2345",Ambulancia.getInstancia());
		a2.setPedido("Atencion");
		a2.setCantidad(0);
		Asociado a3=new Asociado("26789456", "Tomas", "Longaretto", "223412344", "Almafuerte 1234",Ambulancia.getInstancia());
		a3.setPedido("Atencion");
		a3.setCantidad(0);
		Operario operario=new Operario(Ambulancia.getInstancia());
		Clinica.getInstance().setOperario(operario);
		try {
			Clinica.getInstance().altaAsociado(a1);
		} catch (ExisteAsociadoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Clinica.getInstance().altaAsociado(a3);
		} catch (ExisteAsociadoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        IPersistencia idao = new Persistencia();
        
        
        
        //Guardar Datos
        try {
        	idao.abrirOutput("Clinica.bin");
        	System.out.println("Creacion archivo escritura");
        	ClinicaDTO cdto = Util.clinicaDTOFromCLinica();
        	idao.escribir(cdto);
        	System.out.println("Clinica serializada");
        	idao.cerrarOutput();
        	System.out.println("Archivo cerrado");
        	
        }catch(Exception e) {
        	System.out.println(e.getMessage());
        }
        //Levantar Datos
        try {
        	idao.abrirInput("clinica.bin");
    	    ClinicaDTO clinicaDTO = (ClinicaDTO) idao.leer();
    	    Util.clinicaFromClinicaDTO(clinicaDTO);
    	    idao.cerrarInput();
    	    System.out.println("Clinica recuperada: ");
    	    System.out.println(Clinica.getInstance());
        }catch(Exception e) {
        	System.out.println("Exception " + e.getMessage());
        }
        
        //Ambulancia
        Ventana ventana = new Ventana(); 
        Controlador  controlador = new Controlador(ventana,ventana,ventana,ventana,ventana);

		
	}
 
}

