package modelo;

public class MedicoFactory {
	
	public static IMedico getMedico(String dNI, String nombre, String apellido, String ciudad, String telefono, String domicilio, String matricula, String especialidad, String contratacion, String posgrado){
		IMedico encapsulado = null;
		IMedico respuesta = null;
		encapsulado = new Medico(dNI,nombre,apellido,ciudad,telefono,domicilio,matricula,especialidad);
		if (contratacion.equals("Permanente"))
			encapsulado = new DecoratorPermanente(encapsulado);
		else
			if(contratacion.equals("Residente") || contratacion.equals("Temporario"))
				encapsulado = new DecoratorPermanente(encapsulado);
			//else
				//Agregar excpecion
		if (contratacion.equals("Magister"))
			encapsulado = new DecoratorMagister(encapsulado);
		else
			if(contratacion.equals("Doctor"))
				encapsulado = new DecoratorDoctorado(encapsulado);
			//else
				//Agregar excepcion
		if (encapsulado != null)
		{
			
		}
		return respuesta;
	}

}
