package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class IndexController implements Initializable {
	
    @FXML
    private Button btnShowAlumnos;

    @FXML
    private Button btnShowHorarios;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	
	@FXML
    void showPantallaAlumnos(ActionEvent event) {
		  System.out.println("show Pantalla Alumnos -> mostrar pantalla");
		 try {	
		  Parent alumnos_parent = FXMLLoader.load(getClass().getResource("/view/alumnos.fxml"));
          Scene alumnos_scene = new Scene(alumnos_parent);
          Stage app_stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
          app_stage.hide();
          app_stage.setScene(alumnos_scene);
          app_stage.setTitle("Registro de Alumnos");
          app_stage.show();
          
		} catch (IOException e) {
			e.printStackTrace();
		}

    }

    @FXML
    void showPantallaHorarios(ActionEvent event) {
		System.out.println("show Pantalla Horarios -> mostrar horarios");
		try {	
			  Parent alumnos_parent = FXMLLoader.load(getClass().getResource("/view/horarios.fxml"));
	          Scene alumnos_scene = new Scene(alumnos_parent);
	          Stage app_stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
	          app_stage.hide();
	          app_stage.setScene(alumnos_scene);
	          app_stage.setTitle("Creacion de Hoarios");
	          app_stage.show();
	          
			} catch (IOException e) {
				e.printStackTrace();
			}

    }

}
