package personas;

import java.io.Serializable;

public interface IState extends Serializable{

	void solicitaAtencion();
	void solicitaTraslado();
	void volverClinica();
	void solicitaReparacion(); 
	String actual();
	
}
