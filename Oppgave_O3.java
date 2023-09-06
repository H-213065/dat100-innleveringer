package no.hvl.dat100;

import static javax.swing.JOptionPane.*;
import static java.lang.Integer.*;

public class Oppgave_O3 {

	// Fakultetskalkulasjon

	public static void main(String[] args) {
		// Hente inn verdi for n
		String tallTxt = showInputDialog("Skriv inn verdien for n:");
		
		// Dersom bruker klikker på Avbryt
		if (tallTxt == null) {
			showMessageDialog(null,"Greit, programmet lukkes.");
			return;
		}
		
		try {	
			// Setter n
			int n = parseInt(tallTxt);
			
			if ((n > 0) == true) {
				long fakultet = 1;
	            for (int i = 1; i <= n; i++) {
	            	fakultet *= i;
	            }
	            System.out.println(n + "! = " + fakultet);
			}else{
				showMessageDialog(null,"Programmet lukkes, fordi du ikke oppgav et tall høyere enn null.");
				return;
			}
			
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