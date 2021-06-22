package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import infraestructura.Factura;
import infraestructura.Habitacion;
import modelo.Clinica;
import modelo.IMedico;
import vista.IVistaAmbulancia;
import vista.IVistaAsociado;
import vista.IVistaHabitacion;
import vista.IVistaMedico;
import vista.IVistaPaciente;
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
		//this.vistaPaciente.setActionListener(this);
	}

	public void setVistaMedico(IVistaMedico vistaMedico) {
		this.vistaMedico = vistaMedico;
		//this.vistaMedico.setActionListener(this);
	}

	public void setVistaHabitacion(IVistaHabitacion vistaHabitacion) {
		this.vistaHabitacion = vistaHabitacion;
		//this.vistaHabitacion.setActionListener(this);
	}

	public void setVistaAsociado(IVistaAsociado vistaAsociado) {
		this.vistaAsociado = vistaAsociado;
		//this.vistaAsociado.setActionListener(this);
	}

	public void setVistaAmbulancia(IVistaAmbulancia vistaAmbulancia) {
		this.vistaAmbulancia = vistaAmbulancia;
		//this.vistaAmbulancia.setActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String comando = e.getActionCommand();
		if(comando.equalsIgnoreCase("Cargar")) {
			
			this.vistaPaciente.actualizaLista(Clinica.getInstance().getListaAtencion());
			this.vistaMedico.actualizaListaMedicos(Clinica.getInstance().getMedicos());
			this.vistaHabitacion.actualizaListaHabitaciones(Clinica.getInstance().getHabitaciones());
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
        		Clinica.getInstance().derivarHabitacion(paciente, habitacion);
        		this.vistaPaciente.mensaje("Se agrego la habitacion: "+habitacion.toString()+ " al paciente");
        	}
        	else 
        		this.vistaPaciente.mensaje("Debe seleccionar una habitacion y un medico");
        	
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
		
		
	}
 

}
