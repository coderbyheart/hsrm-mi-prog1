package uebung3;
import java.awt.Color;
import java.awt.Graphics;

/**Applet zum Zeichnen einer Figur.
 * 
 * Die Figur kann ueber Befehle gesteuert werden, so dass verschiedene Muster 
 * gezeichnet werden koennen. Die Wegbeschreibung der Figur findet direkt waehrend des 
 * Starts des Applets statt. 
 * 
 * Ueber die Tastate 'n' kann die Figur Schritt fuer Schritt weitergefuehrt werden.
 * 
 * @author berdux@fh-brandenburg.de
 * @version 1.0
 */
public class TurtleApplet extends PaintApplet{
	
	public void start(){

		myTurtle = new Turtle(); // erzeugt eine neue Figur
		
		/* Setze den Weg der Figur 'myTurle' mit den Befehlen: 
		 * setStartpoint(x,y)
		 * rotate(a)
		 * go(x)
		 * jumpTo(x,y)
		 * setColor(c) mit den Farben Color.GREEN, Color.BLACK, Color.RED, Color.ORANGE
		 * 
		 * z.B. myTurtle.setStartpoint(100, 100);
		 */

		// Zwei Rechtecke zeichnen
		myTurtle.setStartpoint(20,20);
		this.drawRect(myTurtle);
		myTurtle.jumpTo(20,60);
		this.drawRect(myTurtle);
		
		// Zwei farbige Rechtecke zeichnen
		myTurtle.jumpTo(60,20);
		myTurtle.setColor(Color.ORANGE);
		this.drawRect(myTurtle);
		myTurtle.jumpTo(60,60);
		myTurtle.setColor(Color.RED);
		this.drawRect(myTurtle);
		
		// Buntes dreieck zeichnen
		myTurtle.jumpTo(20,120);
		myTurtle.rotate(-45);
		myTurtle.setColor(Color.GREEN);
		myTurtle.go(20);
		myTurtle.rotate(90);
		myTurtle.setColor(Color.RED);
		myTurtle.go(20);
		myTurtle.rotate(135);
		myTurtle.setColor(Color.ORANGE);
		myTurtle.go((int)Math.round(Math.sqrt(Math.pow(20, 2) * 2)));
		
		// Das Haus vom Nikolaus zeichnen
		int len = 40;
		int sLen = (int)Math.round(Math.sqrt(Math.pow(len, 2) * 2));
		myTurtle.jumpTo(80,180);
		myTurtle.setColor(Color.BLACK);
		myTurtle.rotate(90);
		myTurtle.go(len);
		myTurtle.rotate(90);
		myTurtle.go(len);
		myTurtle.rotate(-135);
		myTurtle.go(sLen / 2);
		myTurtle.rotate(-90);
		myTurtle.go(sLen / 2);
		myTurtle.rotate(-90);
		myTurtle.go(sLen);
		myTurtle.rotate(-135);
		myTurtle.go(len);
		myTurtle.rotate(-135);
		myTurtle.go(sLen);
		myTurtle.rotate(-135);
		myTurtle.go(len);
	}
	
	/**Zeichnet die Figur inkl. des Weges bis zur aktuellen Position.
	 * 
	 * @param g Grafikkontext auf dem die Figur gezeichnet wird.
	 */
	public void paint(Graphics g){
		g.drawString("My Turtle", 85, 30);
		myTurtle.paint(g); // zeichnet die Figur und den Weg bis zur aktuellen Position
	}
	
	protected void drawRect(Turtle t)
	{
		t.go(20);
		t.rotate(90);
		t.go(20);	
		t.rotate(90);
		t.go(20);
		t.rotate(90);
		t.go(20);
		t.rotate(90);
	}
}
