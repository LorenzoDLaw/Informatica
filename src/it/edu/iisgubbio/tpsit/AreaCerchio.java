package it.edu.iisgubbio.tpsit;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AreaCerchio extends Application{
	
	TextField tRaggio = new TextField();
	Label lRisultato = new Label();
	
	
	public void start(Stage finestra) {
		
		Button bRisolvi = new Button("calcola l'area");
				
		GridPane griglia = new GridPane();
		
		griglia.setPadding(new Insets(5, 5, 5, 5));
		griglia.setHgap(15); 
		griglia.setVgap(15);
		
		griglia.add(tRaggio, 0, 0);
		griglia.add(lRisultato, 1, 0);
		griglia.add(bRisolvi, 2, 0);
		bRisolvi.setMaxWidth(100000);
		
		
		
				
		Scene scena = new Scene(griglia);
	    finestra.setTitle("triangolo rettangolo!");
	    finestra.setScene(scena);
	    finestra.show();
		
	    bRisolvi.setOnAction(e -> triangoli());
  	
	}
	
	
	public void triangoli() {
		
		String stringRaggio= tRaggio.getText();
		double raggio= Double.parseDouble(stringRaggio);
		double risultato;
		
		risultato= (raggio*raggio)*Math.PI;
	}
	
	public static void main(String[] args) {
	    launch(args);
	  }
	
}