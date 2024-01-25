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

public class Rimbalza extends Application{   
	int n=0;
	Timeline timeline = new Timeline(new KeyFrame(
		      Duration.seconds(0.016), // ogni quanto va chiamata la funzione
		      x -> aggiornaTimer()));
	Pane pPallino = new Pane();
	Circle cerchio = new Circle(10);
	int posX=0;
	int posY=200;
	boolean avanti=true;
	boolean sali=true;
  public void start(Stage primaryStage) throws Exception {
    GridPane griglia = new GridPane();
    
    griglia.setPadding(new Insets(5, 5, 5, 5));
	griglia.setHgap(15); 
	griglia.setVgap(15);
	
    griglia.add(pPallino, 0, 1, 1, 2);
    pPallino.setPrefSize(400, 300);
    
    Scene scene = new Scene(griglia);
    primaryStage.setTitle("Timer!"); 
    primaryStage.setScene(scene);
    primaryStage.show();
    
	cerchio.setFill(Color.CORAL);
	pPallino.getChildren().add(cerchio);
	cerchio.setCenterX(posX);
	cerchio.setCenterY(posY);
    
    timeline.setCycleCount(timeline.INDEFINITE);
    timeline.play();   
  }

  private void aggiornaTimer(){
	  if (avanti==true) {
		  posX++;
		  cerchio.setCenterX(posX);;
		  if (posX>=395) {
			  avanti=false;
		  }
	  }else{
		  posX--;
		  cerchio.setCenterX(posX);;
		  if (posX<=10) {
			  avanti=true;
		  }
	  }
	  if(sali==true){
		  posY--;
		  cerchio.setCenterY(posY);;
		  if (posY<=5) {
			  sali=false;
		  }
	  }else {
		  posY++;
		  cerchio.setCenterY(posY);;
		  if (posY>=295) {
			  sali=true;
		  }
	  }
  }
  public static void main(String args[]){
    launch();
  }
}