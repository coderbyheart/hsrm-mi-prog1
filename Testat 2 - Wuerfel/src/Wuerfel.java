/**
 * GC - T1
 * 
 * Testat 2: Wuerfel
 * Würfel werfen mit Java
 * 
 * @author Markus Tacker <m@tacker.org>
 * @author Philipp Siegmund <philipp.siegmund@googlemail.com>
 * @version $Id: Wuerfel.java 88 2010-01-05 08:42:56Z m $
 */
public class Wuerfel 
{
	private static final int A = 1364898;
	
	/**
	 * Bestimmt zufällig zwei Würfelwerte (bis 6), 
	 * einmal mittels eines selbst-implementierten Zufallsgenerators
	 * und einmal mit Math.random()
	 * 
	 * Würfelt maximal dreimal, oder bis ein Pasch gewürfelt wurde.
	 * 
	 * Die gewürfelten Augenzahlen werden ausgegeben.
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		short ersterWurf;
		short zweiterWurf;  
		long zufallsZahl = System.currentTimeMillis();
		short maxWuerfe = 3;
		boolean pasch = false;
		int i = 0;
		
		do {
			i++;

			// Erster Würfel
			zufallsZahl = getRand(zufallsZahl);
			ersterWurf = (short)(zufallsZahl % 6 + 1);

			// Der Zweite Würfel - mittels java.Math.random 
			zweiterWurf = (short)(Math.random() * 6 + 1);
			
			// Pasch geworfen?
			pasch = (ersterWurf == zweiterWurf);
			
			System.out.print("Geworfen wurde");
			if (pasch) {
				System.out.println(" Pasch " + ersterWurf + "!");
			} else {
				System.out.println(": " + ersterWurf + " und " +  zweiterWurf);
			}			
		} while (!pasch && i < maxWuerfe);
	}

	/**
	 * Zufallszahl berechnen
	 * 
	 * Berechnet eine neue Zufallszahl anhand einer vorherigen Zufallszahl
	 * 
	 * @param long oldRand
	 * @return long
	 */
	private static long getRand(long oldRand)
	{
		// Zufallszahl berechnen
		return ((A * oldRand) % Integer.MAX_VALUE);	
	}	
}