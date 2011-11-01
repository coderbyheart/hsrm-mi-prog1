package spiel;

/**
 * GC - T3
 * 
 * Testat 3: Spiel des Lebens
 * 
 * Debug informationen ausgeben
 * 
 * @author Markus Tacker <m@tacker.org>
 * @version $Id: ADebug.java 86 2009-12-16 13:56:15Z m $
 */
abstract public class ADebug
{
	protected boolean enableDebug = false;
	
	/**
	 * Debug message ausgeben
	 * 
	 * @param String
	 */
	protected void debug(String message)
	{
		if (this.enableDebug) System.out.println("> " + message);
	}
}