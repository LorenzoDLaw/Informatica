package it.edu.iisgubbio.mobilitaProva;

import it.edu.iisgubbio.correggiVerifica.Autobus;

public class provaAutobus {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Autobus autobus;
		autobus = new Autobus("AGHD67RD", "Scania", 5, 3);
		System.out.println(autobus.litriTotali(100));
	}
}
