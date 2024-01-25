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

public class Equazioni2 extends Application{
	
	TextField tValoreA = new TextField();
	TextField tValoreB = new TextField();
	TextField tValoreC = new TextField();
	Label lSoluzioni = new Label();
	Button bCalcola = new Button("calcola soluzioni");
	Label lNapoleone = new Label();
	
	public void start(Stage finestra) {
		
		Label lA = new Label("x^2 +");
		Label lB = new Label("x +");
		Label lUguale = new Label("=0");
		
		GridPane griglia = new GridPane();
		
		griglia.setPadding(new Insets(5, 5, 5, 5));
		griglia.setHgap(15); 
		griglia.setVgap(15);
		
		griglia.add(tValoreA, 0, 0);
		griglia.add(lA, 1, 0);
		griglia.add(tValoreB, 2, 0);
		griglia.add(lB, 3, 0);
		griglia.add(tValoreC, 4, 0);
		griglia.add(lUguale, 5, 0);
		griglia.add(bCalcola, 0,1,6,1);
		bCalcola.setMaxWidth(1000000);
		griglia.add(lSoluzioni, 0,2,6,1);
		lSoluzioni.setMaxWidth(1000000);
		griglia.add(lNapoleone, 0, 3);
				
		Scene scena = new Scene(griglia,500,200);
	    finestra.setTitle("Equazioni!");
	    finestra.setScene(scena);
	    finestra.show();
		
	    bCalcola.setOnAction(e -> equazione());
	    
	    
		
	}
	
	
	public void equazione() {
		
		String stringValoreA=tValoreA.getText();
		String stringValoreB=tValoreB.getText();
		String stringValoreC=tValoreC.getText();
		double a;
		double b;
		double c;
		double delta;
		double x1;
		double x2;
		
		if(stringValoreA.equals("")){
			a=0;
		}else {
			a = Double.parseDouble(stringValoreA);
		}
		if(stringValoreB.equals("")){
			b=0;
		}else {
			b = Double.parseDouble(stringValoreB);
		}
		if(stringValoreC.equals("")){
			c=0;
		}else {
			c = Double.parseDouble(stringValoreC);
		}
		
		if (a!=0) {
			delta =((b*b)-4.0*a*c);
			if (delta<0.0){
				lSoluzioni.setText("l'equazione è impossibile. Ther's nothing we can do");
				Image immagine = new Image(getClass().getResourceAsStream("Napoleone.png"));
				ImageView visualizzatoreImmagine = new ImageView(immagine);
				visualizzatoreImmagine.setFitHeight(100);
				visualizzatoreImmagine.setPreserveRatio(true);
				lNapoleone.setGraphic(visualizzatoreImmagine);
			}else{
				x1=((-b+Math.sqrt(delta))/(2*a));
				x2=((-b-Math.sqrt(delta))/(2*a));
				if(x1==x2) {
					lSoluzioni.setText("l'equazioni ha 2 soluzioni uguali x = "+x1);
				}else {
					lSoluzioni.setText("l'equazioni ha soluzioni x1= "+x1+" e x2= "+x2);
				}
			}
		}else if(b!=0){
			x1=((-c)/b);
			lSoluzioni.setText("l'equazione ha risultato x = "+x1);			
		}else if(c!=0) {
			lSoluzioni.setText("l'equazione è impossibile");
		}else {
			lSoluzioni.setText("l'equazione è uguale a 0");
		}
		
				
	}
	
	public static void main(String[] args) {
	    launch(args);
	  }
	
}