
public class Ratsu extends Nappula{
	
	public Ratsu(Vari v, int pelaaja, int x, int y) {
		super(v, pelaaja, x, y);
	}
	
	public boolean tarkistaSiirto(String koordinaatit, Nappula[][] lauta) {
		int y = Integer.parseInt(koordinaatit.substring(0,1));
		int x = Integer.parseInt(koordinaatit.substring(2));
		

		if(((this.xKoord + 1 == x || this.xKoord - 1 == x) && (this.yKoord + 2 == y || this.yKoord - 2 == y)) ||  ((this.xKoord + 2 == x || this.xKoord - 2 == x) && (this.yKoord + 1 == y || this.yKoord - 1 == y))) {
		if(x > 7 || y > 7 || x < 0 || y < 0) {
			return false;
		}
		Nappula[][] nyklauta = new Nappula[8][8];
		nyklauta = lauta;
		
		if (x <= 7 && y <= 7) {
			if (nyklauta[y][x] != null) {
				if (nyklauta[y][x].annaPelaajaNum() == this.pelaaja) {
					return false;

				}
			}
			return true;
		}
	
		return false;
		
		}
		else return false;
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

//x+-1 && y+-2
//++-2 && y+-1