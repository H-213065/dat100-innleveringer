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
		
		// Mottatt inntastede data.
		double bruttoLønn = parseInt(tallTxt);
		// Initialisering.
		double skatt = 0.0;
		
		// Oppdatert fra tabell på sida https://www.skatteetaten.no/satser/trinnskatt/?year=2023#rateShowYear
		double[] trinnGrenser = {198350,279150,642950,926800,1500000};
		double[] trinnProsenter = {1.7,4,13.5,16.5,17.5};
		int antallTrinn = trinnGrenser.length;

		
		// Går gjennom baklengs beløpsgrenser til vi ev. får treff.
		for (int i = antallTrinn - 1;i >= 0;i--) {
			double grense = trinnGrenser[i];
			double prosent = trinnProsenter[i];
			
			if (bruttoLønn >= grense) {

				skatt = prosent;
				
				// Riktig trinn ble funnet og i settes til -1 for å stoppe sløyfen.
				i = -1;
				
			}
			
		}
		
		// Kalkulasjon og utskrift.
		double resultat = (skatt * bruttoLønn) / 100;
		showMessageDialog(null,"Skatteprosent er " + skatt + " som i skatt blir:\n" + (int) resultat + ".");
		
	}

}