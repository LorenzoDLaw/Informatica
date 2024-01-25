package it.edu.iisgubbio.prove;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class Span extends Application{
	
	Button bCiao = new Button("ciao");
	Button b2Colonne = new Button("2 colonne");
	Button bA = new Button("A");
	Button bB = new Button("B");
	
	public void start(Stage finestra){
		GridPane griglia = new GridPane();
		
		
		griglia.setPadding(new Insets(5, 5, 5, 5));
		griglia.setHgap(15); 
		griglia.setVgap(15);
		griglia.add(bCiao, 0, 0, 1, 2);
		bCiao.setMaxHeight(1000);
		griglia.add(b2Colonne, 1, 0, 2,1);
		b2Colonne.setMaxWidth(100);
		griglia.add(bA, 1, 1);
		bA.setMaxWidth(100);
		griglia.add(bB, 2, 1);
		bB.setMaxWidth(100);
		
		
		
		Scene scena = new Scene(griglia);
	    finestra.setTitle("Span!");
	    finestra.setScene(scena);
	    finestra.show();
		
	}
	
	
	public static void main(String[] args) {
	    launch(args);
	  }

}
