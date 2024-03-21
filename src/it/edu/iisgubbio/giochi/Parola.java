package it.edu.iisgubbio.giochi;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Parola extends Application{ 
	int altezza = 5;
	int larghezza = 5;
	Label labelLettere [][]= new Label [larghezza][altezza];
	char lettere [][]= new char [larghezza][altezza];
	TextField tParola = new TextField();
  public void start(Stage primaryStage) throws Exception {
    GridPane griglia = new GridPane(); 
    griglia.setPadding(new Insets(5, 5, 5, 5));
    griglia.setHgap(10); 
	griglia.setVgap(10);
	Button bVerifica = new Button("verifica");
	for (int iH=0; iH<altezza;iH++ ) {
		for(int iL =0 ; iL< larghezza;iL++ ) {;
			char lettera;
			lettera = ((char)(Math.random()*('Z'-'A'+1)+'A'));
			Label lCasella = new Label (""+lettera);
			labelLettere[iH][iL]=lCasella;
			lettere[iH][iL]=lettera;
			//bCasella.setId("ButtonTrue");
			lCasella.setPrefSize(50, 30);
			griglia.add(lCasella, iH,iL );
		}
	}
	bVerifica.setOnAction(e -> TrovaParola());
	griglia.add(tParola, 0, altezza+1,larghezza,1);
	griglia.add(bVerifica, 0, altezza+2,larghezza,1);
	bVerifica.setMaxWidth(1000);
    Scene scene = new Scene(griglia);
    primaryStage.setTitle("Campo Minato"); 
    primaryStage.setScene(scene);
    primaryStage.show();
    scene.getStylesheets().add("it/edu/iisgubbio/giochi/ParolaCSS.css");
  }
  public void TrovaParola(){
	  String strParola = tParola.getText();
	  char parolaCercata []= strParola.toUpperCase().toCharArray();
	  boolean charTrovato =false;
	  for (int iParolaCercata=0; iParolaCercata<parolaCercata.length;iParolaCercata++) {
		  for (int iH=0; iH<altezza;iH++ ) {
			for(int iL =0 ; iL< larghezza;iL++ ) {
				if (lettere[iH][iL]== parolaCercata[iParolaCercata]) {
					labelLettere[iH][iL].setId("labelTrovata");
					charTrovato=true;
				}
			}
		  } 
		  if (charTrovato==false) {
			  parolaCercata[iParolaCercata]='A';
		  }
		}  
  }
  public static void main(String args[]){
    launch();
  }
}