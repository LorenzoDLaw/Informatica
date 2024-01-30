package it.edu.iisgubbio.vettori;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class mescola_inverti extends Application{
	TextField tNumeri = new TextField();	
	Label lInverti = new Label("");
	Label lMescola = new Label("");
	String parti[];
	int numeri[];
	public void start(Stage finestra) {
		GridPane griglia = new GridPane();
		
		Button bInverti = new Button("inverti");
		Button bMescola = new Button("mescola");
		
		griglia.add(tNumeri,  0,  0);
	    griglia.add(bInverti, 0, 1);
	    griglia.add(lInverti,  0,  2);
	    griglia.add(bMescola,  0,  3);
	    griglia.add(lMescola,  0,  4);
	    
	    
	    griglia.setPadding(new Insets(10, 10, 10, 10));
		griglia.setHgap(22); 
		griglia.setVgap(10);
	    
	    Scene scene = new Scene(griglia,280,300);
	    
	    finestra.setTitle("Somma"); 
		finestra.setScene(scene);
		finestra.show();
		
		bInverti.setOnAction(e -> inverti());
		bMescola.setOnAction(e -> mescola());
	}
	public void inverti() {
		String numeriTxt = tNumeri.getText();
		int invertiVettore[];
		if(numeriTxt.equals("")) {
			lInverti.setText("inserisci i numeri");
		}else {
			parti =numeriTxt.split(" ");
			numeri = new int [parti.length];
			for(int indice = 0; indice < parti.length; indice++) {
				numeri[indice] = Integer.parseInt(parti[indice]);
		    }
			invertiVettore= new int [numeri.length];
			for(int indice = parti.length-1, pos=0; indice >= 0; indice--, pos++) {
				invertiVettore[pos] = numeri[indice];
				lInverti.setText(lInverti.getText()+" "+invertiVettore[pos]);
		    }
		}
	}
	public void mescola() {
		String numeriTxt = tNumeri.getText();
		int mescolaVettore[];
		if(numeriTxt.equals("")) {
			lInverti.setText("inserisci i numeri");
		}else {
			parti =numeriTxt.split(" ");
			numeri = new int [parti.length];
			for(int indice = 0; indice < parti.length; indice++) {
				numeri[indice] = Integer.parseInt(parti[indice]);
		    }
			mescolaVettore= new int [numeri.length];
			for(int indice = 0, pos=0; indice<=numeri.length; indice++, pos++) {
				int numero = (int) ((Math.random()*numeri.length)+1); 
				
				mescolaVettore[pos] = numeri[numero];
				lInverti.setText(lInverti.getText()+" "+mescolaVettore[pos]);
		    }
		}
	}
			
	public static void main(String args[]){
		launch();
	}
}