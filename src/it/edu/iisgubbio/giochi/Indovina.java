package it.edu.iisgubbio.giochi;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Indovina extends Application{

	
	TextField tNumero = new TextField();
	Button bProva = new Button("prova se hai indovinato"); 
	Label lSoluzione = new Label("");
	int random = (int)(Math.random()*100)+1;
	Label lMostraRandom = new Label(""+random);
	Button bRiprova = new Button ("rinizia il gioco");
	
	public void start(Stage finestra) {
		
		Label lNumero = new Label("Numero:");

		GridPane griglia = new GridPane();
		
		griglia.setPadding(new Insets(5, 5, 5, 5));
		griglia.setHgap(15); 
		griglia.setVgap(15);
		
		griglia.add(lNumero, 0, 0);
		griglia.add(tNumero, 1, 0);
		griglia.add(bProva, 0, 1, 2, 1);
		bProva.setMaxWidth(10000);
		griglia.add(lSoluzione, 0, 2, 2, 1);
		lSoluzione.setMaxWidth(10000);
		griglia.add(bRiprova, 0, 3, 2, 1);
		griglia.add(lMostraRandom, 0, 4);
		lMostraRandom.setMaxWidth(10000);
						
		Scene scena = new Scene(griglia);
	    finestra.setTitle("Indovina!");
	    finestra.setScene(scena);
	    finestra.show();
		
	    bProva.setOnAction(e -> numeroCasuale()); 
	   	bRiprova.setOnAction(e -> Riprova());	
	}
	public void Riprova() {
		random = (int)(Math.random()*100)+1;
		lMostraRandom.setText(""+random);
	}
	
	public void numeroCasuale() {
		String stringNumero = tNumero.getText();
		int numero = Integer.parseInt(stringNumero);
		int randomico = random;
		if (numero!=randomico) {
			if (numero>random){
				lSoluzione.setText("il numro è più piccolo");
			}else {
				lSoluzione.setText("Il numero è più grande");
			}
		}else {
			lSoluzione.setText("Hai indovinato");
		}
	}
	
	
	public static void main(String[] args) {
	    launch(args);
	  }
	
}