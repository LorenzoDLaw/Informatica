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

public class PalliniAlQuadrato extends Application{
	
	public void start(Stage finestra) {
		// creo gli elementi grafici
		
		boolean casella= true;
		Pane griglia = new Pane();
		int quantità = 160;
		for(int posY = 20; posY<=quantità; posY+=20) {
			for(int posX = 20; posX<=quantità; posX+=20) {
				Circle cerchio = new Circle(7);
				if(casella  == true) {
					cerchio.setFill(Color.BLUE);
					casella  = false;
				}else {
					cerchio.setFill(Color.RED);
					casella  = true;
				}
				griglia.getChildren().add(cerchio);
				cerchio.setCenterX(posX);
				cerchio.setCenterY(posY);
			}

		}
			
		
		Scene scena = new Scene(griglia,180,180);
	    finestra.setTitle("Serie di Pallini");
	    finestra.setScene(scena);
	    finestra.show();
			
	}	
	public static void main(String[] args) {
	    launch(args);
	  }
	
}