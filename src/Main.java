import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Main extends BasicGame {
	
	public static int GAME_WIDTH = 960;
	public static int GAME_HEIGHT = 600;
	private Player player;
	private Stage stage;
	private Diamond diamond;
	private Enemys enemy;
	private boolean gameover = false;
	private boolean win = false;
	private boolean restart;
	
	public Main(String title) {
		super(title);
	}
	
	public static void main(String[] arg) {
		try {
			Main game = new Main("Game");
			AppGameContainer appgc = new AppGameContainer(game);
			appgc.setDisplayMode(GAME_WIDTH, GAME_HEIGHT, false);
			appgc.setMinimumLogicUpdateInterval(1000 / 60);
			appgc.start();
		} catch (SlickException e) {
			e.printStackTrace();

		}
	}

	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		stage.render();
		diamond.render();
		player.render();
		enemy.render();
		if(CheckCollision.checkDiamond(player.getX(), player.getY(), diamond.getX(), diamond.getY())) {
			diamond.getDiamond();
		}
		
		if(CheckCollision.checkEnemy(player.getX(), player.getY(), enemy.getX(), enemy.getY())) {
			gameover = true;;
		}
		
		if(gameover == true) {
			Stage.loose();
		}
		
		if(diamond.letsgo == true && player.getX() <= 0 && player.getY() == 80) {
			win = true;
		}
		
		if(win == true) {
			Stage.win();
		}
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		Color background = new Color(0, 153, 0);
		container.getGraphics().setBackground(background);
		stage = new Stage();
		enemy = new Enemys();
		player = new Player();
		diamond = new Diamond();
		restart = false;
		
	}

	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		if(gameover == false && win == false) {
		
			Input input = container.getInput();
			updateMovement(input, delta);
			diamond.update();
			enemy.update();
		
		}
		
		if(restart) {
			
			gameover = false;
			win = false;
			container.reinit();
			
		}
	}
	
	public void updateMovement(Input input, int delta) {
		
		if(input.isKeyDown(Input.KEY_LEFT ) || input.isKeyDown(Input.KEY_A)){
			player.left();
		}
		if(input.isKeyDown(Input.KEY_RIGHT ) || input.isKeyDown(Input.KEY_D)){
			player.right();
		}
		
	}
	
	@Override
	public void keyPressed(int key, char c) {
		if(key == Input.KEY_ENTER) {
			restart = true;
		}
	}

}
