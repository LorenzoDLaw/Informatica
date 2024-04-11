package it.edu.iisgubbio.tpsit;
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
  public void start(Stage primaryStage) throws Exception {
    GridPane griglia = new GridPane(); 
    griglia.setPadding(new Insets(5, 5, 5, 5));
    griglia.setHgap(10); 
	griglia.setVgap(10);	
	lettere[0][0]='V';lettere[0][1]='B';lettere[0][2]='B';lettere[1][0]='G';lettere[1][1]='G';lettere[1][2]='G';
	lettere[2][0]='B';lettere[2][1]='V';lettere[2][2]='N';
	Button bCalcola = new Button("verifica");
	Label lPesoImmagine = new Label("Peso immagine");
	Label lPesoImmCompressa = new Label("Peso immagine compressa");
	Label lCompressionRate = new Label("Compressio rate");
	
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
	  StringBuilder result = new StringBuilder();
      int rowCount = riga;
      int colCount = colonna;

      for (int iColonna = 0; iColonna < colonna; iColonna++) {
          int count = 1;
          for (int j = 1; j < colCount; j++) {
              if (lettere[iColonna][j] == lettere[iColonna][j - 1]) {
                  count++;
              } else {
                  result.append(lettere[iColonna][j - 1]).append(count);
                  count = 1;
              }
          }
          result.append(lettere[iColonna][colCount - 1]).append(count);
          result.append("\n");
      }
  }
  
  public static void main(String args[]){
    launch();
  }
}
/*for (int iH=0; iH<riga;iH++ ) {
for(int iL =0 ; iL< colonna;iL++ ) {;
	char lettera;
	lettera = ((char)(Math.random()*('Z'-'A'+1)+'A'));
	Label lCasella = new Label (""+lettera);
	labelLettere[iH][iL]=lCasella;
	lettere[iH][iL]=lettera;
	//bCasella.setId("ButtonTrue");
	lCasella.setPrefSize(50, 30);
	griglia.add(lCasella, iH,iL );
}
}*/