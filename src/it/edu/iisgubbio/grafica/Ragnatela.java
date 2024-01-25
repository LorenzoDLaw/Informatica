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

public class Ragnatela extends Application{
	
	public void start(Stage finestra) {
		// creo gli elementi grafici
		/*for(int posX = 20; posX<=quantità; posX+=20) {
		int posX2 =200-posX;
		int posY2 = posY+20;
		posY=posY2;
		Line linea = new Line(posX,posY,posX2,posY2);
		griglia.getChildren().add(linea);
	}*/
		Pane griglia = new Pane();
		int quantità = 200;
		int posX2=220;
		for(int posY=20;posY<=quantità; posY+=20) {
			Line linea = new Line(0,posY,posX2-posY,0);
			griglia.getChildren().add(linea);
			Line linea2 = new Line(200,posX2-posY,posY,200);
			griglia.getChildren().add(linea2);
		}
			
		
		Scene scena = new Scene(griglia,200,200);
	    finestra.setTitle("Serie di Pallini");
	    finestra.setScene(scena);
	    finestra.show();
			
	}	
	public static void main(String[] args) {
	    launch(args);
	  }
	
}