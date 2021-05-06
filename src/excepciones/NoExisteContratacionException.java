package excepciones;

public class NoExisteContratacionException extends Exception{
private String contratacion;
	
   public NoExisteContratacionException(String msj,String contratacion) {
		this.contratacion=contratacion;
	}

	public String getContratacion() {
		return contratacion;
	}

   
}
