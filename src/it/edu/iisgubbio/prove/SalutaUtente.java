package it.edu.iisgubbio.prove;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.control.TextField;


public class SalutaUtente extends Application {
	
	Label lMessaggio = new Label();
	TextField tNome = new TextField();
	Label lmettiNome = new Label();
	Button beseguiSaluto = new Button();
 

  public void start(Stage finestra) {
	  
	  
	  GridPane griglia = new GridPane();
	  
	  tNome.setPromptText("Nome o nomignolo per salutarti");
	  lmettiNome.setText("Nome:");
	  lMessaggio.setText("Sono impaziente...");
	  beseguiSaluto.setText("Premi qui");
	  
	  
	  griglia.add(lmettiNome, 0, 0);
	  griglia.add(tNome, 1, 0);
	  griglia.add(beseguiSaluto, 1, 1);
	  griglia.add(lMessaggio, 1, 2);	  	  
	  
	    
    Scene scena = new Scene(griglia, 300, 250);
    finestra.setTitle("SalutaUtente!");
    finestra.setScene(scena);
    finestra.show();
    
    beseguiSaluto.setOnAction(e -> esegui());
        
  }

  public void esegui(){
	  String utente;
	  utente = tNome.getText();
	  lMessaggio.setText("Signor " + utente + " Le auguro buona giornata!");
  }

  public static void main(String[] args) {
    launch(args);
  }
}