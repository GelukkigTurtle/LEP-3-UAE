package main;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		//Cuadrado
		Cuadrado cuadrado = new Cuadrado();
		cuadrado.setLado(sc.nextInt());
		double areaCuadrado = cuadrado.calcularArea();
		System.out.println(areaCuadrado);
		

	}

}
