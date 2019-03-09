
import java.util.*;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		boolean peli = true;
		Scanner lukija = new Scanner(System.in);
		String nappulaValinta = "";
		String siirto = "";
		Nappula peliNappula;
		int vuoro =0;
		
		System.out.println("Anna tallennus tiedoston polku!");
		System.out.println("Esim. C:/tallenus.txt");
    	String tiedosto = lukija.nextLine();
    	Tallentaja t = null;
    	try {
    		t = new Tallentaja(tiedosto);
    	}
    	catch (IOException e) {
    		System.out.println("Virheellinen tiedosto!");
    		System.exit(0);
    	}
    	
    	System.out.println("");
    	System.out.println("Haluatko jatkaa peliä?");
    	System.out.println("Y - Jep , N - Ei kiitos");
    
    	String valinta = lukija.nextLine();
    	
    	Lauta lauta = null;
    	if(valinta.equals("Y")) {
    		lauta = t.luePeli();
    	}
    	else {
    		lauta = new Lauta();
    	}
    	
		
		System.out.println("Siirrot ja nappulan valinnat annetaan muodossa Pytstyrivi-Vaakarivi esim. 1-1 tai 3-8 !");
		System.out.println("");
		System.out.println("Peli alkakoon!");
		System.out.println("");
		
		//Peli looppi
		while(peli) {
		
		if(lauta.annaVuoro() == 1) {
			System.out.println("Peli Tallennettu!");
			System.out.println("");
			t.tallennaPeli(lauta);
		}
		lauta.tulostaLauta();
		System.out.println("");
		lauta.tulostaVuoro();
		System.out.println("");
		System.out.println("Valitse Nappula!");
		nappulaValinta = lukija.nextLine();
		peliNappula = lauta.palautaNappula(nappulaValinta);
		vuoro = lauta.annaVuoro();
		while(vuoro != peliNappula.annaPelaajaNum() ) {
			System.out.println("Valitse Oma Nappulasi..");
			nappulaValinta = lukija.nextLine();
			peliNappula = lauta.palautaNappula(nappulaValinta);
		}
		System.out.println("Anna Siirto!");
		siirto = lukija.nextLine();
		
		while(lauta.teeSiirto(siirto, peliNappula) == false) {
			System.out.println("Virheellinen koordinaatti!");
			System.out.println("");
			System.out.println("Anna Uusi Siirto!");
			siirto = lukija.nextLine();
		}
		
		System.out.println("");
		
		if(lauta.onkoKuningas() == false) {
			System.out.println("Pelaaja " +lauta.annaVuoro() + " voittaa!");
			peli = false;
			
		}
		lauta.vaihdaVuoro();
		if(peli == false) {
			lauta.tulostaLauta();
		}
		}
		
		
	}

}


//TODO:
/**
 * teeSiirto metodin tulisi tarkistaa vastaako valittu nappula pelaajan vuoroa, tällähetkellä kumoikin pelaaja voi valita toistensa nappuloita
 * ts. Nappula: Pelaaja attribuutti == lauta.annaVuoro()
 * 
 * Jokaiselle nappulalle tarkistus metodi
 * 
 * Poistaa liikuta metodit kaikista nappuloista ja itse nappula luokasta, tarkistus metodi korvaa tämän
 * Sijoitetaan tarkistus metodi lauta.teeSiirto() metodiin
 * 
 * Tarvitaan myös johonkin metodi, joka tarkistaa onko siirron tiellä muu nappula ja jos on haluttu siirto muutetaan tämän nappulan syönniksi
 * Esim. siirretään tornia 1-1 > 5-1, mutta tiellä kohdassa 3-1 on nappula, jolloin tornin siirto jää kohtaan 3-1, tällöin ei tarvita kahta tarkistus metodia
 * ja syönti automatisoituu, tällähetkellä pelaaja voi myös syödä omia nappuloitaan ja hypätä nappuloiden yli
 * 
 * Tässä mun ideat tällähetkellä, jotka tokin vain ideoita ja muutoksia saa mun puolesta tehdä jos paremmaksi näkee :O
*/