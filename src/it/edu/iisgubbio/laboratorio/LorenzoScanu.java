package it.edu.iisgubbio.laboratorio;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LorenzoScanu extends Application{
	
	Label lNumeri = new Label("Scrivi i due numeri");
	TextField tPrimNumero = new TextField("");
	TextField tSecNumero = new TextField("");
	Label lFattoriale = new Label("");
	Label lSomma = new Label("");
	Label lNumPrimi = new Label();
	Button bFattoriale = new Button("Calcola fattoriale");
	Button bSomma = new Button("Calcola la somma tra i due numeri");
	Button bNumPrimi = new Button("Trova i numeri primi tra i due numeri");

	
	public void start(Stage finestra) {
		
		GridPane griglia = new GridPane();
		
		griglia.setPadding(new Insets(5, 5, 5, 5));
		griglia.setHgap(15); 
		griglia.setVgap(15);
		
		
		griglia.add(lNumeri, 0, 0);
		griglia.add(tPrimNumero, 1, 0);
		griglia.add(tSecNumero, 2, 0);
		griglia.add(bSomma, 0, 1,2,1);
		bSomma.setMaxWidth(1000);
		griglia.add(lSomma, 2, 1);
		griglia.add(bNumPrimi, 0, 2,2,1);
		bNumPrimi.setMaxWidth(1000);
		griglia.add(lNumPrimi, 2, 2);
		griglia.add(bFattoriale, 0, 3,2,1);
		bFattoriale.setMaxWidth(1000);
		griglia.add(lFattoriale, 2, 3);	
		Scene scena = new Scene(griglia);
	    finestra.setTitle("Fattoriale!");
	    finestra.setScene(scena);
	    finestra.show();
	    scena.getStylesheets().add("it/edu/iisgubbio/matematica/tabelline.css");
		
	    bFattoriale.setOnAction(e -> calcFattoriale());
	    bNumPrimi.setOnAction(e -> calcolaPrimi());
	    bSomma.setOnAction(e -> calcolaSomma());
	    
	    
		
	}
	//calcolo il fattoriale
	public void calcFattoriale() {
		int intN = Integer.parseInt(tPrimNumero.getText());
		int intM = Integer.parseInt(tSecNumero.getText());
		int numeratore=1;
		int denominatore = 1;
		for( int contatore = 2; contatore<=intN;contatore++) {
			numeratore = numeratore*contatore;
		}
		for( int contatore = 2; contatore<=(intN-intM);contatore++) {
			denominatore = denominatore*contatore;
		}
		lFattoriale.setText(""+(numeratore/denominatore));
	}
	//trovo i numeri primi
	public void calcolaPrimi() {
		int valore = Integer.parseInt(tSecNumero.getText());
		int soglia = Integer.parseInt(tPrimNumero.getText());
		int contatore=0;
		int primo=0;
		boolean trovaPrimi = true;
		for(int numero=valore; numero<=soglia; numero++) {
			for(int val = 2; val<=numero; val++) {
				if (numero%2==0) {
				}else if (trovaPrimi == true) {
					if((numero % val)==0) {
						primo++;
						if (primo>1) {
							contatore--;
						}else {
							contatore++;
						}
						trovaPrimi= false;
					}	
				}
				primo=0;
			}
			trovaPrimi = true;
		}
		lNumPrimi.setText(""+contatore);
			
	}
	// calcolo la somma dei numeri presenti nel intervallo tra il primo numero e il secondo numero
	public void calcolaSomma() {
			int intN = Integer.parseInt(tPrimNumero.getText());
			int intM = Integer.parseInt(tSecNumero.getText());
			int somma = 0;
			for (int n=intM; n<=intN;n++) {
				somma=somma+n;
			}
			lSomma.setText(""+somma);
	}
	
	public static void main(String[] args) {
	    launch(args);
	 }
	
}
