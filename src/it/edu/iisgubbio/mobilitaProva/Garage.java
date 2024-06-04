package it.edu.iisgubbio.mobilitaProva;

import it.edu.iisgubbio.mobilita.Aereo;
import it.edu.iisgubbio.mobilita.Automobile;
import it.edu.iisgubbio.mobilita.Barca;
import it.edu.iisgubbio.mobilita.Bicicletta;
import it.edu.iisgubbio.mobilita.Deltaplano;
import it.edu.iisgubbio.mobilita.MezzoDiTrasporto;
import it.edu.iisgubbio.mobilita.Motocicletta;
import it.edu.iisgubbio.mobilita.Motoslitta;
import it.edu.iisgubbio.mobilita.Skateboard;
import javafx.application.Application;
import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Garage extends Application{
	ListView <MezzoDiTrasporto> listWiewGarage = new ListView<MezzoDiTrasporto>();
	Button bAggiungi = new Button("aggiungi");
	
	TextField tNome = new TextField();
	TextField tCosto = new TextField();
	TextField tParametro3 = new TextField( );
	TextField tParametro4 = new TextField();
	TextField tParametro5 = new TextField();
	TextField tParametro6 = new TextField();
	TextField tParametro7 = new TextField();
	GridPane griglia = new GridPane();
	
	Label lNome = new Label("nome");
	Label lCosto = new Label("costo");
	Label lParametro3 = new Label("");
	Label lParametro4 = new Label("");
	Label lParametro5 = new Label("");
	Label lParametro6 = new Label("");
	Label lParametro7 = new Label("");
	
	ComboBox<String> boxMezzi = new ComboBox<>();
	public void start(Stage finestra) {
		
		boxMezzi.getItems().add("Automobile");
		boxMezzi.getItems().add("Bicicletta");
		boxMezzi.getItems().add("Skateboard");
		boxMezzi.getItems().add("Motocicletta");
		boxMezzi.getItems().add("Barca");
		boxMezzi.getItems().add("Motoslitta");
		boxMezzi.getItems().add("Deltaplano");
		boxMezzi.getItems().add("Aereo");
		
		griglia.setPadding(new Insets(5, 5, 5, 5));
		griglia.setHgap(15); 
		griglia.setVgap(15);
		
		griglia.add(listWiewGarage, 0, 0,1,8);
		listWiewGarage.setPrefSize(200, 100);
		griglia.add(boxMezzi, 1, 0);
		griglia.add(lNome, 1, 1);
		griglia.add(tNome, 2, 1);
		griglia.add(lCosto, 1, 2);
		griglia.add(tCosto, 2, 2);
		griglia.add(lParametro3, 1, 3);
		griglia.add(tParametro3, 2, 3);
		griglia.add(lParametro4, 1, 4);
		griglia.add(tParametro4, 2, 4);
		griglia.add(lParametro5, 1, 5);
		griglia.add(tParametro5, 2, 5);
		griglia.add(lParametro6, 1, 6);
		griglia.add(tParametro6, 2, 6);
		griglia.add(lParametro7, 1, 7);
		griglia.add(tParametro7, 2, 7);
		tParametro3.setDisable(true);
		tParametro4.setDisable(true);
		tParametro5.setDisable(true);
		tParametro6.setDisable(true);
		tParametro7.setDisable(true);

		griglia.add(bAggiungi, 1, 8,2,1);
		bAggiungi.setPrefWidth(100);
		Scene scena = new Scene(griglia);
	    finestra.setTitle("ciao");
	    finestra.setScene(scena);
	    finestra.show();
	    listWiewGarage.addEventHandler(MouseEvent.MOUSE_CLICKED, e->reversLista(e));
	    
	    boxMezzi.setOnAction(e -> selezionaMezzo());
	    bAggiungi.setOnAction(e -> aggiungiAllaLista());
	}		
	private void reversLista(MouseEvent e){
		System.out.println(e.getClickCount());
		if(e.getClickCount()>=2) {
			int indiceSelezionato = listWiewGarage.getSelectionModel().getSelectedIndex();
			MezzoDiTrasporto x = listWiewGarage.getItems().get(indiceSelezionato);
			System.out.println(x);
		}
			
	}
	public void aggiungiAllaLista() {
		//variabili utilizzate nel gioco		
		String strMezzo = boxMezzi.getValue();
		//Mezzo di trasporto
		String nome="";
		double costo=0;
		//aMuscoli
		String muscoiCoinvolti="";
		//bicicletta
		int numeroRapporti=0;
		double peso=0;
		//Skate
		int lunghezza=0;
		//aMotore
		double rumorosita=0;
		String carburante="";
		//terrestre
		double velocita=0;
		//macchina
		String targa="";
		int numeroPorte=0;
		//moto
		int numeroPosti=0;
		double cilindrata=0;
		//barca
		int numeroDiRemi=0;
		boolean singoloRemo = false;
		//motoslitta
		double temperaturaMinima=0;
		//deltaplano
		double quotaMassima=0;
		//numero posti e stata gia creata
		//aereo
		boolean reazione =false;
		int distanzaMassima=0;
		
		
		switch (strMezzo) {
		case "Bicicletta":
			nome = tNome.getText();
			costo = Double.parseDouble(tCosto.getText());
			muscoiCoinvolti = tParametro3.getText();
			numeroRapporti = Integer.parseInt(tParametro4.getText());
			peso = Double.parseDouble(tParametro5.getText());
			Bicicletta bici = new Bicicletta(costo, peso);
			bici.setNumeroDiRapporti(numeroRapporti);
			bici.setMuscoliCoinvolti(muscoiCoinvolti);
			listWiewGarage.getItems().add(bici);
			break;
		case "Skateboard":
			nome = tNome.getText();
			costo = Double.parseDouble(tCosto.getText());
			muscoiCoinvolti = tParametro3.getText();
			lunghezza = Integer.parseInt(tParametro4.getText());
			Skateboard skateboard = new Skateboard(nome, costo, lunghezza);
			skateboard.setMuscoliCoinvolti(muscoiCoinvolti);
			listWiewGarage.getItems().add(skateboard);
			break;
		case "Automobile":
			nome = tNome.getText();
			costo = Double.parseDouble(tCosto.getText());
			rumorosita = Double.parseDouble(tParametro3.getText());
			carburante = tParametro4.getText();
			velocita = Integer.parseInt(tParametro5.getText());
			targa = tParametro6.getText();
			numeroPorte = Integer.parseInt(tParametro7.getText());
			Automobile auto = new Automobile(nome, costo, numeroPorte);
			auto.setCarburante(carburante);
			auto.setVelocita(velocita);
			auto.setTarga(targa);
			listWiewGarage.getItems().add(auto);
			break;
		case "Motocicletta":
			nome = tNome.getText();
			costo = Double.parseDouble(tCosto.getText());
			rumorosita = Double.parseDouble(tParametro3.getText());
			carburante = tParametro4.getText();
			velocita = Integer.parseInt(tParametro5.getText());
			cilindrata = Integer.parseInt(tParametro6.getText());
			numeroPosti = Integer.parseInt(tParametro7.getText());
			Motocicletta moto = new Motocicletta(nome, costo, cilindrata);
			moto.setCarburante(carburante);
			moto.setVelocita(velocita);
			listWiewGarage.getItems().add(moto);
			break;
		case "Barca":
			nome = tNome.getText();
			costo = Double.parseDouble(tCosto.getText());
			muscoiCoinvolti = tParametro3.getText();
			numeroDiRemi = Integer.parseInt(tParametro4.getText());
			singoloRemo = Boolean.getBoolean(tParametro5.getText());
			Barca barca = new Barca(nome, costo, numeroRapporti, singoloRemo);
			listWiewGarage.getItems().add(barca);
			break;
		case "Motoslitta":
			nome = tNome.getText();
			costo = Double.parseDouble(tCosto.getText());
			rumorosita = Double.parseDouble(tParametro3.getText());
			carburante = tParametro4.getText();
			velocita = Integer.parseInt(tParametro5.getText());
			temperaturaMinima = Double.parseDouble(tParametro6.getText());
			Motoslitta motoslitta = new Motoslitta(nome, costo, velocita);
			motoslitta.setTemperaturaMinima(temperaturaMinima);
			listWiewGarage.getItems().add(motoslitta);
			break;
		case "Deltaplano":
			nome = tNome.getText();
			costo = Double.parseDouble(tCosto.getText());
			costo = Double.parseDouble(tCosto.getText());
			rumorosita = Double.parseDouble(tParametro3.getText());
			carburante = tParametro4.getText();
			quotaMassima = Double.parseDouble(tParametro5.getText());
			numeroPosti = Integer.parseInt(tParametro6.getText());
			Deltaplano deltaplano = new Deltaplano(nome, costo, numeroPosti);
			listWiewGarage.getItems().add(deltaplano);
			break;
		case "Aereo":
			nome = tNome.getText();
			costo = Double.parseDouble(tCosto.getText());
			costo = Double.parseDouble(tCosto.getText());
			rumorosita = Double.parseDouble(tParametro3.getText());
			carburante = tParametro4.getText();
			quotaMassima = Double.parseDouble(tParametro5.getText());
			reazione = Boolean.getBoolean(tParametro6.getText());
			distanzaMassima = (int) Double.parseDouble(tParametro7.getText());
			Aereo aereo = new Aereo(nome);
			aereo.setDistanzaMassima(distanzaMassima);
			listWiewGarage.getItems().add(aereo);
			break;
		}
	}
	
	public void selezionaMezzo() {
		String strMezzo = boxMezzi.getValue();
		tParametro3.setDisable(true);
		tParametro4.setDisable(true);
		tParametro5.setDisable(true);
		tParametro6.setDisable(true);
		tParametro7.setDisable(true);
		tCosto.setText("");
		tNome.setText("");
		tParametro3.setText("");
		tParametro5.setText("");
		tParametro6.setText("");
		tParametro7.setText("");
		
		lParametro3.setText("");
		lParametro4.setText("");
		lParametro5.setText("");
		lParametro6.setText("");
		lParametro7.setText("");
		
		switch (strMezzo) {
		case "Bicicletta":
			lParametro3.setText("muscoli coinvolti");
			lParametro4.setText("Numero rapporti");
			lParametro5.setText("peso");
			
			tParametro3.setDisable(false);
			tParametro4.setDisable(false);
			tParametro5.setDisable(false);
			break;
		case "Skateboard":
			lParametro3.setText("muscoli coinvolti");
			lParametro4.setText("lunghezza");
			
			tParametro3.setDisable(false);
			tParametro4.setDisable(false);
			break;
		case "Automobile":
			lParametro3.setText("rumorosita");
			lParametro4.setText("carburante");
			lParametro5.setText("velocità");
			lParametro6.setText("targa");
			lParametro7.setText("numeroPorte");
			
			tParametro3.setDisable(false);
			tParametro4.setDisable(false);
			tParametro5.setDisable(false);
			tParametro6.setDisable(false);
			tParametro7.setDisable(false);
			break;
		case "Motocicletta":
			lParametro3.setText("rumorosita");
			lParametro4.setText("carburante");
			lParametro5.setText("velocità");
			lParametro6.setText("cilindrata");
			lParametro7.setText("numeroPosti");
			
			tParametro3.setDisable(false);
			tParametro4.setDisable(false);
			tParametro5.setDisable(false);
			tParametro6.setDisable(false);
			tParametro7.setDisable(false);
			break;
		case "Barca":
			lParametro3.setText("muscoli coinvolti");
			lParametro4.setText("numero di remi");
			lParametro5.setText("singolo remo");
			
			tParametro3.setDisable(false);
			tParametro4.setDisable(false);
			tParametro5.setDisable(false);
			break;
		case "Motoslitta":
			lParametro3.setText("rumorosita");
			lParametro4.setText("carburante");
			lParametro5.setText("velocità");
			lParametro6.setText("temperatura minima");
			
			tParametro3.setDisable(false);
			tParametro4.setDisable(false);
			tParametro5.setDisable(false);
			tParametro6.setDisable(false);
			break;
		case "Deltaplano":
			lParametro3.setText("rumorosita");
			lParametro4.setText("carburante");
			lParametro5.setText("Quota massima");
			lParametro6.setText("numero posti");
			
			tParametro3.setDisable(false);
			tParametro4.setDisable(false);
			tParametro5.setDisable(false);
			tParametro6.setDisable(false);
			break;
		case "Aereo":
			lParametro3.setText("rumorosita");
			lParametro4.setText("carburante");
			lParametro5.setText("Quota massima");
			lParametro6.setText("reazione");
			lParametro7.setText("distanza massima");
			
			tParametro3.setDisable(false);
			tParametro4.setDisable(false);
			tParametro5.setDisable(false);
			tParametro6.setDisable(false);
			tParametro7.setDisable(false);
		}
	}
	public static void main(String[] args) {
	    launch(args);
	}	
}
