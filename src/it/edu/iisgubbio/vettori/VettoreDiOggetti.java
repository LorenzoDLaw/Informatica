package it.edu.iisgubbio.vettori;

import it.edu.iisgubbio.prove.Stile;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class VettoreDiOggetti extends Application{
	TextField vetText []= new TextField[10];
	TextField tInserisci = new TextField();
	int nField=10;
	public void start(Stage finestra) {

		Button bInsericiButton = new Button("Inserici");
		Button bElimina = new Button("elimina");
		GridPane griglia = new GridPane();
		int posX=0;
		int posY=0;
		for (int i =0; i<nField;i++){
			vetText[i]= new TextField(""+i);
			griglia.add(vetText[i], posX, posY,2,1);
			posY++;
		}
		griglia.add(bInsericiButton, posX, posY+1);
		griglia.add(bElimina, posX+1, posY+1);
		griglia.add(tInserisci, posX, posY+2,2,1);

		griglia.setPadding(new Insets(5, 5, 5, 5));
		griglia.setHgap(15); 
		griglia.setVgap(15);

		Scene scena = new Scene(griglia);
		finestra.setTitle("Indovina!");
		finestra.setScene(scena);
		finestra.show();

		bInsericiButton.setOnAction(e -> inserisci()); 
		bElimina.setOnAction(b -> elimina()); 
	}
	public void inserisci() {
		String numero = tInserisci.getText(); 
		for (int i=0;i<=10-1;i++) {
			if (i==9) {
				vetText[i].setText(numero);
			}else {
				String memo= vetText[i+1].getText();
				vetText[i].setText(memo);
			}
		}
	}
	
	public void elimina() { 
		//String numero = tInserisci.getText(); 
		String memo="";
		for (int i=9;i>0;i--) {
			if (i==0) {
				memo=vetText[i].getText();
				vetText[i].setText("");
			}else {
				String memo2=vetText[i-1].getText();
				vetText[i].setText(memo2);
			}
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}