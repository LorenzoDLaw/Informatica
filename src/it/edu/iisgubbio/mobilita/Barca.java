package it.edu.iisgubbio.mobilita;

public class Barca extends AMuscoli{
	private int numeroDiRemi;
	private boolean singoloRemo;
	
	public Barca(String nome, double costo, int numeroRemi, boolean singoloRemo) {
		super(nome, costo, "quadricipiti");
		this.numeroDiRemi = numeroDiRemi;
		this.singoloRemo = singoloRemo;
	}

	@Override
	public String toString() {
		return "Barca " + nome + ", [singoloRemo=" + singoloRemo + "]";
	}
	
	public boolean getSingoloRemo() {
		return singoloRemo;
		
	}
	public int getNumeroDiRemi() {
		return numeroDiRemi;	
	}
	public int numeroVogatori() {
		int n;
		if(singoloRemo) {
			n=numeroDiRemi;
		}else {
			n=numeroDiRemi/2;
		}
		return n;
	}
}
