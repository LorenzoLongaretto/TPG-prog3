package modelo;

public class DecoratorMagister extends DecoratorPosgrado {

	@Override
	public double getHonorario() {
		return this.encapsulado.getHonorario()*1.05;
	}


	@Override
	public String getEspacialidad() {
		return super.getEspacialidad();
	}

}
