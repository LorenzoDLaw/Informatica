package it.edu.iisgubbio.giochi;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class IndovinaParola extends Application{


	TextField tNome = new TextField();
	TextField tLettera = new TextField();
	String memo= new String();
	Label tentativi = new Label();
	int contatore=0;
	public void start(Stage finestra) {

		Label lNome = new Label("nome:");
		Label lLettera = new Label("lettera");
		Button bVia = new Button("via");
		Button bProva = new Button ("prova");
		Label ltxtTentativo = new Label("hai fatto");

		GridPane griglia = new GridPane();

		griglia.add(lNome, 0, 0);
		griglia.add(tNome, 1, 0);
		griglia.add(bVia, 2, 0);
		griglia.add(lLettera, 0, 1);
		griglia.add(tLettera, 1, 1);
		griglia.add(bProva, 2, 1);
		griglia.add(ltxtTentativo, 0, 2);
		griglia.add(tentativi, 1, 2);

		griglia.setPadding(new Insets(5, 5, 5, 5));
		griglia.setHgap(15); 
		griglia.setVgap(15);

		Scene scena = new Scene(griglia);
		finestra.setTitle("Indovina!");
		finestra.setScene(scena);
		finestra.show();

		bProva.setOnAction(e -> indovina()); 
		bVia.setOnAction(e -> censura()); 
	}

	public void censura() {
		memo = tNome.getText();
		String parola= tNome.getText().toLowerCase();
		char lettera[]= parola.toCharArray();
		for (int i=1 ;i<lettera.length-1;i++) {
			lettera[i]='-';
		}
		String frase=new String("");
		for(int inserici =0; inserici<lettera.length; inserici++) {	
			frase=frase+""+lettera[inserici];
		}
		tNome.setText(frase);
	}

	public void indovina() {
		String parola= memo;
		char vetLettera[]= parola.toCharArray();
		String parolaCensurata = tNome.getText().toLowerCase(); 
		char fCensurata[]= parolaCensurata.toCharArray();
		//mi servono per controllare e poi modificare i vettori
		char lettera = tLettera.getText().charAt(0);

		boolean trovato = false;
		for (int i=1 ;i<vetLettera.length-1;i++) {
			if (vetLettera[i]==lettera){
				trovato=true;
				fCensurata[i]=lettera;
			}else {
				trovato=false;
			}
		}
		if (trovato!=true) {
			contatore++;
			tentativi.setText(""+contatore);
			trovato=true;
		}
		if(parola.equals(tLettera.getText())) {
			tLettera.setText("hai indovinato");;

		}
		String frase=new String("");
		for(int inserici =0; inserici<vetLettera.length; inserici++) {	
			frase=frase+""+fCensurata[inserici];
		}
		tNome.setText(frase);
		tLettera.clear();
	}


	public static void main(String[] args) {
		launch(args);
	}

}