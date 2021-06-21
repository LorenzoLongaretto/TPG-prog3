package personas;

import util.Util;

public class Asociado extends Persona implements Runnable{
private Ambulancia ambulancia;
private String pedido;
	public Asociado(String dNI, String nombre, String apellido, String ciudad, String telefono, String domicilio) {
		super(dNI, nombre, apellido, ciudad, telefono, domicilio);
		
	}

	public void PedirAmbulancia(String comando) {
		
		if(comando.equalsIgnoreCase("Atencion"))
		    this.ambulancia.solicitaAtencion();
		else if (comando.equalsIgnoreCase("Traslado"))
		    this.ambulancia.solicitaTraslado();
	//	else throw new ComandoDesconocidoException(comando);
		
	}
	public void setPedido(String pedido) { //aca se setea el pedido de la interfaz grafica
		this.pedido=pedido;
		
	}
	
	@Override
	public void run() {
		
		this.PedirAmbulancia(pedido);
		
	}
	

}
