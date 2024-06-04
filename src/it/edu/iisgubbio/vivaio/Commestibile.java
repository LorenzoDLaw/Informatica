package it.edu.iisgubbio.vivaio;

public class Commestibile extends Pianta{
	private int quantita;
	private String stagioneProduzione;
	
	public Commestibile(String n, double c) {
		super(n, c);
		this.nome=n;
		this.costo=c;
	}  
	public void setQuantita(int q) {
		quantita=q;
	}
	
	public int getQuantita() {
		return quantita;
	}
	
	public void setStagioneProduzione(String s) {
		stagioneProduzione=s;
	}
	
	public String getStagioneProduzione() {
		return stagioneProduzione;
	}
	
	public String toString() {
		return "Pianta " + nome + "con a disposizoine " + quantita + "unita, di produzione nel" + stagioneProduzione;
	}
}
