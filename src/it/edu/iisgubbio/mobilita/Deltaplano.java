package it.edu.iisgubbio.mobilita;

public class Deltaplano {
	private int numeroPosti;
	
	public Deltaplano(String nome, double costo, int numeroPosti) {
		super();
		this.numeroPosti = numeroPosti;
	}

	public String toString() {
		if (accettaPasseggero()==false) {
			return "Deltaplano: monoposto";
		}
		return "Deltaplano: "+ numeroPosti + " posti";
	}
	
	public boolean accettaPasseggero(){
		return numeroPosti>1;
	}
	
	public int getNumeroPosti() {
		return numeroPosti;
	}
	
	public void setNumeroPosti (int np) {
		numeroPosti = np;
	}
}

