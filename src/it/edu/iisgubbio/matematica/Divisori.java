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

public class Divisori extends Application{
	
	TextField tNumero = new TextField("");
	Label lDivisori = new Label("");
	Button bDivisori = new Button("calcola i divisori");

	
	public void start(Stage finestra) {
		
		Label lNumero = new Label("Numero");
		
		GridPane griglia = new GridPane();
		
		griglia.setPadding(new Insets(5, 5, 5, 5));
		griglia.setHgap(15); 
		griglia.setVgap(15);
		
		
		griglia.add(lNumero, 0, 0);
		griglia.add(tNumero, 1, 0);
		griglia.add(bDivisori, 0, 1,2,1);
		bDivisori.setMaxWidth(1000000);
		griglia.add(lDivisori, 0, 2,2,1);
		lDivisori.setMaxWidth(1000000);		
		Scene scena = new Scene(griglia);
	    finestra.setTitle("Divisori!");
	    finestra.setScene(scena);
	    finestra.show();
	    scena.getStylesheets().add("it/edu/iisgubbio/matematica/tabelline.css");
		
	    bDivisori.setOnAction(e -> calcolaDifisori());
	    
	    
		
	}
	
	
	public void calcolaDifisori() {
		String strDiv = ("");
		int valore = Integer.parseInt(tNumero.getText());
		for(int n = 2; n<valore; n++) {
			if((valore % n)==0) {
				if (strDiv.equals("")) { 
					strDiv += ""+n;
				}else {
					strDiv += ""+n;
				}
				
			}
		}
		lDivisori.setText(strDiv);
	}
	
	public static void main(String[] args) {
	    launch(args);
	  }
	
}