package platformer;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Platformer extends BasicGameState {
	boolean left, right = true;
	int accTime;
	float px = 0, py = 288;
	Image pr, pl, w;
	Input input;
	
	public int getID() {
		return Main.GAME_STATE;
	}
	
	public void init(GameContainer gc, StateBasedGame sb) throws SlickException {
		pr = new Image("images/pr.png");
		pl = new Image("images/pl.png");
		//w = new Image("images/w.png");
		
		input = gc.getInput();
	}

	public void render(GameContainer gc, StateBasedGame sb, Graphics g) throws SlickException {
		if (right) {
			pr.draw(px, py);
		}
		
		if (left) {
			pl.draw(px, py);
		}
	}

	public void update(GameContainer gc, StateBasedGame sb, int delta) throws SlickException {
		accTime += delta;
		
		while (accTime > 0) {
			accTime -= 20;
			
			if (input.isKeyDown(Input.KEY_RIGHT)) {
				right = true;
				px += 4;
			}
			
			if (input.isKeyDown(Input.KEY_LEFT)) {
				left = true;
				px -= 4;
			}
			
			if (input.isKeyDown(Input.KEY_SPACE)) {
				while (py < py - 20) {
					py--;
				}
			}
		}
		
		if (px > 448) {
			px = 448;
		}
	}
}
