

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import berdux.MeineKleineStrasseBasis;
import shape.Auto;
import shape.ShapeBase;
import shape.Haus;
import shape.Baum;
import shape.HinterGr;


/**
 * GC - T1
 * 
 * Testat 4: Meine kleine Strasse
 * 
 * Stellt die Methoden zum Zeichnen der Strasse zur Verfügung.
 * Erweitert die Klasse MeineKleineStrasseBasis. Bei Mausklick
 * wird überprüft ob die geklickte Position ein Haus ist.
 * 
 * Veranlasst das erneute Zeichen über paint nach einem Mausklick.
 *  
 * @author Markus Tacker <m@tacker.org>
 * @author Philipp Siegmund <philipp.siegmund@gmail.com>
 * @version $Id: MeineKleineStrasse.java 117 2010-01-26 08:52:01Z philipp $
 */

public class MeineKleineStrasse extends MeineKleineStrasseBasis 
{
	private ShapeBase[] shapes;
	
	/**
	 * Größe setzen
	 */
	public void init(){
		super.init();
		this.resize(1024, 500);
	}
	
	/** 
	 * Übergabe der shape Argumente in ein Array zur Weiterverarbeitung von paint
	 *  
	 */
	public void start()
	{
		this.shapes = new ShapeBase [13];
		this.shapes[1] = new Baum(0, 200, 80, 180);
		this.shapes[0] = new Haus(40, 140, 190, 240, new Color(202, 225, 255));
		this.shapes[2] = new Haus(200, 170, 150, 210, new Color(255, 215, 0));
		this.shapes[3] = new Baum(320, 280, 100, 100).hasSnow(true);
		this.shapes[4] = new Baum(350, 180, 150, 200).hasSnow(true);
		this.shapes[5] = new Baum(400, 260, 100, 120).hasSnow(true);
		this.shapes[6] = new Haus(480, 0, 185, 380, new Color(205, 198, 115));
		this.shapes[7] = new Haus(640, 90, 150, 290, new Color(0, 205, 0));
		this.shapes[8] = new Haus(785, 10, 115, 370, new Color(143, 188, 143));
		this.shapes[9] = new Baum(875, 180, 150, 200).hasSnow(true);
		this.shapes[10] = new Baum(860, 260, 100, 120).hasSnow(true);
		this.shapes[11]= new Auto(150, 410, 150, 75, Color.RED);
		this.shapes[12]= new Auto(550, 370, 150, 75, Color.BLUE);
		
	}

	/** 
	 * Aufloesung der x, y-Position, an der Maus-Button betaetigt wurde.
	 * 
	 * Umsetzung der Methode
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 * 
	 * @param e Maus-Ereignis, das ausgeloest wurde 
	 */
	public void mouseClicked(MouseEvent e){
		int x, y;
		
		x = e.getX(); // x-Koordinate, an der Mausereignis stattgefunden hat
		y = e.getY(); // y-Koordinate, an der Mausereignis stattgefunden hat
		
		for(int i = 0; i < this.shapes.length; i++) {
			if (this.shapes[i] instanceof Haus) {
				Haus currentHaus = (Haus)this.shapes[i];
				currentHaus.lichtAendern(x, y);
			}
		}
		
		// nach jeder Veraenderung soll der Graphik-Kontext neu gezeichnet werden
		repaint();
	}
	
	/** 
	 * Erhält alle Argument, die nötig sind um alle Shapes zu zeichen. 
	 * Zeichnet alle Shapes aus dem Array ShapeBase auf die Zeichenfläche
	 * 
	 * @param g Grafik-Objekt
	 */
	public void paint(Graphics g)
	{
		g.clearRect(0, 0, g.getClipBounds().width, g.getClipBounds().height);
		HinterGr.draw(g);
		for(int i = 0; i < this.shapes.length; i++) {
			this.shapes[i].paint(g);	
		}			
	}
	

	/** 
	 * Zeichnet erneut Shapes auf die Zeichenfläche
	 * 
	 * @param g Grafik-Objekt
	 *  
	 */
	public void update(Graphics g){
		paint(g);
		
	}
}
