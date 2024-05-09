package it.edu.iisgubbio.fattoria;

public class Mufflato extends Formaggio{
	private String nomeMuffa;
	private boolean muffaInterna;
	//formaggio non dop non stagiona e con muffa interna
	public Mufflato(String nome, double prezzoKg, String nomeMuffa, boolean muffaInterna) {
		super(nome, prezzoKg, 0);//imposto il terzo parametro della stagionatura a zero 
		//perchè ho il costruttore formaggio con solo tre parametri
		this.nomeMuffa = nomeMuffa;
		muffaInterna=true;
	}
	
	
	public String getNomeMuffa() {
		return nomeMuffa;
	}

	public void setNomeMuffa(String nomeMuffa) {
		this.nomeMuffa = nomeMuffa;
	}

	public boolean isMuffaInterna() {
		return muffaInterna;
	}

	public void setMuffaInterna(boolean muffaInterna) {
		this.muffaInterna = muffaInterna;
	}


	@Override
	public String toString() {
		if(muffaInterna) {
			return super.toString() + " nomeMuffa=" + nomeMuffa + ", muffa interna";
		}else {
			return super.toString() + " nomeMuffa=" + nomeMuffa + ", muffa esterna";
		}
		
	}
	
}
