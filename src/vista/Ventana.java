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
import personas.Asociado;
import personas.Paciente;

import javax.swing.JTabbedPane;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
import java.awt.Color;
import javax.swing.JComboBox;

public class Ventana extends JFrame implements IVistaPaciente,IVistaMedico,IVistaHabitacion,IVistaAsociado,IVistaAmbulancia,KeyListener {

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
	private JScrollPane scrollPane_1;
	private JPanel panel_Habitaciones;
	private JList list_habitaciones;
	private JScrollPane scrollPane_2;
	private JPanel panel;
	private DefaultListModel<Paciente> modeloListaPaciente = new DefaultListModel<Paciente>();
	private DefaultListModel<IMedico> modeloListaMedico = new DefaultListModel<IMedico>();
	private DefaultListModel<Habitacion> modeloListaHabitacion = new DefaultListModel<Habitacion>();
	private DefaultListModel<Asociado> modeloListaAsociado = new DefaultListModel<Asociado>();
	private ActionListener actionListener;
	private JPanel panel_1;
	private JButton btn_Cargar;
	private JButton btn_PrestacionHabitacion;
	private JTextArea textArea_Factura;
	private JScrollPane scrollPane_3;
	private JPanel panel_Asociados;
	private JLabel lbl_nombre;
	private JPanel panel_3;
	private JPanel panel_17;
	private JPanel panel_4;
	private JTextField textField_Nombre;
	private JPanel panel_5;
	private JPanel panel_7;
	private JPanel panel_8;
	private JPanel panel_9;
	private JLabel lbl_Apellido;
	private JTextField textField_Apellido;
	private JPanel panel_6;
	private JLabel lbl_DNI;
	private JTextField textField_DNI;
	private JPanel panel_10;
	private JPanel panel_11;
	private JLabel lbl_Ciudad;
	private JTextField textField_Ciudad;
	private JPanel panel_12;
	private JPanel panel_13;
	private JLabel lbl_Telefono;
	private JTextField textField_Telefono;
	private JPanel panel_14;
	private JPanel panel_15;
	private JLabel lbl_Domicilio;
	private JTextField textField_Domicilio;
	private JPanel panel_16;
	private JPanel panel_18;
	private JLabel lblNewLabel_1;
	private JPanel panel_19;
	private JButton btn_AgregarAsociado;
	private JPanel panel_20;
	private JPanel panel_21;
	private JPanel panel_22;
	private JList list_Asociados;
	private JButton btn_EliminarAsociado;
	private JLabel lblNewLabel;
	private JScrollPane scrollPane_4;
	private JPanel panel_23;
	private JPanel panel_Ambulancia;
	private JPanel panel_24;
	private JPanel panel_25;
	private JLabel lbl_cantAsociados;
	private JPanel panel_26;
	private JTextField textField_CantAsociados;
	private JPanel panel_27;
	private JPanel panel_28;
	private JPanel panel_29;
	private JLabel lbl_Solicitudes;
	private JPanel panel_30;
	private JLabel lbl_TipoSolicitud;
	private JPanel panel_31;
	private JPanel panel_32;
	private JTextField textField_cantSolicitudes;
	private JComboBox comboBox_TipoSolicitud;
	private JPanel panel_33;
	private JPanel panel_34;
	private JLabel lblNewLabel_2;
	private JPanel panel_35;
	private JButton btn_Simulacion;
	private JPanel panel_36;
	private JPanel panel_37;
	private JTextArea textArea;
	private JLabel lbl_Factura;
	private JLabel lbl_ListaMedicos;
	private JLabel lbl_habitaciones;
	private JButton btn_Atender;


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
		this.lbl_listaAtencion.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		this.btn_Cargar = new JButton("Cargar");
		this.panel_1.add(this.btn_Cargar);
		
		this.btn_Atender = new JButton("Atender");
		this.panel_1.add(this.btn_Atender);
		
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
		this.panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		this.scrollPane_3 = new JScrollPane();
		this.panel.add(this.scrollPane_3);
		
		this.textArea_Factura = new JTextArea();
		this.textArea_Factura.setColumns(10);
		this.textArea_Factura.setLineWrap(true);
		this.textArea_Factura.setWrapStyleWord(true);
		this.scrollPane_3.setViewportView(this.textArea_Factura);
		
		this.lbl_Factura = new JLabel("Factura");
		this.lbl_Factura.setFont(new Font("Tahoma", Font.BOLD, 15));
		this.scrollPane_3.setColumnHeaderView(this.lbl_Factura);
		
		this.panel_Medicos = new JPanel();
		this.tabbedPane.addTab("Medicos", null, this.panel_Medicos, null);
		this.panel_Medicos.setLayout(new GridLayout(3, 1, 0, 0));
		
		this.scrollPane_1 = new JScrollPane();
		this.panel_Medicos.add(this.scrollPane_1);
		
		this.list_medicos = new JList();
		this.scrollPane_1.setViewportView(this.list_medicos);
		this.list_medicos.setModel(modeloListaMedico);
		
		this.lbl_ListaMedicos = new JLabel("Lista de Medicos");
		this.lbl_ListaMedicos.setFont(new Font("Tahoma", Font.BOLD, 15));
		this.scrollPane_1.setColumnHeaderView(this.lbl_ListaMedicos);
		
		this.panel_Habitaciones = new JPanel();
		this.tabbedPane.addTab("Habitaciones", null, this.panel_Habitaciones, null);
		this.panel_Habitaciones.setLayout(new GridLayout(3, 1, 0, 0));
		
		this.scrollPane_2 = new JScrollPane();
		this.panel_Habitaciones.add(this.scrollPane_2);
		
		this.list_habitaciones = new JList();
		this.scrollPane_2.setViewportView(this.list_habitaciones);
		this.list_habitaciones.setModel(modeloListaHabitacion);
		
		this.lbl_habitaciones = new JLabel("Lista de Habitaciones");
		this.lbl_habitaciones.setFont(new Font("Tahoma", Font.BOLD, 15));
		this.scrollPane_2.setColumnHeaderView(this.lbl_habitaciones);
		
		this.panel_Asociados = new JPanel();
		this.tabbedPane.addTab("Asociados", null, this.panel_Asociados, null);
		this.panel_Asociados.setLayout(new GridLayout(0, 2, 0, 0));
		
		this.panel_3 = new JPanel();
		this.panel_Asociados.add(this.panel_3);
		this.panel_3.setLayout(new GridLayout(0, 2, 0, 0));
		
		this.panel_17 = new JPanel();
		this.panel_3.add(this.panel_17);
		this.panel_17.setLayout(new GridLayout(0, 1, 0, 0));
		
		this.panel_5 = new JPanel();
		this.panel_17.add(this.panel_5);
		this.panel_5.setLayout(new GridLayout(0, 1, 0, 0));
		
		this.panel_7 = new JPanel();
		this.panel_5.add(this.panel_7);
		
		this.lbl_nombre = new JLabel("Nombre");
		this.panel_7.add(this.lbl_nombre);
		
		this.panel_9 = new JPanel();
		this.panel_5.add(this.panel_9);
		
		this.lbl_Apellido = new JLabel("Apellido");
		this.panel_9.add(this.lbl_Apellido);
		
		this.panel_10 = new JPanel();
		this.panel_5.add(this.panel_10);
		
		this.lbl_DNI = new JLabel("DNI");
		this.panel_10.add(this.lbl_DNI);
		
		this.panel_12 = new JPanel();
		this.panel_5.add(this.panel_12);
		
		this.lbl_Ciudad = new JLabel("Ciudad");
		this.panel_12.add(this.lbl_Ciudad);
		
		this.panel_15 = new JPanel();
		this.panel_5.add(this.panel_15);
		
		this.lbl_Telefono = new JLabel("Telefono");
		this.panel_15.add(this.lbl_Telefono);
		
		this.panel_16 = new JPanel();
		this.panel_5.add(this.panel_16);
		
		this.lbl_Domicilio = new JLabel("Domicilio");
		this.panel_16.add(this.lbl_Domicilio);
		
		this.panel_19 = new JPanel();
		this.panel_5.add(this.panel_19);
		
		this.lblNewLabel_1 = new JLabel("");
		this.panel_19.add(this.lblNewLabel_1);
		
		this.panel_4 = new JPanel();
		this.panel_3.add(this.panel_4);
		this.panel_4.setLayout(new GridLayout(0, 1, 0, 0));
		
		this.panel_8 = new JPanel();
		this.panel_4.add(this.panel_8);
		
		this.textField_Nombre = new JTextField();
		this.panel_8.add(this.textField_Nombre);
		this.textField_Nombre.setColumns(10);
		this.textField_Nombre.addKeyListener(this);
		this.panel_6 = new JPanel();
		this.panel_4.add(this.panel_6);
		
		this.textField_Apellido = new JTextField();
		this.panel_6.add(this.textField_Apellido);
		this.textField_Apellido.setColumns(10);
		this.textField_Apellido.addKeyListener(this);
		this.panel_11 = new JPanel();
		this.panel_4.add(this.panel_11);
		
		this.textField_DNI = new JTextField();
		this.panel_11.add(this.textField_DNI);
		this.textField_DNI.setColumns(10);
		this.textField_DNI.addKeyListener(this);
		this.panel_13 = new JPanel();
		this.panel_4.add(this.panel_13);
		
		this.textField_Ciudad = new JTextField();
		this.panel_13.add(this.textField_Ciudad);
		this.textField_Ciudad.setColumns(10);
		this.textField_Ciudad.addKeyListener(this);
		this.panel_14 = new JPanel();
		this.panel_4.add(this.panel_14);
		
		this.textField_Telefono = new JTextField();
		this.panel_14.add(this.textField_Telefono);
		this.textField_Telefono.setColumns(10);
		this.textField_Telefono.addKeyListener(this);
		this.panel_18 = new JPanel();
		this.panel_4.add(this.panel_18);
		
		this.textField_Domicilio = new JTextField();
		this.panel_18.add(this.textField_Domicilio);
		this.textField_Domicilio.setColumns(10);
		this.textField_Domicilio.addKeyListener(this);
		this.panel_20 = new JPanel();
		this.panel_4.add(this.panel_20);
		
		this.btn_AgregarAsociado = new JButton("Agregar");
		this.panel_20.add(this.btn_AgregarAsociado);
		this.btn_AgregarAsociado.setActionCommand("AgregarAsociado");
		this.btn_AgregarAsociado.setEnabled(false);
		this.panel_21 = new JPanel();
		this.panel_Asociados.add(this.panel_21);
		this.panel_21.setLayout(new GridLayout(2, 1, 0, 0));
		
		this.panel_22 = new JPanel();
		this.panel_21.add(this.panel_22);
		
		this.scrollPane_4 = new JScrollPane();
		this.panel_22.add(this.scrollPane_4);
		
		this.list_Asociados = new JList();
		this.scrollPane_4.setViewportView(this.list_Asociados);
		this.list_Asociados.setModel(modeloListaAsociado);
		this.lblNewLabel = new JLabel("Lista Asociados");
		this.lblNewLabel.setForeground(Color.BLACK);
		this.lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		this.scrollPane_4.setColumnHeaderView(this.lblNewLabel);
		
		this.panel_23 = new JPanel();
		this.panel_21.add(this.panel_23);
		
		this.btn_EliminarAsociado = new JButton("Eliminar");
		this.btn_EliminarAsociado.setActionCommand("EliminarAsociado");
		this.panel_23.add(this.btn_EliminarAsociado);
		
		this.panel_Ambulancia = new JPanel();
		this.tabbedPane.addTab("Ambulancia", null, this.panel_Ambulancia, null);
		this.panel_Ambulancia.setLayout(new GridLayout(2, 0, 0, 0));
		
		this.panel_24 = new JPanel();
		this.panel_Ambulancia.add(this.panel_24);
		this.panel_24.setLayout(new GridLayout(0, 2, 0, 0));
		
		this.panel_26 = new JPanel();
		this.panel_24.add(this.panel_26);
		this.panel_26.setLayout(new GridLayout(0, 2, 0, 0));
		
		this.panel_27 = new JPanel();
		this.panel_26.add(this.panel_27);
		this.panel_27.setLayout(new GridLayout(0, 1, 0, 0));
		
		this.panel_29 = new JPanel();
		this.panel_27.add(this.panel_29);
		
		this.lbl_cantAsociados = new JLabel("Cantidad Asociados");
		this.panel_29.add(this.lbl_cantAsociados);
		
		this.panel_30 = new JPanel();
		this.panel_27.add(this.panel_30);
		
		this.lbl_Solicitudes = new JLabel("Solicitudes");
		this.panel_30.add(this.lbl_Solicitudes);
		
		this.panel_31 = new JPanel();
		this.panel_27.add(this.panel_31);
		
		this.lbl_TipoSolicitud = new JLabel("Tipo");
		this.panel_31.add(this.lbl_TipoSolicitud);
		
		this.panel_35 = new JPanel();
		this.panel_27.add(this.panel_35);
		
		this.lblNewLabel_2 = new JLabel("");
		this.panel_35.add(this.lblNewLabel_2);
		
		this.panel_28 = new JPanel();
		this.panel_26.add(this.panel_28);
		this.panel_28.setLayout(new GridLayout(0, 1, 0, 0));
		
		this.panel_32 = new JPanel();
		this.panel_28.add(this.panel_32);
		
		this.textField_CantAsociados = new JTextField();
		this.panel_32.add(this.textField_CantAsociados);
		this.textField_CantAsociados.setColumns(10);
		
		this.panel_33 = new JPanel();
		this.panel_28.add(this.panel_33);
		
		this.textField_cantSolicitudes = new JTextField();
		this.panel_33.add(this.textField_cantSolicitudes);
		this.textField_cantSolicitudes.setColumns(10);
		
		this.panel_34 = new JPanel();
		this.panel_28.add(this.panel_34);
		
		this.comboBox_TipoSolicitud = new JComboBox();
		this.panel_34.add(this.comboBox_TipoSolicitud);
		this.comboBox_TipoSolicitud.addItem("Atencion");
		this.comboBox_TipoSolicitud.addItem("Traslado");
		
		this.panel_36 = new JPanel();
		this.panel_28.add(this.panel_36);
		
		this.btn_Simulacion = new JButton("Simulacion");
		this.panel_36.add(this.btn_Simulacion);
		
		this.panel_37 = new JPanel();
		this.panel_24.add(this.panel_37);
		this.panel_25 = new JPanel();
		this.panel_Ambulancia.add(this.panel_25);
		this.panel_25.setLayout(new GridLayout(0, 1, 0, 0));
		
		this.textArea = new JTextArea();
		this.panel_25.add(this.textArea);
		this.btn_Atender.setEnabled(false);
		
		this.setVisible(true);
	}

	@Override
	public void setActionListenerAmbulancia(ActionListener actionListener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setActionListenerAsociado(ActionListener actionListener) {
		this.btn_AgregarAsociado.addActionListener(actionListener);
		this.btn_EliminarAsociado.addActionListener(actionListener);
		this.actionListener = actionListener;
		
	}

	@Override
	public void setActionListenerHabitacion(ActionListener actionListener) {
		this.actionListener = actionListener;
		
	}

	@Override
	public void setActionListenerMedico(ActionListener actionListener) {
		this.actionListener = actionListener;
		
	}

	@Override
	public void setActionListenerPaciente(ActionListener actionListener) {
		this.btn_Cargar.addActionListener(actionListener);//Carga lista de atencion
		this.btn_Atender.addActionListener(actionListener);//Mueve de lista de espera a lista de atencion
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

	@Override
	public String getDNI() {
		return this.textField_DNI.getText();
	}

	@Override
	public String getNombre() {
		return this.textField_Nombre.getText();
	}

	@Override
	public String getApellido() {
		return this.textField_Apellido.getText();
	}

	@Override
	public String getCiudad() {
		return this.textField_Ciudad.getText();
	}

	@Override
	public String getTelefono() {
		return this.textField_Telefono.getText();
	}

	@Override
	public String getDomicilio() {
		return this.textField_Domicilio.getText();
	}

	@Override
	public Asociado getAsociadoSeleccionado() {
		return (Asociado) this.list_Asociados.getSelectedValue();
	}

	@Override
	public void actualizaAsociados(HashMap<Integer, Asociado> asociados) {
		for (Integer key : 	asociados.keySet()) {
			   this.agregarAsociado(asociados.get(key));
			}
	}

	@Override
	public void borraListaAsociados() {
		this.modeloListaAsociado.removeAllElements();
		
	}

	@Override
	public void agregarAsociado(Asociado asociado) {
	this.modeloListaAsociado.addElement(asociado);
		
	}

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {}

	@Override
	public void keyReleased(KeyEvent e) {
	String DNI ="",nombre="",apellido="",ciudad="",telefono="",domicilio="";
	DNI = this.textField_DNI.getText();
	nombre = this.textField_Nombre.getText();
	apellido = this.textField_Apellido.getText();
	ciudad = this.textField_Ciudad.getText();
	telefono = this.textField_Telefono.getText();
	domicilio = this.textField_Domicilio.getText();
	
	boolean condicion = (!DNI.equals("") && !nombre.equals("") && !apellido.equals("") && !ciudad.equals("") && !telefono.equals("") && !domicilio.equals(""));
	
    this.btn_AgregarAsociado.setEnabled(condicion);
		
	}

	@Override
	public void habilitarAtencion() {
		this.btn_Atender.setEnabled(true);
		
	}


}
