
public class Kuningas extends Nappula{

	public Kuningas(Vari v, int pelaaja, int x, int y) {
		super(v, pelaaja, x, y);
	}
	
	
	
	public String annaTulosteMerkki() {
		if(this.v == Vari.VALKOINEN) {
			return "\u2654";
		}
		else {
			return "\u265A";
		}
	}
}
