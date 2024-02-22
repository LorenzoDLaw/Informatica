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
	Label lNumBin = new Label("");
	Hashtable<Integer,String> my_dict = new Hashtable<Integer,String>();
	
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
		  
		  griglia.add(lConversioni, 0, 0,2,1);
		  griglia.add(lNum, 0, 1);
		  griglia.add(tNumero, 1, 1);
		  griglia.add(lBase, 0, 2);
		  griglia.add(tBase, 1, 2);
		  griglia.add(lNumBin, 0, 3,2,1);
		  griglia.add(bCalcola, 0, 4,2,1);
		  
		  bCalcola.setOnAction(e -> controlla());
	   }

	   public void controlla() {
		   lNumBin.setText("");
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
			   lNumBin.setText(lNumBin.getText()+vetCodifica[i]);
		   }
		   		
	   }
		   
	   public static void main(String[] args) {
		    launch(args);
		  }
	}