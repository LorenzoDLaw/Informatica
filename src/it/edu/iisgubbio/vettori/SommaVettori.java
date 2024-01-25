package it.edu.iisgubbio.vettori;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SommaVettori extends Application {
	   TextField tNum = new TextField();
	   Label lSomma = new Label("Somma");
	   Label lCrescente = new Label(); 
	   public void start(Stage primaryStage) {
	      GridPane griglia = new GridPane();
	      griglia.setPadding(new Insets(5, 5, 5, 5));
	      griglia.setHgap(15); 
	      griglia.setVgap(15);
	      Scene scena = new Scene(griglia,400,400);
	      primaryStage.setTitle("Bho!");
	      primaryStage.setScene(scena);
		  primaryStage.show();
		  
		  Button bSomma = new Button("Somma");
		  Button bCrescente = new Button("Crescente?");
		  
		  griglia.add(tNum, 0, 0);
		  griglia.add(bSomma, 0, 1);
		  griglia.add(lSomma, 0, 2);
		  griglia.add(bCrescente, 0, 3);
		  griglia.add(lCrescente, 0, 4);
		  
		  bSomma.setOnAction(e-> somma());
		  bCrescente.setOnAction(e-> crescente());
	   }
	   public void somma() {
		   String num = tNum.getText();
		   String [] strVettore = num.split(" ");
		   int numeri[]= new int [strVettore.length];
		   for (int pos=0; pos<strVettore.length; pos++) {
				   numeri[pos]=Integer.parseInt(strVettore[pos]);
		   } 
		   int somma=0;
		   for (int pos=0; pos<strVettore.length; pos++) {
			   somma+=numeri[pos];
	   } 
		   lSomma.setText(""+somma);
		   
	   }
	   public void crescente() {
		   String num = tNum.getText();
		   String [] strVettore = num.split(" ");
		   int numeri[]= new int [strVettore.length];
		   for (int pos=0; pos<strVettore.length; pos++) {
			   numeri[pos]=Integer.parseInt(strVettore[pos]);
		   }
		   boolean cresce = true;
		   for (int pos=1; pos<numeri.length; pos++) {
			   if(numeri[pos-1]>numeri[pos]) {
				   cresce=false;
			   }
		   }if (cresce) {
			   lCrescente.setText("Crescente");
		   }else {
			   boolean decresce = true;
			   for (int pos=1; pos<numeri.length; pos++) {
				   if(numeri[pos-1]<numeri[pos]) {
					   decresce=false;
				   }
				   if (decresce) {
					   lCrescente.setText("Decrescente");
				   }
				   else {
					   lCrescente.setText("casuali");
				   }
			   }
		   }
	   }
		   
		   
		   
		   
		   /*for (int pos=1; pos<numeri.length; pos++) {
			   if (cresce==true) {
				   if(numeri[pos-1]>numeri[pos]) {
					   cresce = false;
					   pos=1;
				   }else {
					   
				   }
			   }
			   if (cresce==false) {
				   lCrescente.setText("Decrescente");
				   if(numeri[pos-1]<numeri[pos]){
					   lCrescente.setText("casuali");
					   pos=numeri.length;
				   } 	  
			   }
		   }*/
	    
	   
	   public static void main(String[] args) {
		    launch(args);
		  }
	}