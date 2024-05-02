package it.edu.iisgubbio.fattoria;

public class Formaggio extends Prodotto{
	private int stagionatura;
	boolean dop;
	public Formaggio (String nome, double prezzo, int stagionatura, boolean dop) {
		super();
		this.stagionatura = stagionatura;
		this.dop=dop;
	}
	
	
	public Formaggio(String nome, double prezzoKg, int stagionatura) {
		super(nome, prezzoKg);
		this.stagionatura = stagionatura;
	}


	public String toString() {
		if (dop) {
			return super.toString() + "Formaggio [stagionatura=" + stagionatura + ", dop=" + dop + "]";
		}else {
			return super.toString() + "Formaggio [stagionatura=" + stagionatura + ", dop=" + dop + "]";
		}
	}
	
	//nome prezzo al kl periodo di stagionature 
	//nome prezzo al kl periodo di stagionatura e dop
}
