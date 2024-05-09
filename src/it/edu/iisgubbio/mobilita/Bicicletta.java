package it.edu.iisgubbio.mobilita;

public class Bicicletta extends AMuscoli{
	private int numRapporti;
	private double peso;
	
	public Bicicletta(double costo, double peso) {
		super("Bicicletta", costo, "quadricipiti");
		this.peso = peso;
	}
	@Override
	public String toString() {
		String strLeggera = "";
		if(leggera()) {
			strLeggera = "(leggera)";
		}
		return "Bicicletta: pesa " + peso + "kg " + strLeggera+ " costa"  + costo + "(ha "+ numRapporti +" rapporti)";
	}
	
	public boolean leggera() {
		return peso<10;
	}
	
	public int getNumeroDiRapporti() {
		return numRapporti;
	}
	
	public void setNumeroDiRapporti(int n) {
		numRapporti=n;
	}
	
	public double getPeso() {
		return peso;
	}
	
	public void setPeso(double d) {
		peso=d;
	}
}
