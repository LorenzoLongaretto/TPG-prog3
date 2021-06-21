package personas;

public interface IState {

	void solicitaAtencion();
	void solicitaTraslado();
	void volverClinica();
	void solicitaReparacion(); 
	String actual();
	
}
