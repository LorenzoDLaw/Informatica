package it.edu.iisgubbio.negozio;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.Slider;

public class KebabComboBox extends Application{
	Label lCarne = new Label("Carne");
	Label lPzCarne = new Label("ciao");
	ComboBox<String> cbBurgher = new ComboBox<>();
	Label lVerdura = new Label("Verdura");
	Label lPzVerdura = new Label("ciao");
	ComboBox<String> cbVerdura = new ComboBox<>();
	Label lSalsa = new Label("Salsa");
	Label lPzSalsa = new Label("ciao");
	ComboBox<String> cbSalsa = new ComboBox<>();
	Button bTotale = new Button("Totale");
	Label lTotale = new Label("");
	String strBurgher ;
	String strVerdura ;
	String strSalsa ;
public void start(Stage finestra) {
		
		GridPane griglia = new GridPane();
		
		griglia.setPadding(new Insets(5, 5, 5, 5));
		griglia.setHgap(15); 
		griglia.setVgap(15);
		
		//inaserisco nel box gli elementi
		cbBurgher.getItems().add("Pollo");
		cbBurgher.getItems().add("Maiale");
		cbBurgher.getItems().add("Vitello");
		cbBurgher.getItems().add("Tofu");
	
		cbVerdura.getItems().add("Insalata");
		cbVerdura.getItems().add("Cipolla");
		cbVerdura.getItems().add("Pomodoro");
		cbVerdura.getItems().add("Carota");
		
		cbSalsa.getItems().add("Mayonese");
		cbSalsa.getItems().add("Piccante");
		cbSalsa.getItems().add("Yougurt");
		cbSalsa.getItems().add("Tzatziki");
		
		griglia.add(lCarne, 0, 0);
		griglia.add(cbBurgher, 0, 1);
    	cbBurgher.setPrefWidth(100);
    	griglia.add(lPzCarne, 1, 1);
    	griglia.add(lVerdura, 0, 2);
        griglia.add(cbVerdura, 0, 3);
        cbVerdura.setPrefWidth(100);
        griglia.add(lPzVerdura, 1, 3);
        griglia.add(lSalsa, 0, 4);
		griglia.add(cbSalsa, 0, 5);
		cbSalsa.setPrefWidth(100);
		griglia.add(lPzSalsa, 1, 5);
		griglia.add(bTotale, 0, 6);
		bTotale.setPrefWidth(100);
		griglia.add(lTotale, 0, 7);
		lTotale.setPrefWidth(100);
		
		//creo il pezzo per inserire il prezzo una volta selezionato il prodotto
		/*strBurgher = cbBurgher.getValue();
		strVerdura = cbVerdura.getValue();
		strSalsa = cbSalsa.getValue();*/
		cbBurgher.setOnAction(e -> impostaCarne());
			
		
		cbVerdura.setOnAction(e -> impostaVerdura());
			
		cbSalsa.setOnAction(e -> impostaSalsa());
			
						
		Scene scena = new Scene(griglia);
	    finestra.setTitle("kebab!");
	    finestra.setScene(scena);
	    finestra.show();
		
	    bTotale.setOnAction(e -> totaleKebab()); 
	   		
	}
	

	
	
	public void impostaCarne() {
		strBurgher = cbBurgher.getValue();
		switch (strBurgher ) {
		case "Maiale":
			lPzCarne.setText("2.5€");
		break;
		case "Vitello":
			lPzCarne.setText("4€");
		break;
		default:
			lPzCarne.setText("3€");
		}
	}
	public void impostaVerdura() {
		strVerdura = cbVerdura.getValue();
		switch (strVerdura) {
		case "Insalata":
		case "Cipolla":
			lPzVerdura.setText("0.5€");
		break;
		case "Pomodoro":
			lPzVerdura.setText("1€");
		break;
		default:
			lPzVerdura.setText("1€");
		}
	}
	public void impostaSalsa() {
		strSalsa = cbSalsa.getValue();
		switch (strSalsa) {
		case "Piccante":
			lPzSalsa.setText("1€");
		break;
		default:
			lPzSalsa.setText("0.5€");
		}
	}
	public void totaleKebab() {
		strBurgher = cbBurgher.getValue();
		strVerdura = cbVerdura.getValue();
		strSalsa = cbSalsa.getValue();
		float pzBurgher;
		float pzSalsa;
		float pzVerdura;
		
		switch (strBurgher ) {
		case "Pollo":
			pzBurgher = 3.0f;
		break;
		case "Maiale":
			pzBurgher = 2.5f;
		break;
		case "Vitello":
			pzBurgher = 4.0f;
		break;
		default:
			pzBurgher = 3.0f;
		}


		switch (strVerdura) {
		case "Insalata":
			pzVerdura = 0.5f;
		break;
		case "Cipolla":
			pzVerdura = 0.5f;
		break;
		case "Pomodoro":
			pzVerdura = 1.0f;
		break;
		default:
			pzVerdura = 1.0f;
		}
		
		switch (strSalsa) {
		case "Mayonese":
			pzSalsa = 0.5f;
		break;
		case "Piccante":
			pzSalsa = 1.0f;
		break;
		case "Yougurt":
			pzSalsa = 0.5f;
		break;
		default:
			pzSalsa = 0.5f;
		}
		double totale = 1+(pzBurgher+pzSalsa+pzVerdura);
		lTotale.setText(""+totale);
	}
	
	public static void main(String[] args) {
	    launch(args);
	  }

}
