package it.edu.iisgubbio.prove;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Stile extends Application{	
	
	TextField tBase = new TextField();
	TextField tAltezza = new TextField();
	TextField tArea = new TextField();
	TextField tPerimetro = new TextField();
	Button bCalcola = new Button();
	
	public void start(Stage finestra) {
		GridPane griglia = new GridPane();
		griglia.setId("grid-spazio");
		
		Label lBase = new Label("Bae");
		Label lAltezza = new Label("Altezza");
		Label lArea = new Label("Area");
		Label lPerimetro = new Label("Perimetro");
		
		/*griglia.setPadding(new Insets(5, 5, 5, 5));
		griglia.setHgap(15); 
		griglia.setVgap(15); 
		questo in css*/
		
		griglia.add(lBase, 0, 0);
		griglia.add(tBase, 1, 0);
		griglia.add(lAltezza, 0, 1);
		griglia.add(tAltezza, 1,1);
		griglia.add(lArea, 0, 2);
		lPerimetro.setId("perimetro");
		griglia.add(lPerimetro, 1, 2);
		griglia.add(tArea, 0, 3);
		griglia.add(tPerimetro, 1, 3);
				
		Scene scena = new Scene(griglia);
		scena.getStylesheets().add("it/edu/iisgubbio/prove/Stile.css");
	    finestra.setTitle("Equazioni!");
	    finestra.setScene(scena);
	    finestra.show();
	    tAltezza.setOnAction(e -> calcola());
	    
	    
	}
	public void calcola(){
		if ((!tAltezza.getText().equals(""))||!tBase.getText().equals("")){
			String stBase = tBase.getText();
			String stAltezza = tAltezza.getText();
			double base = Double.parseDouble(stBase);
			double altezza = Double.parseDouble(stAltezza);
			double area;
			double perimetro;
			area = base * altezza;
			perimetro = (base + altezza)*2;
			tArea.setText(""+area);
			tPerimetro.setText(""+perimetro);
			
		}else {
			tArea.setText("errore");
			tPerimetro.setText("errore");
		}
		  
		  
	  }
	
	public static void main(String[] args) {
	    launch(args);
	  }
	
}