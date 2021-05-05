package infraestructura;

public class Prestacion {
private String prestacion;
private double valor,subtotal;
private int cantidad;


public Prestacion(String prestacion, double valor, double subtotal, int cantidad) {
	this.prestacion = prestacion;
	this.valor = valor;
	this.subtotal = subtotal;
	this.cantidad = cantidad;
}


public double getSubtotal() {
	return subtotal;
}


public void setSubtotal(double subtotal) {
	this.subtotal = subtotal;
}



}
