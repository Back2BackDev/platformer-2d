package platformer;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Platformer extends BasicGameState {
	boolean left;
	boolean right = true;
	boolean jump;
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
			
			if (input.isKeyDown(Input.KEY_RIGHT)) {
				right = true;
				if (!right) {
					p = new Image("images/pr.png");
				}
				px += 4;
			}
			
			if (input.isKeyDown(Input.KEY_LEFT)) {
				left = true;
				if (!left) {
					p = new Image("images/pl.png");
				}
				px -= 4;
			}
			
			if (input.isKeyDown(Input.KEY_SPACE)) {
				jump = true;
				if (!jump) {
					p = new Image("images/j.png");
				}
				py -= 4;
			}
		}
		
		if (px > 448) {
			px = 448;
		}
	}
}
