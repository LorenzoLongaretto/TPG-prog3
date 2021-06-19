package persistencia;

import java.io.Serializable;
import java.util.ArrayList;



public class ClinicaDTO implements Serializable
{
    private String nombre;
    private String direccion;
    

    public ClinicaDTO()
    {
    }

    public ClinicaDTO(String nombre, String direccion)
    {
	super();
	this.nombre = nombre;
	this.direccion = direccion;
	
    }

    public String getNombre()
    {
	return nombre;
    }

    public void setNombre(String nombre)
    {
	this.nombre = nombre;
    }

    public String getDireccion()
    {
	return direccion;
    }

    public void setDireccion(String direccion)
    {
	this.direccion = direccion;
    }

 

}
