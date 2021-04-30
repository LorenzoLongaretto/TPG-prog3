package modelo;

public class DecoratorMagister extends DecoratorPosgrado {

	//Constructores
	public DecoratorMagister(IMedico encapsulado) {
		super(encapsulado);
		// TODO Auto-generated constructor stub
	}

	//Metodos
	@Override
	public double getHonorario() {
		return this.encapsulado.getHonorario()*1.05;
	}
	@Override
	public String getEspecialidad() {
		return super.getEspecialidad();
	}

}
