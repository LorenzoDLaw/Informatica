package it.edu.iisgubbio.testi;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Anagramma extends Application{
	TextField tParola1 = new TextField();
	TextField tParolaAnag = new TextField();
	Label lAnagramma = new Label("anagramma:");
	public void start(Stage finestra) {
		GridPane griglia = new GridPane();
		
		Label lParola1 = new Label("parola 1");
		Label lParolaAnagramma = new Label("parola 2");
		Button bTest = new Button("controlla Anagramma");
		
		griglia.add(lParola1,  0,  0);
		griglia.add(tParola1,  1,  0);
		griglia.add(lParolaAnagramma,  0,  1);
		griglia.add(tParolaAnag,  1,  1);
		griglia.add(bTest,  0,  2,2,1);
		bTest.setMaxWidth(1000);
		griglia.add(lAnagramma, 0, 3,2,1);
		lAnagramma.setMaxWidth(1000);
		
	    griglia.setPadding(new Insets(10, 10, 10, 10));
		griglia.setHgap(22); 
		griglia.setVgap(10);
	    
	    Scene scene = new Scene(griglia,280,300);
	    
	    finestra.setTitle("Somma"); 
		finestra.setScene(scene);
		finestra.show();
		
		bTest.setOnAction(e -> controllaAnagramma2());
	
	}
	public void controllaAnagramma() {
		String strParola = tParola1.getText();
		String strAnagramma = tParolaAnag.getText();
		char vetParola [] = strParola.toCharArray();
		char vetAnagramma [] = strAnagramma.toCharArray();
		//creo un vettore per ricostruire l'anagramma con il vettore vetParola
		char vetControllo[] = new char [vetAnagramma.length];
		if (vetAnagramma.length!=vetParola.length) {
			lAnagramma.setText("non è un anagramma");
		}else {
			for (int i = 0 ; i<vetAnagramma.length;i++) {
				for (int pos=0;pos<vetParola.length;pos++) {
					//se l'ho trovato scrivo nel vettore vetControllo la lettera
					//e assegno un valore numerico al vettore vetParola
					if(vetParola[pos]==vetAnagramma[i]) {
						vetControllo[i] = vetParola[pos];
						vetParola [pos] = '0';
						break;
					}
				}
			}
			String strControllo = new String(vetControllo);
			//se le due stringhe sono uguali è un anagramma
			if (strAnagramma.equals(strControllo)) {
				lAnagramma.setText("è un anagramma");
			}else {
				lAnagramma.setText("non è un anagramma");
			}
		}
	}
	
	public void controllaAnagramma2() {
		//creo due vettori di char uno per la paroloa 
		//e uno per l'anagramma
		String strParola = tParola1.getText();
		String strAnagramma = tParolaAnag.getText();
		char vetParola [] = strParola.toCharArray();
		char vetAnagramma [] = strAnagramma.toCharArray();
		// lo utuilizzo per vedere se ho trovato tutti gli elementi dell'anagramma nella frase
		int quantiNeHoBeccati=0;
		//se la lunghezza delle due vettori di char è diversa non è un anagramma
		if (vetAnagramma.length!=vetParola.length) {
			lAnagramma.setText("non è un anagramma");
		}else {
			//effettuo il ciclo per vedere se gli elementi vengono trovati, se sono tatnti 
			//quanti la lunghezza del vettore è unn anagramma
			for (int i =0 ; i<vetAnagramma.length;i++) {
				for (int pos=0;pos<vetParola.length;pos++) {
					if(vetParola[pos]==vetAnagramma[i]) {
						vetParola [pos] = '0';
						quantiNeHoBeccati++;
						break;
					}
				}
			}
			//l'if per controllare quantiNeHoBeccati, se sono come il length del vettore è un anagramma
			if (quantiNeHoBeccati==vetAnagramma.length) {
				lAnagramma.setText("è un anagramma");
			}else {
				lAnagramma.setText("non è un anagramma");
			}
		}
	}
			
	public static void main(String args[]){
		launch();
	}
}