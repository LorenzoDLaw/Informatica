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

public class Kebab extends Application{
	CheckBox ckCarne = new CheckBox("Carne (4,00€)"); 
	CheckBox ckFormaggio = new CheckBox("Formaggio (1,00€)");  
	CheckBox ckPomodoro = new CheckBox("Pomodoro (1,00€)");
	CheckBox ckSalsa = new CheckBox("Salsa (0,50€)");
	CheckBox ckCipolla = new CheckBox("Cipolla (0,50€)"); 
	Button bTotale = new Button("TOTALE");
	Label lTotale = new Label();
	Slider sCursore = new Slider(1,5,1);
	
public void start(Stage finestra) {
		
		Label lNumeroPanini= new Label("Scorri per quantità panini");
		GridPane griglia = new GridPane();
		
		griglia.setPadding(new Insets(5, 5, 5, 5));
		griglia.setHgap(15); 
		griglia.setVgap(15);
		
		// voglio che mostri le tacche
        sCursore.setShowTickMarks(true);
        // voglio che mostri le etichette
        sCursore.setShowTickLabels(true);
        // quanto è grande l'unità principale
        sCursore.setMajorTickUnit(1);
        // l'unità principale non va suddivisa ulterioremente
        sCursore.setMinorTickCount(0);
        // deve muoversi a scatti
        sCursore.setSnapToTicks(true);
		
		griglia.add(lNumeroPanini, 0, 0);
        griglia.add(sCursore, 0, 1,2,1);
		sCursore.setPrefWidth(180);
        griglia.add(ckCarne, 0, 2);
		griglia.add(ckFormaggio, 0, 3);
		griglia.add(ckPomodoro, 0, 4);
		griglia.add(ckSalsa, 0, 5);
		griglia.add(ckCipolla, 0, 6);
		griglia.add(bTotale, 0, 7);
		bTotale.setMaxWidth(100);
		griglia.add(lTotale, 1,7);
		lTotale.setMaxWidth(100);

		
						
		Scene scena = new Scene(griglia);
	    finestra.setTitle("kebab!");
	    finestra.setScene(scena);
	    finestra.show();
		
	    bTotale.setOnAction(e -> totaleKebab()); 
	   		
	}
	public void totaleKebab() {
		double totale;
		totale=0.0;
		double val = sCursore.getValue();
		if (ckCarne.isSelected()) {
			totale = totale +4.00;
		}if (ckFormaggio.isSelected()) {
			totale = totale+1.00;
		}if (ckPomodoro.isSelected()) {
			totale = totale+1.00;
		}if (ckSalsa.isSelected()) {
			totale = totale +0.50;
		}if (ckCipolla.isSelected()) {
			totale = totale +0.50;
		}
		totale = totale *val;
		lTotale.setText(""+ totale);
	}
	
	public static void main(String[] args) {
	    launch(args);
	  }

}
