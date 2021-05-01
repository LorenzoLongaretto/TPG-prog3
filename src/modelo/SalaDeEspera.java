package modelo;

public class SalaDeEspera {

	//Atributos
	public boolean ocupada;
	public Paciente paciente;
	
	//Constructores
	public SalaDeEspera() {
		this.ocupada = false;
	}
	
	//Metodos
	public boolean isOcupada() {
		return ocupada;
	}
	public void setOcupada(boolean ocupada) {
		this.ocupada = ocupada;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void ocupaSalaDeEspera(Paciente paciente) {
		if(isOcupada()) {
			if(this.paciente.prioridad(paciente)) {//si cumple, entonces entra
				//agregar patio
				this.paciente = paciente;
			}
		}
		else {
			setOcupada(true);
			this.paciente = paciente;
		}
		
	}
	
}
