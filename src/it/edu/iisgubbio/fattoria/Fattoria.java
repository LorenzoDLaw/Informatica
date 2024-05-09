package it.edu.iisgubbio.fattoria;

public class Fattoria {

	public static void main(String[] args) {
		
		Prodotto carote = new Prodotto("carote", 2.5);
		System.out.println(carote);
		double spesaCarote = carote.calcolaPrezzo(2);
		//System.out.println(spesaCarote);
		
		Ortaggio pomodoro = new Ortaggio("pomodoro", 2.5, true);
		System.out.println(pomodoro);
		
		Formaggio taleggio = new Formaggio("taleggio", 25.0, 1, true);
		System.out.println(taleggio);
		Formaggio ricotta = new Formaggio("ricotta", 4.0, 0, false);
		System.out.println(ricotta);
		
		Mufflato gorgonzola = new Mufflato("gorgonzola", 20.0, "Penicillium roqeforti", true);
		System.out.println(gorgonzola);
	}

}
//mufflato formaggio con la muffa e controllare se interna o esterna al formaggio