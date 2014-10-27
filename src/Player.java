
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Player {

	private Image image;
	private int px = 50;
	private int py = 480;
	
	
	public Player() throws SlickException {
		
		image = new Image("res/stick.png");
	}
	
	public void render() {
		image.draw(px, py);
	}

	public void left() {
		px -= 5;
		if(px < 0) {
			px = 960;
			
			if(py != 180) {
				py -= 200;
			}
		}
		
	}

	public void right() {
		px += 5;
		if(px > 960) {
			px = 0;
			if(py != 480) {
				py += 200;
			}
		}
	}
	
	public int getX() { return px ;}
	
	public int getY() { return py ;}
	
}
