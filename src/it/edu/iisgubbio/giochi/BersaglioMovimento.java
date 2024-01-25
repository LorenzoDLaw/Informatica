package it.edu.iisgubbio.giochi;

import javax.xml.validation.TypeInfoProvider;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class BersaglioMovimento extends Application{   
	Timeline timeline = new Timeline(new KeyFrame(
		      Duration.seconds(1), // ogni quanto va chiamata la funzione
		      x -> aggiornaTimer()));
	Pane pTavolo = new Pane();
	final int ALTEZZA = 400;
	final int LARGEHEZZA = 400;
	double posX = LARGEHEZZA/2;
	double posY = ALTEZZA/2;
	Circle pallino = new Circle(posX, posY, 40, Color.BLACK);
  public void start(Stage primaryStage) throws Exception {
    GridPane griglia = new GridPane();
    
    griglia.setPadding(new Insets(5, 5, 5, 5));
	griglia.setHgap(15); 
	griglia.setVgap(15);
	
    griglia.add(pTavolo, 0, 1);
    pTavolo.getChildren().add(pallino);
    
    pTavolo.setPrefSize(LARGEHEZZA, ALTEZZA);
    Scene scene = new Scene(griglia);
    primaryStage.setTitle("Bho!"); 
    primaryStage.setScene(scene);
    primaryStage.show();
    timeline.setCycleCount(timeline.INDEFINITE);
    timeline.play();
    
    pTavolo.addEventHandler(
    		MouseEvent.MOUSE_CLICKED, 
    		e-> controllo(e));
  }
  double posXMouse = 0; 
  double posYMouse =0;
  int tocchi =0;
  private void controllo(MouseEvent e) {
	  posXMouse = e.getX();
	  posYMouse = e.getY();	  	
  }  
  public void aggiornaTimer(){
	  posX = (double)(Math.random()*LARGEHEZZA);
	  posY = (double)(Math.random()*ALTEZZA);
	  pallino.setCenterX(posX);
	  pallino.setCenterY(posY);
	  if(posXMouse-posX<10 || posX-posXMouse<10){
		  if (posYMouse-posY<10 || posY-posYMouse<10){
			  tocchi+=1;
			  System.out.print(tocchi);
		  }
	  }
	  
  }
  public static void main(String args[]){
    launch();
  }
}