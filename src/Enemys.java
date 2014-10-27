
import java.util.Random;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Enemys {

	private static Random rand = new Random();
	private Image image;
	private int vx = 6;
	private int px = 485;
	private int py = (rand.nextInt(2)*2 + 1)*100 - 20;
	
	
	public Enemys() throws SlickException {
		
		image = new Image("res/Enemy.png");
	}
	
	public void render() {
		image.draw(px, py);
	}
	
	public void update() {
		
		px += vx;
		if(px >= 960) {
			px = 0;
			py = (rand.nextInt(3)*2 + 1)*100 - 20;
			
		}
		
	}
	
	public int getX() {return px;}
	
	public int getY() {return py;}
}