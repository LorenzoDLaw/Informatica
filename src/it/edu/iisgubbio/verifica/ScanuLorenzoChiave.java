package it.edu.iisgubbio.verifica;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ScanuLorenzoChiave extends Application {
	TextField tPassword = new TextField();
	Label lCorretta = new Label();
	   
	   @Override
	   public void start(Stage primaryStage) {
		   
		  Label lPassword = new Label("password");
		  Button bControlla = new Button("controlla");
		  
	      GridPane griglia = new GridPane();
	      griglia.setPadding(new Insets(5, 5, 5, 5));
	      griglia.setHgap(15); 
	      griglia.setVgap(15);
	      Scene scena = new Scene(griglia);
	      primaryStage.setTitle("Verifica");
	      primaryStage.setScene(scena);
		  primaryStage.show();

		  griglia.add(lPassword, 0, 0);
		  griglia.add(tPassword, 1, 0);
		  griglia.add(bControlla, 0, 1);
		  griglia.add(lCorretta, 0, 2,2,1);
		  
		  bControlla.setOnAction(e -> controlla());
	   }

	   public void controlla() {
		   String strPassword = tPassword.getText();
		   char password[]=strPassword.toCharArray();
		   boolean maiuscola = false ;
		   boolean minuscola = false;
		   boolean numero = false;
		   boolean charSpecial = false;
		   if (password.length>=8) {
			   for (int i =0; i < password.length;i++) {
				   if (password[i]>='a' && password[i]<='z') {
					   minuscola=true;
				   }
				   if (password[i]>='A' && password[i]<='Z') {
					   maiuscola = true;
				   }
				   if (password[i]>='0' && password[i]<='9') {
					   numero = true;
				   }
				   switch ( password[i] ) {
					case '#':
					case '@':
					case '!':
					case '?':
					case '/':
					case '-':
					case '+':
					case '.':
						charSpecial=true;
						break;
					}
			   }
		   }else {
			   lCorretta.setText("password non valida");
		   }
		   if (maiuscola==true && minuscola==true && numero == true && charSpecial==true) {
			   lCorretta.setText("password valida");
		   }
	   }
		   
	   public static void main(String[] args) {
		    launch(args);
		  }
	}