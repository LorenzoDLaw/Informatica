package it.edu.iisgubbio.matematica;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Capitale extends Application{
	
	
	TextField tCapitale = new TextField("");
	TextField tAnni = new TextField("");
	TextField tInteressi = new TextField("");
	Label lRisultato = new Label();
	
	public void start(Stage finestra) {
		Label lCapitale = new Label("Capitale inziale");
		Label lAnni = new Label("Anni di trattenuta");
		Label lInteressi = new Label("Interesse nel tempo");
		GridPane griglia = new GridPane();
		
		griglia.setPadding(new Insets(5, 5, 5, 5));
		griglia.setHgap(15); 
		griglia.setVgap(15);
		
		
		griglia.add(lCapitale, 0, 0);
		griglia.add(tCapitale, 1, 0);
		griglia.add(lAnni, 0, 1);
		griglia.add(tAnni, 1, 1);
		griglia.add(lInteressi, 0, 2);
		griglia.add(tInteressi, 1, 2);
		griglia.add(lRisultato, 0, 3,2,1);
		
		Scene scena = new Scene(griglia);
	    finestra.setTitle("Tabelline!");
	    finestra.setScene(scena);
	    finestra.show();
	    scena.getStylesheets().add("it/edu/iisgubbio/matematica/tabelline.css");
		
	    tInteressi.setOnAction(e -> interesse());
	    
	    
		
	}
	
	
	public void interesse() {
		double cap = Double.parseDouble(tCapitale.getText());
		double anni= Double.parseDouble(tAnni.getText());
		double interessi = Double.parseDouble(tInteressi.getText());
		double risultato;
		for(int n = 1; n<=anni; n++) {
			risultato= cap + (cap/100*interessi);
			cap = risultato;
		}
		lRisultato.setText(""+cap);
	}
	
	public static void main(String[] args) {
	    launch(args);
	  }
	
}