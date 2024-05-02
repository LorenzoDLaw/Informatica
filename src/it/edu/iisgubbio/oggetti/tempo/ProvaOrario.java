package it.edu.iisgubbio.oggetti.tempo;

public class ProvaOrario {
	public static void main(String[] args) {
		Orario addOrario = new Orario(8, 50, 25);
		//System.out.println(addOrario);
		addOrario.addMinuti(120);
		System.out.println(addOrario);
		addOrario.tic();
		System.out.println(addOrario);
	}
}
