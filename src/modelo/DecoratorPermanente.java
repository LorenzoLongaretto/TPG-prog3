package modelo;

public class DecoratorPermanente extends DecoratorContratacion {

	@Override
	public double getHonorario() {
		return this.encapsulado.getHonorario()*1.1;
	}

	@Override
	public String getMatricula() {
		return this.encapsulado.getMatricula();
	}

	@Override
	public String getEspacialidad() {
		return this.encapsulado.getEspacialidad();
	}

	
}
