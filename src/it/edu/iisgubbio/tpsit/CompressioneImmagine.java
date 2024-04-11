package it.edu.iisgubbio.tpsit;
import java.util.Hashtable;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
public class CompressioneImmagine extends Application{ 
	int riga = 3;
	int colonna = 3;
	char lettere [][]= new char [colonna][riga];
	TextField tPesoImmagine = new TextField();
	Label lPesoImmagine = new Label("Peso immagine");
	Label lPesoImmCompressa = new Label("Peso immagine compressa");
	Label lCompressionRate = new Label("Compressio rate");
	Hashtable<Integer,Integer> my_dict = new Hashtable<Integer,Integer>();
  public void start(Stage primaryStage) throws Exception {
	  my_dict.put(1, 1);
	  my_dict.put(2,2);
	  my_dict.put(3,2);
	  my_dict.put(4,3);
	  
    GridPane griglia = new GridPane(); 
    griglia.setPadding(new Insets(5, 5, 5, 5));
    griglia.setHgap(10); 
	griglia.setVgap(10);	
	lettere[0][0]='V';lettere[0][1]='B';lettere[0][2]='B';lettere[1][0]='G';lettere[1][1]='G';lettere[1][2]='G';
	lettere[2][0]='B';lettere[2][1]='V';lettere[2][2]='N';
	Button bCalcola = new Button("verifica");
	
	
	griglia.add(lPesoImmagine, 0, 0);
	griglia.add(tPesoImmagine, 1, 0);
	griglia.add(bCalcola, 0, 1,2,1);
	griglia.add(lPesoImmCompressa, 0, 3,2,1);
	griglia.add(lCompressionRate, 0, 4,2,1);
	bCalcola.setMaxWidth(1000);
	
    Scene scene = new Scene(griglia);
    primaryStage.setTitle("Ciao"); 
    primaryStage.setScene(scene);
    primaryStage.show();
    //scene.getStylesheets().add("it/edu/iisgubbio/giochi/ParolaCSS.css");
    bCalcola.setOnAction(e -> comprimi());
  }
  public void comprimi(){
      int rowCount = riga;
      int colCount = colonna;
      char vAppoggio []= new char [9];
      int iAppoggio =0;
      for (int iRiga = 0; iRiga < colCount;iRiga++) {
          int count = 1;
          for (int iColonna = 0; iColonna < colonna; iColonna++) {
        	  vAppoggio[iAppoggio]=lettere[iRiga][iColonna];
        	  iAppoggio++;
          } 
      }
      int compressione=0;
      int count =1;
      for(int i=1; i<vAppoggio.length;i++) {
    	  if(vAppoggio[i]== vAppoggio[i-1]) {
    		  count++;
    	  }else {
    		  if(i==1) {
    			  compressione=25;
    		  }
    		  compressione=compressione+(24+ my_dict.get(count));
    		  System.out.println(compressione);
    		  count=1;
    	  }
      }
      lPesoImmCompressa.setText(lPesoImmCompressa.getText()+ " "+compressione);
      double compressioneRate=100-(compressione*100.0/(24.0*(riga*colonna)));
      System.out.println(vAppoggio);
      lCompressionRate.setText(lCompressionRate.getText() +" "+compressioneRate);
  }
  
  public static void main(String args[]){
    launch();
  }
}
