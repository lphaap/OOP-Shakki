
public class Ratsu extends Nappula{
	
	public Ratsu(Vari v, int pelaaja, int x, int y) {
		super(v, pelaaja, x, y);
	}
	
	//TODO:
		public boolean tarkistaSiirto(int x, int y) {
			return false;
		}
	
	public String annaTulosteMerkki() {
		if(this.v == Vari.VALKOINEN) {
			return "\u2658";
		}
		else {
			return "\u265E";
		}
	}
}
