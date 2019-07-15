package Handler;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyActionHandler implements KeyListener {

	private boolean jump=false;
	
	
	public void keyPressed(KeyEvent event) {
		if(event.getKeyCode()==KeyEvent.VK_SPACE) {
			jump=true;
		}
	}

	public void keyReleased(KeyEvent event) {
		
	}
	
	public void keyTyped(KeyEvent event) {

	}
	
	public void tick() {
		jump=false;
	}
	
	public boolean getJump() {
		return jump;
	}
	
}
