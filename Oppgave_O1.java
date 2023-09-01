package no.hvl.dat100;

import static javax.swing.JOptionPane.*;
import static java.lang.Integer.*;

public class Oppgave_O1 {

	// Trinnskatt

	public static void main(String[] args) {
		// Hente inn verdi for n
		String tallTxt = showInputDialog("Skriv inn verdien for n:");
		
		// Dersom bruker klikker på Avbryt
		if (tallTxt == null) {
			showMessageDialog(null,"Greit, programmet lukkes.");
			return;
		}
		
		double bruttoLønn = parseInt(tallTxt);
		double skatt = 0.0;
		
		// Oppdatert fra tabell på sida https://www.skatteetaten.no/satser/trinnskatt/?year=2023#rateShowYear
		
		if (bruttoLønn > 198349) {
			skatt = 1.7;		
		}
		if (bruttoLønn > 279149 ) {
			skatt = 4.0;	
		}
		if (bruttoLønn > 642949) {
			skatt = 13.5;	
		}
		if (bruttoLønn > 926799) {
			skatt = 16.5;	
		}
		if (bruttoLønn > 1499999) {
			skatt = 17.5;	
		}
		
		double resultat = (skatt * bruttoLønn) / 100;
		showMessageDialog(null,"Skatteprosent er " + skatt + " som i skatt blir:\n" + (int) resultat + ".");
		
	}

}