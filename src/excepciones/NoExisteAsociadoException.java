package excepciones;

public class NoExisteAsociadoException extends Exception{
private int DNI;

public NoExisteAsociadoException(String msj,int dNI) {
	super(msj);
	DNI = dNI;
}

public int getDNI() {
	return DNI;
}

public void setDNI(int dNI) {
	DNI = dNI;
}


}
