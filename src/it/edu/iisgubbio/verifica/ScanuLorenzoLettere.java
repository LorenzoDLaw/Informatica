package it.edu.iisgubbio.verifica;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ScanuLorenzoLettere extends Application {
	TextField tFrase1 = new TextField();
	TextField tFrase2 = new TextField();
	Label lParolaComposta = new Label();
	   
	   @Override
	   public void start(Stage primaryStage) {
		   
		  Label lParola1 = new Label("parola 1");
		  Label lParola2 = new Label("parola 2");
		  Button bControlla = new Button("controlla");
		  
	      GridPane griglia = new GridPane();
	      griglia.setPadding(new Insets(5, 5, 5, 5));
	      griglia.setHgap(15); 
	      griglia.setVgap(15);
	      Scene scena = new Scene(griglia, 400, 270);
	      primaryStage.setTitle("Verifica");
	      primaryStage.setScene(scena);
		  primaryStage.show();

		  griglia.add(lParola1, 0, 0);
		  griglia.add(tFrase1, 1, 0);
		  griglia.add(lParola2, 0, 1);
		  griglia.add(tFrase2, 1, 1);
		  griglia.add(bControlla, 0, 2);
		  griglia.add(lParolaComposta, 0, 3,2,1);
		  
		  bControlla.setOnAction(e -> controlla());
	   }

	   public void controlla() {
		   String strParola1 = tFrase1.getText();
		   String strParola2 = tFrase2.getText();
		   char charParola1[]=strParola1.toCharArray();
		   char charParola2[]=strParola2.toCharArray();
		   char parolaComposta [] = new char [charParola1.length+charParola2.length];
		   
		   int iParola1=0;
		   int iParola2=0;
		   int contatore =0;
		   char cercata;
		   boolean cercaParola1=true;
		   boolean finito = false;
		   for (int iComposta=0;iComposta<parolaComposta.length;) {
			   if (cercaParola1=true) {
				   cercata = charParola1[iParola1];
				   if (cercata=='-' && iParola1<=charParola1.length) {
					   cercaParola1=false;
					   iParola2=0;
				   }else {
					   if (cercata=='-') {
						   iParola1++;
						   cercata = charParola1[iParola1];
					   }
				   }
			   }else {
				   cercata = charParola2[iParola2];
				   if (cercata=='-' && iParola2<=charParola2.length) {
					   break;
				   }else {
					   for (int i=0; i< charParola2.length;i++) {
						   if (cercata=='-') {
							   iParola2++;
							   cercata = charParola2[iParola2];
							   if (cercata=='-' && iParola2<=charParola2.length) {
								   break;
							   }
						   }
						   if (i == charParola2.length) {
							  finito = true;
							  break;
						   }
					   }
				   }
			   }
			   if (finito == true) {
				   break;
			   }
			   for (int i=iParola1;i<charParola1.length;i++) {
				   if (charParola1[i]==cercata) {
					   charParola1[i]='-';
					   contatore++;
				   }
			   }
			   for (int i=iParola2;i<charParola1.length;i++) {
				   if (charParola2[i]==cercata) {
					   charParola2[i]='-';
					   contatore++;
				   }
			   }
			   for (int i=0;i<contatore;i++) {
				   parolaComposta[iComposta]=cercata;
				   iComposta++;
			   }
			   iParola1++;
			   iParola2++;
			   contatore=0;
		   }
		   String frase = new String (parolaComposta);
		   lParolaComposta.setText(frase);
	   }
		   
	   public static void main(String[] args) {
		    launch(args);
		  }
	}