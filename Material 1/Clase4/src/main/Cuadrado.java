package main;

public class Cuadrado {
	
	private int lado;
	
	
	public double calcularArea() {
		double  area = this.lado * this.lado;
		return area;
	}
	
	
	// metodos get y set
	public int getLado() {
		return lado;
	}

	public void setLado(int lado) {
		this.lado = lado;
	}
	
	
	
	

}
