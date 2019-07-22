package State;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import Asset.Background;
import Entity.Base;
import Entity.Bird;
import Entity.PipeDown;
import Entity.PipeUp;
import Entity.ScoreBoard;
import Main.Display;

public class RunState extends State {
	
	private int alpha=600;
	
	private int delta=0;
	
	private final BufferedImage day=Background.day;
	
	private final BufferedImage night=Background.night;
	
	private Base base;
	
	private ArrayList<PipeUp> pipeUps=new ArrayList<PipeUp>();
	
	private ArrayList<PipeDown> pipeDowns=new ArrayList<PipeDown>();
	
	private Bird bird;
	
	private ScoreBoard scoreBoard;
	
	private int pipeDelta=0;
	
	private int level=30;
	
	private int levelDelta=0;
	
	private int score=0;
	
	public RunState(Display display) {
		super(display);
		
		initialize();
	}
	
	private void initialize() {
		scoreBoard=new ScoreBoard(display,display.getWidth()/2-50/2,150,50,50);
		
		base=new Base(display,-display.getWidth(),display.getHeight()-100,display.getWidth()*2,100);
		
		pipeUps.add(new PipeUp(display,display.getWidth(),0,0,0));
		
		pipeDowns.add(new PipeDown(display,display.getWidth(),0,0,0));
		
		bird=new Bird(display,200,300,40,40);
	}
	
	public void tick() {
		scoreBoard.tick();
		
		base.tick();
		
		int number=(int)(Math.random()*level);
		
		if(number==1 && pipeDelta>=50) {
			pipeUps.add(new PipeUp(display,display.getWidth(),0,0,0));
			
			pipeDowns.add(new PipeDown(display,display.getWidth(),0,0,0));
			
			pipeDelta=0;
		}
		
		
		pipeDelta++;
		
		levelDelta++;
		
		if(levelDelta>=300 && level>10) {
			level--;
			levelDelta=0;
		}
		
		
		for(int i=0;i<pipeUps.size();i++) {
			pipeUps.get(i).tick();
		}
		
		for(int i=0;i<pipeDowns.size();i++) {
			pipeDowns.get(i).tick();
		}

		bird.tick();
		
		if(delta/alpha==2) {
			delta=0;
		}else {
			delta++;
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
		
		for(int i=0;i<pipeUps.size();i++) {
			pipeUps.get(i).render(g);
		}
		
		for(int i=0;i<pipeDowns.size();i++) {
			pipeDowns.get(i).render(g);
		}
		
		bird.render(g);
		
	}
	
	public void setScore(int score) {
		this.score=score;
	}
	
	public int getScore() {
		return score;
	}
	
	public void removePipeUp(PipeUp pipeUp) {
		pipeUps.remove(pipeUp);
	}
	
	public void removePipeDown(PipeDown pipeDown) {
		pipeDowns.remove(pipeDown);
	}
	
	public Bird getBird() {
		return bird;
	}
}
