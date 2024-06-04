package it.edu.iisgubbio.vivaio;

public class Fiore extends Pianta{
	protected String colore;
	protected int stagioneFioritura;
	
	public Fiore (String n, double c, String col, String s) {
		super(n,c);
		this.colore = col;	
		switch (s) {
		case "privamera":
			stagioneFioritura = 1;
			break;
		case "estate":
			stagioneFioritura = 2;
			break;
		case "autunno": 
			stagioneFioritura = 3;
			break;
		case "inverno":
			stagioneFioritura = 4;
			break;
		}
	}
	public String getColore() {
		return colore;
	}
	
	public void setColore(String nome) {
		colore = nome;
	}
	
	public String getstagioneFioritura() {
		return nome;
	}
	
	public void setstagioneFioritura(String nome) {
		switch (nome) {
		case "privamera":
			stagioneFioritura = 1;
			break;
		case "estate":
			stagioneFioritura = 2;
			break;
		case "autunno": 
			stagioneFioritura = 3;
			break;
		case "inverno":
			stagioneFioritura = 4;
			break;
		}
	}
	
}
