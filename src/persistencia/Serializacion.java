package persistencia;
import java.io.IOException;
import java.io.Serializable;

import modelo.*;
import persistencia.*;

public class Serializacion {
	Clinica clinicaSingleton = Clinica.getInstance();
	ClinicaDTO clinicaDTO = new ClinicaDTO();
	private IPersistencia<Serializable> persistencia = new Persistencia();
	
	public void guardarDatos() throws IOException {
		clinicaDTO.setAsociados(clinicaSingleton.getAsociados());
		clinicaDTO.setDireccion(clinicaSingleton.getDireccion());
		clinicaDTO.setFacturas(clinicaSingleton.getFacturas());
		clinicaDTO.setHabitaciones(clinicaSingleton.getHabitaciones());
		clinicaDTO.setListaAtencion(clinicaSingleton.getListaAtencion());
		clinicaDTO.setListaEspera(clinicaSingleton.getListaAtencion());
		clinicaDTO.setMedicos(clinicaSingleton.getMedicos());
		clinicaDTO.setNombre(clinicaSingleton.getNombre());
		clinicaDTO.setPatio(clinicaSingleton.getPatio());
		clinicaDTO.setSalaEspera(clinicaSingleton.getSalaEspera());
		clinicaDTO.setPacientes(clinicaSingleton.getPacientes());
		clinicaDTO.setHabitaciones(clinicaSingleton.getHabitaciones());
		clinicaDTO.setNroOrden(clinicaSingleton.getNroOrden());
		persistencia.abrirOutput("clinica.bin");
		persistencia.escribir(clinicaDTO);
		persistencia.cerrarOutput();
	}
	
	public void levantarDatos() throws IOException, ClassNotFoundException {
		persistencia.abrirInput("clinica.bin");
		clinicaDTO = (ClinicaDTO)persistencia.leer();
		persistencia.cerrarInput();
		clinicaSingleton.setAsociados(clinicaDTO.getAsociados());
		clinicaSingleton.setDireccion(clinicaDTO.getDireccion());
		clinicaSingleton.setFacturas(clinicaDTO.getFacturas());
		clinicaSingleton.setHabitaciones(clinicaDTO.getHabitaciones());
		clinicaSingleton.setListaAtencion(clinicaDTO.getListaAtencion());
		clinicaSingleton.setListaEspera(clinicaDTO.getListaAtencion());
		clinicaSingleton.setMedicos(clinicaDTO.getMedicos());
		clinicaSingleton.setNombre(clinicaDTO.getNombre());
		clinicaSingleton.setPatio(clinicaDTO.getPatio());
		clinicaSingleton.setSalaEspera(clinicaDTO.getSalaEspera());
		clinicaSingleton.setPacientes(clinicaDTO.getPacientes());
		clinicaSingleton.setHabitaciones(clinicaDTO.getHabitaciones());
		clinicaSingleton.setNroOrden(clinicaDTO.getNroOrden());
	}
	
	
}
