package it.edu.iisgubbio.tpsit;
import java.util.Hashtable;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
public class Controllo extends Application{ 
	TextField tMessaggio = new TextField();
	RadioButton bitParita = new RadioButton("Bit parità");
	RadioButton bitHamming = new RadioButton("hamming");
	RadioButton bitY = new RadioButton("bit x");
	Label lRisultato = new Label("messaggio:");
	Label lControllo = new Label("controllo: bit");
	Label lEsisteControllo = new Label("esiste controllo:");
	
	Hashtable<String,Integer> dizionario = new Hashtable<String,Integer>();
	
	public void start(Stage primaryStage) throws Exception {

		dizionario.put("0000",0);
		dizionario.put("0001",1);
		dizionario.put("0010",2);
		dizionario.put("0011",3);
		dizionario.put("0100",4);
		dizionario.put("0101",5);
		dizionario.put("0110",6);
		dizionario.put("0111",7);
		dizionario.put("1000",8);
		dizionario.put("1001",9);
		dizionario.put("1010",10);
		dizionario.put("1011",11);
		dizionario.put("1100",12);
		
		ToggleGroup controllo = new ToggleGroup();
		bitParita.setToggleGroup(controllo);
		bitHamming.setToggleGroup(controllo);
		bitY.setToggleGroup(controllo);
		Button bControllo = new Button("Controlla");
		GridPane griglia = new GridPane(); 
		griglia.setPadding(new Insets(5, 5, 5, 5));
		griglia.setHgap(10); 
		griglia.setVgap(10);	

		griglia.add(tMessaggio, 0, 0);
		griglia.add(bitParita, 0, 1);
		griglia.add(bitHamming, 0, 2);
		griglia.add(bitY, 0,3);
		griglia.add(lRisultato, 0, 4);
		griglia.add(lControllo, 0, 5);
		griglia.add(lEsisteControllo, 0, 6);
		griglia.add(bControllo, 1, 6);

		Scene scene = new Scene(griglia);
		primaryStage.setTitle("gay"); 
		primaryStage.setScene(scene);
		primaryStage.show();
		bControllo.setOnAction(e -> controllaByte());
	}
	public void controllaByte(){
		String messaggio = tMessaggio.getText();
		char vBitParita[]=messaggio.toCharArray();
		char vMessaggio[]= new char [vBitParita.length-1];
		int contaUno=0;
		boolean controlloRiuscito=false;
		int bitSignificativo;
		for (int i =0; i< vBitParita.length-1;i++) {
			vMessaggio[i]=vBitParita[i];
			if(vMessaggio[i]==1) {
				contaUno++;
			}
		}
		if(bitParita.isSelected()) {
			if(contaUno%2==0) {
				if(vBitParita[0]==0) {
					bitSignificativo=0;
					controlloRiuscito=false;
				}else {
					bitSignificativo=1;
					controlloRiuscito=true;
				}
			}else {
				if(vBitParita[0]==1) {
					bitSignificativo=1;
					controlloRiuscito=false;
				}else {
					bitSignificativo=0;
					controlloRiuscito=true;
				}
			}
			String messaString =new String( vMessaggio);
			lRisultato.setText(lRisultato.getText() + messaString);
			lControllo.setText(lControllo.getText()+ " "+bitSignificativo);
			if (controlloRiuscito==true) {
				lEsisteControllo.setText(lEsisteControllo.getText() + " riuscito");
			}else {
				lEsisteControllo.setText(lEsisteControllo.getText() + " non riuscito");
			}
		}	
		
		if (bitHamming.isSelected()) {
			
		}
	}
	public static void main(String args[]){
		launch();
	}
}
