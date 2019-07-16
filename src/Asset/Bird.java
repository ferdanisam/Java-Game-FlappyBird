package Asset;

import java.awt.image.BufferedImage;

import Loader.ImageLoader;

public class Bird {
	public static BufferedImage downFlap;
	
	public static BufferedImage midFlap;
	
	public static BufferedImage upFlap;
	
	public static void initialize(ImageLoader imageLoader) {
		downFlap=imageLoader.loadImage("bird/downFlap.png");
		
		midFlap=imageLoader.loadImage("bird/midFlap.png");
		
		upFlap=imageLoader.loadImage("bird/upFlap.png");
	}
}
