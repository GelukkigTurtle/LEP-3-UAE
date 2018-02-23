package main;

import java.util.ArrayList;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		int cantidad_alumnos = 2;
		ArrayList<Alumno> alumnos =  new ArrayList<>();
		ArrayList<Evaluacion> evaluaciones = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		
		String nombre, apellido;
		double eval1,eval2,eval3,eval4,notafinal;
		
		//Leer los datos
		for(int i = 0 ; i < cantidad_alumnos; i ++) {
			
			System.out.println(i+") nombre: ");
			nombre = sc.nextLine();
			
			System.out.println(i+") apellido: ");
			apellido = sc.nextLine();
			
			System.out.println(i+") eval1: ");
			eval1 = Double.parseDouble(sc.nextLine());
			
			System.out.println(i+") eval2: ");
			eval2 = Double.parseDouble(sc.nextLine());

			System.out.println(i+") eval3: ");
			eval3 = Double.parseDouble(sc.nextLine());

			System.out.println(i+") eval4: ");
			eval4 = Double.parseDouble(sc.nextLine());
			
			notafinal = (eval1 * 0.15) + (eval2 * 0.25) + (eval3 * 0.3)+ (eval4 * 0.3);

			//creamos instancias con datos
			Alumno a = new Alumno(nombre, apellido);
			Evaluacion e = new Evaluacion(eval1, eval2, eval3, eval4, notafinal);
			
			alumnos.add(a);
			evaluaciones.add(e);
			
		}
		sc.close();
		
		Alumno a = null;
		Evaluacion  e = null;
		
		//Mostrar los datos		
		for(int j = 0 ; j < cantidad_alumnos; j++) {
			a = alumnos.get(j);
			e = evaluaciones.get(j);
			
			System.out.println(a.getNombre() + "\t" + a.getApellido() 
			+ "\t"+ e.getEval1() + "\t"+ e.getEval2() +"\t"+e.getEval3()+"\t"+e.getEval4()
			+"\t"+e.getNota_final());
	
		}

	}

}
