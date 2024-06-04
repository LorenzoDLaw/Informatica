package it.edu.iisgubbio.vivaioProva;

import it.edu.iisgubbio.vivaio.Bonsai;
import it.edu.iisgubbio.vivaio.Fiore;
import it.edu.iisgubbio.vivaio.Pianta;

public class ProvaVivaio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pianta erba = new Pianta("Oddium Viandantis", 30);
		System.out.println(erba);
		
		Fiore rosa = new Fiore("Rosa", 5, "Rossa", "Primavera");
		System.out.println();
		
		Bonsai bonsai = new Bonsai("Sakura", 50, 25);
		System.out.println(bonsai);
	}

}
