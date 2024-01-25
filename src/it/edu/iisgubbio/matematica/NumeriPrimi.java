package it.edu.iisgubbio.matematica;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class NumeriPrimi extends Application{
	
	TextField tNumero = new TextField("");
	Label lDivisori = new Label("");
	Button bNPrimi = new Button("calcola i numeri primi");

	
	public void start(Stage finestra) {
		
		Label lNumero = new Label("Numero");
		
		GridPane griglia = new GridPane();
		
		griglia.setPadding(new Insets(5, 5, 5, 5));
		griglia.setHgap(15); 
		griglia.setVgap(15);
		
		
		griglia.add(lNumero, 0, 0);
		griglia.add(tNumero, 1, 0);
		griglia.add(bNPrimi, 0, 1,2,1);
		bNPrimi.setMaxWidth(1000000);
		griglia.add(lDivisori, 0, 2,2,1);
		lDivisori.setMaxWidth(1000000);		
		Scene scena = new Scene(griglia);
	    finestra.setTitle("Divisori!");
	    finestra.setScene(scena);
	    finestra.show();
	    scena.getStylesheets().add("it/edu/iisgubbio/matematica/tabelline.css");
		
	    bNPrimi.setOnAction(e -> calcolanPrimi());
	    
	    
		
	}
	
	
	public void calcolanPrimi() {
		int valore = Integer.parseInt(tNumero.getText());
		lDivisori.setText("il numero " + valore + " è primo");
		for(int n = 2; n<valore; n++) {
			if((valore % n)==0) {
				lDivisori.setText("il numero " + valore + " non è primo");
			}
		}		
	}
	
	public static void main(String[] args) {
	    launch(args);
	  }
	
}