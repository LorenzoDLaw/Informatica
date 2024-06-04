package it.edu.iisgubbio.mobilita;

public class Aereo extends Volante{
	private boolean reazione;
	private double distanaMassima=0; //espressa in km
	
	public Aereo (String nome) {
		super(nome, 10000);
		this.nome = nome;
	}

	public String toString() {
		return "Aereo " + nome +" percorrenza massima " + distanaMassima;
	}
	
	public boolean puoRaggiungere(int dist) {
		return dist<distanaMassima;
	}
	
	public boolean getReazione() {
		return reazione;
	}
	
	public void setReazione(boolean reazione) {
		 this.reazione = reazione;
	}
	
	public double getDistanaMassima() {
		return distanaMassima;
	}
	
	public void setDistanzaMassima(double d) {
		distanaMassima = d;
	}
}
