
public class Torni extends Nappula{
	
	public Torni(Vari v, int pelaaja, int x, int y) {
		super(v, pelaaja, x, y);
	}

	

	public String annaTulosteMerkki() {
		if(this.v == Vari.VALKOINEN) {
			return "\u2656" ;
		}
		else {
			return "\u265C" ;
		}
	}
}
