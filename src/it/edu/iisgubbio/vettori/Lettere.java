package it.edu.iisgubbio.vettori;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Lettere extends Application{
	
	TextField tFrase = new TextField();
	Label lVocali = new Label("");
	Label lCensura = new Label();
	String nome[];

	public void start(Stage finestra){
		
		Button pConta = new Button("conta vocali");
		Button bCensura = new Button("censura");
		Label lFrase = new Label("Frase");
		Label lTxtVocali = new Label("Vocali");
		
		GridPane griglia = new GridPane();
		
		griglia.add(lFrase, 0, 0);
	    griglia.add(tFrase, 1, 0);
		griglia.add(pConta, 1, 1);
		griglia.add(lTxtVocali, 0, 2);
		griglia.add(lVocali,1, 2);
		griglia.add(bCensura, 0,3);
		griglia.add(lCensura, 1, 3);
	    griglia.setPadding(new Insets(5, 5, 5, 5));
	    griglia.setHgap(22); 
		griglia.setVgap(10);
	    Scene scene = new Scene(griglia,280,300);
	    
	    finestra.setTitle("Somma"); 
		finestra.setScene(scene);
		finestra.show();
		
		pConta.setOnAction(e -> contaVocali());
		bCensura.setOnAction(i-> censura());
	}
	public void contaVocali() {
		String StrNome = tFrase.getText().toLowerCase();
		char nome[]=StrNome.toCharArray();
		int contatoreA=0;
		int contatoreE=0;
		int contatoreI=0;
		int contatoreO=0;
		int contatoreU=0;
		
		for (int i=0; i<nome.length; i++) {
			 /*if (nome[i]=='a') {
				contatore++;
			}*/
			switch ( nome[i] ) {
			case 'a':
				contatoreA++;
				break;
			case 'e':
				contatoreE++;
				break;
			case 'i':
				contatoreI++;
				break;
			case 'o':
				contatoreO++;
				break;
			case 'u':
				contatoreU++;
				break;
			}
		}
		String vocali =new String (nome)+" le vocali sono: A "+contatoreA+" E "+contatoreE+" I "+contatoreI+" O "+contatoreO+" U "+contatoreU;
		lVocali.setText(vocali);
	}
	public void censura() {
		String StrNome = tFrase.getText().toLowerCase();
		char nome[]=StrNome.toCharArray();
		
		for (int i=0; i<nome.length; i++) {
			switch ( nome[i] ) {
			case 'a':
			case 'e':
			case 'i':
			case 'o':
			case 'u':
				nome[i]='-';
				break;
			}
		}
		String vocali =new String (nome);
		lCensura.setText(vocali);
	}
			
	public static void main(String args[]){
		launch();
	}
}