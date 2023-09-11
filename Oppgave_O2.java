package no.hvl.dat100;

import static javax.swing.JOptionPane.*;
import static java.lang.Integer.*;

public class Oppgave_O2 {

	public static void main(String[] args) {
		
		// Initialisering
		final int ANT_STUDENTER = 10;
		final int[] TALL_KARAKTERER = {0,40,50,60,80,90};
		final String[] BOKSTAV_KARAKTERER = {"F","E","D","C","B","A"};
		final int ANT_KARAKTER_TRINN = TALL_KARAKTERER.length;
		
		// Hente input for hver student.
		for (int studentNr = 0;studentNr < ANT_STUDENTER;studentNr++) {
			
			// Initiell verdi er at input IKKE blir godkjent.
			int tallKarakter = -1;
			
			while (tallKarakter < 0 || tallKarakter > 100) {
				
				// Hente inn verdi for student studentNr.
				String tallTxt = showInputDialog("Skriv inn tallverdi mellom 0 og 100, for karakter:");
				
				// Dersom bruker klikker på Avbryt.
				if (tallTxt == null) {
					showMessageDialog(null,"Greit, programmet lukkes.");
					// Sløyfen og hele programmet avsluttes.
					return;
				}
				
				// Mottar og kvalitetssjekker inntastede data.
				try {
					
					tallKarakter = parseInt(tallTxt);
		
					if (tallKarakter < 0 || tallKarakter > 100) {
						// Tallverdi, men utenfor avgrensning.
						showMessageDialog(null,
						    "Det kreves en verdi fra 0 (null) til 100.",
						    "Uriktig tallverdi",
						    WARNING_MESSAGE);
					}
					
				}catch(NumberFormatException e) {
					// Ugyldig verdi tastet inn.
					showMessageDialog(null,
					    "Det kreves en TALLverdi fra 0 (null) til 100.",
					    "Uriktig verdi",
					    WARNING_MESSAGE);
				}
	
			}	
	
			
			// Går gjennom baklengs TALL_KARAKTERER til vi ev. får treff.
			
			for (int i = ANT_KARAKTER_TRINN - 1;i >= 0;i--) {
				// Inntastet tall sjekkes mot liste.
				int tall = TALL_KARAKTERER[i];
				String bokstav = BOKSTAV_KARAKTERER[i];
				
				if (tallKarakter >= tall) {
	
					String utregnetBokstav = BOKSTAV_KARAKTERER[i];
					
					System.out.println("Student nr. " + (studentNr + 1) + " får, med en poengsum på " + tallKarakter + ", karakteren " + utregnetBokstav);
					
					// Riktig karakter ble funnet og i sin verdi settes til verdi utenfor spenn for å stoppe sløyfen.
					i = -1;
					
				}	
			}
		
		}
		
	}

}
