package Entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import Main.Display;
import State.State;

public class PipeDown extends Entity {
	
	private final BufferedImage pipeDown=Asset.Obstacle.pipeDown;
	
	private final int[] data= {270,260,250,240,230,220,210,200,190,180,170,160,150,140,130,120,110,100};
	
	private int pipeHeight;
	
	public PipeDown(Display display,int x,int y,int width,int height) {
		super(display,x,y,width,height);
		
		pipeHeight=data[(int)(Math.random()*data.length)];
	}
	
	public void tick() {
		x-=6;
		
		int birdX=display.getGameState().getBird().x;
		
		int birdY=display.getGameState().getBird().y;
		
		int birdSize=display.getGameState().getBird().width;
		
		if(birdX+birdSize>x && birdX<x+pipeDown.getWidth()) {
			if(birdY+birdSize>y+display.getHeight()-100-pipeHeight) {
				display.restart();
				State.setState(display.getEndState());
			}
		}
		
		if(x+pipeDown.getWidth()<0) {
			display.getGameState().removePipeDown(this);
		}
	}
	
	public void render(Graphics2D g) {
		g.drawImage(pipeDown.getSubimage(0,0,pipeDown.getWidth(),pipeHeight),x,display.getHeight()-100-pipeHeight,null);
	}
}
