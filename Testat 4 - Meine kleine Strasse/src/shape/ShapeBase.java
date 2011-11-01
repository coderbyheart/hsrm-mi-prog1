package shape;

import java.awt.Color;

/**
 * ShapeBase ist die Basisklasse unserer Elemente
 * ShapeBase enthält alle Argumente der shapes, die zum Zeichnen
 * der Strasse benötig werden und die Argumente zur Positionierung.

 * 
 * @author Markus Tacker <m@tacker.org>
 * @author Philipp Siegmund<philipp.siegmund@gmail.com>
 * @version $Id: ShapeBase.java 114 2010-01-22 10:36:07Z m $
 */
abstract public class ShapeBase implements ShapeInterface
{
	private int x;
	private int y;
	private int breite;
	private int hoehe;
	
	/**
	 * Konstruktor
	 * 
	 * @param x X-Koordinate der Shape
	 * @param y Y-Koordinate der Shape
	 * @param breite Breite der Shape
	 * @param hoehe Höhe der Shape
	 */
	public ShapeBase(int x, int y, int breite, int hoehe)
	{
		this.x = x;
		this.y = y;
		this.breite = breite;
		this.hoehe = hoehe;
	}
	
	/**
	 * Berechnet die absoluten X-Koordinate zur übergebenen relativen X-Koordinaten
	 * 
	 * @param relativeX relative X-Koordinate
	 * @return int absolute X-Koordinaten
	 */
	protected int getAbsoluteX(int relativeX)
	{
		return this.x + relativeX;
	}
	
	/**
	 * Berechnet die absoluten Y-Koordinate zur übergebenen relativen Y-Koordinaten
	 * 
	 * @param relativeX relative Y-Koordinate
	 * @return int absolute Y-Koordinaten
	 */
	protected int getAbsoluteY(int relativeY)
	{
		return this.y + relativeY;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getBreite() {
		return breite;
	}

	public int getHoehe() {
		return hoehe;
	}
}
