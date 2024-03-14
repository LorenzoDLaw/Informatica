package it.edu.iisgubbio.testi;


import javafx.application.Application;
import javafx.css.converter.FontConverter;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Spazi extends Application{
	TextField tTesto = new TextField("");
	TextField tSpazi = new TextField("");
	public void start(Stage finestra) {
		GridPane griglia = new GridPane();
		
		Label lTesto = new Label("testo");
		Label lSpazi = new Label("spazi");
		Button bTrasforma = new Button("Trasforma");
		
		griglia.add(lTesto,  0,  0);
		griglia.add(tTesto,  1,  0);
		griglia.add(lSpazi,  0,  1);
		griglia.add(tSpazi,  1,  1);
		tSpazi.setPrefWidth(200);
		griglia.add(bTrasforma,  0,  2,2,1);
		bTrasforma.setMaxWidth(1000);

	    griglia.setPadding(new Insets(10, 10, 10, 10));
		griglia.setHgap(22); 
		griglia.setVgap(10);
	    
	    Scene scene = new Scene(griglia);
	    
	    finestra.setTitle("Somma"); 
		finestra.setScene(scene);
		finestra.show();
		
		bTrasforma.setOnAction(e -> TrasformaFont());
	
	}
	public void TrasformaFont() {
	    tSpazi.setText(tTesto.getText());
	    //Font monospace = new Font("Courier New", 10); // Specify Font.PLAIN for style
	    //tSpazi.setFont(monospace);
	    //tTesto.setFont(monospace);
	    // aggiungo gli spazi
	    //123 45 6 78 90
	    char spazi[]= new char [20];
	    char testo [] = tTesto.getText().toCharArray();
	    int numSpaziFrase=0;
	    int spaziTot=20;
	    int sapziDaInserire=0;
	    if (testo.length!=20) {
	    	for (int i =0; i< testo.length;i++) {
		    	if (testo[i]==' ') {
		    		numSpaziFrase++;
		    	}
		    }
		    sapziDaInserire=spaziTot-testo.length;
		    sapziDaInserire=sapziDaInserire/numSpaziFrase;
		    for (int iSpazi =0,iTesto=0; iSpazi< spazi.length;iSpazi++) {
		    	if (testo[iTesto]==' ') {
		    		for (int x =0; x<sapziDaInserire;x++) {
			    		spazi[iSpazi]=' ';
			    		iSpazi++;
		    		}
		    		iTesto++;
		    	}else {
		    		spazi[iSpazi]=testo[iTesto];
		    		iTesto++;
		    	}
		    	if (iTesto==testo.length-1) {
		    		for (int y = iSpazi+1; y<20;y++) {
			    		spazi[y]=' '; 
			    		iSpazi++;
		    		}
		    	}
		    }
		    String k = new String (spazi);
		    tSpazi.setText(k); 
	    	}
	    }else {
	    	for (int i=0;i<20;i++) {
	    		tSpazi.setText(tSpazi.getText()+spazi[i]); 
	    	}
	    }
	   
			
	public static void main(String args[]){
		launch();
	}
}