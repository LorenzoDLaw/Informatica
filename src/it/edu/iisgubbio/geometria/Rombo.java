package it.edu.iisgubbio.geometria;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class Rombo extends Application{
	
	Label lPerimetro = new Label();
	Label lArea = new Label();
	TextField tDiagonaleBase = new TextField();
	TextField tDiagonaleAltezza = new TextField();
	
	
	public void start(Stage finestra) {
		
		Label lDiagonaleBase = new Label("Diagonale 1");
		Label lDiagonaleAltezza = new Label("Diagonale 2");
		Button bCalcola = new Button("calcola l'Area e il Perimetro");
		
		
		GridPane griglia = new GridPane();
		
		griglia.setPadding(new Insets(5, 5, 5, 5));
		griglia.setHgap(15); 
		griglia.setVgap(15);
		
		griglia.add(lDiagonaleBase, 0, 0);
		griglia.add(tDiagonaleBase, 1, 0);
		griglia.add(lDiagonaleAltezza, 0, 1);
		griglia.add(tDiagonaleAltezza, 1, 1);
		griglia.add(bCalcola, 0, 2, 2, 1);
		bCalcola.setMaxWidth(1000);
		griglia.add(lArea, 0, 3);
		lArea.setMaxWidth(10000);
		griglia.add(lPerimetro, 1, 3);
		
		
				
		Scene scena = new Scene(griglia);
	    finestra.setTitle("Rombo!");
	    finestra.setScene(scena);
	    finestra.show();
		
	    bCalcola.setOnAction(e -> AreaPerimetroRombo());
	    
	    
		
	}
	
	
	public void AreaPerimetroRombo() {
		
		String Diagonale1;
		String Diagonale2;
		double dDiagonaleB;
		double dDiagonaleH;
		double area;
		double lato;
		double perimetro; 
		
		
		
		Diagonale1 = tDiagonaleBase.getText();
		Diagonale2 = tDiagonaleAltezza.getText();
		
		dDiagonaleB = Double.parseDouble(Diagonale1);
		dDiagonaleH= Double.parseDouble(Diagonale2);
		
		area = ((dDiagonaleB * dDiagonaleH)/2);
		lArea.setText("l'area è " + area);
		lato = ((dDiagonaleH/2) * (dDiagonaleH/2)) + ((dDiagonaleB/2) * (dDiagonaleB/2));
		perimetro= Math.sqrt(lato)*4;
		lPerimetro.setText("il perimetro è "+perimetro);
		
	}
	
	
	public static void main(String[] args) {
	    launch(args);
	  }
	
}