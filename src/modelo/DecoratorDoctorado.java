package modelo;

public class DecoratorDoctorado extends DecoratorPosgrado {

	public DecoratorDoctorado() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getHonorario() {
		return this.encapsulado.getHonorario()*1.1;
	}


	@Override
	public String getEspacialidad() {
		return super.getEspacialidad();
	}

}
