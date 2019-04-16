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
	 * @param X ja y koordinaatit, johon nappula sijoitetaan laudalle
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
	
	//Tarkistaa ettei peelaajan siirto mene yli laudan ja ettei pelaaja vahingossa voi syödä omaa nappulaansa
	/**
	 * 
	 * @param koordinaatit - Siirron koordinaatit String muodossa 0-0
	 * @param lauta - käyttetty lauta olio
	 * @return false, jos siirto on virheellinen, true - jos sallittu
	 */
	abstract boolean tarkistaSiirto(String koordinaatit, Nappula[][] lauta) ;

	
	/**
	 * 
	 * @return Palauttaa Unicode arvon kyseiselle shakki nappulalle
	 */
	abstract String annaTulosteMerkki();
}
