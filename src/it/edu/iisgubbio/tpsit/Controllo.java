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
	RadioButton bitX = new RadioButton("bit x");
	RadioButton bitY = new RadioButton("bit x");
	Label lRisultato = new Label("messaggio:");
	Label lControllo = new Label("controllo: bit");
	Label lEsisteControllo = new Label("esiste controllo:");
	public void start(Stage primaryStage) throws Exception {

		ToggleGroup controllo = new ToggleGroup();
		bitParita.setToggleGroup(controllo);
		bitX.setToggleGroup(controllo);
		bitY.setToggleGroup(controllo);
		Button bControllo = new Button("Controlla");
		GridPane griglia = new GridPane(); 
		griglia.setPadding(new Insets(5, 5, 5, 5));
		griglia.setHgap(10); 
		griglia.setVgap(10);	
		
		

		griglia.add(tMessaggio, 0, 0);
		griglia.add(bitParita, 0, 1);
		griglia.add(bitX, 0, 2);
		griglia.add(bitY, 0,3);
		griglia.add(lRisultato, 0, 4);
		griglia.add(lControllo, 0, 5);
		griglia.add(lEsisteControllo, 0, 6);
		griglia.add(bControllo, 1, 6);

		Scene scene = new Scene(griglia);
		primaryStage.setTitle("gay"); 
		primaryStage.setScene(scene);
		primaryStage.show();
		//scene.getStylesheets().add("it/edu/iisgubbio/giochi/ParolaCSS.css");
		bControllo.setOnAction(e -> controllaByte());
	}
	public void controllaByte(){
		String messaggio = tMessaggio.getText();
		char vBitParita[]=messaggio.toCharArray();
		char vMessaggio[]= new char [vBitParita.length];
		int contaUno=0;
		boolean controlloRiuscito=false;
		int bitSignificativo;
		for (int i =0; i<vBitParita.length-1;i++) {
			vMessaggio[i]=vBitParita[i];
			if(vMessaggio[i]==1) {
				contaUno++;
			}
		}
		if(bitParita.isSelected()) {
			if(contaUno%2==0) {
				if(vBitParita[vBitParita.length-1]==0) {
					System.out.println(vBitParita[vBitParita.length-1]);
					bitSignificativo=0;
					controlloRiuscito=true;
				}else {
					bitSignificativo=1;
					controlloRiuscito=false;
				}
			}else {
				if(vBitParita[vBitParita.length-1]==1) {
					bitSignificativo=1;
					controlloRiuscito=true;
				}else {
					bitSignificativo=0;
					controlloRiuscito=false;
				}
			}
			String messaString =new String( vMessaggio);
			System.out.println(messaString);
			lRisultato.setText(lRisultato.getText() + messaString);
			lControllo.setText(lControllo.getText()+ " "+bitSignificativo);
			if (controlloRiuscito==true) {
				lEsisteControllo.setText(lEsisteControllo.getText() + " riuscito");
			}else {
				lEsisteControllo.setText(lEsisteControllo.getText() + " non riuscito");
			}
		}
		
			
	}
	public static void main(String args[]){
		launch();
	}
}
