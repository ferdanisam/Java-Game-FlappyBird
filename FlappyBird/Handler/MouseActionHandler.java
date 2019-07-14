package Handler;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseActionHandler implements MouseListener {
	
	private boolean pressed=false;

	public void mousePressed(MouseEvent event) {
		pressed=true;
	}

	public void mouseReleased(MouseEvent event) {
	
	}
	
	public void mouseClicked(MouseEvent event) {
		
	}

	public void mouseEntered(MouseEvent event) {
		
	}

	public void mouseExited(MouseEvent event) {
		
	}
	
	public void tick() {
		pressed=false;
	}
	
	public boolean getPressed() {
		return pressed;
	}
	
}
