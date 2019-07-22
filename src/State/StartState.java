package State;

import java.awt.Color;
import java.awt.Graphics2D;

import Asset.Background;
import Main.Display;

public class StartState extends State {
	
	public StartState(Display display) {
		super(display);
	}

	
	public void tick() {
		if(display.getMouseActionHandler().getPressed()) {
			State.setState(display.getRunState());
		}
	}
	
	public void render(Graphics2D g) {
		g.setColor(Color.PINK);
		g.fillRect(0,0,display.getWidth(),display.getHeight());
		g.drawImage(Background.start,0,0,display.getWidth(),display.getHeight(),null);
	}
}
