package modelo;

import java.util.GregorianCalendar;

import personas.Paciente;

public interface IMedico {
	
	double getHonorario();
	
	String getMatricula();
	
	String getEspecialidad();
	
	String getNombre();

    void asignarPaciente(Paciente paciente,GregorianCalendar fecha);
	
    void reporte(GregorianCalendar fecha1,GregorianCalendar fecha2);
}
