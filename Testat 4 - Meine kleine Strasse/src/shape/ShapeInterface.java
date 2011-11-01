package shape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

/**
 * Zeichnet ein Haus mit
 * - unterschiedlichen Größe
 * - unterschiedlicher Wandfarbe
 * - unterschiedlichen Fenstern
 * 
 * @author Markus Tacker <m@tacker.org>
 * @version $Id: ShapeInterface.java 114 2010-01-22 10:36:07Z m $
 */
interface ShapeInterface
{
	/**
	 * Zeichnet das Haus auf der Grafikausgabe
	 * 
	 * @param g Grafik-Objekt
	 */
	public void paint(Graphics g);
}