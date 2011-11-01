package shape;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

/**
 * Zeichnet eine Auto mit vorgegebenen Größen aus der ShapeBase
 * aus MeineKleineStrasse.
 * 
 * @author Markus Tacker <m@tacker.org>
 * @author Philipp Siegmund<philipp.siegmund@gmail.com>
 * @version $Id
 */


public class Auto extends ShapeBase {

	
	private Color autofarbe;
	private Polygon karosserie;
	private int radDurchmesser = 30;

	/**
	 * Konstruktor
	 * 
	 * @param x X-Koordinate des Autos
	 * @param y Y-Koordinate des Autos
	 * @param breite Breite des Autos
	 * @param hoehe Höhe des Autos
	 * @param autofarbe Autofarbe
	 */
	public Auto(int x, int y, int breite, int hoehe, Color autofarbe){
		
		super(x, y, breite, hoehe);
		this.autofarbe = autofarbe;
		this.createKarosserie();
	}
	
	/**
	 * Karosserie erzeugen
	 */
	private void createKarosserie()
	{
		this.karosserie = new Polygon();
		this.karosserie.addPoint(this.getAbsoluteX(0), this.getAbsoluteY(this.getHoehe() / 3));
		this.karosserie.addPoint(this.getAbsoluteX(this.getBreite() / 5), this.getAbsoluteY(this.getHoehe() / 3));
		this.karosserie.addPoint(this.getAbsoluteX(this.getBreite() / 5 * 2), this.getAbsoluteY(0));
		this.karosserie.addPoint(this.getAbsoluteX(this.getBreite() / 5 * 3), this.getAbsoluteY(0));
		this.karosserie.addPoint(this.getAbsoluteX(this.getBreite() / 5 * 4), this.getAbsoluteY(this.getHoehe() / 3));
		this.karosserie.addPoint(this.getAbsoluteX(this.getBreite()), this.getAbsoluteY(this.getHoehe() / 3));
		this.karosserie.addPoint(this.getAbsoluteX(this.getBreite()), this.getAbsoluteY(this.getHoehe() / 3 * 2));
		this.karosserie.addPoint(this.getAbsoluteX(0), this.getAbsoluteY(this.getHoehe() / 3 * 2));
	}
	
	/**
	 * Zeichnet das Haus auf der Grafikausgabe mit den erhaltenen
	 * Werten von paintRoof, paintWalls und paintWindows.
	 * 
	 * @param g Grafik-Objekt
	 */
	public void paint(Graphics g)
	{
		this.paintKarosserie(g);
		this.paintRad(g);
	}
	
	/**
	 * Karosserie zeichnen
	 * 
	 * @param Graphics Kontext
	 */
	private void paintKarosserie(Graphics g)
	{
		Graphics2D g2 = (Graphics2D)g;
		Rectangle kBox = this.karosserie.getBounds();
		g2.setPaint(new GradientPaint((int)kBox.getX(), (int)kBox.getY(), Color.GRAY, (int)kBox.getX(), (int)kBox.getY() + (int)kBox.getHeight(), this.autofarbe));
		// g.setColor(this.autofarbe);
		g2.fillPolygon(this.karosserie);
	}
	
	/**
	 * Räder zeichnen
	 * 
	 * @param Graphics Kontext
	 */
	private void paintRad(Graphics g)
	{
		g.setColor(Color.BLACK);
		g.fillOval(this.getAbsoluteX(this.getBreite() / 5) - (this.radDurchmesser / 2), this.getAbsoluteY(getHoehe() / 3 * 2) - (this.radDurchmesser / 2), this.radDurchmesser, this.radDurchmesser);
		g.fillOval(this.getAbsoluteX(this.getBreite() / 5 * 4) - (this.radDurchmesser / 2), this.getAbsoluteY(getHoehe() / 3 * 2) - (this.radDurchmesser / 2), this.radDurchmesser, this.radDurchmesser);
	}
}
	



