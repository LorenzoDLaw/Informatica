package it.edu.iisgubbio.vettori;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Check extends Application {
	TextField tFrase = new TextField();
	Label lCorreggi = new Label();
	   
	   @Override
	   public void start(Stage primaryStage) {
		   
		  Label lFrase = new Label("frase");
		  Button bControlla = new Button("controlla");
		  
	      GridPane griglia = new GridPane();
	      griglia.setPadding(new Insets(5, 5, 5, 5));
	      griglia.setHgap(15); 
	      griglia.setVgap(15);
	      Scene scena = new Scene(griglia, 400, 270);
	      primaryStage.setTitle("Bho!");
	      primaryStage.setScene(scena);
		  primaryStage.show();

		  griglia.add(lFrase, 0, 0);
		  griglia.add(tFrase, 0, 1);
		  griglia.add(bControlla, 0, 2);
		  griglia.add(lCorreggi, 0, 3);
		  
		  bControlla.setOnAction(e -> controlla());
	   }

	   public void controlla() {
		   String StrNome = tFrase.getText();
		   char nome[]=StrNome.toCharArray();
		   if (nome[0]>='a' && nome[0]<='z') {
			   char x= nome[0];
			   x = (char)(x-32);
			   nome [0]=x;
		   }
		   for (int i=1; i<nome.length;i++){
			   if(nome[i]== '.' ) {
				   if (i!=nome.length-1) {
					   if(nome[i+1]== ' ') {
						   i=i+2;   
						   if (nome[i]>='a' && nome[i]<='z') {
							   char x= nome[i];
							   x = (char)(x-32);
							   nome [i]=x;
						   }
					   }
				   }
			   }else {
				   if (nome[i]>='A' && nome[i]<='Z') {
					   char x= nome[i];
					   x = (char)(x+32);
					   nome [i]=x;
				   } 
		   }
		   String frase = new String (nome);
		   lCorreggi.setText(frase);
	   }
	   }
		   
	   public static void main(String[] args) {
		    launch(args);
		  }
	}