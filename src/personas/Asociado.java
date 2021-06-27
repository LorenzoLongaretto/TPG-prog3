package personas;

import java.io.Serializable;

import util.Util;
/** Clase que representa a un asociado.
 */
public class Asociado implements Runnable{
	private String dNI,nombre,apellido,domicilio,telefono;
private Ambulancia ambulancia;
private String pedido;
private int cantidad;

	public Asociado(String dNI, String nombre, String apellido,String telefono, String domicilio,Ambulancia ambulancia) {
	    this.dNI=dNI;
	    this.nombre=nombre;
	    this.apellido=apellido;
	    this.domicilio=domicilio;
	    this.telefono=telefono;
		this.ambulancia=ambulancia;
	}
	/**
	 * Metodo que simula el pedido de la ambulancia por parte de un asociado.
	 * <b> Pre: El parametro comando debe ser distinto de null.</b>
	 * <b> Post : Se  ejecuta la peticion a la ambulancia. </b>
	 * @param comando es el pedido que quiere realizar el asociado.
	 *
	 */
	public void PedirAmbulancia(String comando) {
		
		if(comando.equalsIgnoreCase("Atencion")) {
		    this.ambulancia.solicitaAtencion(this.nombre);
		    for(int i=0;i<2;i++) { //este pedido necesita 2 tiempos para volver a disponible
				Util.espera();
				this.ambulancia.volverClinica();
			}
		}
		else if (comando.equalsIgnoreCase("Traslado")) {
		    this.ambulancia.solicitaTraslado(this.nombre);
			Util.espera();
			this.ambulancia.volverClinica();
		}
	}

	public void setPedido(String pedido) { //aca se setea el pedido de la interfaz grafica
		this.pedido=pedido;
		
	}
	public void setCantidad(int cantidad) {
		this.cantidad=cantidad;
	}

	@Override
	public void run() {
		for(int i=0;i<this.cantidad;i++)
			this.PedirAmbulancia(pedido);
		
	}



	@Override
	public String toString() {
		return "Nombre: "+this.nombre+"--DNI: "+this.dNI+" Pedido: "+this.pedido+"--Cantidad: "+this.cantidad;
	}

	public String getdNI() {
		return dNI;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public String getTelefono() {
		return telefono;
	}

	public Ambulancia getAmbulancia() {
		return ambulancia;
	}

	public String getPedido() {
		return pedido;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setdNI(String dNI) {
		this.dNI = dNI;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public void setAmbulancia(Ambulancia ambulancia) {
		this.ambulancia = ambulancia;
	}
	

}
