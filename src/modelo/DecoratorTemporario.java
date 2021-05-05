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
	@Override
	public String getMatricula() {
		return this.encapsulado.getMatricula();
	}
	@Override
	public String getEspecialidad() {
		return this.encapsulado.getEspecialidad();
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return this.encapsulado.getNombre();
	}

	@Override
	public String toString() {
		return this.encapsulado.toString()+" Contratacion Temporario";
	}
}
