package it.edu.iisgubbio.mobilita;

public class Skateboard extends AMuscoli{
	int lunghezza = 60;
	private int lughezza () {
		return lunghezza;
	}
	public Skateboard (String nome, double costo, String muscoliCoinvolti) {
		super(nome, costo, muscoliCoinvolti);
		this.costo = costo;
		this.nome = nome;
	}
	
	public Skateboard (String nome, double costo, String muscoliCoinvolti, int lunghezza) {
		super(nome, costo, muscoliCoinvolti);
		this.lunghezza= lunghezza;
	}
	@Override
	public String toString() {
		String longBoard = "";
		if(longboard()) {
			longBoard = "loangBoard";
		}
			return "Skateboard " + longBoard + ": lungo " + lunghezza + "cm, costa " + costo + "€";
	}
	
	public boolean longboard() {
		return lunghezza>80;
	}
	
	public int getLunghezza() {
		return lunghezza;
	}
	public void setLunghezza(int l) {
		lunghezza=l;
	}
}
