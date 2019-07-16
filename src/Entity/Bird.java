package Entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import Main.Display;

public class Bird extends Entity {
	
	private int alpha=5;
	
	private int delta=0;
	
	private double acceleration=0.1;
	
	private final BufferedImage upFlap=Asset.Bird.upFlap;
	
	private final BufferedImage midFlap=Asset.Bird.midFlap;
	
	private final BufferedImage downFlap=Asset.Bird.downFlap;
	
	public Bird(Display display,int x,int y,int width,int height) {
		super(display,x,y,width,height);
	}
	
	public void tick() {
		if(delta/alpha==3) {
			delta=0;
		}else {
			delta++;
		}
	
		acceleration+=0.1;
		
		y+=3*acceleration;
		
		if(display.getKeyActionHandler().getJump()) {
			acceleration=-2.5;
		}
	}
	
	public void render(Graphics2D g) {
		if(delta/alpha==0 || delta/alpha==3) {
			g.drawImage(upFlap,x,y,width,height,null);
		}else if(delta/alpha==1) {
			g.drawImage(midFlap,x,y,width,height,null);
		}else if(delta/alpha==2) {
			g.drawImage(downFlap,x,y,width,height,null);
		}
	}
}
