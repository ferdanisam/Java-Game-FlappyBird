package Main;

import Asset.Background;
import Asset.Bird;
import Loader.ImageLoader;
import Asset.Number;
import Asset.Obstacle;

public class Launch {
	
	private final String title="Flappy Bird";
	
	private final int width=500;
	
	private final int height=800;
	
	public Window window;
	
	private Display display;
	
	private ImageLoader imageLoader;
	
	public static void main(String[]args) {
		new Launch();
	}
	
	public Launch() {
		loadingData();
		
		window=new Window(title,width,height);
		display=new Display(window);
		display.start();
	}
	
	private void loadingData() {
		imageLoader=new ImageLoader();
		
		Background.initialize(imageLoader);
		
		Bird.initialize(imageLoader);
		
		Number.initialize(imageLoader);
		
		Obstacle.initialize(imageLoader);
	}
}
