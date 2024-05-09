package it.edu.iisgubbio.mobilitaProva;

import it.edu.iisgubbio.mobilita.AMotore;
import it.edu.iisgubbio.mobilita.AMuscoli;
import it.edu.iisgubbio.mobilita.Automobile;
import it.edu.iisgubbio.mobilita.Bicicletta;
import it.edu.iisgubbio.mobilita.MezzoDiTrasporto;
import it.edu.iisgubbio.mobilita.Motocicletta;
import it.edu.iisgubbio.mobilita.Skateboard;
import it.edu.iisgubbio.mobilita.Terrestre;

public class MezziRimessa {
	public static void main(String[] args) {
		MezzoDiTrasporto provaMezzoDiTrasporto;
		provaMezzoDiTrasporto = new MezzoDiTrasporto("Space shuttle", 1000000.00);
		System.out.println(provaMezzoDiTrasporto);
		System.out.println(provaMezzoDiTrasporto.importaRata(400));
		
		AMuscoli provaAMuscoli;
		provaAMuscoli = new AMuscoli("Triciclo", 100, "quadricipiti");
		provaAMuscoli.setMuscoliCoinvolti("bicipiti");
		System.out.println(provaAMuscoli);
		
		Skateboard provaSkate;
		provaSkate = new Skateboard(null, 340, null,90);
		System.out.println(provaSkate);
		
		Bicicletta provaBici;
		provaBici = new Bicicletta(340, 9);
		provaBici.setNumeroDiRapporti(1);
		System.out.println(provaBici);
		
		AMotore elicottero = new AMotore("Elicottero",50000.0,120,"Gasolio");
		System.out.println(elicottero);
		System.out.println("il veicolo può andare in centro? "+elicottero.possibileCentriAbitati());
	
		Terrestre motocarro = new Terrestre();
		motocarro.setVelocita(130);
		motocarro.setCarburante("benzina");
		motocarro.setNome("motocarro di Luigi");
		System.out.println(motocarro);
		
		Motocicletta moto = new Motocicletta("moto guzzi", 5000, 350);
		moto.setNumeroPosti(2);
		System.out.println(moto);
		
		Automobile auto = new Automobile("maserati di Matte", 10000, 2);
		auto.setTarga("BF5567UU");
		System.out.println(auto);
		auto.setPorte(5);
		System.out.println(auto.getPorte());
	}
}
