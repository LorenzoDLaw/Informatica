package it.edu.iisgubbio.prove;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LorenzoScanuNumeri extends Application {
	
	TextField tINumero = new TextField();
	Label lINum = new Label("primo numero");
	TextField tIINumero = new TextField();
	Label lIINum = new Label("secondo numero");
	Button bCalcola = new Button("calcola");
	Label lRisultato = new Label("risultato");
	public void start(Stage finestra) {

		
		GridPane griglia = new GridPane();
		
		griglia.setPadding(new Insets(5, 5, 5, 5));
		griglia.setHgap(15); 
		griglia.setVgap(15);
		
		griglia.add(lINum, 0, 0);
		griglia.add(lIINum, 0, 1);
		griglia.add(tINumero, 1, 0);
		griglia.add(tIINumero, 1, 1);
		griglia.add(bCalcola, 0, 2);
		griglia.add(lRisultato, 1, 2);
								
		Scene scena = new Scene(griglia);
	    finestra.setTitle("Bisestile!");
	    finestra.setScene(scena);
	    finestra.show();
		
	    bCalcola.setOnAction(e -> calcola()); 
	   		
	}
	public void calcola() {
		String stPrimNum = tINumero.getText();
		String stSecNum = tIINumero.getText();
		int iPriNum = Integer.parseInt(stPrimNum);
		int iSecNum = Integer.parseInt(stSecNum);
		boolean trovato = false;
		int mcm;
		for(mcm=1; !trovato; mcm++ ) {
			trovato = mcm%iPriNum==0 && mcm %iSecNum==0;				
			}
		lRisultato.setText("risultato "+mcm);
		}
		
	
	
	public static void main(String[] args) {
	    launch(args);
	  }

}
