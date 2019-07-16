package Entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import Main.Display;
import Asset.Number;

public class ScoreBoard extends Entity {
	
	private final BufferedImage[] numbers= {Number.zero,Number.one,Number.two,Number.three,Number.four,Number.five,Number.six,Number.seven,Number.eight,Number.nine};
	
	private int first;
	
	private int second;
	
	private int third;
	
	public ScoreBoard(Display display,int x,int y,int width,int height) {
		super(display,x,y,width,height);
	}
	
	public void tick() {
		int score=display.getGameState().getScore();
		
		first=score%10;
		
		if(score>=100) {
			second=score/10-(score/100)*10;
		}else {
			second=score/10;
		}
		
		third=score/100;
	}
	
	public void render(Graphics2D g) {
		draw(g);
	}
	
	private void draw(Graphics2D g) {
		g.drawImage(numbers[first],x+50,y,width,height,null);
			
		g.drawImage(numbers[second],x,y,width,height,null);
			
		g.drawImage(numbers[third],x-50,y,width,height,null);
			
		}
	}
