package personas;

import util.Util;

public class Asociado extends Persona implements Runnable{
private Ambulancia ambulancia;
private String pedido;
	public Asociado(String dNI, String nombre, String apellido, String ciudad, String telefono, String domicilio,Ambulancia ambulancia) {
		super(dNI, nombre, apellido, ciudad, telefono, domicilio);
		this.ambulancia=ambulancia;
	}

	public void PedirAmbulancia(String comando) {
		
		if(comando.equalsIgnoreCase("Atencion")) {
		    this.ambulancia.solicitaAtencion();
		    for(int i=0;i<2;i++) {
				Util.espera();
				this.ambulancia.volverClinica();
			}
		}
		else if (comando.equalsIgnoreCase("Traslado")) {
		    this.ambulancia.solicitaTraslado();
			Util.espera();
			this.ambulancia.volverClinica();
		}
	//	else throw new ComandoDesconocidoException(comando);
		
	}
	public void setPedido(String pedido) { //aca se setea el pedido de la interfaz grafica
		this.pedido=pedido;
		
	}
	
	@Override
	public void run() {
		
		this.PedirAmbulancia(pedido);
		/*for(int i=0;i<2;i++) {
			Util.espera();
			this.ambulancia.volverClinica();
		}*/
	}

	@Override
	public String toString() {
		return "Asociado [ambulancia=" + ambulancia + ", pedido=" + pedido + ", DNI=" + DNI + ", nombre=" + nombre
				+ ", apellido=" + apellido + ", ciudad=" + ciudad + ", telefono=" + telefono + ", domicilio="
				+ domicilio + "]";
	}
	

}
