package no.hvl.dat100;

import static javax.swing.JOptionPane.*;
import static java.lang.Integer.*;

public class Oppgave_O1 {

	// Trinnskatt

	public static void main(String[] args) {
		
		
		// INITIALISERING
		
		double bruttoLønn = 0.0;
		double skatt = 0.0;
		
		// Oppdatert fra tabell på sida https://www.skatteetaten.no/satser/trinnskatt/?year=2023#rateShowYear
		final double[] TRINN_GRENSEVERDIER = {198350,279150,642950,926800,1500000};
		final double[] TRINN_PROSENTVERDIER = {1.7,4,13.5,16.5,17.5};
		final int ANT_TRINN = TRINN_GRENSEVERDIER.length;
		

		// KJØRING
		
		// Hente inn verdi for n
		String tallTxt = showInputDialog("Skriv inn verdien for n:");
		
		// Dersom bruker klikker på Avbryt
		if (tallTxt == null) {
			showMessageDialog(null,"Greit, programmet lukkes.");
			return;
		}
		
		try {
			
			// Mottatt inntastede data.
			bruttoLønn = parseInt(tallTxt);
		
			// Går NEDOVER i beløpsgrenser til vi ev. får treff.
			
			for (int i = ANT_TRINN - 1;i >= 0;i--) {
				
				if (bruttoLønn >= TRINN_GRENSEVERDIER[i]) {
	
					// Riktig trinn ble funnet
					skatt = TRINN_PROSENTVERDIER[i];
					
					// Tellevariabelen i settes til verdi utenfor spenn, for å stoppe sløyfen.
					i = -1;
					
				}
				
			}
			
			// Endelig kalkulasjon.
			double resultat = (skatt * bruttoLønn) / 100;
			// Utskrift.
			showMessageDialog(null,"Trinnskatt blir på " + skatt + "% som vil utgjøre:\n" + (int) resultat + " kr.");
		
		}catch(Exception e) {
			
			// Inntastede data sannsynligvis bogus.
			System.out.println("Utregning ikke mulig: " + e);
			showMessageDialog(null,
			    "Kunne ikke regne ut. Du må starte appen på nytt.",
			    "Utilstrekkelige data",
			    WARNING_MESSAGE);
		}
	}

}