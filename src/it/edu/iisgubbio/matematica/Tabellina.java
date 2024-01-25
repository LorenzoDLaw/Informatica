package it.edu.iisgubbio.matematica;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Tabellina extends Application{
	
	TextField tNumero = new TextField("");
	Label lRisTabelline = new Label("");
	Button bCalcola = new Button("calcola la tabellina");

	
	public void start(Stage finestra) {
		
		Label lNumero = new Label("Numero");
		
		GridPane griglia = new GridPane();
		
		griglia.setPadding(new Insets(5, 5, 5, 5));
		griglia.setHgap(15); 
		griglia.setVgap(15);
		
		lRisTabelline.setId("ris");
		
		griglia.add(lNumero, 0, 0);
		griglia.add(tNumero, 1, 0);
		griglia.add(bCalcola, 0, 1,2,1);
		bCalcola.setMaxWidth(1000000);
		griglia.add(lRisTabelline, 0, 2,2,1);
		lRisTabelline.setMaxWidth(1000000);		
		Scene scena = new Scene(griglia);
	    finestra.setTitle("Tabelline!");
	    finestra.setScene(scena);
	    finestra.show();
	    scena.getStylesheets().add("it/edu/iisgubbio/matematica/tabelline.css");
		
	    bCalcola.setOnAction(e -> tabelline());
	    
	    
		
	}
	
	
	public void tabelline() {
		String strTab="0 ";
		int valore = Integer.parseInt(tNumero.getText());
		int n;
		int ris;
		for(n = 1; n<=10; n++) {
			ris = valore *n;  
			strTab += ", " +ris;
		}
		lRisTabelline.setText(strTab);
	}
	
	public static void main(String[] args) {
	    launch(args);
	  }
	
}