package it.edu.iisgubbio.mobilita;

public class Terrestre extends AMotore{
	private double velocita;
	
	public Terrestre() {
		super();
	}

	@Override
	public String toString() {
		return "Veicolo terrestre a motore: "+ nome +", va a " + getCarburante() + " e al\r\n"
				+ "massimo percorre " + velocita + "km all'ora";
	}
	
	public double tempoDiPercorrenza(int distanza) {
		return distanza;
	}
	
	public double getVelocita() {
		return velocita;
	}
	public void setVelocita(double v) {
		velocita=v;
	}
}
