package excepciones;

public class ExisteAsociadoException extends Exception{
	
		
         private int DNI;
		public ExisteAsociadoException(String msj,int DNI) {
			super(msj);
			this.DNI =DNI;
			
		}
		public int getDNI() {
			return DNI;
		}
		public void setDNI(int dNI) {
			DNI = dNI;
		}

		
}
