package it.edu.iisgubbio.mobilita;

public class AMuscoli extends MezzoDiTrasporto{
	String muscoliCoinvolti;
	private String MuscoliCoinvolti() {
		return null;
	}
	
	public AMuscoli() {
		super();
	}
	
	public AMuscoli(String nome, double costo, String muscoliCoinvolti) {
		super(nome, costo);
		this.muscoliCoinvolti = muscoliCoinvolti;	
	}
	
	public boolean parteAlta() {
		String muscolo = getMuscoliCoinvolti();
		boolean parteAlta = false;
		if(muscolo.equals("tricipite") || muscolo.equals("trapezio") || 
				muscolo.equals("dorsali") || muscolo.equals("petto"))  {
			parteAlta=true;
		}else {
			parteAlta = false;
		}
		return parteAlta;
	}
	@Override
	public String toString() {
		return "Veicoli a muscoli: "+ nome + ", " + costo + "€, (usa " + muscoliCoinvolti + ")";
	}
	
	public String getMuscoliCoinvolti() {
		return muscoliCoinvolti;
	}
	public void setMuscoliCoinvolti(String m) {
		if (m.toLowerCase().equals(m)) {
			muscoliCoinvolti=m;
		}
		
	}
}
