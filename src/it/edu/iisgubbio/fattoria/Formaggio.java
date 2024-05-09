package it.edu.iisgubbio.fattoria;

public class Formaggio extends Prodotto{
	private int meseStagionaura;
	boolean dop;
	public Formaggio (String nome, double prezzoKg, int stagionatura, boolean dop) {
		super(nome, prezzoKg);
		this.meseStagionaura = stagionatura;
		this.dop=dop;
	}
	public Formaggio(String nome, double prezzoKg, int stagionatura) {
		super(nome, prezzoKg);
		this.meseStagionaura = stagionatura;
		dop = false;
	}

	public int getMeseStagionaura() {
		return meseStagionaura;
	}
	public void setMeseStagionaura(int meseStagionaura) {
		this.meseStagionaura = meseStagionaura;
	}
	public boolean isDop() {
		return dop;
	}
	public void setDop(boolean dop) {
		this.dop = dop;
	}
	
	public String toString() {
		if (dop) {
			if (meseStagionaura>0) {
				return super.toString() + " stagionatura: " + meseStagionaura + ", è dop.";
			}else {
				return super.toString() + ", è dop";
			}	
		}else {
			if (meseStagionaura>0) {
				return super.toString() + " stagionatura: " + meseStagionaura + ", non è dop.";
			}else {
				return super.toString() + ", non è dop.";
			}
		}
	}
	
	//nome prezzo al kl periodo di stagionature 
	//nome prezzo al kl periodo di stagionatura e dop
	//taleggio 25 al kl dop stagiona 1 mese
	// ricotta non stagiona 4 al k 
}
