import java.io.Serializable;

public class Lauta implements Serializable{
	
	//Sallitut arvot 1 ja 2, kummallekin pelaajalle
	public int vuoro = 1;
	
	private Nappula[][] lauta;
	
	public Lauta(Nappula[][] tallennus) {
		this.lauta = tallennus;
	}
	
	public Lauta() {
		
		this.lauta = new Nappula[8][8];
		
		//Tayttaa laudan
		for(int i = 0; i < 8; ++i) {
			for(int j = 0;  j < 8; ++j) {
				
				if(i == 0) {
					if(j == 0 || j == 7) {
						this.lauta[i][j] = new Torni(Vari.MUSTA, 1, j, i);
					}
					if(j == 1 || j == 6) {
						this.lauta[i][j] = new Ratsu(Vari.MUSTA, 1, j, i);
					}
					if(j == 2 || j == 5) {
						this.lauta[i][j] = new Lahetti(Vari.MUSTA, 1, j, i);
					}
					if(j == 3) {
						this.lauta[i][j] = new Kuningas(Vari.MUSTA, 1, j, i);
					}
					if(j == 4) {
						this.lauta[i][j] = new Kuningatar(Vari.MUSTA, 1, j, i);
					}
				}
				
				if(i == 7) {
					if(j == 0 || j == 7) {
						this.lauta[i][j] = new Torni(Vari.VALKOINEN, 2, j, i);
					}
					if(j == 1 || j == 6) {
						this.lauta[i][j] = new Ratsu(Vari.VALKOINEN, 2, j, i);
					}
					if(j == 2 || j == 5) {
						this.lauta[i][j] = new Lahetti(Vari.VALKOINEN, 2, j, i);
					}
					if(j == 3) {
						this.lauta[i][j] = new Kuningas(Vari.VALKOINEN, 2, j, i);
					}
					if(j == 4) {
						this.lauta[i][j] = new Kuningatar(Vari.VALKOINEN, 2, j, i);
					}
					
				}
						
				if(i == 1) {
					this.lauta[i][j] = new Sotilas(Vari.MUSTA, 1, j, i);
				}
				if(i == 6) {
					this.lauta[i][j] = new Sotilas(Vari.VALKOINEN, 2, j, i);
				}
				
			}
		}
	}


	//Vaihtaa vuoro attribuutin arvon 1 tai 2
	public void vaihdaVuoro() {
		if(this.vuoro == 1) {
			this.vuoro = 2;
		}
		else this.vuoro = 1;
	}
	
	//Tulostaa vuoro attribuutin arvon
	public void tulostaVuoro() {
		System.out.println("Pelaajan " + this.vuoro + " vuoro!");
	}
	
	//Palauttaa vuoron numeron
	public int annaVuoro() {
		return this.vuoro;
	}
	
	/**
	 * 
	 * @param koordinaatit = Main scannerin tuottama nappula valinta muodossa pytstyrivi-vaakarivi
	 * @return Palauttaa listan kyseisessä kohdassa olevan nappulan
	 */
	public Nappula palautaNappula(String koordinaatit) {
		//Testaa vastaako vuoro nappulan pelaajaa
		int koord1 = Integer.parseInt(koordinaatit.substring(0, 1));
		int koord2 = Integer.parseInt(koordinaatit.substring(2));
		//System.out.println(""+koord1+","+koord2);
		return this.lauta[koord1][koord2];
	}
	
	/**
	 * 
	 * @param koordinaatit - Main scannerin tuottama koordinaatti valinta muodossa pytstyrivi-vaakarivi
	 * @param peliNappula = Tämänhetkinen nappulan valinta
	 */
	// [i == 1 == Y][j == 2 == X]
	public void teeSiirto(String koordinaatit, Nappula peliNappula) {
		int koord1 = Integer.parseInt(koordinaatit.substring(0, 1));
		int koord2 = Integer.parseInt(koordinaatit.substring(2));
		//System.out.println("Siirto: "+koord2+","+koord1);
		this.lauta[koord1][koord2] = this.lauta[peliNappula.annaY()][peliNappula.annaX()];
		//System.out.println("Nappula Koord: "+peliNappula.annaY()+","+peliNappula.annaX());
		Nappula n = this.lauta[peliNappula.annaY()][peliNappula.annaX()];
		this.lauta[peliNappula.annaY()][peliNappula.annaX()] = null;
		n.asetaX(koord2);
		n.asetaY(koord1);
		//System.out.println("Siirto: "+this.lauta[koord1][koord2].annaY()+","+this.lauta[koord1][koord2].annaX());
		
		
		
	}
	
	//Tulostaa laudan
	public void tulostaLauta() {
		String tuloste = "";
		System.out.println("  0 1 2 3 4 5 6 7");
		for(int i = 0; i < 8; ++i) {
			for(int j = 0;  j < 8; ++j) {
				//if(j < 7 && j > 0 ) {
				if(this.lauta[i][j] == null) {
					tuloste = tuloste + "  ";
				}
				else {
					tuloste = tuloste + " "+this.lauta[i][j].annaTulosteMerkki()+"";
				}
				//}

			}
			System.out.println(i + tuloste);
			//System.out.println("-------------------------------");
			tuloste = "";
		}
		System.out.println("  0 1 2 3 4 5 6 7");
	}
	
	public Nappula[][] annaLauta() {
		return this.lauta;
	}
	
}
