package it.edu.iisgubbio.geometria;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class TriangoloRettangolo extends Application{
	
	TextField tCateto1 = new TextField();
	TextField tCateto2 = new TextField();
	TextField tIpotenusa = new TextField();
	
	
	public void start(Stage finestra) {
		
		Button bCalcolaCateto1 = new Button("calcola cateto 1");
		Button bCalcolaCateto2 = new Button("calcola cateto 2");
		Button bIpotenusa = new Button("calcola ipotenusa");
		Label lCateto1 = new Label("cateto 1");
		Label lCateto2 = new Label("cateto 2");
		Label lIpotenusa = new Label("Ipotenusa");
		
		GridPane griglia = new GridPane();
		
		griglia.setPadding(new Insets(5, 5, 5, 5));
		griglia.setHgap(15); 
		griglia.setVgap(15);
		
		griglia.add(lCateto1, 0, 0);
		griglia.add(tCateto1, 1, 0);
		griglia.add(bCalcolaCateto1, 2, 0);
		griglia.add(lCateto2, 0, 1);
		griglia.add(tCateto2, 1, 1);
		griglia.add(bCalcolaCateto2, 2, 1);
		griglia.add(lIpotenusa, 0, 2);
		griglia.add(tIpotenusa, 1,2);
		griglia.add(bIpotenusa, 2, 2);
		
		
		
		
				
		Scene scena = new Scene(griglia);
	    finestra.setTitle("triangolo rettangolo!");
	    finestra.setScene(scena);
	    finestra.show();
		
	    bCalcolaCateto1.setOnAction(e -> cateto1());
	    bCalcolaCateto2.setOnAction(e -> cateto2());
	    bIpotenusa.setOnAction(e -> ipotenusa());
	    
	    
		
	}
	
	
	public void cateto1() {
		
		String stringCateto2;
		String stringIpotenusa;
		double cateto2;
		double ipotenusa;
		double cateto1;
		
		
		stringCateto2 = tCateto2.getText();
		stringIpotenusa = tIpotenusa.getText();
		
		cateto2 = Double.parseDouble(stringCateto2);
		ipotenusa= Double.parseDouble(stringIpotenusa);
		
		// esponenzio l'ipotenusa "dIpotenusa" meno l'altro cateto "dCatetoInput" tutto sotto radice
		
		cateto1 = Math.sqrt((ipotenusa*ipotenusa)-(cateto2 * cateto2));
		
		
		tCateto1.setText(""+cateto1);
		
	}

	public void cateto2() {
		
		String cateto1;
		String ipotenusa;
		double dCatetoInput;
		double dIpotenusa;
		double dCateto1;
		 
		
		
		
		cateto1 = tCateto1.getText();
		ipotenusa = tIpotenusa.getText();
		
		dCatetoInput = Double.parseDouble(cateto1);
		dIpotenusa= Double.parseDouble(ipotenusa);
		
		// esponenzio l'ipotenusa "dIpotenusa" meno l'altro cateto "dCatetoInput" tutto sotto radice
		
		dCateto1 = Math.sqrt((dIpotenusa*dIpotenusa)-(dCatetoInput * dCatetoInput));
		
		
		tCateto2.setText(""+dCateto1);
		
	}
	
	public void ipotenusa() {
		
		String cateto1;
		String cateto2;
		double dCateto1Input;
		double dCateto2Input;
		double dipotenusa;
		 
		
		
		
		cateto1 = tCateto1.getText();
		cateto2 = tCateto2.getText();
		
		dCateto1Input = Double.parseDouble(cateto1);
		dCateto2Input= Double.parseDouble(cateto2);
		
		// esponenzio l'ipotenusa "dIpotenusa" meno l'altro cateto "dCatetoInput" tutto sotto radice
		
		dipotenusa = Math.sqrt((dCateto1Input*dCateto1Input)+(dCateto2Input * dCateto2Input));
		
		
		tIpotenusa.setText(""+dipotenusa);
		
	}
	


	
	public static void main(String[] args) {
	    launch(args);
	  }
	
}