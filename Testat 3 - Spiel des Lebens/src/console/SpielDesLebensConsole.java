package console;

/**
 * GC - T3
 * 
 * Testat 3: Spiel des Lebens
 * 
 * View für das Spiel, die in der Konsole angezeigt wird
 * Instanziert das Spiel
 * 
 * @author Philipp Siegmund <philipp.siegmund@googlemail.com>
 * @author Markus Tacker <m@tacker.org>
 * @version $Id: SpielDesLebensConsole.java 86 2009-12-16 13:56:15Z m $
 */
public class SpielDesLebensConsole 
{
	/**
	 * Main methode
	 * Wird immer aufgerufen, erzeugt Instanz des Spiels mit eingelesenen Parametern
	 * 
	 * @param args
	 */	
	public static void main(String[] args)
	{
		ControllerText spiel = new ControllerText(); 
		spiel.display();		
	}
}