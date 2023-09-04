package no.hvl.dat100;

import static javax.swing.JOptionPane.*;
import static java.lang.Integer.*;

public class Oppgave_O2 {

	public static void main(String[] args) {
		
		// Initialisering
		int antallStudenter = 10;
		int[] tallKarakterer = {0,40,50,60,80,90};
		String[] bokstavKarakterer = {"F","E","D","C","B","A"};
		int antallKarakterTrinn = tallKarakterer.length;
		
		// Hente input for hver student.
		for (int studentNr = 0;studentNr < antallStudenter;studentNr++) {
			
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
	
			
			// Går gjennom baklengs tallkarakterer til vi ev. får treff.
			
			for (int i = antallKarakterTrinn - 1;i >= 0;i--) {
				// Inntastet tall sjekkes mot liste.
				int tall = tallKarakterer[i];
				String bokstav = bokstavKarakterer[i];
				
				if (tallKarakter >= tall) {
	
					String utregnetBokstav = bokstavKarakterer[i];
					
					System.out.println("Student nr. " + (studentNr + 1) + " får, med en poengsum på " + tallKarakter + ", karakteren " + utregnetBokstav);
					
					// Riktig karakter ble funnet og i settes til -1 for å stoppe sløyfen.
					i = -1;
					
				}	
			}
		
		}
		
	}

}