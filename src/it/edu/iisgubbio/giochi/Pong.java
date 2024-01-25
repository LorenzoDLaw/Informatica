package it.edu.iisgubbio.giochi;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Pong extends Application{   
	int n=0;
	Timeline timeline = new Timeline(new KeyFrame(
		      Duration.seconds(0.016), // ogni quanto va chiamata la funzione
		      x -> aggiornaTimer()));
	Pane pTavolo = new Pane();
	Circle cerchio = new Circle(10);
	final int WIDTH_RACCHETTA = 10;
    final int HEIGHT_RACCHETTA = 80;
    final int WIDTH_GIOCO = 400;
    final int HEIGHT_GIOCO =300;
	Rectangle rPlayer = new Rectangle(10,(HEIGHT_GIOCO/2)-(HEIGHT_RACCHETTA/2),WIDTH_RACCHETTA,HEIGHT_RACCHETTA);
	Rectangle rEnemy = new Rectangle(WIDTH_GIOCO-20,(HEIGHT_GIOCO/2)-(HEIGHT_RACCHETTA/2),WIDTH_RACCHETTA,HEIGHT_RACCHETTA);
	int posX=0;
	int posY=200;
	boolean avanti=true;
	boolean sali=true;
  public void start(Stage primaryStage) throws Exception {
    GridPane griglia = new GridPane();
    
    griglia.setPadding(new Insets(5, 5, 5, 5));
	griglia.setHgap(15); 
	griglia.setVgap(15);
	
    griglia.add(pTavolo, 0, 1, 1, 2);
    pTavolo.setPrefSize(WIDTH_GIOCO, HEIGHT_GIOCO);
  
    Scene scene = new Scene(griglia);
    primaryStage.setTitle("Timer!"); 
    primaryStage.setScene(scene);
    primaryStage.show();
    
	//inserisco la pallina
    cerchio.setFill(Color.CORAL);
	pTavolo.getChildren().add(cerchio);
	cerchio.setCenterX(posX);
	cerchio.setCenterY(posY);
	//inserisco le racchette
	pTavolo.getChildren().add(rPlayer);
	pTavolo.getChildren().add(rEnemy);
	
    
    timeline.setCycleCount(timeline.INDEFINITE);
    timeline.play();
    
    scene.setOnKeyPressed(e -> premi(e));
  }
  public void premi(KeyEvent evento) {
	  if (evento.getText().equals("w")) {
		  rPlayer.setY(rPlayer.getY()-2);
		  if(rPlayer.getY()<-20) {
			  rPlayer.setY(-20);
		  }
	  }
	  if (evento.getText().equals("s")) {
		  rPlayer.setY(rPlayer.getY()+2);
		  if(rPlayer.getY()>HEIGHT_GIOCO-HEIGHT_RACCHETTA) {
			  rPlayer.setY(HEIGHT_GIOCO-HEIGHT_RACCHETTA);
		  }
	  }
	  if (evento.getCode()==KeyCode.UP) {
		  rEnemy.setY(rEnemy.getY()-2);
		  if(rEnemy.getY()<-20) {
			  rEnemy.setY(-20);
		  }
	  }
	  if (evento.getCode()==KeyCode.DOWN) {
		  rEnemy.setY(rEnemy.getY()+2);
		  if(rEnemy.getY()>HEIGHT_GIOCO-HEIGHT_RACCHETTA) {
			  rEnemy.setY(HEIGHT_GIOCO-HEIGHT_RACCHETTA);
		  }
	  }
  }
  private void aggiornaTimer(){
	  if (avanti==true) {
		  posX++;
		  cerchio.setCenterX(posX);;
		  if (posX>=WIDTH_GIOCO) {
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
		  if (posY>=HEIGHT_GIOCO) {
			  sali=true;
		  }
	  }
  }
  public static void main(String args[]){
    launch();
  }
}