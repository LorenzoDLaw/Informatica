package it.edu.iisgubbio.animazioni;

import java.time.temporal.Temporal;
import java.util.Iterator;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Barra extends Application{   
	TextField tSimbolo = new TextField();
	TextField tTempo = new TextField();
	Button bStart = new Button("start");
	Label lBarra = new Label();
	int n=0;
	String strBarra="";
	
	  public void start(Stage primaryStage) throws Exception {
	    GridPane griglia = new GridPane();
	    griglia.setPadding(new Insets(5, 5, 5, 5));
		griglia.setHgap(15); 
		griglia.setVgap(15);
		
		Label lSimbolo = new Label("Silbolo");
		Label lTempo = new Label("millisecondi");
		
		griglia.add(lSimbolo,  0,  0);
	    griglia.add(lTempo, 0, 1);
	    griglia.add(tSimbolo,  1,  0);
		griglia.add(tTempo,  1,  1);
	    griglia.add(bStart,  2,  0, 1,2);
	    bStart.setMaxHeight(100);
	    griglia.add(lBarra, 0, 3, 3, 1); 
		
	    Scene scene = new Scene(griglia);
	    primaryStage.setTitle("Timer!"); 
	    primaryStage.setScene(scene);
	    primaryStage.show();
	    
	    
	      
	    bStart.setOnAction(e -> vai());
	    
	  }
	  public void vai() {
		  String strTempo = tTempo.getText();
		  int tempo = Integer.parseInt(strTempo);
		  
		  Timeline timeline = new Timeline(new KeyFrame(
			      Duration.millis(tempo), 
			      x -> barra()));
		  timeline.setCycleCount(timeline.INDEFINITE);
		  timeline.play(); 
		}
	
	  private void barra(){
		  String strSimbolo = tSimbolo.getText();
		  strBarra = strBarra + strSimbolo;
		  lBarra.setText(strBarra);				  
		  n++;
		  }
	    
	  public static void main(String args[]){
	    launch();
	  }
}