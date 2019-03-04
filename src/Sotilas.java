
public class Sotilas extends Nappula{
	
	public Sotilas(Vari v, int pelaaja, int x, int y) {
		super(v, pelaaja, x, y);
	}

	//TODO:
	public boolean liikuta(int x, int y){
		return false;
	}
	
	//TODO:
	public boolean tarkistaSiirto(int x, int y) {
		return false;
	}
	
	public String annaTulosteMerkki() {
		if(this.v == Vari.VALKOINEN) {
			return "\u2659";
		}
		else {
			return "\u265F";
		}
	}
}
