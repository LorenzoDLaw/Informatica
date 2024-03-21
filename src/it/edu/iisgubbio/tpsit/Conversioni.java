package it.edu.iisgubbio.tpsit;

import java.util.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Conversioni extends Application {
	TextField tBase = new TextField();
	TextField tNumero = new TextField();
	Label lNumConvertito = new Label("");
	Hashtable<Integer,String> my_dict = new Hashtable<Integer,String>();
	Hashtable<Character,Integer> dict_decimale = new Hashtable<Character,Integer>();
	   public void start(Stage primaryStage) {
		   my_dict.put(1,"1");
		   my_dict.put(2,"2");
		   my_dict.put(3,"3");
		   my_dict.put(4,"4");
		   my_dict.put(5,"5");
		   my_dict.put(6,"6");
		   my_dict.put(7,"7");
		   my_dict.put(8,"8");
		   my_dict.put(9,"9");
		   my_dict.put(10,"A");
		   my_dict.put(11,"B");
		   my_dict.put(12,"C");
		   my_dict.put(13,"D");
		   my_dict.put(14,"E");
		   my_dict.put(15,"F");

		   dict_decimale.put('0',0);
		   dict_decimale.put('1',1);
		   dict_decimale.put('2',2);
		   dict_decimale.put('3',3);
		   dict_decimale.put('4',4);
		   dict_decimale.put('5',5);
		   dict_decimale.put('6',6);
		   dict_decimale.put('7',7);
		   dict_decimale.put('8',8);
		   dict_decimale.put('9',9);
		   dict_decimale.put('A',10);
		   dict_decimale.put('B',11);
		   dict_decimale.put('C',12);
		   dict_decimale.put('D',13);
		   dict_decimale.put('E',14);
		   dict_decimale.put('F',15);		   
		   
		  GridPane griglia = new GridPane();
	      griglia.setPadding(new Insets(5, 5, 5, 5));
	      griglia.setHgap(15); 
	      griglia.setVgap(15);
	      Scene scena = new Scene(griglia, 400, 270);
	      primaryStage.setTitle("Bho!");
	      primaryStage.setScene(scena);
		  primaryStage.show();
		  
		  Label lConversioni = new Label("Conversioni");
		  Label lNum = new Label("inserisci il numero");
		  Label lBase = new Label("base");
		  Button bCalcola = new Button("calcola");
		  Button bDecimelae = new Button("Converti in decimale");
		  
		  griglia.add(lConversioni, 0, 0,2,1);
		  griglia.add(lNum, 0, 1);
		  griglia.add(tNumero, 1, 1);
		  griglia.add(lBase, 0, 2);
		  griglia.add(tBase, 1, 2);
		  griglia.add(lNumConvertito, 0, 3,2,1);
		  griglia.add(bCalcola, 0, 4);
		  griglia.add(bDecimelae, 1, 4);
		  
		  bCalcola.setOnAction(e -> controlla());

		  bDecimelae.setOnAction(e -> convertiInDecimale());
	   }

	   public void controlla() {
		   lNumConvertito.setText("");
		   String vetCodifica[]= new String [8];
		   int numero =Integer.parseInt(tNumero.getText());
		   int base = Integer.parseInt(tBase.getText());
		   for (int i = vetCodifica.length-1; i>=0;i-- ) {
			   int resto=numero%base;
			   if (resto==0) {
				   vetCodifica[i] ="0";
			   }else {
				   vetCodifica[i] = my_dict.get(resto);
			   }
			   numero=numero/base;
		   }
		   for (int i=0; i<vetCodifica.length;i++ ) {
			   lNumConvertito.setText(lNumConvertito.getText()+vetCodifica[i]);
		   }
		   		
	   }
	   
	   public void convertiInDecimale() {
		   lNumConvertito.setText("");
		   char vetCharNumeri[] = tNumero.getText().toCharArray();
		   int vetIntNumeri []= new int [vetCharNumeri.length];
		   for (int i=0;i<vetIntNumeri.length;i++) {
			   vetIntNumeri[i]=dict_decimale.get(vetCharNumeri[i]);
		   }
		   int base = Integer.parseInt(tBase.getText());
		   int numDecimale=0;
		   
		   for (int i=vetIntNumeri.length-1, pos=0;i>=0;i--,pos++) {
			   numDecimale += vetIntNumeri[pos]*Math.pow(base, i) ;
		   }
		   lNumConvertito.setText(""+numDecimale);
	   }
		   
	   public static void main(String[] args) {
		    launch(args);
		  }
	}