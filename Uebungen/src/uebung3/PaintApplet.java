package uebung3;
import java.applet.Applet;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author berdux
 *
 */
public class PaintApplet extends Applet implements KeyListener{
	
	
	/**Figur, die gezeichnet wird
	 */
	protected Turtle myTurtle = null;
	
	/** (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 */
	public void keyReleased(KeyEvent actEvent){
		
	}
	
	public void keyPressed(KeyEvent actEvent){
		
	}
	
	public void keyTyped(KeyEvent actEvent){
		char key = actEvent.getKeyChar();
		switch(key){
			case('n'):	myTurtle.nextStep();
						repaint();
						break;
		}
	}
	
	public void init(){
		this.addKeyListener(this);
	}
}
