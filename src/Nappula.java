import java.io.Serializable;

public abstract class Nappula implements Serializable{
	private static final long serialVersionUID = 1;
	protected Vari v ;
	protected int xKoord;
	protected int yKoord;
	
	//Arvo 1 tai 2 eri pelaajalle
	protected int pelaaja;
	
	/**
	 * 
	 * @param v = enum luokan väri nappulalle
	 * @param pelaaja, 1 tai 2 eri pelaajille
	 */
	public Nappula(Vari v, int pelaaja, int x, int y) {
		this.v = v;
		this.pelaaja = pelaaja;
		this.xKoord = x;
		this.yKoord = y;
	}
	
	//Palauttaa nappulalle annetun pelaajanumeron
	public int annaPelaajaNum() {
		return this.pelaaja;
	}
	
	public int annaX() {
		return this.xKoord;
	}
	
	public int annaY() {
		return this.yKoord;
	}
	
	public void asetaX(int x) {
		this.xKoord = x;
	}
	
	public void asetaY(int y) {
		this.yKoord = y;
	}
	
	public boolean tarkistaSiirto(String koordinaatit, Nappula[][] lauta) {
		int x = Integer.parseInt(koordinaatit.substring(0,1));
		int y = Integer.parseInt(koordinaatit.substring(2));
		if(x > 7 || y > 7 || x < 0 || y < 0) {
			return false;
		}
		Nappula[][] nyklauta = new Nappula[8][8];
		nyklauta = lauta;

		if (x <= 7 && y <= 7) {
			if (nyklauta[x][y] != null) {
				if (nyklauta[x][y].annaPelaajaNum() == this.pelaaja) {
					return false;

				}
			}
			return true;
		}

		return false;
	}
	
	
	
	/**
	 * 
	 * @return Palauttaa String arvon kyseiselle shakki nappulalle
	 */
	abstract String annaTulosteMerkki();
}
