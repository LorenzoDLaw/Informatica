package it.edu.iisgubbio.geometria;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class Rettangolo extends Application{
	
	Label lArea = new Label();
	Label lPerimetro = new Label();
	TextField tBase = new TextField();
	TextField tAltezza = new TextField();
	
	
	public void start(Stage finestra) {
		
		Label lBase = new Label("base");
		Label lAltezza = new Label("altezza");
		Button bCalcola = new Button("calcola l'Area e il 2P");
		
		
		GridPane griglia = new GridPane();
		
		griglia.setPadding(new Insets(5, 5, 5, 5));
		griglia.setHgap(15); 
		griglia.setVgap(15);
		
		griglia.add(lBase, 0, 0);
		griglia.add(tBase, 1, 0);
		griglia.add(lAltezza, 0, 1);
		griglia.add(tAltezza, 1, 1);
		griglia.add(bCalcola, 0, 2, 2, 1);
		bCalcola.setMaxWidth(1000);
		griglia.add(lArea, 0, 3);
		lArea.setPrefWidth(100);
		griglia.add(lPerimetro, 1, 3);
		lPerimetro.setPrefWidth(100);
		
				
		Scene scena = new Scene(griglia);
	    finestra.setTitle("Quadrato!");
	    finestra.setScene(scena);
	    finestra.show();
		
	    bCalcola.setOnAction(e -> AreaPerimetro());
	    
		
	}
	
	
	public void AreaPerimetro() {
		
		String BaseString;
		String AltezzaString;
		double dBase;
		double dAltezza;
		double Area;
		double Perimetro;
		
		BaseString = tBase.getText();
		AltezzaString = tAltezza.getText();
		
		dBase = Double.parseDouble(BaseString);
		dAltezza= Double.parseDouble(AltezzaString);
		
		Area = (dBase * dAltezza);
		lArea.setText("l'area è " + Area);
		Perimetro= ((dBase+dAltezza)*2);
		lPerimetro.setText("il perimetro è "+Perimetro);
		
	}
	
	
	public static void main(String[] args) {
	    launch(args);
	  }
	
}