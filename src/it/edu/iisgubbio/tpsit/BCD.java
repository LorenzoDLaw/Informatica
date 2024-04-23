package it.edu.iisgubbio.tpsit;
import java.util.Hashtable;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
public class BCD extends Application{ 
	int riga = 3;
	int colonna = 3;
	char lettere [][]= new char [colonna][riga];
	TextField tNumero = new TextField();
	Label lNumDec = new Label("Numero Decimale");
	Label lBCD = new Label("risultato");
	Hashtable<Character,String> dict_decimale = new Hashtable<Character,String>();
	
	public void start(Stage primaryStage) throws Exception {

		dict_decimale.put('0',"0000");
		dict_decimale.put('1',"0001");
		dict_decimale.put('2',"0010");
		dict_decimale.put('3',"0011");
		dict_decimale.put('4',"0100");
		dict_decimale.put('5',"0101");
		dict_decimale.put('6',"0110");
		dict_decimale.put('7',"0111");
		dict_decimale.put('8',"1000");
		dict_decimale.put('9',"1001");
		
		GridPane griglia = new GridPane(); 
		griglia.setPadding(new Insets(5, 5, 5, 5));
		griglia.setHgap(10); 
		griglia.setVgap(10);	
		
		Button bCalcola = new Button("converti");


		griglia.add(lNumDec, 0, 0);
		griglia.add(tNumero, 1, 0);
		griglia.add(bCalcola, 0, 1,2,1);
		griglia.add(lBCD, 0,2);
		bCalcola.setMaxWidth(1000);

		Scene scene = new Scene(griglia);
		primaryStage.setTitle("gay"); 
		primaryStage.setScene(scene);
		primaryStage.show();
		//scene.getStylesheets().add("it/edu/iisgubbio/giochi/ParolaCSS.css");
		bCalcola.setOnAction(e -> comprimi());
	}
	public void comprimi(){
		String sBCD = "";
		
		char v[]= tNumero.getText().toCharArray();
		for(int i=0; i<v.length;i++) {
			sBCD+=dict_decimale.get(v[i]);
		}
		
		lBCD.setText(sBCD);
		
	}
	public static void main(String args[]){
		launch();
	}
}
