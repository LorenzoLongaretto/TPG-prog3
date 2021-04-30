package modelo;

public abstract class DecoratorPosgrado implements IMedico {
protected IMedico encapsulado;

	@Override
	public double getHonorario() {
		return this.encapsulado.getHonorario();
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
