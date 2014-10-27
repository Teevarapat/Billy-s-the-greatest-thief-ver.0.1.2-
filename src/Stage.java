import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public class Stage {
	
	private Image pic;
	private Image signdown;
	private Image signup;
	private static Image loose;
	private static Image win;
	private int num = 3;

	public Stage () throws SlickException {
		
		pic = new Image("res/stage.png");
		signdown = new Image("res/down.png");
		signup = new Image("res/up.png");
		loose = new Image("res/gameover.jpg");
		win = new Image("res/youwin.png");
	}
	
	public void render() {
		
		for(int i = 0; i < num; i++) {
			pic.draw(0, (2*i + 1)*100 + 80 );
		}
		
		for(int i = 0; i < 2; i++) {
			signdown.draw(890 , (2*i + 1)*100);
		}
		
		for(int i = 2; i > 0; i--) {
			signup.draw(10, (2*i + 1)*100);
		}
	}

	public static void loose() {
		
		loose.draw(225,150);
		
	}

	public static void win() {
		win.draw(225,150);
		
	}
	
}
