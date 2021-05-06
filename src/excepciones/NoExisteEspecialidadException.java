package excepciones;

public class NoExisteEspecialidadException extends Exception{

	private String especialidad;
	
	public NoExisteEspecialidadException(String msj,String especialidad) {
		super(msj);
		this.especialidad=especialidad;
	}
	public String getEspecialidad() {
		return especialidad;
	}

}
