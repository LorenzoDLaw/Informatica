package it.edu.iisgubbio.giochi;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class PongFunziona extends Application{   
	int n=0;
	//timeline per il gioco 
	Timeline timelineGioco = new Timeline(new KeyFrame(
		      Duration.millis(7), // ogni quanto va chiamata la funzione
		      x -> aggiornaTimer()));
	//timeline per il menù
	Timeline timelineMenù = new Timeline(new KeyFrame(
		      Duration.millis(10), // ogni quanto va chiamata la funzione
		      x -> aggiornaMenù()));
	Pane pTavolo = new Pane();
	final int WIDTH_RACCHETTA = 10;
    final int HEIGHT_RACCHETTA = 80;
    final int WIDTH_GIOCO = 550;
    final int HEIGHT_GIOCO =250;
	// creo gli oggetti e gli posiziono 
    Circle pallina = new Circle(WIDTH_GIOCO/2, HEIGHT_GIOCO/2, 10, null);
	Rectangle rPlayer = new Rectangle(10,(HEIGHT_GIOCO/2)-(HEIGHT_RACCHETTA/2),WIDTH_RACCHETTA,HEIGHT_RACCHETTA);
	Rectangle rEnemy = new Rectangle(WIDTH_GIOCO-10,(HEIGHT_GIOCO/2)-(HEIGHT_RACCHETTA/2),WIDTH_RACCHETTA,HEIGHT_RACCHETTA);
	Rectangle rCampo = new Rectangle(WIDTH_GIOCO/2,0,10,HEIGHT_GIOCO);
	double posX=WIDTH_GIOCO/2;
	double posY=HEIGHT_GIOCO/2;
	//creo le booleane per il movimento della pallina
	int randAvanti = (int)(Math.random() * 2) + 1;
	int randSali = (int) (Math.random() * 2) + 1;
	boolean avanti=randAvanti==1;
	boolean sali=randSali==1;
	//creo le label per i punti e i comandi
	Label lStart = new Label("SPACE per iniziare");
	Label lPuntPlayer = new Label("Player 1");
	Label lpuntEnemy = new Label("Player 2");
	Label lVittoria = new Label("Ha vinto il player");
	//Bottoni della difficolta
	RadioButton bFacile = new RadioButton("FACILE");
	RadioButton bNormale = new RadioButton("NORMALE");
	RadioButton bDifficile= new RadioButton("DIFFICIlE");
	//creo degl int4eri per il punteggio
	int puntEnemy = 0;
	int puntPlayer = 0;
	int puntMax=15;
	//Creo la griglia
	GridPane griglia = new GridPane();	
  public void start(Stage primaryStage) throws Exception {
	
	//aggiungo gli elementi alla griglia
	griglia.add(lStart, 0, 0, 2 ,1);
	lStart.setPrefWidth(WIDTH_GIOCO);
	griglia.add(pTavolo, 0, 1, 2, 3);
    pTavolo.setPrefSize(WIDTH_GIOCO, HEIGHT_GIOCO);
    griglia.add(lPuntPlayer, 0, 4);
    lPuntPlayer.setPrefWidth(WIDTH_GIOCO/2);
    griglia.add(lpuntEnemy, 1, 4);
    lpuntEnemy.setPrefWidth(WIDTH_GIOCO/2);
    griglia.add(lVittoria, 0,4,2,1);
    lVittoria.setPrefWidth(WIDTH_GIOCO);
    lVittoria.setVisible(false);
    
    //imposto la scena
    Scene scene = new Scene(griglia);
    scene.getStylesheets().add("it/edu/iisgubbio/giochi/Pong.css");
    griglia.setId("GPane");
	pTavolo.setId("sfondo");
	rPlayer.setId("RecPlayer");
	rEnemy.setId("RecEnemy");
	rCampo.setId("RecEnemy");
	pallina.setId("Circle");
    primaryStage.setTitle("Pong iper mega spaziale"); 
    primaryStage.setScene(scene);
    primaryStage.show();
    
	//inserisco la pallina e le racchette nel pane
	pTavolo.getChildren().add(rPlayer);
	pTavolo.getChildren().add(rEnemy);
	pTavolo.getChildren().add(rCampo);
	pTavolo.getChildren().add(pallina);
	pallina.setCenterX(posX);
	pallina.setCenterY(posY);
    //creo una timeline indefinita 
    timelineGioco.setCycleCount(timelineGioco.INDEFINITE);
    timelineMenù.setCycleCount(timelineMenù.INDEFINITE);
    scene.setOnKeyPressed(e -> premi(e));
  	}
  
  public void premi(KeyEvent evento) {
	  //faccio partire il gioco
	  if (evento.getCode()==KeyCode.SPACE) {
		  pallina.setCenterX(posX);
		  pallina.setCenterY(posY);
		  lpuntEnemy.setVisible(true);
		  lPuntPlayer.setVisible(true);
		  lVittoria.setVisible(false);
		  timelineGioco.play();		  
	  }
	  //movimento dei tasti W/S per il Player Up/Down per l'Enemy
	  if (evento.getText().equals("w")) {
		  rPlayer.setY(rPlayer.getY()-10);
		  if(rPlayer.getY()<5) {
			  rPlayer.setY(5);
		  }
	  }
	  if (evento.getText().equals("s")) {
		  rPlayer.setY(rPlayer.getY()+10);
		  if(rPlayer.getY()>HEIGHT_GIOCO-HEIGHT_RACCHETTA) {
			  rPlayer.setY(HEIGHT_GIOCO-HEIGHT_RACCHETTA);
		  }
	  }
	  if (evento.getCode()==KeyCode.UP) {
		  rEnemy.setY(rEnemy.getY()-10);
		  if(rEnemy.getY()<5) {
			  rEnemy.setY(5);
		  }
	  }
	  if (evento.getCode()==KeyCode.DOWN) {
		  rEnemy.setY(rEnemy.getY()+10);
		  if(rEnemy.getY()>HEIGHT_GIOCO-HEIGHT_RACCHETTA) {
			  rEnemy.setY(HEIGHT_GIOCO-HEIGHT_RACCHETTA);
		  }
	  }
	  if (evento.getCode()==KeyCode.ESCAPE) {
		  timelineGioco.stop();	
		  griglia.getChildren().clear();
		  timelineMenù.play();
		  
	  }
  }
  private void aggiornaMenù() {
	  griglia.getChildren().clear();
	  griglia.add(bFacile, 0, 0);
	  bFacile.setPrefSize(WIDTH_GIOCO/3, 20);
	  griglia.add(bNormale, 1, 0);
	  bNormale.setPrefSize(WIDTH_GIOCO/3, 20);
	  griglia.add(bDifficile, 2, 0);
	  bDifficile.setPrefSize(WIDTH_GIOCO/3, 20);
	  ToggleGroup difficolta = new ToggleGroup();
	  bFacile.setToggleGroup(difficolta);
	  bNormale.setToggleGroup(difficolta);
	  bDifficile.setToggleGroup(difficolta);
	  
	  bFacile.setOnAction(f -> modFacile()); 
	  bNormale.setOnAction(n -> modNOrmale()); 
	  bDifficile.setOnAction(d -> modDifficile());  
  }
  public void modFacile() {
	  griglia.getChildren().clear();
	  rEnemy.setHeight(HEIGHT_GIOCO/4);
	  rPlayer.setHeight(HEIGHT_GIOCO/4);
	  griglia.getChildren().clear();
	  griglia.add(lStart, 0, 0, 2 ,1);
	  lStart.setPrefWidth(WIDTH_GIOCO);
	  griglia.add(pTavolo, 0, 1, 2, 3);
	  pTavolo.setPrefSize(WIDTH_GIOCO, HEIGHT_GIOCO);
	  griglia.add(lPuntPlayer, 0, 4);
	  lPuntPlayer.setPrefWidth(WIDTH_GIOCO/2);
	  griglia.add(lpuntEnemy, 1, 4);
	  lpuntEnemy.setPrefWidth(WIDTH_GIOCO/2);
	  griglia.add(lVittoria, 0,4,2,1);
	  lVittoria.setPrefWidth(WIDTH_GIOCO);
	  lVittoria.setVisible(false);
	  timelineGioco.play();
	}
  public void modNOrmale() {
	  griglia.getChildren().clear();
	  rEnemy.setHeight(HEIGHT_GIOCO/5);
	  rPlayer.setHeight(HEIGHT_GIOCO/5);
	  griglia.getChildren().clear();
	  griglia.add(lStart, 0, 0, 2 ,1);
	  lStart.setPrefWidth(WIDTH_GIOCO);
	  griglia.add(pTavolo, 0, 1, 2, 3);
	  pTavolo.setPrefSize(WIDTH_GIOCO, HEIGHT_GIOCO);
	  griglia.add(lPuntPlayer, 0, 4);
	  lPuntPlayer.setPrefWidth(WIDTH_GIOCO/2);
	  griglia.add(lpuntEnemy, 1, 4);
	  lpuntEnemy.setPrefWidth(WIDTH_GIOCO/2);
	  griglia.add(lVittoria, 0,4,2,1);
	  lVittoria.setPrefWidth(WIDTH_GIOCO);
	  lVittoria.setVisible(false);
	  timelineGioco.play();
	}
  public void modDifficile() {
	  griglia.getChildren().clear();
	  rEnemy.setHeight(HEIGHT_GIOCO/6);
	  rPlayer.setHeight(HEIGHT_GIOCO/6);
	  griglia.getChildren().clear();
	  griglia.add(lStart, 0, 0, 2 ,1);
	  lStart.setPrefWidth(WIDTH_GIOCO);
	  griglia.add(pTavolo, 0, 1, 2, 3);
	  pTavolo.setPrefSize(WIDTH_GIOCO, HEIGHT_GIOCO);
	  griglia.add(lPuntPlayer, 0, 4);
	  lPuntPlayer.setPrefWidth(WIDTH_GIOCO/2);
	  griglia.add(lpuntEnemy, 1, 4);
	  lpuntEnemy.setPrefWidth(WIDTH_GIOCO/2);
	  griglia.add(lVittoria, 0,4,2,1);
	  lVittoria.setPrefWidth(WIDTH_GIOCO);
	  lVittoria.setVisible(false);
	  timelineGioco.play();
	}
  
  private void aggiornaTimer(){
	  //rimbalzo sulle raqcchette
	  Bounds boundPlayer = rPlayer.getBoundsInParent();
	  Bounds boundEnemy = rEnemy.getBoundsInParent();
	  Bounds boundPallina = pallina.getBoundsInParent();
	  
	  
	  if (avanti==true) {
		  double casuale = (double)(Math.random()*0.9)+1;
		  posX = posX+casuale;
		  pallina.setCenterX(posX);
		  if(boundPallina.intersects(boundEnemy)) { 
			  avanti=false;
	      }
		  if (posX>=WIDTH_GIOCO-5) {
			  posX=WIDTH_GIOCO/2;
			  posY=HEIGHT_GIOCO/2;
			  pallina.setCenterX(posX);
			  pallina.setCenterY(posY);
			//rifaccio ripartire randomicamente
			  randSali = (int) (Math.random() * 2) + 1;
			  avanti=true;
			  sali=randSali==1;
			  puntPlayer++;
			  lPuntPlayer.setText("Player 1 "+ puntPlayer);
			  if(puntPlayer==puntMax) {
				  timelineGioco.stop();
				  lpuntEnemy.setVisible(false);
				  lPuntPlayer.setVisible(false);
				  lVittoria.setText("Ha vinto il player 1");
				  lVittoria.setVisible(true);
				  posX=WIDTH_GIOCO/2;
				  posY=HEIGHT_GIOCO/2;
				  //azzero il punteggio
				  puntPlayer=0;
				  puntEnemy=0;
				  lpuntEnemy.setText("Player 2 "+puntEnemy);
				  lPuntPlayer.setText("Player 1 "+puntPlayer);
			  } 
		  }
	  }else{
		  double casuale = (double)(Math.random()*0.9)+1;
		  posX=posX-casuale;
		  pallina.setCenterX(posX);
		  if(boundPallina.intersects(boundPlayer)) { 
			  avanti=true;
	      }
		  if (posX<=10 ) {
			  posX=WIDTH_GIOCO/2;
			  posY=HEIGHT_GIOCO/2;
			  pallina.setCenterX(posX);
			  pallina.setCenterY(posY);
			  //per ripartire al centro
			  randSali = (int) (Math.random() * 2) + 1;
			  avanti=false;
			  sali=randSali==1; 
			  
			  puntEnemy++; //aumento il punteggio
			  lpuntEnemy.setText("Player 2 "+puntEnemy);
			  if(puntEnemy==puntMax) {
				  timelineGioco.stop();
				  lpuntEnemy.setVisible(false);
				  lPuntPlayer.setVisible(false);
				  lVittoria.setText("Ha vinto il player 2");
				  lVittoria.setVisible(true);
				  posX=WIDTH_GIOCO/2;
				  posY=HEIGHT_GIOCO/2;
				  //azzero il punteggio
				  puntPlayer=0;
				  puntEnemy=0;
				  lpuntEnemy.setText("Player 2 "+puntEnemy);
				  lPuntPlayer.setText("Player 1 "+puntPlayer);
			  }
		  }
	  }
	  if (avanti==true) {
		  double casuale = (double)(Math.random()*0.9)+1;
		  posX= posX+casuale;
		  pallina.setCenterX(posX);;
		  if (posX>=WIDTH_GIOCO) {
			  avanti=false;
		  }
	  }else{
		  double casuale = (double)(Math.random()*0.9)+1;
		  posX=posX-casuale;
		  pallina.setCenterX(posX);;
		  if (posX<=5) {
			  avanti=true;
		  }
	  }
	  if(sali==true){
		  double casuale = (double)(Math.random()*0.9)+1;
		  posY=posY-casuale;
		  pallina.setCenterY(posY);;
		  if (posY<=10) {
			  sali=false;
		  }
	  }else {
		  double casuale = (double)(Math.random()*0.9)+1;
		  posY=posY+casuale;
		  pallina.setCenterY(posY);;
		  if (posY>=HEIGHT_GIOCO-10) {
			  sali=true;
		  }
	  }
  }
  public static void main(String args[]){
    launch();
  }
}