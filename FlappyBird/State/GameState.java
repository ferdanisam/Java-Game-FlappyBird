package State;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import Asset.Background;
import Entity.Base;
import Entity.Bird;
import Entity.PipeDown;
import Entity.PipeUp;
import Entity.ScoreBoard;
import Main.Display;

public class GameState extends State {
	
	private int alpha=600;
	
	private int delta=0;
	
	private final BufferedImage day=Background.day;
	
	private final BufferedImage night=Background.night;
	
	private Base base;
	
	private PipeUp pipeUp;
	
	private PipeDown pipeDown;
	
	private Bird bird;
	
	private ScoreBoard scoreBoard;
	
	private int score=0;
	
	public GameState(Display display) {
		super(display);
		
		initialize();
	}
	
	private void initialize() {
		scoreBoard=new ScoreBoard(display,display.getWidth()/2-50/2,150,50,50);
		
		base=new Base(display,-display.getWidth(),display.getHeight()-100,display.getWidth()*2,100);
		
		pipeUp=new PipeUp(display,display.getWidth(),0,0,0);

		pipeDown=new PipeDown(display,display.getWidth(),0,0,0);
		
		bird=new Bird(display,200,200,40,40);
	}
	
	public void tick() {
		scoreBoard.tick();
		
		base.tick();
		
		pipeUp.tick();
		
		pipeDown.tick();
		
		bird.tick();
		
		if(delta/alpha==2) {
			delta=0;
		}else {
			delta++;
		}
		
		if(pipeUp.getX()<=0) {
			pipeUp=new PipeUp(display,display.getWidth(),0,0,0);
			
			pipeDown=new PipeDown(display,display.getWidth(),0,0,0);
			
			score++;
		}
	}
	
	public void render(Graphics2D g) {
		if(delta/alpha==0 || delta/alpha==2) {
			g.drawImage(day,0,0,display.getWidth(),display.getHeight(),null);
		}else if(delta/alpha==1) {
			g.drawImage(night,0,0,display.getWidth(),display.getHeight(),null);
		}
		
		scoreBoard.render(g);
		
		base.render(g);
		
		pipeUp.render(g);
		
		pipeDown.render(g);
		
		bird.render(g);
		
	}
	
	public int getScore() {
		return score;
	}
	
	public Bird getBird() {
		return bird;
	}
}
