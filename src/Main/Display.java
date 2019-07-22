package Main;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

import Handler.KeyActionHandler;
import Handler.MouseActionHandler;
import State.EndState;
import State.RunState;
import State.StartState;
import State.State;

public class Display implements Runnable {
	private Thread thread;
	
	private Window window;
	
	private boolean running=false;
	
	private final double tpt=1000000000/60;
	
	private BufferStrategy bs;
	
	private Graphics g;
	
	private KeyActionHandler keyActionHandler;
	
	private MouseActionHandler mouseActionHandler;
	
	private StartState startState;
	
	private RunState runState;
	
	private EndState endState;
	
	public Display(Window window) {
		thread=new Thread(this);
		this.window=window;
		
		initializeHandler();
		initializeState();
	}
	
	private void initializeHandler() {
		window.getCanvas().requestFocus();
		
		keyActionHandler=new KeyActionHandler(this);
		window.getCanvas().addKeyListener(keyActionHandler);
		
		mouseActionHandler=new MouseActionHandler();
		window.getCanvas().addMouseListener(mouseActionHandler);
	}
	
	private void initializeState() {
		startState=new StartState(this);
		
		runState=new RunState(this);
		
		endState=new EndState(this);
		
		State.setState(startState);
	}
	
	public synchronized void start() {
		running=true;
		thread.start();
	}
	
	public void run() {
		
		double delta=0;
		
		long lastTime=System.nanoTime();
		
		long nowTime;
		
		while(running) {
			nowTime=System.nanoTime();
			delta+=(nowTime-lastTime)/tpt;
			
			lastTime=nowTime;
			
			if(delta>=1) {
				tick();
				render();
				delta--;
			}
		}
	}
	
	public synchronized void stop() {
		running=false;
		System.exit(0);
	}
	
	private void tick() {
		if(State.getState()==startState) {
			startState.tick();
		}else if(State.getState()==runState) {
			if(keyActionHandler.getPause()%2==0) {
				runState.tick();
			}
		}else if(State.getState()==endState) {
			endState.tick();
		}
		
		keyActionHandler.tick();
		mouseActionHandler.tick();
	}
	
	private void render() {
		bs=window.getCanvas().getBufferStrategy();
		
		if(bs==null) {
			window.getCanvas().createBufferStrategy(3);
			return;
		}
		
		g=bs.getDrawGraphics();
		
		g.clearRect(0,0,window.getWidth(),window.getHeight());
		
		if(State.getState()==startState) {
			startState.render((Graphics2D)g);
		}else if(State.getState()==runState) {
			runState.render((Graphics2D)g);
		}else if(State.getState()==endState) {
			endState.render((Graphics2D)g);
		}
		
		bs.show();
		g.dispose();
	}
	
	public int getWidth() {
		return window.getWidth();
	}
	
	public int getHeight() {
		return window.getHeight();
	}
	
	public KeyActionHandler getKeyActionHandler() {
		return keyActionHandler;
	}
	
	public MouseActionHandler getMouseActionHandler() {
		return mouseActionHandler;
	}
	
	public StartState getStartState() {
		return startState;
	}
	
	public RunState getRunState() {
		return runState;
	}
	
	public EndState getEndState() {
		return endState;
	}
	
	public void restart() {
		runState=new RunState(this);
	}
}
