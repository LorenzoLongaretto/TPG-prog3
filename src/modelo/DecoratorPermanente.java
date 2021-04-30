package modelo;

public class DecoratorPermanente extends DecoratorContratacion {

	//Constructores
	public DecoratorPermanente(IMedico encapsulado) {
		super(encapsulado);
		// TODO Auto-generated constructor stub
	}

	//Metodos
	@Override
	public double getHonorario() {
		return this.encapsulado.getHonorario()*1.1;
	}
	@Override
	public String getMatricula() {
		return this.encapsulado.getMatricula();
	}
	@Override
	public String getEspecialidad() {
		return this.encapsulado.getEspecialidad();
	}
	
}
