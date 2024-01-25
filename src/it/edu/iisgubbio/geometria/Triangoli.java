package it.edu.iisgubbio.geometria;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class Triangoli extends Application{
	
	TextField tCateto1 = new TextField();
	TextField tCateto2 = new TextField();
	TextField tCateto3 = new TextField();
	Label lTipo = new Label();
	
	
	public void start(Stage finestra) {
		
		Button bTipoTriangolo = new Button("trova tipo");
				
		GridPane griglia = new GridPane();
		
		griglia.setPadding(new Insets(5, 5, 5, 5));
		griglia.setHgap(15); 
		griglia.setVgap(15);
		
		griglia.add(tCateto1, 0, 0);
		griglia.add(tCateto2, 1, 0);
		griglia.add(tCateto3, 2, 0);
		griglia.add(bTipoTriangolo, 0, 1,3,1);
		bTipoTriangolo.setMaxWidth(100000);
		griglia.add(lTipo, 0, 2, 3, 1);
		lTipo.setMaxWidth(100000);
		
		
		
				
		Scene scena = new Scene(griglia);
	    finestra.setTitle("triangolo rettangolo!");
	    finestra.setScene(scena);
	    finestra.show();
		
	    bTipoTriangolo.setOnAction(e -> triangoli());
  	
	}
	
	
	public void triangoli() {
		
		String stringLato1;
		String stringLato2;
		String stringLato3;
		double lato1;
		double lato2;
		double lato3;
		
		
		stringLato1 = tCateto1.getText();
		stringLato2 = tCateto2.getText();
		stringLato3 = tCateto3.getText();
		
		lato1 = Double.parseDouble(stringLato1);
		lato2= Double.parseDouble(stringLato2);
		lato3= Double.parseDouble(stringLato3);
		
		//calcolo del triangolo		
		//ogni lato deve essere più piccolo della somma degli altri 2
		if((lato1>lato2+lato3)||(lato2>lato1+lato3)||(lato3>lato1+lato2)){
			lTipo.setText("il triangolo non esiste");
		}
		else if ((lato3*lato3)==((lato1*lato1)+(lato2 * lato2))){
			lTipo.setText("il traingolo e rettangolo");
		}else if(lato1==lato2 && lato1==lato3 ){
			lTipo.setText("il triangolo è equilatero");
		}else if ((lato1==lato2 && lato1!=lato3)||(lato1==lato3 && lato1!=lato2)) {
			lTipo.setText("il triangolo è isoscele");			
		}else if ((lato1!=lato2 && lato1!=lato3 && lato2!=lato3)) {
			lTipo.setText("il triangolo è scaleno");
		}
		
		
		
	}
	
	public static void main(String[] args) {
	    launch(args);
	  }
	
}