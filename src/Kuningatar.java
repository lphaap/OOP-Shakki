
public class Kuningatar extends Nappula{
	
	public Kuningatar(Vari v, int pelaaja, int x, int y) {
		super(v, pelaaja, x, y);
	}
	

	public String annaTulosteMerkki() {
		if(this.v == Vari.VALKOINEN) {
			return "\u2655";
		}
		else {
			return "\u265B";
		}
	}
}
