package spiel;

import java.util.LinkedList;
import berdux.In;

/**
 * GC - T3
 * 
 * Testat 3: Spiel des Lebens
 * 
 * Basis Controller für das Game
 * Kümmert sich um das Einlesen der Spielparameter und Erzeugen der Generationen
 * 
 * @author Philipp Siegmund <philipp.siegmund@googlemail.com>
 * @author Markus Tacker <m@tacker.org>
 * @version $Id: AController.java 86 2009-12-16 13:56:15Z m $
 */
abstract public class AController extends ADebug implements IController 
{
	protected int matrixSize;
	protected LinkedList<int[][]> generations;
	protected int generation = 0;
	
	private boolean allDead = false;
	private boolean stable = true;
	private int calculateMaxGenerations = 1000;
	private int currentRow = 0;
	
	/**
	 * Konstruktor
	 * 
	 * Erstellt eine neue Instanz des Spiels
	 */
	public AController()
	{
		this.enableDebug = false;
		this.generations = new LinkedList<int[][]>();
		this.readGameParameters();
		this.breed();
	}
	
	/**
	 * Spielparameter einlesen
	 */
	private void readGameParameters()
	{
		System.out.print("Bitte geben Sie die Matrixgröße ein: ");
		do {
			this.matrixSize = In.readInt();
		} while ((int)this.matrixSize < 2);
		
		System.out.println("");
		System.out.println("Bitte geben Sie " + this.matrixSize + " Zeilen ein.");
		System.out.println("Fehlende Stellen werden mit 0 aufgefüllt.");
		System.out.println("Zu lange Zeilen werden abgeschnitten.");
		System.out.println("Leer lassen, um zufällige Zeile zu erzeugen.");
		System.out.println("Beispiel: " + this.getRandomLine());
		System.out.println("");
		String line;
		do {
			System.out.print("Zeile " + (this.currentRow + 1) + ": ");
			line = In.readString();
			line = this.addLine(line);
			System.out.println("Zeile eingefügt: " + line);
		} while(this.currentRow < this.matrixSize);
		System.out.println("Vielen Dank.");
		System.out.println();
	}
	
	/**
	 * Eine Zeile zum Spiel hinzufügen
	 * 
	 * @param line
	 * @return String eingfügte Zeile
	 */
	public String addLine(String line)
	{
		return this.addLine(line, this.currentRow);
	}
	
	/**
	 * Eine Zeile zum Spiel hinzufügen
	 * 
	 * @param line
	 * @param int Zeile in der eingefügt wird
	 * @return String eingfügte Zeile
	 */
	public String addLine(String line, int row)
	{
		if (line.length() == 0) {
			line = this.getRandomLine();
		} else if (line.length() < this.matrixSize) {
			line = this.fillLine(line);
		} else if (line.length() > this.matrixSize) {
			line = line.substring(0, this.matrixSize);
		}
		if (line.length() != this.matrixSize) throw new IllegalArgumentException("Ungültige Länge: " + line.length());
		int[][] firstGen = this.getGeneration(0);
		int cellValue;
		for(int i = 0; i < this.matrixSize; i++) {
			cellValue = Integer.parseInt(line.substring(i, i+1)) == 1 ? 1 : 0;
			firstGen[row][i] = cellValue;
		}
		this.currentRow++;
		return line;
	}
	
	/**
	 * Erzeugt eine zufällige Startgeneration
	 */
	public void random()
	{
		// Erste Generation generieren
		for (int i = 0; i < this.matrixSize; i++) {	
			this.addLine("", i);
		}
	}
	
	/**
	 * Alle Generationen berechnen
	 */
	public void breed()
	{
		System.out.println("Erzeuge max. " + this.calculateMaxGenerations + " Generationen in einer " + this.matrixSize + "x" + this.matrixSize + " Matrix");
		// Weitere Generationen berechnen
		do {
			this.breedNewGeneration();
		} while (!this.allDead && !this.stable && this.generation < this.calculateMaxGenerations);
		System.out.println(this.generation + " Generationen erzeugt.");
	}
	
	/**
	 * Erzeugt eine neue Generation
	 */
	public void breedNewGeneration()
	{
		int prevGeneration = this.generation++;
		this.debug("Erzeuge " + (this.generation) + ". Generation");
		
		// Alle Zellen durchgehen
		int[][] nextGenerationMatrix = new int[this.matrixSize][this.matrixSize];
		this.generations.add(this.generations.size(), nextGenerationMatrix);
		
		int[][] prevGenerationMatrix = this.getGeneration(prevGeneration);
		int currentValue;
		Cell currentCell;
		Cell nextGenCell;
		int newValue;
		int total = 0;
		this.stable = true;
		
		for(int x = 0; x < prevGenerationMatrix.length; x++) {
			for(int y = 0; y < prevGenerationMatrix[x].length; y++) {
				currentValue = prevGenerationMatrix[x][y];
				currentCell = new Cell(currentValue, x, y, prevGenerationMatrix);
				newValue = currentCell.getNextGenerationState();
				nextGenCell = new Cell(newValue, x, y, nextGenerationMatrix);
				nextGenerationMatrix[x][y] = newValue;
				total += newValue;
				if (currentValue != newValue) this.stable = false;
			}
		}
		this.allDead = (total == 0);
	}
	
	/**
	 * Eine bestimmte Generation zurückgeben
	 * 
	 * @param index
	 * @return LinkedList
	 */
	protected int[][] getGeneration(int index)
	{
		if (this.generations.size() < index + 1) {
			int generation[][] = new int[this.matrixSize][this.matrixSize]; 
			this.generations.add(index, generation);
		}
		return (int[][])this.generations.get(index);
	}
	
	/**
	 * Gibt zurück, ob alle Zellen tot sind
	 * 
	 * @return boolean
	 */
	protected boolean getAllDead()
	{
		return this.allDead;
	}

	/**
	 * Gibt zurück, ob die Matrix stabil ist und keinen neuen Muster mehr erzeugt
	 * 
	 * @return boolean
	 */
	protected boolean getStable()
	{
		return this.stable;
	}
	
	/**
	 * Füllt eine Zeile mit Nullen auf
	 * 
	 * @param line
	 * @return String
	 */
	private String fillLine(String line) 
	{
		while (line.length() < this.matrixSize) line += "0";
		return line;
	}
	
	/**
	 * Erzeugt eine zufällige Zeile
	 * 
	 * @return String
	 */
	private String getRandomLine()
	{
		String randomLine = "";
		for (int i = 0; i < this.matrixSize; i++) {
			randomLine += Math.random() > 0.5 ? "1" : "0";
		}
		return randomLine;
	}
}