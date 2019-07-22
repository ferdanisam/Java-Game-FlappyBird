package State;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import Main.Display;

public class EndState extends State {
	
	private final BufferedImage over=Asset.Background.over;
	
	public EndState(Display display) {
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
		g.drawImage(over,0,display.getHeight()/2-100,display.getWidth(),200,null);
	}
}
