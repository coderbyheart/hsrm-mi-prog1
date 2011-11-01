package console;

import spiel.AController;
import spiel.Cell;

/**
 * GC - T3
 * 
 * Testat 3: Spiel des Lebens
 * 
 * Controller zur Anzeige des Spiels auf der Konsole
 * 
 * @author Philipp Siegmund <philipp.siegmund@googlemail.com>
 * @author Markus Tacker <m@tacker.org>
 * @version $Id: ControllerText.java 86 2009-12-16 13:56:15Z m $
 */
public class ControllerText extends AController 
{	
	public void display()
	{
		// Erzeugte Generation ausgeben
		for(int i = 0; i <= this.generation; i++) this.displayGeneration(i);
		if (this.getAllDead()) {
			System.out.println("Alle tot.");
		}
		if (this.getStable()) {
			System.out.println("Matrix stabil.");
		}
	}
	
	/**
	 * Eine bestimmte Generation zeichnen
	 * 
	 * @param int
	 */
	public void displayGeneration(int generation)
	{
		this.printGeneration(generation);
	}
	
	/**
	 * Ein generation ausgeben
	 * 
	 * @param int Generation
	 */
	private void printGeneration(int generation)
	{
		System.out.println((generation + 1) + ". Generation");
		int[][] currentGenerationMatrix = this.getGeneration(generation);
		for(int x = 0; x < currentGenerationMatrix.length; x++) {
			for(int y = 0; y < currentGenerationMatrix.length; y++) {
				new Cell(currentGenerationMatrix[x][y], x, y, currentGenerationMatrix).print();				
			}
			// Newline am Ende einer Reihe
			System.out.println();
		}			
	}
}