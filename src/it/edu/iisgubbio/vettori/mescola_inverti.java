package it.edu.iisgubbio.vettori;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class mescola_inverti extends Application{
	TextField tNumeri = new TextField();	
	Label lInverti = new Label("");
	Label lMescola = new Label("");
	String parti[];
	int numeri[];
	public void start(Stage finestra) {
		GridPane griglia = new GridPane();
		
		Button bInverti = new Button("inverti");
		Button bMescola = new Button("mescola");
		
		griglia.add(tNumeri,  0,  0);
	    griglia.add(bInverti, 0, 1);
	    griglia.add(lInverti,  0,  2);
	    griglia.add(bMescola,  0,  3);
	    griglia.add(lMescola,  0,  4);
	    
	    
	    griglia.setPadding(new Insets(10, 10, 10, 10));
		griglia.setHgap(22); 
		griglia.setVgap(10);
	    
	    Scene scene = new Scene(griglia,280,300);
	    
	    finestra.setTitle("Somma"); 
		finestra.setScene(scene);
		finestra.show();
		
		bInverti.setOnAction(e -> inverti());
		bMescola.setOnAction(e -> mescola());
	}
	public void inverti() {
		String numeriTxt = tNumeri.getText();
		int dep=0;
		if(numeriTxt.equals("")) {
			lInverti.setText("inserisci i numeri");
		}else {
			parti =numeriTxt.split(" ");
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
		
	public void mescola(int[] vettore) {

		/*lMescola.setText("");
		String numeriTxt = tNumeri.getText();
		int vettoreCasuale [];
		if(numeriTxt.equals("")) {
			lInverti.setText("inserisci i numeri");
		}else {
			parti =numeriTxt.split(" ");
			numeri = new int [parti.length];
			vettoreCasuale = new int [parti.length];
			int posMescola;
			for(int indice = 0; indice < parti.length; indice++) {
				numeri[indice] = Integer.parseInt(parti[indice]);
		    }
			for(int pos=0; pos<numeri.length; pos++) {
				posMescola = (int) ((Math.random()*numeri.length));
				if(vettoreCasuale[posMescola]==0){
					posMescola = (int) ((Math.random()*numeri.length));
					vettoreCasuale[posMescola]=numeri[pos];	
				}
				vettoreCasuale[posMescola]=numeri[pos];	
			}
			for(int i=0;i<numeri.length;i++) {
				lMescola.setText(lMescola.getText()+" "+vettoreCasuale[i]);
			}
		}*/
	}
			
	public static void main(String args[]){
		launch();
	}
}