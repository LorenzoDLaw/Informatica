package it.edu.iisgubbio.vettori;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Caso extends Application {
	   TextField tNumElementi = new TextField();
	   TextField tMinim = new TextField();
	   TextField tMax = new TextField();
	   Label lVettore = new Label("");
	   Label lPari = new Label("");
	   Label lSomma = new Label("");
	   Label lSomma2 = new Label("");
	   Label lTrovaMin = new Label("");
	   int elementi[];
	   public void start(Stage primaryStage) {
	      GridPane griglia = new GridPane();
	      griglia.setPadding(new Insets(5, 5, 5, 5));
	      griglia.setHgap(15); 
	      griglia.setVgap(15);
	      Scene scena = new Scene(griglia);
	      primaryStage.setTitle("Bho!");
	      primaryStage.setScene(scena);
		  primaryStage.show();
		  
		  Label lNumElementi = new Label("elementi");
		  Label lMin = new Label("Numero Minore");
		  Label lMax = new Label("Numero Maggiore");
		  Button bCaricaVett = new Button("genera");
		  Button bStampa = new Button("stampa");
		  Button bPari = new Button("pari");
		  Button bSomma = new Button("Somma");
		  Button bSom2 = new Button("somma di 2_3");
		  Button bTrovaMin = new Button("Minimo Numero");
		  
		  griglia.add(tNumElementi, 1, 0);
		  griglia.add(lNumElementi, 0, 0);
		  griglia.add(lMin, 0, 1);
		  griglia.add(tMinim, 1, 1);
		  griglia.add(lMax, 0, 3);
		  griglia.add(tMax, 1, 3);
		  griglia.add(bCaricaVett, 0, 4);
		  bCaricaVett.setMaxWidth(1000);
		  griglia.add(bStampa, 1, 4);
		  bStampa.setMaxWidth(1000);
		  griglia.add(lVettore, 0, 5,2,1);
		  griglia.add(bPari, 0, 6);
		  bPari.setMaxWidth(1000);
		  griglia.add(lPari, 1, 6);
		  griglia.add(bSomma, 0, 7);
		  griglia.add(lSomma, 1, 7);
		  griglia.add(bSom2, 0, 8);
		  griglia.add(lSomma2, 1, 8);
		  griglia.add(bTrovaMin, 0, 9);
		  griglia.add(lTrovaMin, 1, 9);
		  
		  
		  bCaricaVett.setOnAction(e -> crea_caricaVettore());
		  bStampa.setOnAction(e -> stampaVettore());
		  bPari.setOnAction(e-> trovaPari());
		  bSomma.setOnAction(e-> somma());
		  bSom2.setOnAction(e-> somma2());
		  bTrovaMin.setOnAction(e-> trovaMin());
		  
	   }
	   public void crea_caricaVettore() {
		   int numElementi = Integer.parseInt(tNumElementi.getText());
		   int min = Integer.parseInt(tMinim.getText());
		   int max = Integer.parseInt(tMax.getText());
		   int numero;
		   elementi = new int[numElementi];
		   for (int pos=0; pos<elementi.length; pos++) {
			   numero = (int) (Math.random()*(max - min + 1) + min);
			   System.out.print(numero);
			   elementi[pos]=numero;
		   }   
	   }
		      
	   public void stampaVettore() {
		   String vettore="";
		   for(int pos=0; pos<elementi.length;pos++) {
			   if (vettore.equals("")){
				   vettore += (""+elementi[pos]);
			   }else {
				   vettore += (", "+elementi[pos]);
			   }
		   }	
		   lVettore.setText(vettore);
	   }
	   public void trovaPari() {
		   int contatore=0;
		   for (int pos=0; pos<elementi.length; pos++) {
			   if (elementi[pos]%2==0){
				   contatore++;
			   }
		   } 
		   lPari.setText(""+contatore);
	   }
	   public void somma() {
		   int contatore=0;
		   for (int pos=0; pos<elementi.length; pos++) {
				   contatore+=elementi[pos];
		   } 
		   lSomma.setText(""+contatore);
	   }
	   public void somma2() {
		   int contatore=0;
		   for (int pos=0; pos<elementi.length; pos++) {
			   if ((elementi[pos]%2==0)&&(elementi[pos]%3==0)){
				   contatore++;
			   }
		   } 
		   lSomma2.setText(""+contatore);
	   }
	   public void trovaMin() {
		   int nMin = Integer.parseInt(tMax.getText());
		   int compara=0;
		   for (int pos=0; pos<elementi.length; pos++) {
			   compara = elementi[pos];
			   if(compara<nMin) {
				   nMin=compara;
			   }
		   } 
		   lTrovaMin.setText(""+nMin);
	   }
	   public static void main(String[] args) {
		    launch(args);
		  }
	}