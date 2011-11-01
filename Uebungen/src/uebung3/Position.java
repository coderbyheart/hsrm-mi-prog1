package uebung3;
import java.awt.Color;

/**Datentyp zum Speichern der Position und Farbe einer Figur.
 * 
 * Datentyp speichert die aktuelle Position, den Winkel, in der die Figur gedreht ist
 * und die Farbe in der der Weg ab dieser Position gezeichnet werden soll.
 * 
 * @author berdux@fh-brandenburg.de
 * @version 1.0
 */
public 	class Position {
	int x, y; //Positionsangabe in Pixel
	double angle; //Winkel, ab dieser Position der Weg beschrieben wird
	boolean hasPrevious; //soll der Punkt mit Vorgaengerpunkt verbunden werden
	Color actColor = Color.BLACK; // Farbe, in der der Weg gezeichnet werden soll
	
	/**Positionselement mit einem Vorgaenger fuer die Verbindungslinie.
	 * 
	 * @param x x-Position in Pixel.
	 * @param y y-Position in Pixel.
	 */
	public Position (int x, int y){
		this.x = x;
		this.y = y;
		this.hasPrevious = true;
	}
	
	/** Erzeugt ein neues Positionselement.
	 * 
	 * @param x x-Position in Pixel.
	 * @param y y-Position in Pixel.
	 * @param hasPrevious Verbindungslinie zu vorheriger Position
	 */
	public Position (int x, int y, boolean hasPrevious){
		this.x = x;
		this.y = y;
		this.hasPrevious = hasPrevious;
	}
	
	/**Setzt die Farbe, die ab dieser Position verwendet werden soll.
	 * 
	 * @param c Farbe
	 */
	public void setColor(Color c){
		this.actColor = c;
	}
	
	/**Setzt den Winkel, in dem die nachfolgende Position berechnet wird.
	 * 
	 * @param a Winkel in Grad.
	 */
	public void setAngle(double a){
		this.angle = a;
	}
}
