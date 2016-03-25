package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import Game.Game.STATE;

public class Menu extends MouseAdapter {
	
	private Game game;
	private Handler handler;
	private StatusDisplay stats;
	
	public Menu(Game game, Handler handler, StatusDisplay stats) {
		this.game = game;
		this.handler = handler;
		this.stats = stats;
	}
	
	public void render(Graphics g) {
		if (game.getGameState() == STATE.Opening) {
			g.setColor(new Color(0, 0, 102));
			g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
		}
		
		if(game.getGameState() == STATE.GameOver) {
			g.setColor(new Color(0, 51, 0));
			g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
