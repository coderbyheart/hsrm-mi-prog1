package berdux;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


/** 
 * Basis-Applet stellt Grundfunktionen f�r den Aufbau interaktiver Anwendungen zur
 * Verfuegung.
 *  
 * Alle Mausereignisse koennen in einzelnen Methoden verarbeitet werden. 
 *  
 * @author Joerg Berdux
 * @version 1.0
 */
public class MeineKleineStrasseBasis extends Applet implements MouseListener {


	/**
	 * Initialisierung des Applets und setzen des MouseListerns
	 * fuer die Verwendung von Maus-Ereignissen
	 */
	public void init(){
		/* registriert Applet als MouseListener, so dass die jeweilige spezialisierte 
		 * Methoden aufgerufen wird, wenn ein Mausereignis innerhalb des Applets ausgeloest 
		 * wird
		 */
		this.addMouseListener(this);
	}
	
	/** 
	 * Initialisierung der Objekte, die verwaltet und angezeigt werden sollen
	 * 
	 * @see java.applet.Applet#start()
	 */
	public void start(){

	}
	
	/** 
	 * Zeichnen aller Objekte, die zu der Strasse gehoeren.
	 * 
	 * Umsetzung der Methode
	 * @see java.awt.Component#paint(java.awt.Graphics)
	 * 
	 * @param g Garphik-Kontext, auf dem Haeuser und Baeume gezeichnet werden
	 */
	public void paint(Graphics g){

	}
	
	/** 
	 * Aufloesung der x, y-Position, an der Mausbutton betaetigt wurde.
	 * 
	 * diese Methode muss in MeineKleineStrasse ueberschrieben werden, 
	 * da sie noch keine Funktion implementiert.
	 * 
	 * Umsetzung der Methode
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 * 
	 * @param e Maus-Ereignis, das ausgeloest wurde 
	 */
	public void mouseClicked(MouseEvent e){
	}
	
	/** Faengt Mouse-Event ab, ohne ihn weiter zu verarbeiten
	 * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
	 */
	public void mouseEntered(MouseEvent e){

	}
	
	/** Faengt Mouse-Event ab, ohne ihn weiter zu verarbeiten
	 * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
	 */
	public void mouseExited(MouseEvent e){

	}
	
	/** Faengt Mouse-Event ab, ohne ihn weiter zu verarbeiten
	 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	 */
	public void mousePressed(MouseEvent e){

	}

	/** Faengt Mouse-Event ab, ohne ihn weiter zu verarbeiten
	 * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
	 */
	public void mouseReleased(MouseEvent e){

	}

}
