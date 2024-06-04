package it.edu.iisgubbio.mobilitaProva;

import it.edu.iisgubbio.mobilita.MezzoDiTrasporto;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Garage2 extends Application{
	ListView garage = new ListView<MezzoDiTrasporto>();
	Button bAggiungi = new Button("aggiungi");
	
	TextField tNome = new TextField();
	TextField tCosto = new TextField();
	TextField tMuscoliCoinvolti = new TextField( );
	TextField tNumeroRapporti = new TextField();
	TextField tPeso = new TextField();
	TextField tCarburante = new TextField();
	TextField tRumorosita = new TextField();
	TextField tVelocita = new TextField();
	TextField tTarga = new TextField();
	TextField tNumeroPosti = new TextField();
	TextField tCilindrata = new TextField();
	TextField tLunghezza = new TextField();
	GridPane griglia = new GridPane();
	
	ComboBox<String> boxMezzi = new ComboBox<>();
	public void start(Stage finestra) {
		Label lNome = new Label("nome");
		Label lCosto = new Label("costo");
		Label lMuscoliCoinvolti = new Label("muscoli coinvolti");
		Label lNumeroRapporti = new Label("numero rapporti");
		Label lPeso = new Label("peso");
		Label lCarburanteLabel = new Label("carburante");
		Label lRumorosita = new Label("rumorosita");
		Label lVelociLabel = new Label("velocità");
		Label lTarga = new Label("targa");
		Label lNumeroPosti = new Label("numero di posti");
		Label lCilindrata = new Label("cilindrata");
		Label lLunghezza = new Label("lunghezza");
		
		boxMezzi.getItems().add("Automobile");
		boxMezzi.getItems().add("Bicicletta");
		boxMezzi.getItems().add("Skateboard");
		boxMezzi.getItems().add("Motocicletta");
		
		
		griglia.setPadding(new Insets(5, 5, 5, 5));
		griglia.setHgap(15); 
		griglia.setVgap(15);
		
		griglia.add(garage, 0, 0,1,7);
		garage.setPrefSize(150, 100);
		griglia.add(boxMezzi, 1, 0);
		griglia.add(lNome, 1, 1);
		griglia.add(tNome, 2, 1);
		griglia.add(lCosto, 1, 2);
		griglia.add(tCosto, 2, 2);
		griglia.add(lMuscoliCoinvolti, 1, 3);
		griglia.add(tMuscoliCoinvolti, 2, 3);
		griglia.add(lNumeroRapporti, 1, 4);
		griglia.add(tNumeroRapporti, 2, 4);
		griglia.add(lPeso, 1, 5);
		griglia.add(tPeso, 2, 5);
		griglia.add(tCarburante, 2, 6);
		griglia.add(lCarburanteLabel, 1, 6);
		griglia.add(tRumorosita, 2, 7);
		griglia.add(lRumorosita, 1, 7);
		griglia.add(tVelocita, 2, 8);
		griglia.add(lVelociLabel, 1, 8);
		griglia.add(tTarga, 2, 9);
		griglia.add(lTarga, 1, 9);
		griglia.add(tNumeroPosti, 2, 10);
		griglia.add(lNumeroPosti, 1, 10);
		griglia.add(tCilindrata, 2, 11);
		griglia.add(lCilindrata, 1, 11);
		griglia.add(tLunghezza, 2, 12);
		griglia.add(lLunghezza, 1, 12);	

		griglia.add(bAggiungi, 1, 13,2,1);
		bAggiungi.setPrefWidth(100);
		
		Scene scena = new Scene(griglia);
	    finestra.setTitle("ciao");
	    finestra.setScene(scena);
	    finestra.show();
	    
	    boxMezzi.setOnAction(e -> selezionaMezzo());
	    bAggiungi.setOnAction(e -> aggiungiAllaLista());
	}		
	public void aggiungiAllaLista() {
		
	}
	
	public void selezionaMezzo() {
		String strMezzo = boxMezzi.getValue();
		switch (strMezzo) {
		case "Bicicletta":
			break;
		case "Skateboard":
			break;
		case "Automobile":
			break;
		case "Motocicletta":
			break;
		}
	}
	public static void main(String[] args) {
	    launch(args);
	}	
}
