package it.edu.iisgubbio.mobilita;

public class MezzoDiTrasporto {
	double costo;
	String nome;
	
	public MezzoDiTrasporto() {
		
	}
	
	public MezzoDiTrasporto(String nome, double costo) {
		this.nome = nome;
		this.costo = costo;
	}

	@Override
	public String toString() {
		return "Mezzo di trasporto: " + nome + ", " + costo + "€";
	}
	
	public double importaRata(int numeroRate){
		double importo = 0;
		importo = costo/numeroRate;
		return importo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String setNome(String n) {
		return this.nome = n;
	}
	
	public double getCosto() {
		return costo;
	}
	
	public double setCosto(double c) {
		return this.costo = c;
	}
	
}
