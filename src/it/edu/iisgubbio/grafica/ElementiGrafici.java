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

public class ElementiGrafici extends Application{
	
	public void start(Stage finestra) {
		// creo gli elementi grafici
		Circle faccia = new Circle(100);
		faccia.setFill(Color.PINK);
		faccia.setCenterX(100);
		faccia.setCenterY(100);
		Circle occhioDx = new Circle(5);
		occhioDx.setFill(Color.BLUE);
		occhioDx.setCenterX(130);
		occhioDx.setCenterY(60);
		Circle occhioSx = new Circle(5);
		occhioSx.setFill(Color.BLUE);
		occhioSx.setCenterX(70);
		occhioSx.setCenterY(60);
		Line boccaDx = new Line(150,130,100,100);
		boccaDx.setStroke(Color.RED);
		boccaDx.setStrokeWidth(5);
		Line boccaSx= new Line(50,130,100,100);
		boccaSx.setStroke(Color.RED);
		boccaSx.setStrokeWidth(5);
		Circle lenteDx = new Circle(20);
		//lrntr drstra dell'occhiale, bisogna rendere il cerchio vuoto
		//lenteDx.setFill(Colo);
		lenteDx.setCenterX(130);
		lenteDx.setCenterY(60);

		Pane griglia = new Pane();
				
		griglia.getChildren().add(faccia);
		griglia.getChildren().add(occhioDx);
		griglia.getChildren().add(occhioSx);
		griglia.getChildren().add(boccaDx);
		griglia.getChildren().add(boccaSx);
		griglia.getChildren().add(lenteDx);				
		
		
		Scene scena = new Scene(griglia,200,200);
	    finestra.setTitle("Disegnamo con Java");
	    finestra.setScene(scena);
	    finestra.show();
			
	}	
	public static void main(String[] args) {
	    launch(args);
	  }
	
}