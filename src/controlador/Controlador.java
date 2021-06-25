package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import excepciones.ExisteAsociadoException;
import excepciones.HabitacionOcupadaException;
import excepciones.NoExisteAsociadoException;
import infraestructura.Factura;
import infraestructura.Habitacion;
import modelo.Clinica;
import modelo.IMedico;
import vista.IVistaAmbulancia;
import vista.IVistaAsociado;
import vista.IVistaHabitacion;
import vista.IVistaMedico;
import vista.IVistaPaciente;
import personas.Ambulancia;
import personas.Asociado;
import personas.Paciente;


public class Controlador implements ActionListener{

	private IVistaPaciente vistaPaciente;
	private IVistaMedico vistaMedico;
	private IVistaHabitacion vistaHabitacion;
	private IVistaAsociado vistaAsociado;
	private IVistaAmbulancia vistaAmbulancia;
	
	public Controlador(IVistaPaciente vistaPaciente, IVistaMedico vistaMedico, IVistaHabitacion vistaHabitacion,
			IVistaAsociado vistaAsociado, IVistaAmbulancia vistaAmbulancia) {
		this.setVistaPaciente(vistaPaciente);
		this.setVistaMedico(vistaMedico);
		this.setVistaHabitacion(vistaHabitacion);
		this.setVistaAsociado(vistaAsociado);
		this.setVistaAmbulancia(vistaAmbulancia);
	}
	public IVistaPaciente getVistaPaciente() {
		return vistaPaciente;
	}
	public IVistaMedico getVistaMedico() {
		return vistaMedico;
	}

	public IVistaHabitacion getVistaHabitacion() {
		return vistaHabitacion;
	}
	public IVistaAsociado getVistaAsociado() {
		return vistaAsociado;
	}

	public IVistaAmbulancia getVistaAmbulancia() {
		return vistaAmbulancia;
	}

	public void setVistaPaciente(IVistaPaciente vistaPaciente) {
		this.vistaPaciente = vistaPaciente;
		this.vistaPaciente.setActionListenerPaciente(this);
	}

	public void setVistaMedico(IVistaMedico vistaMedico) {
		this.vistaMedico = vistaMedico;
		this.vistaMedico.setActionListenerMedico(this);
	}

	public void setVistaHabitacion(IVistaHabitacion vistaHabitacion) {
		this.vistaHabitacion = vistaHabitacion;
		this.vistaHabitacion.setActionListenerHabitacion(this);
	}
	public void setVistaAsociado(IVistaAsociado vistaAsociado) {
		this.vistaAsociado = vistaAsociado;
	    this.vistaAsociado.setActionListenerAsociado(this);	
	}

	public void setVistaAmbulancia(IVistaAmbulancia vistaAmbulancia) {
		this.vistaAmbulancia = vistaAmbulancia;
		this.vistaAmbulancia.setActionListenerAmbulancia(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String comando = e.getActionCommand();
		if(comando.equalsIgnoreCase("Cargar")) {
			
			this.vistaPaciente.actualizaLista(Clinica.getInstance().getListaAtencion());
			this.vistaMedico.actualizaListaMedicos(Clinica.getInstance().getMedicos());
			this.vistaHabitacion.actualizaListaHabitaciones(Clinica.getInstance().getHabitaciones());
			this.vistaAsociado.actualizaAsociados(Clinica.getInstance().getAsociados());
			this.vistaPaciente.habilitarAtencion();
		}
		if(comando.equalsIgnoreCase("Atender") ) {
			Paciente paciente  = Clinica.getInstance().getListaEspera().poll();
			if(paciente!=null) {
				Clinica.getInstance().atenderPaciente(paciente);
				this.vistaPaciente.borraLista();
				this.vistaPaciente.actualizaLista(Clinica.getInstance().getListaAtencion());
			}
			else
				this.vistaPaciente.mensaje("No hay mas pacientes en la lista de espera");
		}
		if(comando.equalsIgnoreCase("Prestacion Medica")) {
			
			Paciente paciente  = this.vistaPaciente.getPacienteSeleccionado();
			IMedico medico  = this.vistaMedico.getMedicoSeleccionado();
			
			if(medico!=null && paciente!=null) {
				Clinica.getInstance().derivarMedico(paciente, medico);
				this.vistaPaciente.mensaje("Se agrego la prestacion medica: "+medico.getNombre()+" "+medico.getMatricula()+" al paciente");
			}
			else
				this.vistaPaciente.mensaje("Debe seleccionar un paciente y un medico");
		}
        if(comando.equalsIgnoreCase("Prestacion Habitacion")) {
        	Paciente paciente  = this.vistaPaciente.getPacienteSeleccionado();
        	Habitacion habitacion = this.vistaHabitacion.getHabitacionSeleccionada();
        	
        	if(habitacion!= null && paciente!=null) {
        		try {
					Clinica.getInstance().derivarHabitacion(paciente, habitacion);
					this.vistaPaciente.mensaje("Se agrego la habitacion: "+habitacion.toString()+ " al paciente");
				} catch (HabitacionOcupadaException e1) {
				this.vistaPaciente.mensaje(e1.getMessage());
				}
        		
        	}
        	else 
        		this.vistaPaciente.mensaje("Debe seleccionar una habitacion y un paciente");
        	
		}
        if(comando.equalsIgnoreCase("Egreso")) {
            Paciente paciente  = this.vistaPaciente.getPacienteSeleccionado();
            if(paciente!=null) {
            	Factura factura = Clinica.getInstance().buscaUltima(paciente);
            	if(factura!=null) {
            		Clinica.getInstance().egreso(paciente);
                	this.vistaPaciente.borraLista();
                	this.vistaPaciente.actualizaLista(Clinica.getInstance().getListaAtencion());
                	this.vistaPaciente.actualizaFactura(factura);
            	}
            	else
            		this.vistaPaciente.mensaje("Ese paciente no tiene una factura en el sistema");
            	
            }
            else
            	this.vistaPaciente.mensaje("Debe seleccionar un paciente de la lista de Atencion");
			
		}
        if(comando.equalsIgnoreCase("AgregarAsociado")) {
        	Asociado asociado = new Asociado(this.vistaAsociado.getDNI(),this.vistaAsociado.getNombre(),this.vistaAsociado.getApellido(),this.vistaAsociado.getDomicilio(),this.vistaAsociado.getTelefono(),Ambulancia.getInstancia());
        	try {
                Integer.parseInt(this.vistaAsociado.getDNI());
                try {
    				Clinica.getInstance().altaAsociado(asociado);
    				this.vistaAsociado.agregarAsociado(asociado);
    			} catch (ExisteAsociadoException e1) {
    				this.vistaAsociado.mensaje(e1.getMessage()+ "con DNI: "+e1.getDNI());
    			}
                
            } catch (NumberFormatException excepcion) {
                this.vistaAsociado.mensaje("El DNI debe ser un numero");
            }
        	
        	
        }
        
        if(comando.equalsIgnoreCase("EliminarAsociado")) {
        	Asociado asociado = this.vistaAsociado.getAsociadoSeleccionado();
        	if(asociado!=null) {
        		try {
					Clinica.getInstance().eliminarAsociado(Integer.parseInt(asociado.getdNI()));
					this.vistaAsociado.borraListaAsociados();
	            	this.vistaAsociado.actualizaAsociados(Clinica.getInstance().getAsociados());
				} catch (NumberFormatException | NoExisteAsociadoException e1) {
					this.vistaAsociado.mensaje("No existe asociado ");
				}
            	
        	}
        	else
        		this.vistaAsociado.mensaje("Debe seleccionar un asociado");
        }
        if(comando.equalsIgnoreCase("AgregarSolicitud")) {
        	System.out.println("Entra");
    	   Asociado asociado = this.vistaAmbulancia.getAsociadoSeleccionadoSimulacion();
    	   if(asociado!=null) {
    		   asociado.setPedido(this.vistaAmbulancia.getTipo());
    		   asociado.setCantidad(Integer.parseInt(this.vistaAmbulancia.getCantidad()));
    	   }
    	   this.vistaAsociado.borraListaAsociados();
    	   this.vistaAsociado.actualizaAsociados(Clinica.getInstance().getAsociados());
			
		}
		if(comando.equalsIgnoreCase("Simulacion")) {
			this.vistaAmbulancia.simulacion(Clinica.getInstance().getAsociados());
			this.vistaAmbulancia.anularSimulacion();
		}
		
	}
 

}
