package it.edu.iisgubbio.giochi;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Bersaglio extends Application{   
	Pane pTavolo = new Pane();
	final int ALTEZZA = 400;
	final int LARGEHEZZA = 400;
  public void start(Stage primaryStage) throws Exception {
    GridPane griglia = new GridPane();
    
    griglia.setPadding(new Insets(5, 5, 5, 5));
	griglia.setHgap(15); 
	griglia.setVgap(15);
	
    griglia.add(pTavolo, 0, 1);
    pTavolo.setPrefSize(LARGEHEZZA, ALTEZZA);
    Scene scene = new Scene(griglia);
    primaryStage.setTitle("Bho!"); 
    primaryStage.setScene(scene);
    primaryStage.show();
    
    pTavolo.addEventHandler(
    		MouseEvent.MOUSE_CLICKED, 
    		e-> controllo(e));
  }
  
  private void controllo(MouseEvent e) {
	  double posX = e.getX();
	  double posY = e.getY();
	  /*System.out.print(posX);
	  System.out.print(posY);*/
	  if(e.getButton().equals(MouseButton.SECONDARY)){
		  Circle pallinaR = new Circle(10);
		  pallinaR.setFill(Color.RED);
		  pTavolo.getChildren().add(pallinaR);
		  pallinaR.setCenterX(posX);
		  pallinaR.setCenterY(posY);
		  
	  }else {
		  Circle pallinaV = new Circle(10);
		  pTavolo.getChildren().add(pallinaV);
		  pallinaV.setFill(Color.GREEN);
		  pallinaV.setCenterX(posX);
		  pallinaV.setCenterY(posY);
	  }
	  	
  }
  public static void main(String args[]){
    launch();
  }
}