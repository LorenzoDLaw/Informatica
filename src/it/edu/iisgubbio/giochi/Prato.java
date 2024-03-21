package it.edu.iisgubbio.giochi;

import javafx.application.Application;
import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Prato extends Application{ 
	int prefColonna = 8;
	int prefRiga = 8;
	boolean bombe [][]= new boolean [prefColonna][prefRiga];
	int nBombe=20;
	Label lESito = new Label("ciao");
  public void start(Stage primaryStage) throws Exception {
    GridPane griglia = new GridPane(); 
    griglia.setPadding(new Insets(5, 5, 5, 5));
    griglia.setHgap(10); 
	griglia.setVgap(10);
	for (int iH=0; iH<prefColonna;iH++ ) {
		for(int iL =0 ; iL< prefRiga;iL++ ) {
			boolean bomba =false;
			bomba = Math.random()>0.6;
			Button bCasella = new Button("");
			bCasella.setId("ButtonTrue");
			if(bomba==true) {
				if (nBombe>0) {
					bombe[iH][iL]=true;
					bCasella.setId("Button");
					nBombe--;
				}
			}
			bCasella.setPrefSize(50, 30);
			bCasella.setOnAction(e -> BombaPresente(e));
			griglia.add(bCasella, iH,iL );
		}
	}
	griglia.add(lESito, 1, prefColonna+1);
    
    Scene scene = new Scene(griglia);
    primaryStage.setTitle("Campo Minato"); 
    primaryStage.setScene(scene);
    primaryStage.show();
    
    scene.getStylesheets().add("it/edu/iisgubbio/giochi/CampoMinato.css");
  }
    
  public void BombaPresente(Event e){
	  Button a =(Button) e.getSource();
	  int colonna = GridPane.getColumnIndex(a);
	  int riga = GridPane.getRowIndex(a);
	  int quantitàBombe=0;
	  if (bombe[colonna][riga]==true) {
		  a.setText("boom");
		  lESito.setText("hai perso");
	  } else {
		  if(colonna==prefColonna-1) {
			  if(riga==prefRiga-1) {
				  for (int iColonna =colonna-1; iColonna <= colonna; iColonna++) {
					  for (int iRiga =riga - 1; iRiga <= riga; iRiga++) {
						  if(bombe[iColonna][iRiga]==true) {
							  quantitàBombe++;
						  }
					  }
				  }
			  }
			  if(riga==0) {
				  for (int iColonna =colonna-1; iColonna <= colonna; iColonna++) {
					  for (int iRiga =riga; iRiga <= riga+1; iRiga++) {
						  if(bombe[iColonna][iRiga]==true) {
							  quantitàBombe++;
						  }
					  }
				  }
			  }
			  if(riga!=0&&riga!=prefRiga){
				  for (int iColonna =colonna-1; iColonna <= colonna; iColonna++) {
					  for (int iRiga =riga - 1; iRiga <= riga+1; iRiga++) {
						  if(bombe[iColonna][iRiga]==true) {
							  quantitàBombe++;
						  }
					  }
				  }
			  }
		  }
		  if(colonna==0) {
			  if(riga==prefRiga-1) {
				  for (int iColonna =colonna; iColonna <= colonna+1; iColonna++) {
					  for (int iRiga =riga - 1; iRiga <= riga; iRiga++) {
						  if(bombe[iColonna][iRiga]==true) {
							  quantitàBombe++;
						  }
					  }
				  }
			  }if(riga==0) {
				  for (int iColonna =colonna; iColonna <= colonna+1; iColonna++) {
					  for (int iRiga =riga; iRiga <= riga+1; iRiga++) {
						  if(bombe[iColonna][iRiga]==true) {
							  quantitàBombe++;
						  }
					  }
				  }
			  }
			  if(riga!=0&&riga!=prefRiga){
				  for (int iColonna =colonna; iColonna <= colonna+1; iColonna++) {
					  for (int iRiga =riga - 1; iRiga <= riga+1; iRiga++) {
						  if(bombe[iColonna][iRiga]==true) {
							  quantitàBombe++;
						  }
					  }
				  }
			  }
		  }
		  if(colonna!=prefColonna-1&&colonna!=0){
			  if(riga==prefRiga-1) {
				  for (int iColonna =colonna-1; iColonna <= colonna+1; iColonna++) {
					  for (int iRiga =riga - 1; iRiga <= riga; iRiga++) {
						  if(bombe[iColonna][iRiga]==true) {
							  quantitàBombe++;
						  }
					  }
				  }
			  }
			  if(riga==0) {
				  for (int iColonna =colonna-1; iColonna <= colonna+1; iColonna++) {
					  for (int iRiga =riga; iRiga <= riga+1; iRiga++) {
						  if(bombe[iColonna][iRiga]==true) {
							  quantitàBombe++;
						  }
					  }
				  }
			  }
			  if(riga!=0&&riga!=prefRiga) {
				  for (int iH =colonna-1; iH <= colonna+1; iH++) {
					  for (int iL =riga - 1; iL <= riga+1; iL++) {
						  if(bombe[iH][iL]==true) {
							  quantitàBombe++;
						  }
					  }
				  } 
			  }
			  
		  }
	       	a.setText("" + quantitàBombe);
	    }
  }
  public static void main(String args[]){
    launch();
  }
}
/*for (int iH =colonna-1; iH <= colonna+1; iH++) {
	  for (int iL =riga - 1; iL <= riga+1; iL++) {
		  if(bombe[iH][iL]==true) {
			  quantitàBombe++;
		  }
	  }
}*/
/*for (int iH = Math.max(0, colonna - 1); iH <= Math.min(larghezza - 1, colonna + 1); iH++) {
for (int iL = Math.max(0, riga - 1); iL <= Math.min(altezza - 1, riga + 1); iL++) {
    if (bombe[iH][iL]) {
        quantitàBombe++;
    }
}
}*/