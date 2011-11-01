package shape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

/**
 * GC - T1
 * 
 * Testat 4: Meine kleine Strasse
 * 
 * Zeichnet ein Haus mit den vorgegeben Werten zu Position, Größe, Wandfarbe 
 * aus der Shapebase in MeineKleineStrasse. 
 *  
 * Das Dach und die Wände werden als Polygone aufgespannt und werden von
 * der jeweiligen Methode an paint zurückgegeben. Die Fenster bedienen sich
 * fillRect und werden mittels for-Schleife in Relation zu den Maßen des
 * wall-Polygons aufgezeichnet. 
 * 
 * @author Markus Tacker <m@tacker.org>
 * @author Philipp Siegmund <philipp.siegmund@gmail.com>
 * @version $Id: Haus.java 116 2010-01-26 08:20:47Z m $
 */
public class Haus extends ShapeBase
{
	private java.awt.Color mauerfarbe; 
	private boolean lichtAn = false; 
	private Polygon roof;
	private Polygon walls;
	private Polygon door;
	private int windowWidth = 20; 
	private int windowHeight = 25;
	private Color fensterFarbeAn;
	private Color fensterFarbeAus;


	/**
	 * Konstruktor
	 * 
	 * @param x X-Koordinate des Hauses
	 * @param y Y-Koordinate des Hauses
	 * @param breite Breite des Hauses
	 * @param hoehe Höhe des Hauses
	 * @param mauerfarbe Mauerfarbe
	 */
	public Haus(int x, int y, int breite, int hoehe, Color mauerfarbe)
	{
		super(x, y, breite, hoehe);
		this.mauerfarbe = mauerfarbe;
		this.fensterFarbeAn = new Color(255, 255, 200);
		this.fensterFarbeAus = new Color(100, 100, 100);
		// Formen initialisieren
		this.createRoof();
		this.createWalls();
		this.createDoor();
	}
	
	/**
	 * Erzeugt das Polygon für das Dach ausgehend von der Breite des Hauses
	 */
	private void createRoof()
	{	
		// Dach: 50% der Breite
		int roofHeight = (int)(this.getBreite() * 0.5); 
		this.roof = new Polygon();
		// First
		this.roof.addPoint(this.getAbsoluteX(this.getBreite() / 2), this.getAbsoluteY(0));
		// Ecken
		this.roof.addPoint(this.getAbsoluteX(0), this.getAbsoluteY(roofHeight));
		this.roof.addPoint(this.getAbsoluteX(this.getBreite()), this.getAbsoluteY(roofHeight));
	}
	
	/**
	 * Erzeugt das Polygon für die Wände ausgehend von den Parametern des Hauses und des Dachs
	 */
	private void createWalls()
	{
		// Breite - 20%
		int wallWidth = (int)(this.getBreite() - this.getBreite() * 0.2); 
		int wallIndent = (int)((this.getBreite() - wallWidth) / 2);
		this.walls = new Polygon();
		Rectangle roofBox = this.roof.getBounds();
		
		// Ecken
		this.walls.addPoint(this.getAbsoluteX(wallIndent), roofBox.y + roofBox.height);
		this.walls.addPoint(this.getAbsoluteX(this.getBreite() - wallIndent), roofBox.y + roofBox.height);
		this.walls.addPoint(this.getAbsoluteX(this.getBreite() - wallIndent), this.getAbsoluteY(this.getHoehe()));
		this.walls.addPoint(this.getAbsoluteX(wallIndent), this.getAbsoluteY(this.getHoehe()));
	}
	
	/**
	 * Erzeugt das Polygon für die Tür relativ zur Position des Hauses innherhalb der wallBox
	 */
	private void createDoor()
	{
		// Breite = 30
		int doorWidth = 30; 
		int doorHeight = (int)(doorWidth * 2);
		this.door = new Polygon();
		Rectangle wallBox = this.walls.getBounds();
		
		// Ecken
		this.door.addPoint((int)wallBox.getX() + (int)(0.5 * doorWidth), (int)(wallBox.getY() + wallBox.getHeight()) - doorHeight);
		this.door.addPoint((int)wallBox.getX() + (int)(1.5 * doorWidth), (int)(wallBox.getY() + wallBox.getHeight()) - doorHeight);
		this.door.addPoint((int)wallBox.getX() + (int)(1.5 * doorWidth), (int)(wallBox.getY() + wallBox.getHeight()));
		this.door.addPoint((int)wallBox.getX() + (int)(0.5 * doorWidth), (int)(wallBox.getY() + wallBox.getHeight()));
	}
	
	/**
	 * Simuliert einen Mausklick mit den Koordinaten x, y
	 * und schaltet damit das Licht des Hauses ein oder aus
	 * 
	 * @param x X-Koordinate des Klicks
	 * @param y Y-Koordinate des Klicks
	 */
	public void lichtAendern(int x, int y)
	{
		if (x >= this.getX() && y >= this.getY() && x <= this.getX() + this.getBreite() - 1 && y <= this.getY() + this.getHoehe() - 1) {
			this.lichtAn = !this.lichtAn;
		}
	}
	
	/**
	 * Zeichnet das Haus auf der Grafikausgabe mit den erhaltenen
	 * Werten von paintRoof, paintWalls und paintWindows.
	 * 
	 * @param g Grafik-Objekt
	 */
	public void paint(Graphics g)
	{
		this.paintRoof(g);
		this.paintWalls(g);
		this.paintDoor(g);
		this.paintWindows(g);
	}
	
	/**
	 * Zeichnet das Dach
	 * 
	 * @param g	Grafik-Objekt
	 */
	private void paintRoof(Graphics g)
	{	
		g.setColor(Color.RED);
		g.fillPolygon(this.roof);
	}
	
	/**
	 * Zeichnet die Wände
	 * 
	 * @param g 	Grafik-Objekt
	 */
	private void paintWalls(Graphics g)
	{
		g.setColor(this.mauerfarbe);
		g.fillPolygon(this.walls);
	}
	
	/**
	 * Zeichnet die Tür
	 * 
	 * @param g 	Grafik-Objekt
	 */
	private void paintDoor(Graphics g)
	{
		g.setColor(new Color(200, 200, 200));
		g.fillPolygon(this.door);
	}
	
	/**
	 * Zeichnet die Fenster abhängig von der Breite und der Höhe des Hauses.
	 * 
	 * paintWindows durchläuft mehrfach zwei Schleifen, um die benötigte Anzahl 
	 * der Fenster und Stockwerke anhand der Höhe und Breite des Hauses zu zeichen.
	 * 
	 * Ändert bei Anforderung von lichtAendern die Fensterfarbe.
	 * 
	 * @param g 	Grafik-Objekt
	 */
	private void paintWindows(Graphics g)
	{
		Rectangle wallBox = this.walls.getBounds();
		Rectangle doorBox = this.door.getBounds();
	
		g.setColor(this.lichtAn ? this.fensterFarbeAn : this.fensterFarbeAus);
		
		/* Beide Schleifen zeichen zuerst die Fenster oberhalb der Tür
		 * Die Breite und Höhe der wallBox bestimmt die Anzahl der Fenster, 
		 * bzw die Anzahl Iterationen.
		 */
		for (int i = 0; i <= (wallBox.getHeight() - 95); i += (this.windowHeight + 10)){
			for (int j = 5; j < (wallBox.getWidth()- 10); j += (this.windowWidth + 10)){
				g.fillRect((int)wallBox.getX() + j, (int)(doorBox.getY() - (this.windowHeight + 10) - i), this.windowWidth, this.windowHeight);
			}
		}
			
		/* Anschliessend werden die Fenster rechts der Tür gezeichnet
		 * j arbeitet hier bei als Abstandhalter mit der der 1.5fachen
		 * Breite der Tür, zuzüglich 20 um sich an den anderen Fenstern 
		 * zu orientieren.
		 * Die Breite der wallBox bestimmt die Anzahl der Fenster, bzw
		 * Iterationen.
		 */
		for (int j = (int)(doorBox.getWidth() * 1.5 + 20); j < (wallBox.getWidth()- 20); j += (this.windowWidth + 10)){
			g.fillRect((int)wallBox.getX() + j, (int)doorBox.getY(), this.windowWidth , this.windowHeight);
		}
	}
}
