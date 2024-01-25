package it.edu.iisgubbio.negozio;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Sconto2 extends Application{
	
	TextField tPrezzo = new TextField();
	TextField tNPanini = new TextField();
	Label lTotale = new Label();	
	RadioButton rScontoNull = new RadioButton("nessuno");
	RadioButton rSconto10 = new RadioButton("sconto 10%");
	RadioButton rSconto20 = new RadioButton("sconto 20%");
	
	public void start(Stage finestra) {
		
		Button bTotale = new Button("Calcola il totale");
		Label lPrezzo = new Label("Prezzo panino");
		Label lNPanini = new Label("Numero Panini");
		ToggleGroup togSconti = new ToggleGroup();
		
		rScontoNull.setToggleGroup(togSconti);
		rSconto10.setToggleGroup(togSconti);
		rSconto20.setToggleGroup(togSconti);
		
		GridPane griglia = new GridPane();
		
		griglia.setPadding(new Insets(5, 5, 5, 5));
		griglia.setHgap(15); 
		griglia.setVgap(15);
		
		griglia.add(lPrezzo, 0, 0);
		griglia.add(tPrezzo, 1, 0);
		griglia.add(lNPanini, 0, 1);
		griglia.add(tNPanini, 1, 1);
		griglia.add(rScontoNull, 1, 2);
		griglia.add(rSconto10, 1, 3);
		griglia.add(rSconto20, 1,4);
		griglia.add(bTotale, 0, 5, 2, 1);
		bTotale.setMaxWidth(1000);
		griglia.add(lTotale, 0, 6, 2, 1);
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
		double prezzo;
		double panino;
		double sconto;
		double totale;
			
		stringPrezzo = tPrezzo.getText();
		stringNPanino = tNPanini.getText();
		
		prezzo = Double.parseDouble(stringPrezzo);
		panino= Double.parseDouble(stringNPanino);
		
		
		//calcolo il prezzo dei panini con spunta su nessuno sconto
		if(rScontoNull.isSelected()){
			totale = ((prezzo*panino));
			
			lTotale.setText(""+ totale);
		}
		//calcolo il prezzo dei panini con spunta su sconto 10%
		if(rSconto10.isSelected()){
			sconto = 10.0;
			totale = ((prezzo*panino))-((prezzo*panino)*(sconto/100));
			
			lTotale.setText(""+ totale);
		}
		//calcolo il prezzo dei panini con spunta su sconto 20%
		if(rSconto20.isSelected()){
			sconto = 20.0;
			totale = ((prezzo*panino))-((prezzo*panino)*(sconto/100));
			
			lTotale.setText(""+ totale);
		}
	}

	
	public static void main(String[] args) {
	    launch(args);
	  }
	
}