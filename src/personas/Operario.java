package personas;

import java.io.Serializable;

import util.Util;
/**
 * Clase que representa a un operario de la clinica.
 *
 */
public class Operario extends Thread implements Serializable{
private Ambulancia ambulancia;

	public Operario(Ambulancia ambulancia) {
	this.ambulancia = ambulancia;
}

	@Override
	public void run() {
		for(int i=0;i<2;i++) { //hace 2 pedidos
			this.ambulancia.solicitaReparacion();
			for(int j=0;j<2;j++) { //este pedido necesita 2 tiempos para volver a disponible
				Util.espera();
				this.ambulancia.volverClinica();
			}
		}
			
		
	}

}
