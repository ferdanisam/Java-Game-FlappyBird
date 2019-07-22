package Entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import Asset.Obstacle;
import Main.Display;
import State.State;

public class Base extends Entity {
	
	private final BufferedImage base=Obstacle.base;
	
	public Base(Display display,int x,int y,int width,int height) {
		super(display,x,y,width,height);
	}
	
	public void tick() {
		if(x>=0) {
			x=-display.getWidth();
		}else {
			x+=6;
		}
		
		if(display.getRunState().getBird().y+display.getRunState().getBird().height>=this.y) {
			State.setState(display.getStartState());
			display.restart();
		}
	}
	
	public void render(Graphics2D g) {
		g.drawImage(base,x,y,width,height,null);
	}
}
