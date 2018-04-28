package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AlumnosController {
	
	    @FXML
	    private Button btnRegresar;

	    @FXML
	    void regresarAlMenu(ActionEvent event) {
	    	try {	
	  		   Parent regresar_parent = FXMLLoader.load(getClass().getResource("/view/index.fxml"));
	            Scene regresar_scene = new Scene(regresar_parent);
	            Stage app_stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
	            app_stage.hide();
	            app_stage.setScene(regresar_scene);
	            app_stage.setTitle("Menu");
	            app_stage.show();
	            
	  		} catch (IOException e) {
	  			e.printStackTrace();
	  		}

	    }

}
