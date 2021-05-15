package infraestructura;

import personas.Paciente;

public class SalaDeEspera {

	//Atributos
	public boolean ocupada;

    /**
     * @aggregation shared
     */
    public Paciente paciente;
	
	//Constructores
	public SalaDeEspera() {
		this.ocupada = false;
		this.paciente=null;
	}
	
	//Metodos
	public boolean isOcupada() {
		return this.ocupada;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void ocupaSalaDeEspera(Paciente paciente) {
		this.paciente=paciente;
		this.ocupada=true;
		
	}
	public void desocupar() {
		this.ocupada = false;
		this.paciente=null;		
	}
	
	
	
}
