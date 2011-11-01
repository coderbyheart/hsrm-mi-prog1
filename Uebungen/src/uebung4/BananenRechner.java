package uebung4;
import berdux.In;

/**
 * Ein einfacher Banenrechner
 * 
 * @author Markus Tacker <m@tacker.org>
 *
 */
public class BananenRechner
{
	/**
	 * - Liest den Kilopreis der Banenen in Cent ein
	 * - Liest das Gewicht der Banenen in Gramm ein
	 * - Berechnet den Brutto-Preis
	 * - Berechnet den Netto-Preis
	 * - Berechnet die enthaltene MwSt (7%)
	 * 
	 * @param args
	 */
	public static void main(String args[])
	{
		int kiloPreis = 232;
		int gewicht = 1500;
		float bruttoPreis = 0;
		float nettoPreis = 0;
		float mwSt = 7;
		float mwStBetrag = 0;
		
		System.out.println("Herzlich Willkommen bei JavaMarkt");
		System.out.println();
		// Kilopreis einlesen
		System.out.println("Bitte geben Sie den Kilopreis in €-Cent ein:");
		// kiloPreis = In.readInt();
		// Gewicht einlesen
		System.out.println("Bitte geben Sie das Gewicht der Banenen in Gramm ein:");
		// gewicht = In.readInt();
		
		// Berechne den Bruttopreis
		// Gewicht in kg umrechnen, mit Kilopreis multiplizieren
		bruttoPreis = (((float)gewicht/1000) * kiloPreis);
		// Berechne den Nettopreis
		// Der Bruttopreis enthält die MwSt, daher gilt brutto = netto * 1.07 => netto = brutto / 1.07 * 1 
		nettoPreis = bruttoPreis / (100 + mwSt) * 100;

		mwStBetrag = bruttoPreis - nettoPreis;
		
		// Ausgabe des Kassenzettels
		System.out.println();
		System.out.println("Ihre Quittung:");
		// Was wurde gekauft?
		System.out.println(((float)gewicht/1000) + " kg Bananen,\t" + ((float)kiloPreis / 100) + " €/kg");
		// Brutto-Preis ausgeben
		System.out.println("\tBrutto:\t" + (bruttoPreis / 100) + " €/kg");
		// enthaltene MwSt ausgeben
		System.out.println("\tMWSt:\t" + (((float)Math.round(mwStBetrag) / 100)) + " €/kg");
		// Netto-Preis ausgeben
		System.out.println("\tNetto:\t" + ((float)Math.round(nettoPreis) / 100) + " €/kg");   
	}
}