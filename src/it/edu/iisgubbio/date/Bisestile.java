package it.edu.iisgubbio.date;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Bisestile extends Application {
	
	TextField tAnno = new TextField();
	Button bBisestile = new Button("bisestile");
	Label lBisestile = new Label();
	public void start(Stage finestra) {
			
		Label lAnno = new Label("Anno");

		
		GridPane griglia = new GridPane();
		
		griglia.setPadding(new Insets(5, 5, 5, 5));
		griglia.setHgap(15); 
		griglia.setVgap(15);
		
		griglia.add(lAnno, 0, 0);
		griglia.add(tAnno, 1, 0);
		griglia.add(bBisestile, 0, 1);
		griglia.add(lBisestile, 1, 1);
								
		Scene scena = new Scene(griglia);
	    finestra.setTitle("Bisestile!");
	    finestra.setScene(scena);
	    finestra.show();
		
	    bBisestile.setOnAction(e -> calcolaAnno()); 
	   		
	}
	public void calcolaAnno() {
		String stringAnno = tAnno.getText();
		int anno;
		
		anno = Integer.parseInt(stringAnno);
		if((anno%4)==0 &&((anno%100)!=0 || (anno%400)==0)){
			lBisestile.setText("bisestile");			
		} else {
			lBisestile.setText("non bisestile");			
		}	
	}
	
	public static void main(String[] args) {
	    launch(args);
	  }

}
