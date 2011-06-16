package platformer;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Platformer extends BasicGameState {
	int accTime;
	float px = 0, py = 320 - 32;
	Image p, w;
	Input input;
	
	public int getID() {
		return Main.GAME_STATE;
	}
	
	public void init(GameContainer gc, StateBasedGame sb) throws SlickException {
		p = new Image("images/p.png");
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
				px += 4;
			}
		}
		
		if (px > 480 - 32) {
			px = 480 - 32;
		}
	}
}
