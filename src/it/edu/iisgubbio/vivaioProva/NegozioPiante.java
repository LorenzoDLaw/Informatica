package it.edu.iisgubbio.vivaioProva;

import it.edu.iisgubbio.vivaio.Bonsai;
import it.edu.iisgubbio.vivaio.Fiore;
import it.edu.iisgubbio.vivaio.Pianta;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class NegozioPiante extends Application {
	GridPane griglia = new GridPane();
	ListView<Pianta> scelta = new ListView<>();
	ListView<Pianta> carrello = new ListView<>();
	Button bAggiungi = new Button("Calcola il totale");
	Label lTotale = new Label("Totale :");
	public void start(Stage finestra) {
		griglia.add(scelta, 0, 0, 1,15);
		griglia.add(carrello, 1, 0,1,15);
		griglia.add(bAggiungi, 1, 16);
		griglia.add(lTotale, 1, 17);

		bAggiungi.setPrefWidth(270);
		scelta.addEventHandler(MouseEvent.MOUSE_CLICKED, e->scelta());
		carrello.addEventHandler(MouseEvent.MOUSE_CLICKED, e->remove(e));

		griglia.setPadding(new Insets(10, 10, 10, 10));
		griglia.setHgap(15);
		griglia.setVgap(10);
		
		Fiore margherita = new Fiore("Margherita", 5, "Bianco", "Estate");
		scelta.getItems().add(margherita);
		
		Fiore rosa = new Fiore("Rosa", 20, "Rosa", "Primavera");
		scelta.getItems().add(rosa);
		
		Bonsai acero = new Bonsai("Acero", 19, 15);
		scelta.getItems().add(acero);
		
		Bonsai pino = new Bonsai("Pino", 6, 20);
		scelta.getItems().add(pino);
		
		bAggiungi.setOnAction(e-> costoTot());
		
		Scene scena = new Scene(griglia);
		finestra.setTitle("Negozio Piante");
		finestra.setScene(scena);
		finestra.show();
	}

	private void remove(MouseEvent e) {
		if(e.getClickCount()==2) {
			int index=carrello.getSelectionModel().getSelectedIndex();
			carrello.getItems().remove(index);
			costoTot();
		}
	}
	private void costoTot() {
		lTotale.setText(totale()+"");
	}

	public void scelta() {
		Pianta appoggioNome=scelta.getSelectionModel().getSelectedItem();
		carrello.getItems().add(appoggioNome);
	}
	
	public double totale() {
		double somma=0;
		for (int i=0; i< carrello.getItems().size(); i++) {
			somma += carrello.getItems().get(i).getCosto();
		}
		return somma;
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}