package applet;

import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.awt.Color;
import java.awt.Graphics2D;

import spiel.AController;
import spiel.Cell;

/**
 * GC - T3
 * 
 * Testat 3: Spiel des Lebens
 * 
 * Controller zur Anzeige des Spiels als Applet
 * 
 * @author Markus Tacker <m@tacker.org>
 * @version $Id: ControllerGraphics.java 86 2009-12-16 13:56:15Z m $
 */
public class ControllerGraphics extends AController 
{
	private Graphics2D g;
	private int currentGeneration = 0;
	private int scale;
	private BufferedImage stage;
	
	/**
	 * Graphics objekt setzen
	 * 
	 * @param Graphics
	 */
	public void setStage(BufferedImage stage)
	{
		this.stage = stage;
		this.scale = Math.min(20, (int)Math.floor((this.stage.getHeight() - 30) / this.matrixSize));
	}
	
	/**
	 * Zeichnet alle Generation, nicht sehr sinnvoll, da diese 
	 * für die Tastaturnavigation übereinander gerendert werde
	 */
	public void display()
	{
		// Erzeugte Generation ausgeben
		for(int i = 0; i <= this.generation; i++) this.displayGeneration(i);
	}
	
	/**
	 * Eine bestimmte Generation zeichnen
	 * 
	 * @param int
	 */
	public void displayGeneration(int generation)
	{
		this.printGeneration(generation);
	}
	
	/**
	 * Die nächste Generation zeichnen
	 */
	public void nextGeneration()
	{
		this.currentGeneration++;
	}
	
	/**
	 * Die vorige Generation zeichnen
	 */
	public void prevGeneration()
	{
		this.currentGeneration--;
	}
	
	/**
	 * Die aktuelle Generation zeichnen
	 */
	public void displayCurrentGeneration()
	{
		this.printGeneration(this.currentGeneration);
	}
	
	/**
	 * Ein generation ausgeben
	 * 
	 * @param int Generation
	 */
	private void printGeneration(int generation)
	{
		// Hole Graphic-Object aus dem Buffered Image
		this.g = this.stage.createGraphics();
		
		// Hintergrund zeichnen
	    this.g.setBackground(Color.BLACK);
	    this.g.clearRect(0, 0, this.stage.getWidth(), this.stage.getHeight());
		// Zellen zeichnen
		if (generation > this.generation) generation = 0;
		if (generation < 0) generation = this.generation;
		this.currentGeneration = generation;
		int cellValue;
		int[][] currentGenerationMatrix = this.getGeneration(generation);
		Cell currentCell; 
		for(int y = 0; y < currentGenerationMatrix.length; y++) {
			for(int x = 0; x < currentGenerationMatrix.length; x++) {
				new Cell(currentGenerationMatrix[y][x], x, y, currentGenerationMatrix).draw(this.g, this.scale);	
			}
		}
		// Texte unter den Kacheln
		int yPos = (this.matrixSize * scale) + Math.max(20, this.scale);
		this.g.setColor(Color.WHITE);
		this.g.drawString(generation + ". Generation", 0, yPos);
		this.g.drawString("Navigation durch die Generation mit den Pfeiltasten.", 0, yPos + Math.max(20, this.scale));
		this.g.drawString("Abspielen der Animation mit Enter.", 0, yPos + 2 * Math.max(20, this.scale));
		String status = "";
		if (this.getAllDead()) {
			status += "Alle tot. ";
		}
		if (this.getStable()) {
			status += "Matrix stabil. ";
		}
		if (status.length() > 0) {
			status += "(nach " + this.generation + " Generationen)";
			this.g.drawString(status, 0, yPos + 3 * Math.max(20, this.scale));
		}
		// Fertig
		this.g.dispose();
	}
}