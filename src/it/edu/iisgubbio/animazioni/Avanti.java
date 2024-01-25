package it.edu.iisgubbio.animazioni;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Avanti extends Application{   
	Button bStart = new Button("start");
	int n=0;
	Timeline timeline = new Timeline(new KeyFrame(
		      Duration.seconds(0.50), // ogni quanto va chiamata la funzione
		      x -> aggiornaTimer()));
	Pane pPallino = new Pane();
	Circle cerchio = new Circle(7);
  public void start(Stage primaryStage) throws Exception {
    GridPane griglia = new GridPane();
    griglia.setPadding(new Insets(5, 5, 5, 5));
	griglia.setHgap(15); 
	griglia.setVgap(15);
	
    griglia.add(bStart,  0,  0);
    griglia.add(pPallino, 0, 1, 1, 2);
    pPallino.setPrefSize(300, 100);
    
	cerchio.setFill(Color.CORAL);
	pPallino.getChildren().add(cerchio);
	cerchio.setCenterX(10);
	cerchio.setCenterY(10);
    
	
    Scene scene = new Scene(griglia);
    primaryStage.setTitle("Timer!"); 
    primaryStage.setScene(scene);
    primaryStage.show();
    
    timeline.setCycleCount(timeline.INDEFINITE);
      
    bStart.setOnAction(e -> start());
    
  }
  public void start() {
	  timeline.play();
	}

  private void aggiornaTimer(){
	n+=5;
	cerchio.setCenterX(n);

  }
    
  public static void main(String args[]){
    launch();
  }
}