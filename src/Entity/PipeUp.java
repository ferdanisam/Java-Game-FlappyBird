package Entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import State.State;
import Main.Display;

public class PipeUp extends Entity {
	
	private final BufferedImage pipeUp=Asset.Obstacle.pipeUp;
	
	private final int[] data= {270,260,250,240,230,220,210,200,190,180,170,160,150,140,130,120,110,100};
	
	private int pipeHeight;
	
	private boolean over=true;
	
	public PipeUp(Display display,int x,int y,int width,int height) {
		super(display,x,y,width,height);
		
		pipeHeight=data[(int)(Math.random()*data.length)];
	}
	
	public void tick() {
		x-=6;
		
		int birdX=display.getRunState().getBird().x;
		
		int birdY=display.getRunState().getBird().y;
		
		int birdSize=display.getRunState().getBird().width;
		
		if(birdX+birdSize>x && birdX<x+pipeUp.getWidth()) {
			if(birdY<y+pipeHeight) {
				display.restart();
				State.setState(display.getEndState());
			}
		}
		
		if(birdX>x+pipeUp.getWidth()) {
			if(over) {
				display.getRunState().setScore(display.getRunState().getScore()+1);
				over=false;
			}
		}
		
		if(x+pipeUp.getWidth()<0) {
			display.getRunState().removePipeUp(this);
		}
	}
	
	public void render(Graphics2D g) {
		g.drawImage(pipeUp.getSubimage(0,pipeUp.getHeight()-pipeHeight,pipeUp.getWidth(),pipeHeight),x,0,null);
	}
	
	public int getX() {
		return x;
	}
}
