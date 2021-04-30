package modelo;

public class DecoratorTemporario extends DecoratorContratacion{

	//Construcores
	public DecoratorTemporario(IMedico encapsulado) {
		super(encapsulado);
		// TODO Auto-generated constructor stub
	}
	
	//Metodos
	@Override
	public double getHonorario() {
		return this.encapsulado.getHonorario()*1.05;
	}
	
}
