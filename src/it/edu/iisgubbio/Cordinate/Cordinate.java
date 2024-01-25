package it.edu.iisgubbio.Cordinate;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;


public class Cordinate extends Application{   
	Pane pPiano = new Pane();
	Circle cPunto = new Circle();
	final int WIDTH = 400;
	final int HEIGHT = 400;
	
  public void start(Stage primaryStage) throws Exception {
	 GridPane griglia = new GridPane();
	 griglia.setPadding(new Insets(5, 5, 5, 5));
     griglia.setHgap(15); 
     griglia.setVgap(15);
     Scene scena = new Scene(griglia,WIDTH,HEIGHT);
     scena.getStylesheets().add("it/edu/iisgubbio/cordinate/Cordinate.css");
     primaryStage.setTitle("Bho!");
     primaryStage.setScene(scena);
	 primaryStage.show();
	 
	 griglia.add(pPiano, 0, 0);
	 pPiano.setPrefSize(WIDTH, HEIGHT);
	 pPiano.getChildren().add(cPunto);
	 
	 griglia.setId("GPane");
	 pPiano.setId("sfondo");
	 cPunto.setId("Circle");
	 
	 cPunto.setCenterX(WIDTH/2);
	 cPunto.setCenterY(HEIGHT/2);
  }
  public static void main(String args[]){
    launch();
  }
}