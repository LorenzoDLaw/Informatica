package it.edu.iisgubbio.verifica;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.CheckBox;

public class LorenzoScanuRistorante extends Application{
	
	
	TextField tNPanini = new TextField();
	TextField tPrezPanini = new TextField();
	TextField tNPatatine = new TextField();
	TextField tPrezPatatine = new TextField();
	CheckBox ckSalsa = new CheckBox("salse+0.2€");
	CheckBox ckSconto = new CheckBox("sconto 10%");  
	Button bTotale = new Button("Calcola prezzo");
	Label lWTotale = new Label();
	
	public void start(Stage finestra) {
		
		Label lNPanini = new Label("Numero hamburger;");
		Label lPrezPanini = new Label("Prezzo hamburger");
		Label lNPatatine = new Label("Numero patatine");
		Label lPrezPatatine = new Label("Prezzo patatine");
		Label lTotale = new Label("Totale:");
		
		GridPane griglia = new GridPane();
		
		griglia.setPadding(new Insets(5, 5, 5, 5));
		griglia.setHgap(15); 
		griglia.setVgap(15);
		
		griglia.add(lNPanini, 0, 0);
		lNPanini.setId("nHamburger");
		griglia.add(lPrezPanini, 1, 0);
		griglia.add(tNPanini, 0, 1);
		griglia.add(tPrezPanini, 1, 1);
		griglia.add(lNPatatine, 0, 2);
		lNPatatine.setId("nPatatine");
		griglia.add(lPrezPatatine, 1,2);
		griglia.add(tNPatatine, 0, 3);
		griglia.add(tPrezPatatine, 1, 3);
		griglia.add(ckSalsa, 0,4);
		griglia.add(ckSconto, 1,4);
		griglia.add(bTotale, 0,5,2,1);
		bTotale.setMaxWidth(10000);
		griglia.add(lTotale, 0,6);
		griglia.add(lWTotale, 1,6);	
						
		Scene scena = new Scene(griglia);
		griglia.setId("sfondo");
		finestra.setTitle("Sconto!");
	    finestra.setScene(scena);
	    finestra.show();
	    scena.getStylesheets().add("it/edu/iisgubbio/verifica/LorenzoScanu.css");
	    
	    bTotale.setOnAction(e -> calcTotale()); 
	   		
	}
	
	
	public void calcTotale() {
		
		String stringPrezPanini = tPrezPanini.getText();
		String stringNPanino = tNPanini.getText();
		String stringPrezPatatine = tPrezPatatine.getText();
		String stringNPatatine = tNPatatine.getText();
		double prezPan = Double.parseDouble(stringPrezPanini);
		int nPan = Integer.parseInt(stringNPanino);
		double prezPat= Double.parseDouble(stringPrezPatatine);
		int nPat = Integer.parseInt(stringNPatatine);
		double salsa;
		double totale;
		
		totale=(nPan*prezPan)+(nPat*prezPat);
		if(ckSalsa.isSelected()){
			salsa=nPat * 0.20;
			totale+=salsa;
		}
		if(ckSconto.isSelected()){
			totale =totale-(totale*10/100);
		}
		lWTotale.setText(""+totale);
	}

	
	public static void main(String[] args) {
	    launch(args);
	  }
	
}