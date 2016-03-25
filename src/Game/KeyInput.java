package Game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
	
	private Handler handler;

	private boolean keyDown[] = new boolean[4];
	
	public KeyInput(Handler handler) {
		this.handler = handler;
		
		keyDown[0] = false;
		keyDown[1] = false;
		keyDown[2] = false;
		keyDown[3] = false;
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		for (int i = 0; i < handler.listOfSprites.size(); i++) {
			GameObject go = handler.listOfSprites.get(i);
		
			if (go.getID() == ID.Player1) {
				if (key == KeyEvent.VK_W) {
					go.setSpeedY(-6);
					keyDown[0] = true;
				}
				if (key == KeyEvent.VK_S) {
					go.setSpeedY(6);
					keyDown[1] = true;
				}
			}
			if (go.getID() == ID.Player2) {
				if (key == KeyEvent.VK_UP) {
					go.setSpeedY(-6);
					keyDown[2] = true;
				}
				if (key == KeyEvent.VK_DOWN) {
					go.setSpeedY(6);
					keyDown[3] = true;
				}
			}
		}
		
		if (key == KeyEvent.VK_SPACE) {
			//if game over then restart game
			//else if game in progress then pause game
		}
		if (key == KeyEvent.VK_ESCAPE) {
			System.exit(1);
		}
	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		for (int i = 0; i < handler.listOfSprites.size(); i++) {
			GameObject go = handler.listOfSprites.get(i);
		
			if (go.getID() == ID.Player1) {
				if (key == KeyEvent.VK_W) {
					keyDown[0] = false;
				}
				if (key == KeyEvent.VK_S) {
					keyDown[1] = false;
				}
			}
			if (go.getID() == ID.Player2) {
				if (key == KeyEvent.VK_UP) {
					keyDown[2] = false;
				}
				if (key == KeyEvent.VK_DOWN) {
					keyDown[3] = false;
				}
			}
			
			if (!keyDown[0] && !keyDown[1]) {
				go.setSpeedY(0);
			}
			if (!keyDown[2] && !keyDown[3]) {
				go.setSpeedY(0);
			}
		}
	}

}
