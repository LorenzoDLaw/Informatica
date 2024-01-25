package it.edu.iisgubbio.vettori;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Introduzione extends Application {
	   TextField tNumTempi = new TextField();
	   TextField tTempo = new TextField();
	   TextField tCoach = new TextField();
	   Label lRisultati = new Label("Risultati negativi");
	   Label lElencoRis = new Label("");
	   int tempi[];
	   int numTempi;
	   int pos;
	   
	   @Override
	   public void start(Stage primaryStage) {
	      GridPane griglia = new GridPane();
	      griglia.setPadding(new Insets(5, 5, 5, 5));
	      griglia.setHgap(15); 
	      griglia.setVgap(15);
	      Scene scena = new Scene(griglia, 400, 270);
	      primaryStage.setTitle("Bho!");
	      primaryStage.setScene(scena);
		  primaryStage.show();
		  
		  Label lNumTempi = new Label("Numero tempi");
		  Label lTempo = new Label("Inserisci Tempo");
		  Label lCoach = new Label("tempo del coach");
		  Button bCaricaTempo = new Button("Inserisci tampo");
		  Button bRisultati = new Button("Risultati Negativi");
		  Button bElencoTempi = new Button("Stampa risultati");
		  
		  griglia.add(tNumTempi, 1, 0);
		  griglia.add(lNumTempi, 0, 0);
		  griglia.add(lTempo, 0, 1);
		  griglia.add(tTempo, 1, 1);
		  griglia.add(bCaricaTempo, 0, 2,2,1);
		  bCaricaTempo.setMaxWidth(1000);
		  griglia.add(lCoach, 0, 3);
		  griglia.add(tCoach, 1, 3);
		  griglia.add(bRisultati, 0, 4);
		  bRisultati.setMaxWidth(800);
		  griglia.add(bElencoTempi, 1, 4);
		  bElencoTempi.setMaxWidth(1000);
		  griglia.add(lRisultati, 0, 5,2,1);
		  griglia.add(lElencoRis, 0, 6,2,1);
		  
		  
		  tNumTempi.setOnAction(e -> alloca());
		  bCaricaTempo.setOnAction(e -> inserisciTempo());
		  bRisultati.setOnAction(e -> contaPessimi());
		  bElencoTempi.setOnAction(e -> elencaTempi());
		  
	   }

	   public void alloca() {
	      numTempi = Integer.parseInt(tNumTempi.getText());
	      tempi = new int[numTempi];
	      System.out.print(numTempi);
	   }
	   public void inserisciTempo() {
		      if(pos < numTempi) {
		         tempi[pos++]=Integer.parseInt(tTempo.getText());
		         System.out.print(tTempo);
		         tTempo.setText("");   /* Così si pulisce la casella di testo rendendola pronta per il prossimo tempo */
		      }else {
		    	  //tTempo.setVisible(false);
		      }
		      System.out.print(tempi);
		   }
	   public void contaPessimi() {
		      int indice, contatore;
		      int coach = Integer.parseInt(tCoach.getText());
		      System.out.print(coach);
		      for(contatore = indice = 0; indice < tempi.length; indice++) {
		         if(tempi[indice] > coach) {
		            contatore++;
		         }
		      }
		      lRisultati.setText("Risultati negativi " + contatore);
		   }
	   public void elencaTempi() {
		   String elenco="";
		   for(int i=0;i<tempi.length;i++) {
			   if(elenco.equals("")) {
				   elenco +=(" "+tempi[i]);
			   }else {
				   elenco +=(","+tempi[i]);
			   }
		      }
		   lElencoRis.setText(" tempi sono:"+elenco);
	   }
	   public static void main(String[] args) {
		    launch(args);
		  }
	}