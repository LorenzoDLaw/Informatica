package it.edu.iisgubbio.vettori;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TrovaNumeriOrdinati extends Application{


	Label eRipetuti=new Label();
	Label eRisultato=new Label();
	TextField cNumeri=new TextField();
	TextField cTrovare=new TextField();
	public void start(Stage finestra) {
		GridPane griglia=new GridPane();
		Button bTrovare=new Button("Trova");
		griglia.add(eRisultato, 0,2 );
		griglia.add(cNumeri, 0, 0,2,1);
		griglia.add(cTrovare, 0, 1);
		griglia.add(bTrovare, 1, 1);
		cNumeri.setMinWidth(100);
		bTrovare.setOnAction(e->ricerca());
		Scene scena =new Scene(griglia,200,200);
		finestra.setTitle("somma su stringa");
		finestra.setScene(scena);
		finestra.show();
	}

	public void ricerca() {
		int cercare=Integer.parseInt(cTrovare.getText());
		boolean trovato=false;
		String t=cNumeri.getText();
		String parti[]=t.split(" ");
		int numeri[]=new int[parti.length];
		for(int i=0;i<parti.length;i++) {
			numeri[i]=Integer.parseInt(parti[i]);
		}
		int inizio=0;
		int fine=numeri.length-1;
		int metà;
		while(inizio<=fine && !trovato){
			metà=(fine+inizio)/2;
			if(numeri[metà]==cercare) {
				trovato=true;
			}else{
				if(numeri[metà]<cercare){
					inizio=metà+1;
				}else {
					fine=metà-1;
				}
			}
		}
		if(trovato) {
			eRisultato.setText("Trovato");
		}else {
			eRisultato.setText("non Trovato");
		}
		

	}


	public static void main(String[] args) {

		launch(args);
	}
}