package Asset;

import java.awt.image.BufferedImage;

import Loader.ImageLoader;

public class Background {
	public static BufferedImage day;
	
	public static BufferedImage night;
	
	public static BufferedImage start;
	
	public static BufferedImage over;
		
	public static void initialize(ImageLoader imageLoader) {
		day=imageLoader.loadImage("background/day.png");
		
		night=imageLoader.loadImage("background/night.png");
		
		start=imageLoader.loadImage("background/start.png");
		over=imageLoader.loadImage("background/over.png");
	}
}
