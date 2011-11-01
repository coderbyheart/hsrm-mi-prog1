package spiel;

import java.awt.Color;
import java.awt.Graphics;

/**
 * GC - T3
 * 
 * Testat 3: Spiel des Lebens
 * 
 * Eine Zelle
 * 
 * Die Zelle kann ihren nächsten Status bestimmen und sich auf der Konsole
 * oder im Applet anzeigen
 * 
 * @author Philipp Siegmund <philipp.siegmund@googlemail.com>
 * @author Markus Tacker <m@tacker.org>
 * @version $Id: Cell.java 86 2009-12-16 13:56:15Z m $
 */
public class Cell extends ADebug
{
	int state;
	int x;
	int y;
	int[][] matrix;
	int matrixSize;
	
	/**
	 * Konstruktor
	 * 
	 * Setzt den Status der Zelle
	 * 
	 * @param int Status true: lebend, false: tot
	 * @param int x
	 * @param int y
	 * @param int[][] Matrix
	 */
	public Cell(int state, int x, int y, int[][] matrix)
	{
		this.state = state;
		this.x = x;
		this.y = y;
		this.matrix = matrix;
		this.matrixSize = matrix.length;
	}
	
	/**
	 * Setzt den Status der Zelle
	 * 
	 * @param int Status true: lebend, false: tot
	 */
	public void setState(int state)
	{
		this.state = state;
	}
	
	/**
	 * State zurück geben
	 * 
	 * @return int
	 */
	public int getState()
	{
		return this.state;
	}
	
	/**
	 * X-Wert zurück geben
	 * 
	 * @return int
	 */
	public int getX()
	{
		return this.x;
	}
	
	/**
	 * Y-Wert zurück geben
	 * 
	 * @return int
	 */
	public int getY()
	{
		return this.y;
	}
	
	/**
	 * Berechnet den Zellenstatus in der nächsten Generation
	 *
	 * Regeln:
	 * - Hat eine tote Zelle genau 3 lebende Nachbarn, erwacht sie zum Leben.
	 * - Hat eine Zelle 2 oder 3 lebende Nachbarn, bleibt sie am Leben.
	 * - Alle anderen lebenden Zellen sterben.
	 * 
	 * @param generation
	 * @param i
	 * @param j
	 * @return int
	 */
	public int getNextGenerationState()
	{
		this.debug("Betrachte " + (this.x+1) + "x" + (this.y+1) + "(" + this.state + ")");

		// Werte der Nachbarzellen einsammeln
		int neighbourValues = 0;
		for(int shiftX = -1; shiftX <= 1; shiftX++) {
			for(int shiftY = -1; shiftY <= 1; shiftY++) {
				if (shiftX == 0 && shiftY == 0) continue; // Sich selbst nicht mitzählen
				neighbourValues += this.getNeighbourValue(this.x + shiftX, this.y + shiftY);
			}
		}

		// Hat eine tote Zelle genau 3 lebende Nachbarn, erwacht sie zum Leben.
		if (this.state == 0 && neighbourValues == 3) return 1;
		// Hat eine Zelle 2 oder 3 lebende Nachbarn, bleibt sie am Leben.
		if (this.state == 1 && (neighbourValues == 2 || neighbourValues == 3)) return 1;
		// Alle anderen lebenden Zellen sterben
		return 0;
	}
	
	/**
	 * Gibt den benachbarten Wert zurück
	 * 
	 * @param int generation
	 * @param int 
	 * @paran int
	 * @return int
	 */
	private int getNeighbourValue(int x, int y)
	{
		// i, j korrigieren
		x = this.fixMatrixCoordinate(x);
		y = this.fixMatrixCoordinate(y);
		return new Cell(this.matrix[x][y], x, y, this.matrix).getState();
	}
	
	/**
	 * "Ungültige" Matrix-Koordinate korrigieren
	 * 
	 * @param value
	 * @return int
	 */
	private int fixMatrixCoordinate(int value)
	{
		if (value < 0) {
			value = this.matrixSize + value;
		} else if (value >= this.matrixSize) {
			value = value - this.matrixSize;
		}
		return value;
	}

	/**
	 * Textwert der Zelle ausgeben 
	 */
	public void print()
	{
		System.out.print(this.state);
	}
	
	/**
	 * Zelle zeichnen
	 * 
	 * @param Graphics
	 */
	public void draw(Graphics g, int scale)
	{
		this.draw(g, scale, 0);
	}
	
	/**
	 * Zelle zeichnen
	 * 
	 * @param Graphics
	 */
	public void draw(Graphics g, int scale, int offset)
	{
		int yOffset = this.matrixSize * scale * offset + ((offset > 0 ? offset + 1 : 0) * scale);
		
		// Füllung
		g.setColor(this.getState() == 1 ? Color.GREEN : Color.RED);
		g.fillRect(this.getX() * scale, this.getY() * scale + yOffset, scale, scale);
		// Rahmen
		g.setColor(Color.BLACK);
		g.drawRect(this.getX() * scale, this.getY() * scale + yOffset, scale, scale);
	}
}