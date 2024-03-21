package it.edu.iisgubbio.giochi;



import javafx.application.Application;
import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class PratoConBombe extends Application{ 
	int altezza = 8;
	int larghezza = 8;
	int nBombe=20;
	boolean bombe [][]= new boolean [larghezza][altezza];
  public void start(Stage primaryStage) throws Exception {
    GridPane griglia = new GridPane();
    
    griglia.setPadding(new Insets(5, 5, 5, 5));
    griglia.setHgap(10); 
	griglia.setVgap(10);
	
   
	for (int iH=0; iH<altezza;iH++ ) {
		for(int iL =0 ; iL< larghezza;iL++ ) {
			Button bCasella = new Button("");
			bCasella.setPrefSize(30, 30);
			bCasella.setOnAction(e -> crocetta(e));
			griglia.add(bCasella, iL, iH);
		}
	}
    for (int i =0 ; i<nBombe;i++) {
    	bombe[(int)Math.random()][(int)Math.random()]= true;
    }
    Scene scene = new Scene(griglia);
    primaryStage.setTitle("Bho!"); 
    primaryStage.setScene(scene);
    primaryStage.show();
    
    
  }
    
  public void crocetta(Event e){
	  Button a =(Button) e.getSource();
	  a.setText("X");
  }
  public static void main(String args[]){
    launch();
  }
}