package Asset;

import java.awt.image.BufferedImage;

import Loader.ImageLoader;

public class Number {
	public static BufferedImage zero;
	
	public static BufferedImage one;
	
	public static BufferedImage two;
	
	public static BufferedImage three;
	
	public static BufferedImage four;
	
	public static BufferedImage five;
	
	public static BufferedImage six;
	
	public static BufferedImage seven;
	
	public static BufferedImage eight;
	
	public static BufferedImage nine;
	
	public static void initialize(ImageLoader imageLoader) {
		zero=imageLoader.loadImage("number/0.png");
		
		one=imageLoader.loadImage("number/1.png");
		
		two=imageLoader.loadImage("number/2.png");
		
		three=imageLoader.loadImage("number/3.png");
		
		four=imageLoader.loadImage("number/4.png");
		
		five=imageLoader.loadImage("number/5.png");
		
		six=imageLoader.loadImage("number/6.png");
		
		seven=imageLoader.loadImage("number/7.png");
		
		eight=imageLoader.loadImage("number/8.png");
		
		nine=imageLoader.loadImage("number/9.png");
	}
}
