package it.edu.iisgubbio.negozio;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Palestra extends Application{
	Label lKm = new Label("Inserire Km");
	TextField tKm = new TextField();
	RadioButton rbCorsa = new RadioButton("Corsa");
	RadioButton rbNuoto = new RadioButton("Corsa");
	RadioButton rbBici = new RadioButton("Corsa");
	Label lSovreppeso = new Label("Oggetti sovrappeso");
	CheckBox ckBrac = new CheckBox("braccialetti");
	CheckBox ckCav = new CheckBox("Cavigliere");
	Button bCalorie = new Button("Calcola calorie");
	Label lTotale = new Label();
	Image iNuoto = new Image(getClass().getResourceAsStream("Nuoto.jpg"));
 	Image iCorsa = new Image(getClass().getResourceAsStream("corsa.jpg"));
 	Image iBici = new Image(getClass().getResourceAsStream("bici.jpg"));
 	ImageView iwMostraC = new ImageView();
 	ImageView iwMostraB = new ImageView();	 	
 	ImageView iwMostraN = new ImageView();
 	
public void start(Stage finestra) {
		GridPane griglia = new GridPane();
		griglia.setId("sfondo");
		griglia.setPadding(new Insets(5, 5, 5, 5));
		griglia.setHgap(15); 
		griglia.setVgap(15);
		
		ToggleGroup attivita = new ToggleGroup();
		rbBici.setToggleGroup(attivita);
		rbCorsa.setToggleGroup(attivita);
		rbNuoto.setToggleGroup(attivita);
		
		griglia.add(lKm, 0, 0);
		lKm.setPrefWidth(125);
        griglia.add(tKm, 1, 0);
		griglia.add(rbCorsa, 0, 1);
		griglia.add(rbNuoto, 0, 2);
		griglia.add(rbBici, 0, 3);
		griglia.add(lSovreppeso, 1, 1);
		griglia.add(ckBrac, 1, 2);
		griglia.add(ckCav, 1, 3);
		griglia.add(bCalorie, 0, 4,2,1);
		bCalorie.setMaxWidth(100000);
		griglia.add(lTotale, 0,5);
		lTotale.setMaxWidth(100);
		griglia.add(iwMostraB, 1, 5);
		griglia.add(iwMostraC, 1, 5);
		griglia.add(iwMostraN, 1, 5);
		
		Scene scena = new Scene(griglia);
		scena.getStylesheets().add("it/edu/iisgubbio/negozio/Palestra.css");			
		finestra.setTitle("palestra!");
	    finestra.setScene(scena);
	    finestra.show();
		
	    bCalorie.setOnAction(e -> calcCalorie()); 
	   		
	}
	public void calcCalorie() {
		String strKm = tKm.getText();
		double km =  Double.parseDouble(strKm);
		double attività;
		double totale;	
		if(rbCorsa.isSelected()){
			attività = km * 12;
			totale = attività;
			if((ckBrac.isSelected()) && (ckCav.isSelected())){
				totale = attività * 1.18 * 1.35;
				lTotale.setText(""+totale+"Kcal");
			}else 
				if (ckCav.isSelected()) {
				totale = attività * 1.35;
				lTotale.setText(""+totale+"Kcal");
			}else 
				if(ckBrac.isSelected()){
				totale = attività * 1.18;
				lTotale.setText(""+totale+"Kcal");
			}
		}
		if(rbBici.isSelected()){
			attività = km * 7;
			totale = attività;
			if((ckBrac.isSelected()) && (ckCav.isSelected())){
				totale = attività * 1.18 * 1.35;
				lTotale.setText(""+totale+"Kcal");
			}else if (ckCav.isSelected()) {
				totale = attività * 1.35;
				lTotale.setText(""+totale+"Kcal");
			}else if(ckBrac.isSelected()){
				totale = attività * 1.18;
				lTotale.setText(""+totale+"Kcal");
			}
			
		}
		if(rbNuoto.isSelected()){
			ImageView iwMostraN = new ImageView(iNuoto);
			attività = km * 21;
			totale = attività;
			if((ckBrac.isSelected()) && (ckCav.isSelected())){
				totale = attività * 1.18 * 1.35;
				lTotale.setText(""+totale+"Kcal");
			}else if (ckCav.isSelected()) {
				totale = attività * 1.35;
				lTotale.setText(""+totale+"Kcal");
			}else if(ckBrac.isSelected()){
				totale = attività * 1.18;
				lTotale.setText(""+totale+"Kcal");
			}
		}
		
	}
	
	public static void main(String[] args) {
	    launch(args);
	  }

}
