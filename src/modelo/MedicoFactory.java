package modelo;

import personas.Medico;

public class MedicoFactory {
	
	public static IMedico getMedico(String dNI, String nombre, String apellido, String ciudad, String telefono, String domicilio, String matricula, String especialidad, String contratacion,String posgrado){
		IMedico encapsulado = null;
		IMedico respuesta = null;
		encapsulado = new Medico(dNI,nombre,apellido,ciudad,telefono,domicilio,matricula,especialidad);

		if (encapsulado != null)
		{
			if (contratacion.equals("Permanente"))
				encapsulado = new DecoratorPermanente(encapsulado);
			else
				if(contratacion.equals("Residente") || contratacion.equals("Temporario"))
					encapsulado = new DecoratorPermanente(encapsulado);
				//else
				  //  throw new NoExisteContratacionException();
			if (posgrado.equals("Magister"))
				encapsulado = new DecoratorMagister(encapsulado);
			else
				if(posgrado.equals("Doctor"))
					encapsulado = new DecoratorDoctorado(encapsulado);
				//else
					//throw NoExistePosgradoException  ver si va o no
			
			
		}
		return respuesta;
	}

}
