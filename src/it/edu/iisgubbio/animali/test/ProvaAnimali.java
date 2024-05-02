package it.edu.iisgubbio.animali.test;

import it.edu.iisgubbio.animali.cani.Cane;
import it.edu.iisgubbio.animali.cani.Cuccia;

public class ProvaAnimali {

	public static void main(String[] args) {
		Cane caneGiulia;
		caneGiulia = new Cane("Athena", 2021);
		caneGiulia.razza= "bovaro del vernese";
		System.out.println(caneGiulia.nome);
		caneGiulia.annoNascita++;
		System.out.println(caneGiulia.annoNascita);
		Cuccia cucciaAthena;
		cucciaAthena = new Cuccia(true,12.3 ,2, "bianca");
		System.out.println(cucciaAthena.getNumPosti());
		cucciaAthena.setNumeroPosti(0);
		System.out.println(cucciaAthena.toString());
	}
}

