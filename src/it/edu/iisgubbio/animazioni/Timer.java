package it.edu.iisgubbio.animazioni;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Timer extends Application{   
	Button bStart = new Button("start");
	Button bPausa = new Button("pausa");
	Label testo;
	int n=1000;
	Timeline timeline = new Timeline(new KeyFrame(
		      Duration.seconds(0.16), // ogni quanto va chiamata la funzione
		      x -> aggiornaTimer()));

  public void start(Stage primaryStage) throws Exception {
    testo = new Label("finestra timer");
    GridPane griglia = new GridPane();
    griglia.setId("grid-spazio");
    griglia.add(bStart,  0,  0);
    griglia.add(bPausa,  1,  0);
    griglia.add(testo,  0,  1,2,1);
    
	
    Scene scene = new Scene(griglia);
    scene.getStylesheets().add("it/edu/iisgubbio/animazioni/timer.css"); 
    primaryStage.setTitle("Timer!"); 
    primaryStage.setScene(scene);
    primaryStage.show();
    
    timeline.setCycleCount(timeline.INDEFINITE);
      
    bStart.setOnAction(e -> start());;
    bPausa.setOnAction(e -> pausa());;
  }
  public void start() {
	  timeline.play();
	}
  public void pausa() {
	  timeline.stop();
	}
  private void aggiornaTimer(){
    testo.setText(""+ (n--));
  }
    
  public static void main(String args[]){
    launch();
  }
}