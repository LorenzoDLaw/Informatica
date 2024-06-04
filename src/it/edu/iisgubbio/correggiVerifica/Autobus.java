package it.edu.iisgubbio.correggiVerifica;

public class Autobus {
	protected String targa;
	protected String modello;
	protected int numeroPosti;
	protected double kmPerLitro;
	
	
	public Autobus() {
		super();
	}
	
	public Autobus (String targa, String modello, int numeroPosti, double kmPerLitro ) {
		this.targa = targa;
		this.modello=modello;
		this.numeroPosti=numeroPosti;
		this.kmPerLitro=kmPerLitro;
	}
	
	public boolean puoTrasportare (int numeroPasseggeri) {
		return numeroPasseggeri<numeroPosti;
	}
	
	public double litriTotali(double km) {
		return km/kmPerLitro;
	}
	
	public String getTarga(){
		return targa;
	}
	public void setTarga(String t) {
		targa=t;
	}
	
}
