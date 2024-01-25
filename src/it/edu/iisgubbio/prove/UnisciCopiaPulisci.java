package it.edu.iisgubbio.prove;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.control.TextField;

public class UnisciCopiaPulisci extends Application{
	
	TextField tCasualesx = new TextField();
	Button bUnisci = new Button();
	TextField tCasualedx = new TextField();
	Button bCopiasx = new Button();
	Label eUnisciText = new Label();
	Button bCopiadx = new Button();	
	Label eCopiasx = new Label();
	Button bPulisci = new Button();
	Label eCopiadx = new Label();
	
	
	public void start(Stage finestra) {
		
		GridPane griglia = new GridPane();
		
		
		
		bUnisci.setText("Unisci");
		bCopiasx.setText("Copia");
		bCopiadx.setText("Copia");
		bPulisci.setText("Pulisci");
		
		griglia.setPadding(new Insets(5, 5, 5, 5));
		griglia.setHgap(10); 
		griglia.setVgap(10);
		griglia.setAlignment(Pos.CENTER);
		griglia.add(tCasualesx, 0, 0);
		griglia.add(bUnisci, 1, 0);
		griglia.add(tCasualedx, 2, 0);
		griglia.add(bCopiasx, 0, 1);
		griglia.add(eUnisciText, 1, 1);
		griglia.add(bCopiadx, 2, 1);
		griglia.add(eCopiasx, 0, 2);
		griglia.add(bPulisci, 1, 2);
		griglia.add(eCopiadx, 2, 2);
		
		ColumnConstraints vincoliPrimaColonna = new ColumnConstraints();
		vincoliPrimaColonna.setHalignment(HPos.CENTER);
		
		ColumnConstraints vincoliSecondaColonna = new ColumnConstraints();
		vincoliSecondaColonna.setHalignment(HPos.CENTER);
		
		ColumnConstraints vincoliTerzaColonna = new ColumnConstraints();
		vincoliTerzaColonna.setHalignment(HPos.CENTER); 
		
		griglia.getColumnConstraints().addAll(vincoliPrimaColonna, vincoliSecondaColonna, vincoliTerzaColonna);
		
		
		
		Scene scena = new Scene(griglia);
	    finestra.setTitle("JoJo!");
	    finestra.setScene(scena);
	    finestra.show();
	    
	    bUnisci.setOnAction(e -> unisci());
	    bCopiasx.setOnAction(e -> copiaSx());
	    bCopiadx.setOnAction(e -> copiaDx());
	    bPulisci.setOnAction(e -> pulisci());
		
	}
	
	
	public void unisci(){
		  String utente;
		  utente = bUnisci.getText();
		  eUnisciText.setText(tCasualesx.getText() + tCasualedx.getText() );
	  }
	
	public void copiaSx(){
		  String utente;
		  utente = bCopiasx.getText();
		  eCopiasx.setText(tCasualesx.getText());
	  }
	
	public void copiaDx(){
		  String utente;
		  utente = bCopiadx.getText();
		  eCopiadx.setText(tCasualedx.getText());
	  } 
	
	public void pulisci(){
		  String utente;		 
		  tCasualesx.setText("");
          tCasualedx.setText("");
          eUnisciText.setText("");
          eCopiasx.setText("");
          eCopiadx.setText("");          
	  } 
	
	
	
	
	
	 public static void main(String[] args) {
		    launch(args);
		  }
	
}
