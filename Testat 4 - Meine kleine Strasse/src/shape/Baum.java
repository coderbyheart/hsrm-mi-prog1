package shape;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.Rectangle;

/**
 * Zeichnet einen Baum mit vorgegebenen Größen aus der ShapeBase
 * aus MeineKleineStrasse.
 * 
 * @author Markus Tacker <m@tacker.org>
 * @author Philipp Siegmund<philipp.siegmund@gmail.com>
 * @version $Id: Baum.java 116 2010-01-26 08:20:47Z m $
 */
public class Baum extends ShapeBase
{
	private char type;
	private int laubBaumBreite;
	private int laubBaumHoehe;
	private Color baumColor;
	private Color trunkColor;
	private Color snowColor; 
	private Polygon trunk;
	private Polygon[] nadeln;
	private boolean snow = false;
	private int laubBaumX;
	private int laubBaumY;
	private GradientPaint snowPaint;
	
	/**
	 * Konstruktor
	 * 
	 * @param x X-Koordinate des Baumes
	 * @param y Y-Koordinate des Baumes
	 * @param breite Breite des Baumes
	 * @param hoehe Höhe des Baumes
	 */
	public Baum(int x, int y, int breite, int hoehe)
	{
		super(x, y, breite, hoehe);
		this.type = Math.random() > 0.5 ? 'n' : 'l';
		this.laubBaumBreite = (int)(this.getBreite() * (0.5 + Math.random() * 0.5));
		this.baumColor = new Color((int)(Math.random() * 100), 50 + (int)(Math.random() * 50), (int)(Math.random() * 50));
		this.trunkColor = new Color(50 + (int)(Math.random() * 20), 30 + (int)(Math.random() * 20), (int)(Math.random() * 20));
		this.laubBaumHoehe = (int)(this.getHoehe() * (0.5 + Math.random() * 0.35));
		// Formen initialisieren
		this.createTrunk();
		switch(this.type) {
		case 'n': 
			this.createNadelGreen();
			break;
		case 'l': 
			this.laubBaumX = this.getAbsoluteX((int)((this.getBreite() - this.laubBaumBreite) / 2));
			this.laubBaumY = this.getAbsoluteY(0);
			break;
		}
	}
	
	/**
	 * Bestimmt, ob Schnee auf dem Baum liegt
	 * 
	 * @param Schnee an/ausschalten
	 * @return Instanz des Baumes
	 */
	public Baum hasSnow(boolean snow)
	{
		this.snow = snow;
		if (snow) {
			this.snowColor = new Color(255, 255, 255);
			float gradientX = this.laubBaumY + (this.laubBaumHoehe / 2);
			this.snowPaint = new GradientPaint(gradientX, this.laubBaumY, this.snowColor, gradientX, this.laubBaumY + this.laubBaumHoehe, this.baumColor);
		}
		return this;
	}
	
	/**
	 * Erzeugt das Polygon für den Stamm in unterschiedlichen Farben mittels Math.random
	 */
	private void createTrunk()
	{
		this.trunk = new Polygon();
		int breiteUnten = (int)(this.getBreite() * 0.2);
		// Unten links
		this.trunk.addPoint(this.getAbsoluteX((this.getBreite() / 2) - (breiteUnten / 2)), this.getAbsoluteY(this.getHoehe()));
		// Unten rechts
		this.trunk.addPoint(this.getAbsoluteX((this.getBreite() / 2) + (breiteUnten / 2)), this.getAbsoluteY(this.getHoehe()));
		// Oben rechts
		this.trunk.addPoint(this.getAbsoluteX((this.getBreite() / 2) + (breiteUnten / 4)), this.getAbsoluteY(this.getHoehe() / 2));
		// Oben links
		this.trunk.addPoint(this.getAbsoluteX((this.getBreite() / 2) - (breiteUnten / 4)), this.getAbsoluteY(this.getHoehe() / 2));
	}
	
	/**
	 * Erzeugt die Polygone für das Grün eines Nadelbaums
	 */
	private void createNadelGreen()
	{
		int greenHeight = (int)(this.getHoehe() * 0.8);
		int steps = greenHeight / 10;
		this.nadeln = new Polygon[steps];
		Polygon currGreen;
		for (int n = 1; n <= steps; n++) {
			int greenBreite = (int)(this.getBreite() / (steps - 1) * n);
			currGreen = new Polygon();
			currGreen.addPoint(this.getAbsoluteX((int)(this.getBreite() / 2)), this.getAbsoluteY(n * 10));
			currGreen.addPoint(this.getAbsoluteX((int)((this.getBreite() - greenBreite) / 2)), this.getAbsoluteY(n * 10 + 20));
			currGreen.addPoint(this.getAbsoluteX((int)((this.getBreite() - greenBreite) / 2) + greenBreite), this.getAbsoluteY(n * 10 + 20));
			this.nadeln[n - 1] = currGreen;
		}
	}
	
	/**
	 * Zeichnet den Baum auf der Grafikausgabe
	 * 
	 * @param g Grafik-Objekt
	 */
	public void paint(Graphics g)
	{
		this.paintTrunk(g);
		this.paintGreen(g);
	}
	
	/**
	 * Zeichnet den Stamm
	 * 
	 * @param g 		Grafik-Objekt
	 */
	private void paintTrunk(Graphics g)
	{
		g.setColor(this.trunkColor);
		g.fillPolygon(this.trunk);
	}
	
	/**
	 * Bestimmt Grün abhängig von der vorher bestimmten Sorte 
	 * 
	 * @param g Grafik-Objekt
	 */
	private void paintGreen(Graphics g)
	{
		switch(this.type) {
		case 'n': 
			this.paintNadelGreen(g);
			break;
		case 'l': 
			this.paintLaubGreen(g);
			break;
		}
	}
	
	/**
	 * Zeichnet das Grün eines Nadelbaums
	 * 
	 * @param g Grafik-Objekt
	 */
	private void paintNadelGreen(Graphics g)
	{
		for (int n = 0; n < this.nadeln.length; n++) {
			if (this.snow) {
				int rb = Math.max(10, 255 - n * 20);
				g.setColor(new Color(rb, 255 - n * 10, rb));
			} else {
				g.setColor(new Color(10, 255 - n * 10, 10));
			}			
			g.fillPolygon(this.nadeln[n]);
		}
	}
	
	/**
	 * Zeichnet das Grün eines Laubbaums mit variablen Größen der Baumkrone
	 * 
	 * @param g Grafik-Objekt
	 */
	private void paintLaubGreen(Graphics g)
	{
		if (this.snow) {
			Graphics2D g2 = (Graphics2D)g;
			g2.setPaint(this.snowPaint);
			g2.fillOval(this.laubBaumX, this.laubBaumY, this.laubBaumBreite, this.laubBaumHoehe);
		} else {
			g.setColor(this.baumColor);
			g.fillOval(this.laubBaumX, this.laubBaumY, this.laubBaumBreite, this.laubBaumHoehe);	
		}
	}
}
