/**
 * GC - T1
 * 
 * Testat 1: Geldautomat.
 * Ein einfacher Geldautomat.
 * 
 * @author Philipp Siegmund <philipp.siegmund@googlemail.com>
 * @author Markus Tacker <m@tacker.org>
 * @version $Id: GeldAutomat.java 61 2009-12-01 08:06:05Z m $
 */
public class GeldAutomat 
{
	public final static int HUNDERTERWERT = 100;
	public final static int FUENFZIGERWERT = 50;
	public final static int ZWANZIGERWERT = 20;
	public final static int ZEHNERWERT = 10;
	/**
	 * Main methode, wird immer Aufgerufen
	 * 
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// Variablen initialisieren
		long kontoNummer;
		long kontoStand = 123406L;
		int auszahlBetrag;
		int ausgezahlt =  0;
		long kontoStandEuro;
		long kontoStandCent;
		int hunderter = 0;
		int fuenfziger = 0;
		int zwanziger = 0;
		int zehner = 0;	
		
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("++    Herzlich Willkommen bei Ihrem JavaBanker 1.0    ++");
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println();
		System.out.println("Bitte geben Sie Ihre Kontonummer ein:");
		kontoNummer = In.readLong();
		System.out.println("Bitte geben Sie nun den auszuzahlenden Betrag in € ein:");
		auszahlBetrag = In.readInt();
		
		// Kontostand verringern
		kontoStand -= auszahlBetrag * 100;
		System.out.println();
		System.out.println("Vom Konto " + kontoNummer + " wurde der Betrag " + auszahlBetrag + " € abgehoben.");
		
		// Anzahl der auszugebenden Scheine berechnen
		hunderter = auszahlBetrag / HUNDERTERWERT;
		ausgezahlt += hunderter * HUNDERTERWERT;
		fuenfziger = (auszahlBetrag - ausgezahlt) / FUENFZIGERWERT;
		ausgezahlt += fuenfziger * FUENFZIGERWERT;
		zwanziger = (auszahlBetrag - ausgezahlt) / ZWANZIGERWERT;
		ausgezahlt += zwanziger * ZWANZIGERWERT;
		zehner = (auszahlBetrag - ausgezahlt) / ZEHNERWERT;
		ausgezahlt += zehner * ZEHNERWERT;
		System.out.println();
		System.out.println("Sie erhalten:");
		System.out.println("\t" + hunderter + " x 100 €");
		System.out.println("\t" + fuenfziger + " x 50 €");
		System.out.println("\t" + zwanziger + " x 20 €");
		System.out.println("\t" + zehner + " x 10 €");
		
		// Kontostand formatiert ausgeben
		kontoStandCent = kontoStand % 100;
		kontoStandEuro = (kontoStand - kontoStandCent) / 100;
		System.out.println();
		System.out.print("Ihr neuer Kontostand: " + kontoStandEuro + ",");
		if (kontoStandCent < 10) System.out.print("0");
		System.out.print(kontoStandCent + " €");
		System.out.println();
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("++ Vielen Dank dass Sie JavaBanker 1.0 benutzt haben. ++");
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
	}
}