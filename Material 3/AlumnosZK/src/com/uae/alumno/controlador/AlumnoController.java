package com.uae.alumno.controlador;

import java.util.ArrayList;
import java.util.Iterator;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Textbox;

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
	Textbox txtNombres;
	Textbox txtApellidos;
	Textbox txtEdad;
	Textbox txtCUM;
	
	//Variables globales
	Alumno alumno_seleccionado;
	
	//Constructor
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		
		listarAlumnos();
	}
	
	private void listarAlumnos() {
		
		lstAlumnos.getItems().clear(); //limpiamos la tabla antes de listar nuevos elementos 
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
	
	//Eventos de la vista
	public void onClick$btnGuardar() {
		
		// Obtenemos el texto escrito por el usuario 
		String nombre = txtNombres.getText();
		String apellidos = txtApellidos.getText();
		float cum = Float.valueOf(txtCUM.getText()) ;
		int edad = Integer.valueOf(txtEdad.getText());
				
		
		//validar si se ha seleccionado un alumno de la tabla
		if(alumno_seleccionado != null) {
			//Si se ha seleccionado un registro en la tabla
			// Se realizara un UPDATE
			
			//Obtenemos id del registro
			Integer idAlumno = alumno_seleccionado.getIdAlumno();
	
			Alumno alumnoEditado = new Alumno(idAlumno, nombre, apellidos, cum, edad);
			AlumnoModel modelo = new AlumnoModel();
			modelo.update(alumnoEditado);
			//limpiamos alumno seleccionado
			alumno_seleccionado = null;
			
		}else {
			// Significa que no se le ha dado click a un registro de la tabla
			//se realizara un INSERT
						
			//Creamos objeto alumno con los datos obtenidos
			Alumno alumnoNuevo = new Alumno(null, nombre, apellidos, cum, edad);
			
			//Insertamos el alumno utilizando el modelo
			AlumnoModel modelo = new AlumnoModel();
			modelo.insert(alumnoNuevo);
		}
		
		
		//refrescar tabla
		this.listarAlumnos();
		this.limpiarCampos();
		
		
	}
	
	private void limpiarCampos () {
		txtNombres.setText("");
		txtApellidos.setText("");
		txtCUM.setText("");
		txtEdad.setText("");
	}
	
	//Click en el listbox o tabla
	public void onClick$lstAlumnos() {
		Listitem elemento_seleccionado = lstAlumnos.getSelectedItem();
		if(elemento_seleccionado != null) {
			//Si existe un elemento seleccionado
			alumno_seleccionado = elemento_seleccionado.getValue();
			
			//llenamos el formulario con los datos del alumno seleccionado
			txtNombres.setText(alumno_seleccionado.getNombre());
			txtApellidos.setText(alumno_seleccionado.getApellidos());
			txtCUM.setText(alumno_seleccionado.getCum().toString());
			txtEdad.setText(alumno_seleccionado.getEdad().toString());
		}
		
	}
	
	//Click en el boton Eliminar
	public void onClick$btnEliminar() {
		//verificamos si se selecciono un alumno
		if(alumno_seleccionado != null) {
			AlumnoModel modelo = new AlumnoModel();
			modelo.delete(alumno_seleccionado);
			this.listarAlumnos();
			this.limpiarCampos();
			alumno_seleccionado = null;
		}
	}
	
	

}
