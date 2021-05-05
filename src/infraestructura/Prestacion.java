package infraestructura;

public class Prestacion {
private String prestacion;
private double valor,subtotal;
private int cantidad;


public Prestacion(String prestacion, double valor,int cantidad) {
	this.prestacion = prestacion;
	this.valor = valor;
	this.cantidad = cantidad;
}


public double getValor() {
	return valor;
}


public void setValor(double valor) {
	this.valor = valor;
}


public int getCantidad() {
	return cantidad;
}


public void setCantidad(int cantidad) {
	this.cantidad = cantidad;
}


public String getPrestacion() {
	return prestacion;
}


public double getSubtotal() {
	return subtotal;
}


public void setSubtotal(double subtotal) {
	this.subtotal = subtotal;
}


@Override
public String toString() {
	return "Prestacion [prestacion=" + prestacion + ", valor=" + valor + ", subtotal=" + subtotal + ", cantidad="
			+ cantidad + "]";
}



}
