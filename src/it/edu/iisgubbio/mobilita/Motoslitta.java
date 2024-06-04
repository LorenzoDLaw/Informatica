package it.edu.iisgubbio.mobilita;

public class Motoslitta extends Terrestre{
	private double temperaturaMinima=-20;
	
	public Motoslitta (String nome, double costo, double velocita) {
		super();
		this.nome=nome;
		this.costo=costo;
	}

	public String toString() {
		return "Motoslitta: motoslitta di " + nome +" funziona fino a " + temperaturaMinima + "°C";
	}
		
	public boolean puoFunzionare(int temperatura) {
		return temperatura>temperaturaMinima; 
	}
	public double getTemperaturaMinima() {
		return temperaturaMinima;
	}
	
	public void setTemperaturaMinima(double t) {
		 temperaturaMinima=t;
	}
}
