package it.edu.iisgubbio.grafica;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

public class Triangolo extends Application{
	TextField tNumero= new TextField();
	Button bTriangolo = new Button("vai");
	Pane pPallini = new Pane();
	public void start(Stage finestra) {
		// creo gli elementi grafici
		GridPane griglia = new GridPane();
		griglia.setPadding(new Insets(5, 5, 5, 5));
		griglia.setHgap(15); 
		griglia.setVgap(15);
		
		Label lNumero = new Label("numero");
		
		griglia.add(lNumero, 0, 0);
		griglia.add(tNumero, 1, 0);
		griglia.add(bTriangolo, 2, 0);
		griglia.add(pPallini, 0, 2, 3, 1);
		
		pPallini.setPrefSize(200, 200);
			
		
		Scene scena = new Scene(griglia);
	    finestra.setTitle("Serie di Pallini");
	    finestra.setScene(scena);
	    finestra.show();
	    bTriangolo.setOnAction(e -> triangolo());
			
	}
	public void triangolo() {
		pPallini.getChildren().clear();
		int base = Integer.parseInt(tNumero.getText());
		int colPal = base*20;
		for(int posY=10; posY<=(base*20); posY+=20) {
			for(int posX = 20; posX<=(colPal); posX+=20) {
				Circle cerchio = new Circle(7);
				pPallini.getChildren().add(cerchio);
				cerchio.setCenterX(posX);
				cerchio.setCenterY(posY);				
			}
			colPal-=20;
		}
	}
	public static void main(String[] args) {
	    launch(args);
	  }
	
}