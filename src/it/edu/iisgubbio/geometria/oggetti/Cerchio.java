package it.edu.iisgubbio.geometria.oggetti;

public class Cerchio {
	double raggio;
	static double piGreco = 3.14;
	public Cerchio (double raggio){
		this.raggio=raggio;
	}
	public double calcolaArea() {
		double area= piGreco* (raggio *raggio);
		return area;
	}
}
