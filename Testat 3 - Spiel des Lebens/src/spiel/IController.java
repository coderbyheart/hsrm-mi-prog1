package spiel;

/**
 * GC - T3
 * 
 * Testat 3: Spiel des Lebens
 * 
 * Interface für Controller
 * 
 * @author Markus Tacker <m@tacker.org>
 * @version $Id: IController.java 86 2009-12-16 13:56:15Z m $
 */
interface IController 
{
	/**
	 * Alles Anzeigen
	 */
	void display();
	
	/**
	 * Eine bestimmte Generation zeichnen
	 * 
	 * @param int
	 */
	void displayGeneration(int generation);
}