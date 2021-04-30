package modelo;

public abstract class DecoratorContratacion implements IMedico {
protected IMedico encapsulado;


	@Override
	public String getMatricula() {
		return this.encapsulado.getMatricula();
	}

	@Override
	public String getEspacialidad() {
		return this.encapsulado.getEspacialidad();
	}

}
