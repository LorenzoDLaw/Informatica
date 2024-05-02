package it.edu.iisgubbio.fattoria;

public class Prodotto {
	protected String nome;
	protected double prezzoKg;
	
	
	public Prodotto(String nome, double prezzoKg) {
		super();
		this.nome = nome;
		this.prezzoKg = prezzoKg;
	}
	
	public Prodotto() {
		super();
	}
	@Override
	public String toString() {
		return "Prodotto [nome=" + nome + ", prezzoKg=" + prezzoKg + "]";
	}
	
	public double calcolaPrezzo(double peso){
		double prezzoTot=0;
		prezzoTot = prezzoKg*peso;
		return prezzoTot;
	}
	
	
	
}
