package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import infraestructura.Factura;
import infraestructura.Habitacion;
import infraestructura.Prestacion;
import modelo.IMedico;
import personas.Paciente;

import javax.swing.JTabbedPane;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Queue;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class Ventana extends JFrame implements IVistaPaciente,IVistaMedico,IVistaHabitacion,IVistaAsociado,IVistaAmbulancia {

	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private JPanel panel_Pacientes;
	private JPanel panel_Medicos;
	private JLabel lbl_listaAtencion;
	private JList list_pacientes;
	private JScrollPane scrollPane;
	private JButton btn_Egreso;
	private JPanel panel_2;
	private JButton btn_PrestacionMedica;
	private JList list_medicos;
	private JLabel lbl_medicos;
	private JScrollPane scrollPane_1;
	private JPanel panel_Habitaciones;
	private JLabel lbl_habitaciones;
	private JList list_habitaciones;
	private JScrollPane scrollPane_2;
	private JPanel panel;
	private JLabel lbl_Factura;
	private DefaultListModel<Paciente> modeloListaPaciente = new DefaultListModel<Paciente>();
	private DefaultListModel<IMedico> modeloListaMedico = new DefaultListModel<IMedico>();
	private DefaultListModel<Habitacion> modeloListaHabitacion = new DefaultListModel<Habitacion>();
	private ActionListener actionListener;
	private JPanel panel_1;
	private JButton btn_Cargar;
	private JButton btn_PrestacionHabitacion;
	private JTextArea textArea_Factura;
	private JScrollPane scrollPane_3;


   	public Ventana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 723, 598);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(this.contentPane);
		this.setTitle("Clinica");
		this.tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		this.contentPane.add(this.tabbedPane, BorderLayout.NORTH);
		
		this.panel_Pacientes = new JPanel();
		this.tabbedPane.addTab("Pacientes", null, this.panel_Pacientes, null);
		this.panel_Pacientes.setLayout(new GridLayout(4, 1, 0, 0));
		
		this.panel_1 = new JPanel();
		this.panel_Pacientes.add(this.panel_1);
		
		this.lbl_listaAtencion = new JLabel("Lista de Atencion");
		this.panel_1.add(this.lbl_listaAtencion);
		this.lbl_listaAtencion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		this.btn_Cargar = new JButton("Cargar");
		this.panel_1.add(this.btn_Cargar);
		
		this.scrollPane = new JScrollPane();
		this.panel_Pacientes.add(this.scrollPane);
		
		this.list_pacientes = new JList();
		this.scrollPane.setViewportView(this.list_pacientes);
		this.list_pacientes.setModel(modeloListaPaciente);
		
		this.panel_2 = new JPanel();
		this.panel_Pacientes.add(this.panel_2);
		
		this.btn_PrestacionHabitacion = new JButton("Prestacion Habitacion");
		this.panel_2.add(this.btn_PrestacionHabitacion);
		
		this.btn_PrestacionMedica = new JButton("Prestacion Medica");
		this.panel_2.add(this.btn_PrestacionMedica);
		
		this.btn_Egreso = new JButton("Egreso");
		this.panel_2.add(this.btn_Egreso);
		
		this.panel = new JPanel();
		this.panel_Pacientes.add(this.panel);
		this.panel.setLayout(new GridLayout(2, 1, 0, 0));
		
		this.lbl_Factura = new JLabel("Factura");
		this.panel.add(this.lbl_Factura);
		
		this.scrollPane_3 = new JScrollPane();
		this.panel.add(this.scrollPane_3);
		
		this.textArea_Factura = new JTextArea();
		this.textArea_Factura.setColumns(10);
		this.textArea_Factura.setLineWrap(true);
		this.textArea_Factura.setWrapStyleWord(true);
		this.scrollPane_3.setViewportView(this.textArea_Factura);
		
		this.panel_Medicos = new JPanel();
		this.tabbedPane.addTab("Medicos", null, this.panel_Medicos, null);
		this.panel_Medicos.setLayout(new GridLayout(3, 1, 0, 0));
		
		this.lbl_medicos = new JLabel("Lista de Medicos");
		this.lbl_medicos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.panel_Medicos.add(this.lbl_medicos);
		
		this.scrollPane_1 = new JScrollPane();
		this.panel_Medicos.add(this.scrollPane_1);
		
		this.list_medicos = new JList();
		this.scrollPane_1.setViewportView(this.list_medicos);
		this.list_medicos.setModel(modeloListaMedico);
		
		this.panel_Habitaciones = new JPanel();
		this.tabbedPane.addTab("Habitaciones", null, this.panel_Habitaciones, null);
		this.panel_Habitaciones.setLayout(new GridLayout(3, 1, 0, 0));
		
		this.lbl_habitaciones = new JLabel("Lista de Habitaciones");
		this.lbl_habitaciones.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.panel_Habitaciones.add(this.lbl_habitaciones);
		
		this.scrollPane_2 = new JScrollPane();
		this.panel_Habitaciones.add(this.scrollPane_2);
		
		this.list_habitaciones = new JList();
		this.scrollPane_2.setViewportView(this.list_habitaciones);
		this.list_habitaciones.setModel(modeloListaHabitacion);
		
		this.setVisible(true);
	}

	@Override
	public void setActionListener(ActionListener actionListener) {
		this.btn_Cargar.addActionListener(actionListener);
		this.btn_PrestacionMedica.addActionListener(actionListener);
		this.btn_PrestacionHabitacion.addActionListener(actionListener);
		this.btn_Egreso.addActionListener(actionListener);
		this.actionListener = actionListener;
	}

	@Override
	public Paciente getPacienteSeleccionado() {
		
		return (Paciente) this.list_pacientes.getSelectedValue();
	}

	@Override
	public void actualizaLista(Queue<Paciente> atencion) {
		Iterator<Paciente> it = atencion.iterator();
        while(it.hasNext()) {
        	Paciente paciente  = it.next();
        	if(paciente!=null)
        		this.agregaPaciente(paciente);
        }
        this.btn_Cargar.setEnabled(false);
	}

	@Override
	public void agregaPaciente(Paciente paciente) {
		this.modeloListaPaciente.addElement(paciente);
		
	}

	@Override
	public void actualizaFactura(Factura factura) {
        this.textArea_Factura.append(factura.toString()+'\n');
		for (Prestacion prestaciones : factura.getPrestaciones()) {
			this.textArea_Factura.append(prestaciones.toString()+'\n');
			
			
		}
	
		this.textArea_Factura.append("Importe Total: "+factura.getImporteTotal());
	
	}


	@Override
	public Habitacion getHabitacionSeleccionada() {
		
		return (Habitacion) this.list_habitaciones.getSelectedValue();
	}

	@Override
	public void actualizaListaHabitaciones(HashMap<Integer, Habitacion> habitaciones) {
		for (Integer key : habitaciones.keySet()) {
			   this.agregarHabitacion(habitaciones.get(key));
		}
	}

	@Override
	public IMedico getMedicoSeleccionado() {
		
		return (IMedico) this.list_medicos.getSelectedValue();
	}

	@Override
	public void actualizaListaMedicos(HashMap<Integer, IMedico> medicos) {
		for (Integer key : medicos.keySet()) {
		   this.agregaMedico(medicos.get(key));
		}
		
	}

	@Override
	public void agregaMedico(IMedico medico) {
		this.modeloListaMedico.addElement(medico);
		
	}

	@Override
	public void agregarHabitacion(Habitacion habitacion) {
		if(habitacion!=null)
		this.modeloListaHabitacion.addElement(habitacion);
		
	}

	@Override
	public void mensaje(String msj) {
		JOptionPane.showMessageDialog(this, msj);
		
	}

	@Override
	public void borraLista() {
		this.modeloListaPaciente.removeAllElements();
	
  }
}
