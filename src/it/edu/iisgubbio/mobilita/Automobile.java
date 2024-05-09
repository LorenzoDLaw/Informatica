package it.edu.iisgubbio.mobilita;

public class Automobile extends Terrestre {
	private String targa;
	private int numeroPorte;
	
	public Automobile(String nome, double costo, int numeroPorte) {
		super();
		this.nome = nome;
		this.numeroPorte = numeroPorte;
	}
	
	public String toString() {
		return "Motocicletta: " + nome + " [" + targa + "]";
	}
	
	public String getTarga() {
		return targa;
	}
	public String setTarga(String t) {
		return targa=t;
	}
	
	public int getPorte() {
		return numeroPorte;
	}
	public int setPorte(int p) {
		return numeroPorte=p;
	}
}
