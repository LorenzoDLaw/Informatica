package it.edu.iisgubbio.vivaio;

public class Bonsai extends Pianta{
	private int eta;
	
	public Bonsai (String n, double c, int e) {
		super(n, c);
		this.eta = e;
	}
	
	public int getEta() {
		return eta;
	}
	public void setEta(int e) {
		eta=e;
	}
	
	public boolean vecchio() {
		return eta>20;
	}

	@Override
	public String toString() {
		String strVecchio ="";
		if(vecchio()) {
			strVecchio = "vecchio";
		}else {
			strVecchio = "giovane";
		}
		return "Bonsai " + nome + "di costo " +costo + " euro ha " + eta + " anni (" +strVecchio+")";
	}
	
	
}
