package it.edu.iisgubbio.vettori;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MinMax extends Application {
	   TextField tNumeri = new TextField();
	   Label lRisultato = new Label("Ris");
	   public void start(Stage primaryStage) {
	      GridPane griglia = new GridPane();
	      griglia.setPadding(new Insets(5, 5, 5, 5));
	      griglia.setHgap(15); 
	      griglia.setVgap(15);
	      Scene scena = new Scene(griglia);
	      primaryStage.setTitle("bancndjfnhasdajhvbabvhbvabbfhdabvlkafbvfvffajkvbfuoiabvi!");
	      primaryStage.setScene(scena);
		  primaryStage.show();
		  
		  Button bMin = new Button("Min");
		  Button bMax = new Button("Max");
		  
		  griglia.add(tNumeri, 0, 0,3,1);
		  griglia.add(bMin, 0, 1);
		  griglia.add(lRisultato, 1, 1);
		  griglia.add(bMax, 2, 1);
		  
		  bMin.setOnAction(e-> trovaMin());
		  bMax.setOnAction(e-> trovaMax());
		  
	   }
	   public void trovaMin() {
		   String num = tNumeri.getText();
		   String [] strVettore = num.split(" ");
		   int vetElemetni[]= new int [strVettore.length];
		   for (int i =0; i<vetElemetni.length;i++) {
			   
		   }
		   int nMin=vetElemetni[0];
		   for (int pos=1; pos<vetElemetni.length; pos++) {
			   if(vetElemetni[pos]<nMin) {
				   nMin = vetElemetni[pos];
			   }
		   }
		   lRisultato.setText(""+nMin);
	   }
	   //4 8 9 10 11 5 6 3
	   public void trovaMax() {
		   String num = tNumeri.getText();
		   String [] strVettore = num.split(" ");
		   int vetElemetni[]= new int [strVettore.length];
		   int nMax=vetElemetni[0];
		   for (int pos=0; pos<vetElemetni.length; pos++) {
			   if(vetElemetni[pos]>nMax) {
				   nMax = vetElemetni[pos];
			   }
		   } 
		   lRisultato.setText(""+nMax);
	   }
	  
	   public static void main(String[] args) {
		    launch(args);
		  }
	}