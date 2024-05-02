package it.edu.iisgubbio.oggetti.tempo;

public class Orario {
	private int ora;
	private int minuto;
	private int secondo;
	
	public Orario(int ora, int minuto, int secopndo) {
		super();
		this.ora = ora;
		this.minuto = minuto;
		this.secondo = secopndo;
	}
	
	public void addOre (int addOre) {
		ora += addOre;
	}
	public void addMinuti(int addMinuti) {
		minuto += addMinuti;
		if (minuto>=60) {
			addOre(minuto/60);
			minuto = minuto%60;
		}
	}
	public void addSecondi (int addSecondi) {
		secondo +=addSecondi;
		if (secondo>=60) {
			addMinuti(secondo/60);
			secondo = secondo%60;
		}
	}
	public void addOrario(Orario daAggiungere) {
		addOre(daAggiungere.ora);
		addMinuti(daAggiungere.minuto);
		addSecondi(daAggiungere.secondo);
	}
	
	public void tic() {
		addSecondi(1);
	}
	
	public String toString() {
		String strOrario="";
		
		if(ora>=9) {
			strOrario += "" + ora;
		}else {
			strOrario += "0" + ora;
		}
		strOrario += ":";
		
		if(minuto>=9) {
			strOrario += "" + minuto;
		}else {
			strOrario += "0" + minuto;
		}
		strOrario += ":";
		
		if(secondo>=9) {
			strOrario += ""+secondo;
		}else {
			strOrario += "0"+secondo;
		}
		
		return strOrario;
	}
	
}
