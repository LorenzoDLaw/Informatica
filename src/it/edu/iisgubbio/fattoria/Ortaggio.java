package it.edu.iisgubbio.fattoria;

public class Ortaggio extends Prodotto{
	boolean biologico;
	
	public Ortaggio (String nome, double prezzo, boolean biologico) {
		super(nome, prezzo);
		this.biologico = biologico;
	}
	public String toString() {
		
		if(biologico) {
			return super.toString() + "Ortaggio bilogico";
		}else {
			return super.toString() + "Ortaggio non bilogico";
		}
		
	}
	
}
