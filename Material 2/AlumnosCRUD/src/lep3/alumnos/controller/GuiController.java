package lep3.alumnos.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.StageStyle;
import lep3.alumnos.model.Alumno;
import lep3.alumnos.model.AlumnoModel;

public class GuiController implements Initializable {

	@FXML
	private TextField txtNombres;

	@FXML
	private TextField txtApellidos;

	@FXML
	private TextField txtCUM;

	@FXML
	private Button btnGuardar;

	@FXML
	private TableView<Alumno> tableData;

	@FXML
	private TableColumn<Alumno, Number> colId;

	@FXML
	private TableColumn<Alumno, String> colNombres;

	@FXML
	private TableColumn<Alumno, String> colApellidos;

	@FXML
	private TableColumn<Alumno, Number> colCUM;

	@FXML
	private TextField txtBuscador;

	@FXML
	private Button btnLimpiar;

	ObservableList<Alumno> listData;
	AlumnoModel alumnoModel = new AlumnoModel();

	@Override
	public void initialize(URL url, ResourceBundle resources) {

		colId.setCellValueFactory((TableColumn.CellDataFeatures<Alumno, Number> cellData) -> new SimpleIntegerProperty(
				cellData.getValue().getIdAlumno()));

		colNombres.setCellValueFactory(
				(TableColumn.CellDataFeatures<Alumno, String> cellData) -> new SimpleStringProperty(
						cellData.getValue().getNombre()));

		colApellidos.setCellValueFactory(
				(TableColumn.CellDataFeatures<Alumno, String> cellData) -> new SimpleStringProperty(
						cellData.getValue().getApellidos()));

		colCUM.setCellValueFactory((TableColumn.CellDataFeatures<Alumno, Number> cellData) -> new SimpleFloatProperty(
				cellData.getValue().getCum()));

		listData = FXCollections.observableArrayList();
		
		this.obtenerAlumnos();

		tableData.getSelectionModel().clearSelection();
	}

	private void obtenerAlumnos() {
		ArrayList<Alumno> alumnos = alumnoModel.getAll();
		listData = FXCollections.observableArrayList(alumnos);
		tableData.setItems(listData);
	}

	@FXML
	void eventBuscar(KeyEvent event) {
		
	}

	@FXML
	void eventClickTable(MouseEvent event) {
		 try {
			 ObservableList<Alumno> alumnoSeleccionados = tableData.getSelectionModel().getSelectedItems();
			 if(alumnoSeleccionados.size() >= 1) {
				 Alumno a = alumnoSeleccionados.get(0);
	             txtNombres.setText(a.getNombre());
	             txtApellidos.setText(a.getApellidos());
	             txtCUM.setText(a.getCum().toString());
			 }
			
       
         } catch (Exception e) {
        	 e.printStackTrace();
         }
	}

	@FXML
	void eventGuardar(ActionEvent event) {
		
		//evaluar si haremos un INSERT o un UPDATE, dependiendo si tengo seleccionado
		// un regristro en la tabla
		
		//Capturar los datos de la vista
		 String nombres = txtNombres.getText();
		 String apellidos = txtApellidos.getText();
		 Float cum = Float.valueOf(txtCUM.getText());
		
		 ObservableList<Alumno> alumnoSeleccionados = tableData.getSelectionModel().getSelectedItems();

		 
		//Si no existe un alumno seleccionado en la tabla hacemos INSERT
		if( alumnoSeleccionados.size() < 1) {
			
			 
			 //Crear un nuevo objeto alumno y lo llenamos con los datos capturados
			 // se coloca id = 0 ; ya que MySQL generara automaticamente el id
			 Alumno alumno_a_insertar = new Alumno(0,nombres,apellidos,cum);
			
			 //Llamamos el Modelo de Alumno para insertalo en la BDD
			 AlumnoModel alumnModel = new AlumnoModel();
			 alumnModel.insert(alumno_a_insertar);
			 
			
		}else {
			// Si existe un alumno seleccionado en la tabla, hacemos UPDATE
			Integer idAlumno = alumnoSeleccionados.get(0).getIdAlumno();
			
			Alumno alumno_a_actualizar = new Alumno(idAlumno,nombres,apellidos,cum);
			AlumnoModel alumnModel = new AlumnoModel();
			alumnModel.update(alumno_a_actualizar);
		}
		
		
		 //Refrescamos la tabla en la vista para que muestre los cambios
		 this.obtenerAlumnos();
		 
		
		this.dialog(Alert.AlertType.INFORMATION, "Guardar Ejecutado");	
		
		//Limpiar los textbox de la vista
		txtNombres.clear();
		txtApellidos.clear();
		txtCUM.clear();
		
		
		
	
	
	}

	@FXML
	void eventLimpiar(ActionEvent event) {
		// Deseleccionamos el Alumno en la tabla
		tableData.getSelectionModel().clearSelection();

	}
	
	private void dialog(Alert.AlertType alertType,String s){
        Alert alert = new Alert(alertType,s);
        alert.initStyle(StageStyle.UTILITY);
        alert.setTitle("Info");
        alert.showAndWait();
    }

}
