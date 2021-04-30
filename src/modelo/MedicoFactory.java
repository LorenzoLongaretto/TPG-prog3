package modelo;

public class MedicoFactory {
	public static IPersonaje getPersonaje(String tipo, String elemento, String nombre)
	{
		IPersonaje encapsulado=null;
		IPersonaje respuesta = null;
		
		if (tipo.equals("MAGO"))
			encapsulado = new Mago(nombre);
		else if (tipo.equals("ELFO"))
			encapsulado = new Elfo(nombre);
		else if (tipo.equals("HECHICERA"))
			encapsulado = new Hechicera(nombre);
		else if (tipo.equals("DRAGON"))
			encapsulado = new Dragon(nombre);
		else if (tipo.equals("GUERRERO"))
			encapsulado = new Guerrero(nombre);

		if (encapsulado != null)
		{
			if (elemento.equals("FUEGO"))
				respuesta = new DecoratorFuego(encapsulado);
			else if (elemento.equals("AGUA"))
				respuesta = new DecoratorAgua(encapsulado);
			else if (elemento.equals("AIRE"))
				respuesta = new DecoratorAire(encapsulado);
			else if (elemento.equals("TIERRA"))
				respuesta = new DecoratorTierra(encapsulado);
			
		}

		return respuesta;

	}

}
