package personas;

import util.Util;

public class Asociado extends Persona implements Runnable{
private Ambulancia ambulancia;
private String pedido;
private int cantidad;
	public Asociado(String dNI, String nombre, String apellido, String ciudad, String telefono, String domicilio,Ambulancia ambulancia) {
		super(dNI, nombre, apellido, ciudad, telefono, domicilio);
		this.ambulancia=ambulancia;
	}

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
	//	else throw new ComandoDesconocidoException(comando);
		
	}
	public void setPedido(String pedido) { //aca se setea el pedido de la interfaz grafica
		this.pedido=pedido;
		
	}
	public void setCantidad(int cantidad) {
		this.cantidad=cantidad;
	}
	
	@Override
	public void run() {
		//for (int i=0;i<this.cantidad;i++)
			this.PedirAmbulancia(pedido);
		
	}

	@Override
	public String toString() {
		return "Asociado [ambulancia=" + ambulancia + ", pedido=" + pedido + ", DNI=" + DNI + ", nombre=" + nombre
				+ ", apellido=" + apellido + ", ciudad=" + ciudad + ", telefono=" + telefono + ", domicilio="
				+ domicilio + "]";
	}
	

}
