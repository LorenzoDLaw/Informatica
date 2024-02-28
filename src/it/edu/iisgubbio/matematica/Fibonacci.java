package it.edu.iisgubbio.matematica;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Fibonacci extends Application{
	
	TextField tNumero = new TextField("");
	Label lFibonacci = new Label("");
	Button bCalcolaFibonacci = new Button("Calcoal");

	
	public void start(Stage finestra) {
		
		GridPane griglia = new GridPane();
		
		griglia.setPadding(new Insets(5, 5, 5, 5));
		griglia.setHgap(15); 
		griglia.setVgap(15);
		
		
		griglia.add(tNumero, 0, 0);
		griglia.add(bCalcolaFibonacci, 1, 0);
		griglia.add(lFibonacci, 2, 0);	
		Scene scena = new Scene(griglia,300,50);
	    finestra.setTitle("Fattoriale!");
	    finestra.setScene(scena);
	    finestra.show();
	    scena.getStylesheets().add("it/edu/iisgubbio/matematica/tabelline.css");
		
	    bCalcolaFibonacci.setOnAction(e -> calcolafattoriale());		
	}
	int fibonacci(int numero) {
		int fatt=0;
		if (numero == 0) {
			fatt=0;
		}else if (numero==1){
			fatt=1;
		}else {
			if (numero>1) {
				fatt = fibonacci(numero-1)+fibonacci(numero-2);
			}
		}
		return fatt;
	}
	
	public void calcolafattoriale() {
		int numero = Integer.parseInt(tNumero.getText());
		int risultato;
		risultato = fibonacci(numero);
		lFibonacci.setText(""+risultato);
	}		
	
	public static void main(String[] args) {
	    launch(args);
	 }
	
}