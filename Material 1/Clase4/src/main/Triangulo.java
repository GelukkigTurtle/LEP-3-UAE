package main;

public class Triangulo {
	
	private int base;
	private int altura;
	
	public double calcularArea() {
		double  area = (this.base * this.altura) / 2;
		return area;
	}
	
	//metodos get y set
	
	public int getBase() {
		return base;
	}
	public void setBase(int base) {
		this.base = base;
	}
	public int getAltura() {
		return altura;
	}
	public void setAltura(int altura) {
		this.altura = altura;
	}
	
	
	

}
