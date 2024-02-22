package it.edu.iisgubbio.vettori;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Palindromo extends Application{
	TextField tParola = new TextField();	
	Label lInverti = new Label("");
	int frase[];
	public void start(Stage finestra) {
		GridPane griglia = new GridPane();
		
		Button bInverti = new Button("palindromo?");
		
		griglia.add(tParola,  0,  0);
	    griglia.add(bInverti, 0, 1);
	    griglia.add(lInverti,  0,  2);	    
	    
	    griglia.setPadding(new Insets(10, 10, 10, 10));
		griglia.setHgap(22); 
		griglia.setVgap(10);
	    
	    Scene scene = new Scene(griglia,280,300);
	    
	    finestra.setTitle("Somma"); 
		finestra.setScene(scene);
		finestra.show();
		
		bInverti.setOnAction(e -> inverti());
	}
	public void inverti() {
		String StrNome = tParola.getText().toLowerCase();
		char nome[]=StrNome.toCharArray();
		boolean palindromo;
		int lunghezza= nome.length-1;
		if(nome.equals("")) {
			lInverti.setText("inserisci i numeri");
		}else {
			for(int i=0; i< lunghezza/2; i++) {
				if(nome[i]==nome[lunghezza-i]) {
					palindromo=false;
				}else {
					palindromo=true;
				}
		    }
		}
		if (palindromo=true) {
			lInverti.setText("sì");
		}else {
			lInverti.setText("no");
		}
	}
			
	public static void main(String args[]){
		launch();
	}
}