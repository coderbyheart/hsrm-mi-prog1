package uebung6;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

/**
 * Rendert einen Farbverlauf, von rot nach weiß, wobei rot mit 255 vorgegeben ist
 * 
 * @author Markus Tacker <m@tacker.org>
 */
public class Farbraum extends Applet 
{
	/**
	 * Farbverlauf zeichnen
	 * 
	 * @param Graphics
	 */
	public void paint(Graphics graphics)
	{
		int x = 0;
		int y = 0;
		int r = 255;
		for(int g = 0; g <= 255; g++) {
			for(int b = 0; b <= 255; b++) {
				graphics.setColor(new Color(r, g, b));
				graphics.drawLine(x, y, x, y);
				x++;
				if (x % 256 == 0) {
					y++;
					x = 0;
				}
			}
		}
	}
}