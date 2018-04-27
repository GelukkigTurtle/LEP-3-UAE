package com.uae.alumno.controlador;

import java.util.ArrayList;
import java.util.Iterator;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;

import com.uae.alumno.modelo.Alumno;
import com.uae.alumno.modelo.AlumnoModel;

@SuppressWarnings("rawtypes")
public class AlumnoController extends GenericForwardComposer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//Variables de la vista
	Listbox lstAlumnos;
	
	//Constructor
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		
		listarAlumnos();
	}
	
	private void listarAlumnos() {
		AlumnoModel model = new AlumnoModel();
		ArrayList<Alumno> listaAlumnos = model.getAll();
		Iterator<Alumno> iterator = listaAlumnos.iterator();
		
		Listitem fila = null;
		
		while(iterator.hasNext()) {
			Alumno alumno = iterator.next();
			
			fila = new Listitem();
			
			//Creamos celda del ID
			Listcell cellID = new Listcell();
			cellID.setLabel(alumno.getIdAlumno().toString());
			cellID.setParent(fila); //la celda ID es hija de la fila actual
			
			//Creamos celda Nombres
			Listcell cellNombre = new Listcell();
			cellNombre.setLabel(alumno.getNombre());
			cellNombre.setParent(fila);
			
			//Creamos celda Apellidos
			Listcell cellApellidos = new Listcell();
			cellApellidos.setLabel(alumno.getApellidos());
			cellApellidos.setParent(fila);
			
			//Creamos celda Edad
			Listcell cellEdad = new Listcell();
			cellEdad.setLabel(alumno.getEdad().toString());
			cellEdad.setParent(fila);
			
			//Creamos celda CUM
			Listcell cellCUM = new Listcell();
			cellCUM.setLabel(alumno.getCum().toString());
			cellCUM.setParent(fila);
			
			fila.setValue(alumno);
			fila.setParent(lstAlumnos);
			
			
		}
		
	}
	
	

}
