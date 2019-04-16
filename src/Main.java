
import java.util.*;
import java.io.IOException;

public class Main {

	public static void main(String[] args)  {
		boolean peli = true;
		Scanner lukija = new Scanner(System.in);
		String nappulaValinta = "";
		String siirto = "";
		Nappula peliNappula;
		int vuoro =0;
		
		System.out.println("Anna tallenne tiedoston polku tai uuden tiedoston Nimi!");
		System.out.println("Esim. C:/tallenus.txt Tai Peli1 ");
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
    		try {
				lauta = t.luePeli();
			} catch (ClassNotFoundException | IOException e) {
				System.out.println("Peliä ei voitu ladata!");
				System.out.println("");
				System.out.println("Virheellinen tiedosto tai Tiedosto on tyhjä!");
				System.out.println("Muista antaa jo olemassa olevan txt-tallenne.");
				System.exit(0);
			}
    	}
    	else {
    		lauta = new Lauta();
    	}
    	
		
		System.out.println("Siirrot ja nappulan valinnat annetaan muodossa Vaakarivi-Pystyrivi esim. 1-1 tai 3-8 !");
		System.out.println("");
		System.out.println("Peli alkakoon!");
		System.out.println("");
		
		//Peli looppi
		while(peli) {
		
		if(lauta.annaVuoro() == 1) {
			try {
				t.tallennaPeli(lauta);
				System.out.println("Peli Tallennettu!");
				System.out.println("");
			} catch (Exception e) {
				System.out.println("Peliä ei voida Tallentaa!");
				System.out.println("Virheellinen tiedosto osoite!");
				System.out.println("");
			}
		}
		lauta.tulostaLauta();
		System.out.println("");
		lauta.tulostaVuoro();
		System.out.println("");
		System.out.println("Valitse Nappula!");
		nappulaValinta = lukija.nextLine();
		
		int testi1;
		int testi2;
		loop1: while(true) {
			try {
				testi1 =Integer.parseInt(nappulaValinta.substring(0,1));
				testi2 = Integer.parseInt(nappulaValinta.substring(2));
				break loop1;
			}
			catch (NumberFormatException | ArrayIndexOutOfBoundsException e){
				System.out.println("");
				System.out.println("Virheellinen Nappulan valinta!");
				System.out.println("Anna Uusi valinta muodossa Vaakarivi-Pystyrivi!");
				nappulaValinta = lukija.nextLine();
			}
		}
		
		
		
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
