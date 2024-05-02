package it.edu.iisgubbio.fattoria;

public class Fattoria {

	public static void main(String[] args) {
		Prodotto carote = new Prodotto("carote", 2.5);
		System.out.println(carote);
		double spesaCarote = carote.calcolaPrezzo(2);
		System.out.println(spesaCarote);
		Ortaggio pomodoro = new Ortaggio("pomodoro", 2.5, true);
		System.out.println(pomodoro);
		
	}

}
