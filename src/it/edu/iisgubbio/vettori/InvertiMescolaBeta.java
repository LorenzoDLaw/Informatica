package it.edu.iisgubbio.vettori;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class InvertiMescolaBeta extends Application{
	TextField tNumeri = new TextField();
	TextField tTrova = new TextField();
	Button pInverti = new Button("inverti");
	Button pMescola = new Button("mescola");
	Button pDuplicati = new Button("duplicati");
	Button pNuovoVettore = new Button("nuovo vettore");
	Label eInvertito = new Label("");
	Label eMescolato = new Label("");
	Label eCoppie = new Label("");
	Label eNuovoVettore = new Label("");
	public void start(Stage finestra) {
		GridPane griglia = new GridPane();
		griglia.add(tNumeri,  0,  0, 2, 1);
		griglia.add(pInverti,  0,  1);
		griglia.add(pMescola, 1, 1);
		griglia.add(pDuplicati, 2, 1);
		griglia.add(eInvertito,  0,  2, 2, 1);
		griglia.add(eMescolato,  0,  3, 2, 1);
		griglia.add(eCoppie,  0,  4, 2, 1);
		
		griglia.setPadding(new Insets(10, 10, 10, 10));
		griglia.setHgap(22); 
		griglia.setVgap(10);

		Scene scene = new Scene(griglia,260,200);

		finestra.setTitle("Somma"); 
		finestra.setScene(scene);
		finestra.show();

		pInverti.setOnAction(e -> inverti());
		pMescola.setOnAction(e -> mescola());
		pDuplicati.setOnAction(e -> cercaDuplicati());
		
	}
	
	int[] testoVettore(String testo) {
		
		String parti[]=testo.split(" ");
		int n[]= new int[parti.length];
		for(int indice=0; indice < n.length; indice++) {
			n[indice] = Integer.parseInt(parti[indice]);
		}
		return n;
	}
	
	String daVettoreATesto(int[] numeriDaStampare) {
		String testoDaStampare="";
		for(int indice = 0; indice < numeriDaStampare.length; indice++) {
			testoDaStampare=testoDaStampare+" "+numeriDaStampare[indice];
		}
		return testoDaStampare;
	}
	
	public void inverti() {
		int numeri[];
		int i=0;
		int scambiatore=0;
		String t = tNumeri.getText();
		if(t.equals("")) {
			eInvertito.setText("inserisci i numeri");
		}else {
			numeri=testoVettore(t);

			for(i=0; i<(numeri.length)/2; i++) {
				scambiatore=numeri[i];
				numeri[i]=numeri[numeri.length-1-i];
				numeri[numeri.length-1-i]=scambiatore;

			}
			
			eInvertito.setText(daVettoreATesto(numeri));
		}
	}
	public void mescola() {
		int numeri[];
		int indice;
		int numeroRandom=0;
		int lunghezza=0;
		int a=0;
		String vettoreStampato="";
		String t = tNumeri.getText();
		if(t.equals("")) {
			eInvertito.setText("inserisci i numeri");
		}else {
			numeri=testoVettore(tNumeri.getText());
			lunghezza=numeri.length;
			indice=0;
			for(int indice2 = 0; indice2 < numeri.length; indice2++) {
				numeroRandom=(int)(Math.random()*lunghezza);
				a=numeri[indice2];
				numeri[indice2]=numeri[numeroRandom];
				numeri[numeroRandom]=a;
			}
			for(indice = 0; indice < numeri.length; indice++) {
				vettoreStampato+=" "+numeri[indice];
			}

			eMescolato.setText(vettoreStampato);
		}
	}
	public void cercaDuplicati() {
		int numeri[];
		int duplicati;
		int contaCoppie=0;
		String t = tNumeri.getText();
		if(t.equals("")) {
			eInvertito.setText("inserisci i numeri");
		}else {
			numeri=testoVettore(tNumeri.getText());
			for(int indice1 = 0; indice1 < numeri.length; indice1++) {
				duplicati=0;
				for(int indice2 = indice1+1; indice2 < numeri.length; indice2++) {
					if(numeri[indice1]==numeri[indice2]) {
						duplicati++;
					}
				}
				if(duplicati>=1) {
					contaCoppie++;
				}
			}

			eCoppie.setText(""+contaCoppie);
		}
	}
	
	public static void main(String args[]){
		launch();
	}
}