package modelo;
import personas.Paciente;
import personas.Niño;
import excepciones.NoExisteRangoEtarioException;
import personas.Joven;
import personas.Mayor;


public class PacienteFactory {

	public static Paciente getPaciente(String dNI, String nombre, String apellido, String ciudad, String telefono, String domicilio,String rangoEtario,int nroOrden) /*throws NoExisteRangoEtarioException*/ {
		Paciente encapsulado=null;
		
		if(rangoEtario.equals("Nino")) 
			encapsulado = new Niño(dNI,nombre,apellido,ciudad,telefono,domicilio,nroOrden);
			else
				if(rangoEtario.equals("Joven"))
					encapsulado = new Joven(dNI,nombre,apellido,ciudad,telefono,domicilio,nroOrden);
				else
					if(rangoEtario.equals("Mayor"))
							encapsulado = new Mayor(dNI,nombre,apellido,ciudad,telefono,domicilio,nroOrden);
		               /*  else
		                    throw new NoExisteRangoEtarioException("No existe rango Etario",rangoEtario);	*/	               
		
		
		return encapsulado;
		
		
	}
}
