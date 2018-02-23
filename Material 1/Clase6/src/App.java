import java.util.ArrayList;
import java.util.Scanner;

public class App {
	

	public static void main(String[] args) {
		ArrayList<Alumno> alumnos = new ArrayList<>();
		
	     int cantidad_alumnos = 2;
	     Alumno alum = null;
	     
	     String nombre, apellido;
	     int edad;
	     
	     Scanner sc = new Scanner(System.in);
	     
	     for(int i=1; i <= cantidad_alumnos ; i ++){
	    	 //alum = new Alumno();
	    
	    	 System.out.println("Nombre ["+i+"] = ");
	    	 nombre = sc.nextLine();
	    	// alum.setNombre(nombre);
	    	 
	    	 System.out.println("Apellido ["+i+"] = ");
	    	 apellido = sc.nextLine();
	    	 //alum.setApellido(apellido);
	    	 
	    	 System.out.println("Edad ["+i+"] = ");
	    	 edad = Integer.parseInt(sc.nextLine());
	    	 //alum.setEdad(edad);
	    	 
	    	 alumnos.add(new Alumno(nombre,apellido,edad));
	     }
	     
	     sc.close();
	     
	     for (Alumno a : alumnos) {
	    	 System.out.println(a.getNombre() + " - " + a.getApellido() + " - " + a.getEdad());
	     }

	}

}
