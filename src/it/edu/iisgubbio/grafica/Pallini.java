package it.edu.iisgubbio.grafica;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

public class Pallini extends Application{
	
	public void start(Stage finestra) {
		// creo gli elementi grafici
		

		Pane griglia = new Pane();
		
		for(int n = 20; n<=280; n+=20) {
			Circle cerchio = new Circle(7);
			cerchio.setFill(Color.PURPLE);
			griglia.getChildren().add(cerchio);
			cerchio.setCenterX(n);
			cerchio.setCenterY(10);
		}
			
		
		Scene scena = new Scene(griglia);
	    finestra.setTitle("Serie di Pallini");
	    finestra.setScene(scena);
	    finestra.show();
			
	}	
	public static void main(String[] args) {
	    launch(args);
	  }
	
}