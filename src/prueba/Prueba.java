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
import persistencia.Serializacion;

import java.io.IOException;
import java.util.GregorianCalendar;

import controlador.Controlador;
import excepciones.ImposibleCrearMedicoException;
import excepciones.NoExisteRangoEtarioException;
import infraestructura.Factura;
import infraestructura.HabitacionCompartida;
public class Prueba {

	public static void main(String[] args) throws IOException {
		
		//Serializacion archivo = new Serializacion();
   /*	
		Paciente paciente=null,paciente2=null,paciente3=null,paciente4=null;
		
		//cuando copien y pegen para hacer mas pacientes recuerden cambiarles el DNI
		try {
			paciente = PacienteFactory.getPaciente("41927911", "Juan Jose   ", "Java", "MDP    ","2235673421", "San Juan 2140","Nino");
			paciente2 = PacienteFactory.getPaciente("41822123", "Ximena		", "ConX", "MDP    ","2235673421", "San Juan 2140","Mayor");
		    paciente3  = PacienteFactory.getPaciente("4444444", "Rigoberto", "Rodriguez", "Miramar","43256321", "Independencia 01","Joven");
		       
		} catch (NoExisteRangoEtarioException e) {
			System.out.println(e.getMessage()+e.getRango());
		}
            
       
        // Creacion de medicos
        IMedico medico=null, medico2 =null,medico3=null;
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
        Clinica.getInstance().ingresoPaciente(paciente3);
        System.out.println("Pacientes en espera");
        System.out.println("El paciente en la sala de espera es: "+Clinica.getInstance().getSalaEspera().getPaciente());
        System.out.println("Los pacientes en el patio son: "+Clinica.getInstance().getPatio());
        //DERIVACION Y ATENCION
        System.out.println("------------------------");
        Clinica.getInstance().atenderPaciente(paciente);
        Clinica.getInstance().atenderPaciente(paciente2);
        
        Factura factura = new Factura(1,fecha1,paciente);
        factura.asignarMedico(medico);
        factura.asignarMedico(medico);
        Clinica.getInstance().asignarHabitacion(new HabitacionCompartida(32,21,200));
        factura.asignarHabitacion(Clinica.getInstance().buscaHabitacion(32));
        Clinica.getInstance().facturacion(factura); 
        
        Factura factura2 = new Factura(2,fecha2,paciente);
        factura2.asignarMedico(medico);
        Clinica.getInstance().facturacion(factura2);
        //MODULO DE EGRESO Y FACTURACION
        //System.out.println("FACTURA:");
        //Clinica.getInstance().egreso(paciente);
        //Clinica.getInstance().egreso(paciente2,factura2);
        //REPORTE MEDICO
       // System.out.println("--------------------");
        //System.out.println("REPORTE:");
        //Clinica.getInstance().reporteMedico(medico, fecha1, fecha2);
        
        
        
        //Ambulancia
        Ventana ventana = new Ventana(); 
        
        Controlador  controlador = new Controlador(ventana,ventana,ventana,ventana,ventana);
        ventana.setActionListener(controlador);
        //archivo.guardarDatos();
		*/
		/*
		 * Ambulancia.getInstancia() --> le aplicamos singleton
        Ambulancia amb=new Ambulancia();
		Asociado a1=new Asociado("--", "--", "--", "--", "--", "--",amb);
		a1.setPedido("Traslado");
		Asociado a2=new Asociado("--", "--", "--", "--", "--", "--",amb);
		a2.setPedido("Atencion");
		Asociado a3=new Asociado("--", "--", "--", "--", "--", "--",amb);
		a3.setPedido("Atencion");
		Operario op1=new Operario(amb);
		Thread hilo1 = new Thread(a1);
		Thread hilo2 = new Thread(a2);
		Thread hilo3 = new Thread(a3);
		
		op1.start();
		//hilo1.start();
		hilo2.start();
		hilo3.start();
		*/
	}
 
}



