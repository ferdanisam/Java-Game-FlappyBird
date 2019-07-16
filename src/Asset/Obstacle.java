package Asset;

import java.awt.image.BufferedImage;

import Loader.ImageLoader;

public class Obstacle {
	public static BufferedImage base;
	
	public static BufferedImage pipeUp;
	
	public static BufferedImage pipeDown;
	
	public static void initialize(ImageLoader imageLoader) {
		base=imageLoader.loadImage("obstacle/base.png");
		
		pipeUp=imageLoader.loadImage("obstacle/pipeUp.png");
		
		pipeDown=imageLoader.loadImage("obstacle/pipeDown.png");
	}
}
