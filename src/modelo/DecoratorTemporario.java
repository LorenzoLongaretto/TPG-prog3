package modelo;

public class DecoratorTemporario extends DecoratorContratacion{

	@Override
	public double getHonorario() {
		return this.encapsulado.getHonorario()*1.05;
	}



	

}
