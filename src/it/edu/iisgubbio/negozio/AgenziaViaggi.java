package it.edu.iisgubbio.negozio;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

public class AgenziaViaggi extends Application{
	Button bCalcola = new Button("calcola il biglietto");
	TextField tCapienza = new TextField();
	TextField tPartecipanti = new TextField();
	TextField tCostoBus = new TextField();
	Label tCostoBiglietto = new Label();
public void start(Stage finestra) {
		
		Label lCapienza= new Label("persone per autobus");	
		Label lPartecipanti= new Label("partecipanti");
		Label lCostoBus= new Label("costo bus");
		Label lCostoBiglietto= new Label("costo biglietti");
		
		GridPane griglia = new GridPane();
		
		griglia.setPadding(new Insets(5, 5, 5, 5));
		griglia.setHgap(15); 
		griglia.setVgap(15);
		
		griglia.add(lCapienza, 0, 0);
        griglia.add(tCapienza, 1, 0);
        griglia.add(lPartecipanti, 0, 1 );
		griglia.add(tPartecipanti, 1, 1);
		griglia.add(lCostoBus, 0, 2);
		griglia.add(tCostoBus, 1, 2);
		griglia.add(bCalcola, 0, 3, 2, 1);
		bCalcola.setMaxWidth(1000);
		griglia.add(lCostoBiglietto, 0, 4);
		griglia.add(tCostoBiglietto, 1, 4);
		

		
						
		Scene scena = new Scene(griglia);
	    finestra.setTitle("BUS!");
	    finestra.setScene(scena);
	    finestra.show();
		
	    bCalcola.setOnAction(e -> bigliettoSingolo()); 
	   		
	}
	public void bigliettoSingolo() {
		String stringCapienza = tCapienza.getText();
		String stringpartecipanti = tPartecipanti.getText();
		String stringCosto = tCostoBus.getText();
		int capienza = Integer.parseInt(stringCapienza);
		int partecipanti = Integer.parseInt(stringpartecipanti);
		double costo = Double.parseDouble(stringCosto);	
		double biglietto;
		int bus;
		
		if((partecipanti%capienza)>0) {
			bus=(partecipanti/capienza+1);
		}else {
			bus=(partecipanti/capienza);
		}
		biglietto = (costo*bus)/partecipanti;
		tCostoBiglietto.setText(""+biglietto);
	}
	
	public static void main(String[] args) {
	    launch(args);
	  }

}
