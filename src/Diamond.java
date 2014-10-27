import java.util.Random;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public class Diamond {
	
	private static Random rand = new Random();
	private Image image;
	private int px = 0;
	private int py = 130;
	private int vx = 5;
	private int maxX = 910;
	public  boolean letsgo = false;
	
	public Diamond() throws SlickException {
		image = new Image ("res/diamond.png");
		px = rand.nextInt(maxX);
	}
	
	public void render() {
		image.draw(px, py);
	}
	
	public void update() {
		
		px += vx;
		if(px >= 960) {
			px = 0;
			py = 30 + (rand.nextInt(2)*2 + 1)*100;
			
		}
		
	}
	
	public int getX() {return px;}
	
	public int getY() {return py;}

	public void getDiamond() {
		
		px = 910;
		py= 10;
		vx = 0;
		letsgo = true;
		
	}

}
