package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Ball extends GameObject {
	public static int WIDTH = 20;
	public static int HEIGHT = 20;
	
	private Random rand = new Random();
	
	private Color color;
	private Handler handler;
	
	public Ball(float x, float y, float speedX, float speedY, ID id, Color color, Handler handler) {
		super(x, y, speedX, speedY, id);
		
		this.color = color;
		this.handler = handler;
	}

	public void tick() {
		x += speedX;
		y += speedY;
		
		collision();
		
		if (y < 0 || y > Game.HEIGHT - 40) {
			speedY *= -1;
		}
	}

	public void render(Graphics g) {
		g.setColor(color);
		g.fillOval((int) x, (int) y, WIDTH, HEIGHT);
	}

	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, WIDTH, HEIGHT);
	}
	
	public void collision() {
		int randSpeedX = rand.nextInt(10);
		int randSpeedY = rand.nextInt(10);
		int randColor = rand.nextInt(255);
		
		for (GameObject go : handler.listOfSprites) {
			if (go.getID() == ID.Player1) {
				if (getBounds().intersects(go.getBounds())) {
					collisionPlayer1(randSpeedX, randSpeedY, randColor);		
				}
			}
			if (go.getID() == ID.Player2) {
				if (getBounds().intersects(go.getBounds())) {
					collisionPlayer2(randSpeedX, randSpeedY, randColor);
				}
			}
		}
	}
	
	public void collisionPlayer1(int randSpeedX, int randSpeedY, int randColor) {
		if (randSpeedX == 0){
			randSpeedX = 12;
		}
		if (randSpeedY == 0) {
			randSpeedY = 12;
		}
		
		speedX = randSpeedX;
		speedY = randSpeedY;
		
		setColor(new Color(randColor, randColor, randColor));
	}
	
	public void collisionPlayer2(int randSpeedX, int randSpeedY, int randColor) {	
		if (randSpeedX == 0){
			randSpeedX = 12;
		}
		if (randSpeedY == 0) {
			randSpeedY = 12;
		}
		
		speedX = randSpeedX;
		speedY = randSpeedY;
		
		speedX *= -1;
		speedY *= -1;
		
		setColor(new Color(randColor, randColor, randColor));
	}

	public Color getColor() {
		return color;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	
}
