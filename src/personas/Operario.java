package personas;

import util.Util;

public class Operario extends Thread{
private Ambulancia ambulancia;

	public Operario(Ambulancia ambulancia) {
	this.ambulancia = ambulancia;
}





	@Override
	public void run() {
	//	for(int i=0;i<3;i++) {
			this.ambulancia.solicitaReparacion();
		//	for(int j=0;j<2;j++) {
				Util.espera(1);
				this.ambulancia.volverClinica();
		//	}
	//	}
			
		
	}

}
