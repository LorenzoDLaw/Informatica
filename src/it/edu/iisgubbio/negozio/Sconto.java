package it.edu.iisgubbio.negozio;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.CheckBox;

public class Sconto extends Application{
	
	TextField tPrezzo = new TextField();
	TextField tNPanini = new TextField();
	TextField tSconto = new TextField();
	Label lTotale = new Label();
	CheckBox ckSconto = new CheckBox("spuntare per ottenere lo sconto");  
	
	
	public void start(Stage finestra) {
		
		Button bTotale = new Button("Calcola il totale");
		Label lPrezzo = new Label("Prezzo");
		Label lNPanini = new Label("Numero Panini");
		Label lSconto = new Label("Percentuale sconto");
		
		
		GridPane griglia = new GridPane();
		
		griglia.setPadding(new Insets(5, 5, 5, 5));
		griglia.setHgap(15); 
		griglia.setVgap(15);
		
		griglia.add(lPrezzo, 0, 0);
		griglia.add(tPrezzo, 1, 0);
		griglia.add(lNPanini, 0, 1);
		griglia.add(tNPanini, 1, 1);
		griglia.add(ckSconto, 0, 2,2,1);
		ckSconto.setMaxWidth(1000);
		griglia.add(lSconto, 0, 3);
		griglia.add(tSconto, 1,3);
		griglia.add(bTotale, 0, 4, 2, 1);
		bTotale.setMaxWidth(1000);
		griglia.add(lTotale, 0, 5, 2, 1);
		lTotale.setMaxWidth(1000);
		
						
		Scene scena = new Scene(griglia);
	    finestra.setTitle("Sconto!");
	    finestra.setScene(scena);
	    finestra.show();
		
	    bTotale.setOnAction(e -> totale()); 
	   		
	}
	
	
	public void totale() {
		
		String stringPrezzo;
		String stringNPanino;
		String stringSconto;
		double prezzo;
		double panino;
		double sconto;
		double totale;
			
		stringPrezzo = tPrezzo.getText();
		stringNPanino = tNPanini.getText();
		stringSconto = tSconto.getText();
		
		prezzo = Double.parseDouble(stringPrezzo);
		panino= Double.parseDouble(stringNPanino);
		
		//calcolo il prezzo dei panini con lo sconto se la checkbox e spuntata
		if(ckSconto.isSelected()){
			sconto= Double.parseDouble(stringSconto);
			totale = ((prezzo*panino))-((prezzo*panino)*(sconto/100));
			
			lTotale.setText(""+ totale);
		}
		
		else{
			totale = ((prezzo*panino));
			
			lTotale.setText(""+ totale);
		}
	}

	
	public static void main(String[] args) {
	    launch(args);
	  }
	
}