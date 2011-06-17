package platformer;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Platformer extends BasicGameState {
	boolean jumping;
	float velocityY;
	float gravity = 0.4f;
	int accTime;
	float px = 0;
	float py = 288;
	Image p;
	Input input;
	
	public int getID() {
		return Main.GAME_STATE;
	}
	
	public void init(GameContainer gc, StateBasedGame sb) throws SlickException {
		p = new Image("images/pr.png");	
		//w = new Image("images/w.png");
		
		input = gc.getInput();
	}

	public void render(GameContainer gc, StateBasedGame sb, Graphics g) throws SlickException {
		p.draw(px, py);
	}

	public void update(GameContainer gc, StateBasedGame sb, int delta) throws SlickException {
		accTime += delta;
		
		while (accTime > 0) {
			accTime -= 20;
			velocityY -= gravity;
			
			if (input.isKeyDown(Input.KEY_RIGHT)) {
				px += 4;
			}
			
			if (input.isKeyDown(Input.KEY_LEFT)) {
				px -= 4;
			}
			
			if (input.isKeyDown(Input.KEY_SPACE) && !jumping) {
				velocityY = 8.0f;
				jumping = true;
			}
			
			if (jumping) {
				py -= velocityY;
			}
			
			if (px > 448) {
				px = 448;
			} else if (py > 288) {
				velocityY = 0;
				py = 288;
				jumping = false;
			}
		}
	}
}
