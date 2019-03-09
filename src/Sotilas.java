
public class Sotilas extends Nappula{
	
	public Sotilas(Vari v, int pelaaja, int x, int y) {
		super(v, pelaaja, x, y);
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
