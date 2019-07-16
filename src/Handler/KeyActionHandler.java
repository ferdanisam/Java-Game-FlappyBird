package Handler;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Main.Display;

public class KeyActionHandler implements KeyListener {

	private Display display;
	
	private boolean jump=false;

	private int pause=2;
	
	private boolean quit=false;
	
	public KeyActionHandler(Display display) {
		this.display=display;
	}
	
	public void keyPressed(KeyEvent event) {
		if(event.getKeyCode()==KeyEvent.VK_SPACE) {
			jump=true;
		}
		
		if(event.getKeyCode()==KeyEvent.VK_P) {
			pause++;
		}
		
		if(event.getKeyCode()==KeyEvent.VK_ESCAPE) {
			quit=true;
		}
	}

	public void keyReleased(KeyEvent event) {
		
	}
	
	public void keyTyped(KeyEvent event) {
		
	}
	
	public void tick() {
		jump=false;
		
		if(quit==true) {
			display.stop();
		}
		
	}
	
	public boolean getJump() {
		return jump;
	}
	
	public int getPause() {
		return pause;
	}
	
}
