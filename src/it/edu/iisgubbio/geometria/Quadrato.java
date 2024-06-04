package it.edu.iisgubbio.geometria;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class Quadrato extends Application{
	
	Label lLato = new Label("lato");
	TextField tLato = new TextField();
	Button bArea = new Button("Area");
	Label lArea = new Label();
	Button bPerimetro = new Button("Perimetro");
	Label lPerimetro = new Label();
	
	public void start(Stage finestra) {
		
		GridPane griglia = new GridPane();
		
		griglia.setPadding(new Insets(5, 5, 5, 5));
		griglia.setHgap(15); 
		griglia.setVgap(15);
		
		griglia.add(lLato, 0, 0);
		griglia.add(tLato, 1, 0);
		griglia.add(bArea, 0, 1);
		bArea.setMaxWidth(100);
		griglia.add(lArea, 1, 1);
		griglia.add(bPerimetro, 0, 2);
		bPerimetro.setMaxWidth(100);
		griglia.add(lPerimetro, 1, 2);
		
				
		Scene scena = new Scene(griglia);
	    finestra.setTitle("Quadrato!");
	    finestra.setScene(scena);
	    finestra.show();
		
	    bArea.setOnAction(e -> area());
	    bPerimetro.setOnAction(e -> perimetro());
	    
		
	}
	
	public void area(){
		  String latoStringa;
		  int lato;
		  int area; 
		  		 
		  latoStringa = tLato.getText();
		  lato = Integer.parseInt(latoStringa) ;
		  area = lato * lato; 
		  lArea.setText("l'area è "+area);
	  }
	
	public void perimetro(){
		String latoStringa;
		int lato;
		int perimetro;
		latoStringa = tLato.getText();
		lato = Integer.parseInt(latoStringa) ;
		perimetro = lato* 4; 
		lPerimetro.setText("il perimetro è "+perimetro);
	}
	
	public static void main(String[] args) {
	    launch(args);
	}
	
}