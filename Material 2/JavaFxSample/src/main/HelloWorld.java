package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HelloWorld  extends Application{
	
	
	public static void main (String[] args) {
		launch(args);
	}
	

	@Override
	public void start(Stage primaryStage) throws Exception {
		   Parent root = null;
	        try {
	            root = FXMLLoader.load(getClass().getResource("HelloWorld.fxml"));
	        } catch (Exception e) {
	        	e.printStackTrace();
	        	
	          //  root = AnchorPaneBuilder.create().id("mainWindow").prefWidth(800).prefHeight(600).build();
	        }
	        Scene scene = new Scene(root);

	        primaryStage.setTitle("Titulo de la App");
	        primaryStage.setScene(scene);
	        //primaryStage.centerOnScreen();
	        primaryStage.show();	
	}

}
