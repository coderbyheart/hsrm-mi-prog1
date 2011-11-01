package applet;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * GC - T3
 * 
 * Testat 3: Spiel des Lebens
 * 
 * View für das Spiel, die in einem Applet angezeigt wird
 * Instanziert das Spiel und kümmert sich um die Anzeige der 
 * einzelnen Generation mittels Tastatursteuerung
 * 
 * @author Markus Tacker <m@tacker.org>
 * @version $Id: SpielDesLebensApplet.java 86 2009-12-16 13:56:15Z m $
 */
public class SpielDesLebensApplet extends Applet implements KeyListener, Runnable
{
	private ControllerGraphics spiel;
	private boolean playing = true;
	private Thread animation;
	private long paintTime = 80;
	private BufferedImage stage;
	
	/**
	 * Konstruktor
	 * Wird immer aufgerufen, erzeugt Instanz des Spiels
	 */	
	public void init()
	{
		this.addKeyListener(this);
		// Matrixgröße einlesen
		this.spiel = new ControllerGraphics();
		this.stage = new BufferedImage(800, 600, BufferedImage.TYPE_INT_RGB);
		this.spiel.setStage(this.stage);
	}
	
	/**
	 * Aktuelle Generation zeichnen
	 * 
	 * @param Graphics
	 */
	public void paint(Graphics g)
	{
		// long start = System.currentTimeMillis();
		this.spiel.displayCurrentGeneration();
		// this.paintTime = System.currentTimeMillis() - start;
		g.drawImage(this.stage, 0, 0, this);
	}
	
	/**
	 * Eventlistener für die Tastatur
	 * 
	 * @param KeyEvent
	 */
	public void keyReleased(KeyEvent ev)
	{

	}
	
	/**
	 * Eventlistener für die Tastatur
	 * 
	 * @param KeyEvent
	 */	
	public void keyPressed(KeyEvent ev)
	{
		switch(ev.getKeyCode()) {
		case 39: // Pfeil nach rechts
			this.playing = false;
			this.spiel.nextGeneration();
			this.repaint();
			break;
		case 37: // Pfeil nach link
			this.playing = false;
			this.spiel.prevGeneration();
			this.repaint();
			break;
		case 32: // Space
		case 10: // Enter
			this.playing = !this.playing;
			if (this.playing) {
				this.animation = new Thread(this);
				this.animation.start();
			} else {
				this.animation = null;
			}
			break;
		}		
	}
	
	/**
	 * Eventlistener für die Tastatur
	 * 
	 * @param KeyEvent
	 */
	public void keyTyped(KeyEvent ev)
	{

	}
	
	/**
	 * Run-Methode des Threads
	 */
	public void run()
	{
		 Thread myThread = this.animation.currentThread();
		 while(myThread == this.animation) {
			 this.spiel.nextGeneration();
			 this.repaint();
			 try {
				 this.animation.sleep(this.paintTime);
			 } catch(InterruptedException e) {
				 // Kommt vor
			 }
		 }
	}
}