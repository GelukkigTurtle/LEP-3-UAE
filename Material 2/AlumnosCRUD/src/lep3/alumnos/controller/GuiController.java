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
             Alumno a = tableData.getSelectionModel().getSelectedItems().get(0);
             txtNombres.setText(a.getNombre());
             txtApellidos.setText(a.getApellidos());
             txtCUM.setText(a.getCum().toString());
         } catch (Exception e) {
        	 e.printStackTrace();
         }
	}

	@FXML
	void eventGuardar(ActionEvent event) {
		this.dialog(Alert.AlertType.INFORMATION, "Guardar Ejecutado");	
	}

	@FXML
	void eventLimpiar(ActionEvent event) {

	}
	
	private void dialog(Alert.AlertType alertType,String s){
        Alert alert = new Alert(alertType,s);
        alert.initStyle(StageStyle.UTILITY);
        alert.setTitle("Info");
        alert.showAndWait();
    }

}
