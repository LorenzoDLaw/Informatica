package it.edu.iisgubbio.mobilita;

public class Motocicletta extends Terrestre{
	private double cilindrata;
	private int numeroPosti;
	
	public Motocicletta(String nome, double costo, double cilindrata) {
		super();
		this.nome=nome;
		this.cilindrata=cilindrata;
	}

	@Override
	public String toString() {
		return "Motocicletta: " + nome + " " + cilindrata + " di Giovanni";
	}
	
	public boolean puoTrasportare(int persone) {
		return persone<=numeroPosti;
	}
	
	public double getcilindrata() {
		return cilindrata;
	}
	
	public void setCilindrata(double c) {
		cilindrata=c;
	}
	
	public int getNumeroPosti() {
		return numeroPosti;
	}
	
	public void setNumeroPosti(int n) {
		numeroPosti=n;
	}
}
