package modelo;

import personas.MedicoCirujano;
import personas.MedicoClinico;
import personas.MedicoPediatra;
import excepciones.NoExisteContratacionException;
import excepciones.NoExisteEspecialidadException;
import excepciones.NoExistePosgradoException;

public class MedicoFactory {
	
	public static IMedico getMedico(String dNI, String nombre, String apellido, String ciudad, String telefono, String domicilio, String matricula, String especialidad, String contratacion,String posgrado) throws NoExisteEspecialidadException, NoExisteContratacionException, NoExistePosgradoException {
		IMedico encapsulado = null;
		IMedico respuesta = null;
		
		if(especialidad.equals("Cirujia"))
		   encapsulado = new MedicoCirujano(dNI,nombre,apellido,ciudad,telefono,domicilio,matricula);
		else
			if(especialidad.equals("Pediatria"))
				encapsulado = new MedicoPediatra(dNI,nombre,apellido,ciudad,telefono,domicilio,matricula);
			else 
				if(especialidad.equals("Clinica"))
					encapsulado = new MedicoClinico(dNI,nombre,apellido,ciudad,telefono,domicilio,matricula);
		        else
		            throw new NoExisteEspecialidadException("No existe especialidad",especialidad);

		
		if (encapsulado != null)
		{
			
			if (posgrado.equals("Magister"))
				respuesta = new DecoratorMagister(respuesta);
			else
				if(posgrado.equals("Doctor"))
					respuesta = new DecoratorDoctorado(respuesta);
				else
					throw new NoExistePosgradoException("No Existe Posgrado ",posgrado);
			
			if (contratacion.equals("Permanente"))
				respuesta = new DecoratorPermanente(encapsulado);
			else
				if(contratacion.equals("Residente") || contratacion.equals("Temporario"))
					respuesta = new DecoratorPermanente(encapsulado);
				else
				    throw new NoExisteContratacionException("No existe Contratacion ",contratacion);
		}
		return respuesta;
	}

}
