
public class Torni extends Nappula{
	
	public Torni(Vari v, int pelaaja, int x, int y) {
		super(v, pelaaja, x, y);
	}

	public boolean tarkistaSiirto(String koordinaatit, Nappula[][] lauta) {
		int y = Integer.parseInt(koordinaatit.substring(0,1));
		int x = Integer.parseInt(koordinaatit.substring(2));

		if((x == this.xKoord && y != this.yKoord) || (x != this.xKoord && y == this.yKoord)) {

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
			return "\u2656" ;
		}
		else {
			return "\u265C" ;
		}
	}
}
