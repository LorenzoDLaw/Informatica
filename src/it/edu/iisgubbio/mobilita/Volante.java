package it.edu.iisgubbio.mobilita;

public class Volante extends AMotore{
	private double quotaMassima;
	
	public Volante() {
		
	}
	public Volante(String nome, double costo) {
		super();
		this.nome = nome;
		this.costo= costo;
	}
	
	public String toString() {
		return "Mezzo volante: "+ nome +"("+ costo + ") vola fino a "
				+ quotaMassima+"m di quota";
	}
	
	public boolean isNecessarioPressurizzazione () {
		return quotaMassima>300;
	}
	
	public void setQuotaMassima(double quota) {
		quotaMassima=quota;
	}
	public double getQuotaMassima() {
		return quotaMassima;
	}
}
