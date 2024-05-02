package it.edu.iisgubbio.animali.cani;

public class Cuccia {
	private boolean interno;
	private double prezzo;
	private int numPosti;
	private String colore;
	public Cuccia(boolean interno, double prezzo, int numeroPosti, String colore) {
		this.interno = interno;
		this.prezzo= prezzo;
		this.numPosti = numeroPosti;
		this.colore = colore;
	}

	public boolean interno() {
		return interno;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public int getNumPosti() {
		return numPosti;
	}
	public void setNumeroPosti(int numeroPosti) {
		if (numeroPosti>2) {
			numeroPosti=2;
		}
	}
	
	public String toString() {
		String s = "cuccia " + colore + ", ";
		if (interno==true) {
			s+= "da interno";
		}
		s+= ", costa "+ prezzo + ", ha " + numPosti + " posti" ;
		return s;
	}
	public String getColore() {
		return colore;
	}
}
