package it.edu.iisgubbio.vettori;

import java.awt.ContainerOrderFocusTraversalPolicy;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class mescola_inverti_Buono extends Application{
	TextField tNumeri = new TextField();	
	Label lInverti = new Label("");
	Label lMescola = new Label("");
	Label lDuplicati = new Label("");
	int numeri[];
	public void start(Stage finestra) {
		GridPane griglia = new GridPane();
		
		Button bInverti = new Button("inverti");
		Button bMescola = new Button("mescola");
		Button bDuplicati = new Button("duplicati");
		
		griglia.add(tNumeri,  0,  0);
	    griglia.add(bInverti, 0, 1);
	    griglia.add(lInverti,  0,  2);
	    griglia.add(bMescola,  0,  3);
	    griglia.add(lMescola,  0,  4);
	    griglia.add(bDuplicati, 0, 5);
	    griglia.add(lDuplicati, 0, 6);
	    
	    griglia.setPadding(new Insets(10, 10, 10, 10));
		griglia.setHgap(22); 
		griglia.setVgap(10);
	    
	    Scene scene = new Scene(griglia,280,300);
	    
	    finestra.setTitle("Somma"); 
		finestra.setScene(scene);
		finestra.show();
		
		bInverti.setOnAction(e -> inverti());
		bMescola.setOnAction(e -> mescola());
		bDuplicati.setOnAction(e-> cancellaDuplicati());
	}
	public void inverti() {
		String numeriTxt = tNumeri.getText();
		int dep=0;
		if(numeriTxt.equals("")) {
			lInverti.setText("inserisci i numeri");
		}else {
			String parti [] =numeriTxt.split(" ");
			numeri = new int [parti.length];
			for(int indice = 0; indice < parti.length; indice++) {
				numeri[indice] = Integer.parseInt(parti[indice]);
		    }
			for(int i=0; i< numeri.length/2; i++) {
				dep=numeri[i];
				numeri[i]=numeri[numeri.length-1-i];
				numeri[numeri.length-1-i]=dep;
		    }
			for(int i=0; i< numeri.length; i++) {
				lInverti.setText(lInverti.getText()+" "+numeri[i]);
		    }
		}
	}
		
	public void mescola() {
		lMescola.setText("");
		String numeriTxt = tNumeri.getText();
		String parti[];
		parti =numeriTxt.split(" ");
		numeri = new int [parti.length];
		int posMescola;
		
		for(int indice = 0; indice < parti.length; indice++) {
			numeri[indice] = Integer.parseInt(parti[indice]);
		   }
		
		for(int pos=0; pos<numeri.length; pos++) {
			posMescola = (int) ((Math.random()*numeri.length));
			int memo = numeri[pos];
			numeri[pos]=numeri[posMescola];
			numeri[posMescola]=memo;
		}
		
		for(int i=0;i<numeri.length;i++) {
			lMescola.setText(lMescola.getText()+" "+numeri[i]);
		}
	}
	
	public void cancellaDuplicati(){
		String numeriTxt = tNumeri.getText();
		String parti[];
		parti =numeriTxt.split(" ");
		numeri = new int [parti.length];
		for(int indice = 0; indice < parti.length; indice++) {
			numeri[indice] = Integer.parseInt(parti[indice]);
		   }
		// 1 58 1 81 98 48 48 8 5 963 7 28 2 89 1 8 5 84 6 9 7 8 ->1 58 81 98 48 8 5 963 7 28 2 89 84 6 9
		int contatore =0;
		int nv=-1;
		for(int pos=0; pos<numeri.length; pos++) {
			boolean ripetuti=false;
			for (int i = pos+1;i<numeri.length;i++) {
				if (numeri[pos]==numeri[i]){
					ripetuti=true;
					contatore++;
				}
			}
		}
		//1 2 3 3 5 7 2
		int numeriDup[]=new int [numeri.length-contatore];
		int contatoreDup=0;
		boolean ripetuti;
		for (int pos=0; pos<numeri.length;pos++) {
			ripetuti=false;
			for(int posCont=pos+1; posCont<numeri.length; posCont++) {
				if (numeri[pos]==numeri[posCont]){
					ripetuti=true;
				}
			}
			if(ripetuti==false) {
				numeriDup[contatoreDup]=numeri[pos];
				contatoreDup++;
			}
			
		}
		
		for(int i=0;i<numeriDup.length;i++) {
				lDuplicati.setText(lDuplicati.getText()+" "+numeriDup[i]);
			}
		lDuplicati.setText(lDuplicati.getText()+". I numeri doppi sono "+ contatore);
	}
		
			
	public static void main(String args[]){
		launch();
	}
}