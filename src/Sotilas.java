
public class Sotilas extends Nappula{
	
	public Sotilas(Vari v, int pelaaja, int x, int y) {
		super(v, pelaaja, x, y);
	}

	public boolean tarkistaSiirto(String koordinaatit, Nappula[][] lauta) {
		int y = Integer.parseInt(koordinaatit.substring(0,1));
		int x = Integer.parseInt(koordinaatit.substring(2));
		

		if(this.v == Vari.VALKOINEN && y < this.yKoord + 2 && y > this.yKoord  &&(this.xKoord == x || this.xKoord == x + 1 || this.xKoord == x - 1 )) {
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
		
		
		
		else if(this.v == Vari.MUSTA && y > this.yKoord - 2 && y < this.yKoord && (this.xKoord == x || this.xKoord == x + 1 || this.xKoord == x - 1 )) {
		
		
		
		
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
		
		return false;
	}
	
	public String annaTulosteMerkki() {
		if(this.v == Vari.VALKOINEN) {
			
			return "\u265F";
		}
		else {
			
			return "\u2659";
		}
	}
}
