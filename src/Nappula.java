
public abstract class Nappula {
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
	
	/**
	 * @param Parametreina laudan x ja y koordinaatti
	 * Liikuttaa nappulaa haluttuun (x,y) ruutuun
	 * @return Palauttaa true jos siirto laillinen
	 */
	abstract boolean liikuta(int x, int y);
	
	/**
	 * 
	 * @param x = laudan vaakarivi
	 * @param y = laudan pystyrivi
	 * @return Palauttaa true, jos siirto onnistuu
	 */
	//Tarkastatetaan jokaiselle nappulalle ominaisten liikkeiden kautta siirron oikeellisuus
	abstract boolean tarkistaSiirto(int x, int y);
	
	
	/**
	 * 
	 * @return Palauttaa String arvon kyseiselle shakki nappulalle
	 */
	abstract String annaTulosteMerkki();
}
