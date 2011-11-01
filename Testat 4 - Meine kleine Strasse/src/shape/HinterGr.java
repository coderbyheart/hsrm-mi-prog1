package shape;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Zeichnet den Hintergrund der Strasse
 * 
 * @author Markus Tacker<m@tacker.org>
 * @author Philipp Siegmund<philipp.siegmund@gmail.com>
 * @version $Id: HinterGr.java 114 2010-01-22 10:36:07Z m $
 */

public class HinterGr {
	
	/**
	 * Zeichnet den blauen Hintergrund, die Rasenfläche,
	 * die Strasse und die Markierungen 
	 * 
	 * @param g Grafik-Objekt
	 */
	
	public static void draw(Graphics g){
	
	g.setColor(new Color(0, 154, 205));
	g.fillRect(0, 0, 1024, 500);
		
	g.setColor(new Color(34,139,34));
	g.fillRect(0,380, 1024, 120);
	
	g.setColor(Color.DARK_GRAY);
	g.fillRect(0, 400, 1024, 80);
	
	g.setColor(Color.WHITE);
	for (int i = 0; i <= 896; i += 128){
		g.fillRect(i, 438, 64, 4);
	}

	}
}