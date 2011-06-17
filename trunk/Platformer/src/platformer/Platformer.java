package platformer;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Platformer extends BasicGameState {
	boolean falling;
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
			
			if (input.isKeyDown(Input.KEY_RIGHT)) {
				p = new Image("images/pr.png");
				px += 4;
			}
			
			if (input.isKeyDown(Input.KEY_LEFT)) {
				p = new Image("images/pr.png");
				px -= 4;
			}
			
			if (input.isKeyDown(Input.KEY_SPACE)) {
				p = new Image("images/pr.png");
				
				jumping = true;
				velocityY = 10.0f; 
			}
		}
		
		if (jumping){
			py -= velocityY;

			if (py > py - 100){
				jumping = false;
				falling = true;
			}
		}
		
		if (falling){
			py += gravity;
			
			if (py == 288){
				falling = false;
			}
		}
		
		if (px > 448) {
			px = 448;
		} else if (py > 288) {
			jumping = false;
			py = 288;
		}
	}
}
