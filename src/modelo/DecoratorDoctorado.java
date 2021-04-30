package modelo;

public class DecoratorDoctorado extends DecoratorPosgrado {

	//Constructores
	public DecoratorDoctorado(IMedico encapsulado) {
		super(encapsulado);
		// TODO Auto-generated constructor stub
	}
	
	//Metodos
	@Override
	public double getHonorario() {
		return this.encapsulado.getHonorario()*1.1;
	}
	@Override
	public String getEspecialidad() {
		return super.getEspecialidad();
	}

}
