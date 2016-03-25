package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Player extends GameObject {
	
	private static int WIDTH = 10;
	private static int HEIGHT = 100;
	
	private Color color;
	private Random rand = new Random();
	
	private Handler handler;

	public Player(float x, float y, ID id, Color color, Handler handler) {
		super(x, y, id);
		
		this.color = color;
		this.handler = handler;
	}
	
	public void tick() {
		y += speedY;
		
		if (y < 0) {
			y = 0;
		}
		if (y > Game.HEIGHT - 120) {
			y = Game.HEIGHT - 120;
		}
	}
	
	public void render(Graphics g) {
		g.setColor(color);
		g.fillRect((int) x, (int) y, WIDTH, HEIGHT);
	}

	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, WIDTH, HEIGHT);
	}

}
