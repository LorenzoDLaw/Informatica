package it.edu.iisgubbio.animali.cani;

public class Cane {
	public String nome;
	public String razza;
	public int annoNascita;
	int cibo;
	String nomeProprietario;
	
	public Cane(String nome, int annoNascita) {
		this.nome = nome;
		this.annoNascita = annoNascita; 
	}
	public Cane() {
		
	}
	public String toString() {
		return nome+ " ("+ razza + ")";
	}
	public String getNome() {
		return nome;
	}
	
	public void setNome(String x) {
		nome = x;
	}
	
	public String getRazza(String razza) {
		return razza;
	}
}
