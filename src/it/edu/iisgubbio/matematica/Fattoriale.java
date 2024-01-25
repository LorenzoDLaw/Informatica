package it.edu.iisgubbio.matematica;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Fattoriale extends Application{
	
	TextField tNumero = new TextField("");
	Label lFattoriale = new Label("");
	Button bFattoriale = new Button("!");

	
	public void start(Stage finestra) {
		
		GridPane griglia = new GridPane();
		
		griglia.setPadding(new Insets(5, 5, 5, 5));
		griglia.setHgap(15); 
		griglia.setVgap(15);
		
		
		griglia.add(tNumero, 0, 0);
		griglia.add(bFattoriale, 1, 0);
		griglia.add(lFattoriale, 2, 0);	
		Scene scena = new Scene(griglia,300,50);
	    finestra.setTitle("Fattoriale!");
	    finestra.setScene(scena);
	    finestra.show();
	    scena.getStylesheets().add("it/edu/iisgubbio/matematica/tabelline.css");
		
	    bFattoriale.setOnAction(e -> calcolanPrimi());
	    
	    
		
	}
	
	public void calcolanPrimi() {
		int valore = Integer.parseInt(tNumero.getText());
		int fatt = 1;
		for( int contatore = 2; contatore<=valore;contatore++) {
			fatt = fatt*contatore;
		}
		lFattoriale.setText("="+fatt);
	}		
	
	public static void main(String[] args) {
	    launch(args);
	 }
	
}