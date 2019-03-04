
public class Lahetti extends Nappula{
	
	public Lahetti(Vari v, int pelaaja, int x, int y) {
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
			return "\u2657";
		}
		else {
			return "\u265D";
		}
	}
}
