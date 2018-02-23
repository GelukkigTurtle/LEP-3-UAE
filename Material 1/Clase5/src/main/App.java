package main;

import java.util.Scanner;

// Clase 5
// Arreglos

public class App {
	
	static String[] alumnos = {"Julio","Bernardo","Melisa"};
	static int[] edades = new int[3];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		leerEdades(sc);
		imprimirDatos();

	}
	
	private static void imprimirDatos() {
		for(int i = 0; i < edades.length; i++) {
			System.out.println("Nombre: "+alumnos[i]+ " - Edad: "+edades[i]);
		}
	}
	
	private static void leerEdades(Scanner sc) {
		for(int i = 0 ; i < edades.length ; i++) {
			System.out.println("Ingrese edad ["+(i+1)+"] = ");
			int  valorTecleado = sc.nextInt();
			edades[i] = valorTecleado;
		}
	}

}
