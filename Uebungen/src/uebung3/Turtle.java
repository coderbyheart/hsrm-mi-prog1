package uebung3;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;


/**Grafische Figur, deren Bewegung steuerbar ist.
 * 
 * Die Figur kann ueber den Bildschirm gesteuert werden. Dabei wird der Weg der 
 * Figur als Linie gezeichnet. Die Figur kann frei ueber den Bildschirm gesteuert werden. 
 * Die Schrittgoesse wird in Pixeln, die Drehung der Figur in Grad angegeben.
 * 
 * @author berdux@fh-brandenburg.de
 * @version 1.0
 */
public class Turtle {
	private ArrayList positions = new ArrayList(); // Positionsangaben der Figur
	private int step = 0; // aktuelle Position der Figur
	private Color actColor = Color.BLACK; // Farbe in der die Figur und der Weg gezeichnet wird
	private double actAngle = 0; // aktueller Winkel, in der die Figur sich bewegt
	
	/**Setzt die Farbe der Figur und des Weges.
	 * 
	 * Farbe, mit der die Figur inkl. des Weges gezeichnet wird.
	 * Die Farbe wird auschliesslich ab der aktuellen Position der Figur geaendert.
	 * 
	 * @param c Farbe der Figur
	 */
	public void setColor(Color c){
		this.actColor = c;
	}
	
	/**Setzt die Figur an die angebene Startposition.
	 * 
	 * Alte Positionsangaben werden gelöscht und die aktuelle Position gesetzt. 
	 * 
	 * @param x x-Position der Figur in Pixel
	 * @param y y-Position der Figur in Pixel
	 */
	public void setStartpoint(int x, int y){
		Position newPosition = new Position(x , y, false);
		newPosition.setColor(this.actColor);
		newPosition.setAngle(0);
		positions = new ArrayList();
		positions.add(newPosition);
	}
	
	/**Setzt die Figur an die angebene Position.
	 * 
	 * Alte Positionen werden weiterhin 
	 * @param x
	 * @param y
	 */
	public void jumpTo(int x, int y){
		Position newPosition = new Position(x , y, false);
		newPosition.setColor(this.actColor);
		newPosition.setAngle(this.actAngle);
		positions.add(newPosition);
	}
	
	/**Bewegt die Figur um x Pixel nach links.
	 * 
	 * @param x Schritte in Pixel
	 */
	public void goLeft(int x){
		Position actPosition = (Position)positions.get(positions.size()-1);
		Position newPosition = new Position(actPosition.x - x, actPosition.y);
		newPosition.setColor(this.actColor);
		positions.add(newPosition);
	}
	
	/**Bewegt die Figur um x Pixel nach rechts.
	 * 
	 * @param x Schritte in Pixel
	 */
	public void goRight(int x){
		Position actPosition = (Position)positions.get(positions.size()-1);
		Position newPosition = new Position(actPosition.x + x, actPosition.y);
		newPosition.setColor(this.actColor);
		positions.add(newPosition);
	}
	
	/**Bewegt die Figur um x Pixel nach unten.
	 * 
	 * @param y Schritte in Pixel
	 */
	public void goDown(int y){
		Position actPosition = (Position)positions.get(positions.size()-1);
		Position newPosition = new Position(actPosition.x, actPosition.y + y);
		newPosition.setColor(this.actColor);
		positions.add(newPosition);
	}
	
	/**Bewegt die Figur um x Pixel nach oben.
	 * 
	 * @param y Schritte in Pixel
	 */
	public void goUp(int y){
		Position actPosition = (Position)positions.get(positions.size()-1);
		Position newPosition = new Position(actPosition.x, actPosition.y - y);
		newPosition.setColor(this.actColor);
		positions.add(newPosition);
	}
	
	/**Bewegt die Figur um x Pixel.
	 * 
	 * Die Bewegung der Figur wird in der Richtung des aktuellen Winkels der Figur
	 * ausgeführt.
	 * 
	 * @param x Schritte in Pixel
	 */
	public void go(int x){
		Position actPosition = (Position)positions.get(positions.size()-1);
		double angle = 2*Math.PI*this.actAngle/360; // rechne Winkel in Grad um
		Position newPosition = new Position(actPosition.x + (int)Math.round(Math.cos(angle)* x), actPosition.y + (int)Math.round(Math.sin(angle)* x));
		newPosition.setColor(this.actColor);
		positions.add(newPosition);
	}

	/**Veraendert die Richtung der Figur um den Winkel a.
	 * 
	 * Die Bewegung der Figur wird in der Richtung des aktuellen Winkels der Figur
	 * ausgeführt.
	 * 
	 * @param a Drehwinkel in Grad, um den die Figur gedreht wird.
	 */
	public void rotate(int a){
		this.actAngle += a;
	}
	
	/**Bewegt die Figur einen Schritt weiter.
	 * 
	 * Setzt die aktuelle Position der Figur einen Schritt weiter, solange
	 * die Figur nicht die Endposition erreicht hat.
	 */
	public void nextStep(){
		if (this.positions.size() > step + 1)
			step++;
	}
	
	/**Zeichnet die Figur.
	 * 
	 * Zeichnet die Figur und den Weg - ab der Startposition der Figur - bis zum
	 * aktuell gesetzten Schritt.
	 * 
	 * @param g Grafikkontext, auf den die Figur dargestellt wird.
	 */
	public void paint(Graphics g){
		Position point1 = null, point2 = null;
		
		// zeichne Weg der Figur ...
		point1 = (Position)this.positions.get(0); // hole Startposition
		for (int s = 0; s < step && s + 1 < this.positions.size();s++){
			point2 = (Position)this.positions.get(s+1);
			g.setColor(point2.actColor);
			if (point2.hasPrevious) // wenn es nicht die Startposition und kein Sprung ist
				g.drawLine(point1.x, point1.y, point2.x , point2.y);
			point1 = point2;
		}
		
		// zeichne Figur ...
		if (point2 == null){ // wenn Figur noch keinen Weg zurueckgelegt hat ...
			point2 = (Position)this.positions.get(0);
			g.setColor(point2.actColor);
		}
		g.fillOval(point2.x - 3, point2.y - 3, 6, 6);
	}
 }
