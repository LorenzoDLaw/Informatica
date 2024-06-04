package it.edu.iisgubbio.mobilitaProva;

import it.edu.iisgubbio.mobilita.AMotore;
import it.edu.iisgubbio.mobilita.AMuscoli;
import it.edu.iisgubbio.mobilita.Aereo;
import it.edu.iisgubbio.mobilita.Automobile;
import it.edu.iisgubbio.mobilita.Bicicletta;
import it.edu.iisgubbio.mobilita.Deltaplano;
import it.edu.iisgubbio.mobilita.MezzoDiTrasporto;
import it.edu.iisgubbio.mobilita.Motocicletta;
import it.edu.iisgubbio.mobilita.Motoslitta;
import it.edu.iisgubbio.mobilita.Skateboard;
import it.edu.iisgubbio.mobilita.Terrestre;
import it.edu.iisgubbio.mobilita.Volante;

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
		provaSkate = new Skateboard(null, 340, 90);
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
		
		Motoslitta motoSlitta = new Motoslitta("franco", 15000, 50);
		motoSlitta.setTemperaturaMinima(-30);
		System.out.println(motoSlitta);

		Volante aereoVolante = new Volante("Delt", 30000);
		aereoVolante.setQuotaMassima(500);
		System.out.println(aereoVolante);
		
		Deltaplano deltaplano = new Deltaplano("billy", 15000.00, 4);
		System.out.println(deltaplano);
		
		Aereo aereo = new Aereo("A340");
		aereo.setDistanzaMassima(4500);
		System.out.println(aereo);
	}
}
