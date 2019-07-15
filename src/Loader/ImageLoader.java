package Loader;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class ImageLoader {
	public ImageLoader() {
		
	}
	
	public BufferedImage loadImage(String path) {
		try {
			return ImageIO.read(getClass().getClassLoader().getResource(path));
		}catch(Exception exception) {
			System.out.println("Cannot load image");
		}
		
		return null;
	}
	
}
