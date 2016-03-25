package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject {
	
	protected float x, y;
	protected float speedX, speedY;
	protected ID id;
	
	public GameObject(float x, float y, ID id) {
		this.x = x;
		this.y = y;
		this.id = id;
	}
	
	public GameObject(float x, float y, float speedX, float speedY, ID id) {
		this.x = x;
		this.y = y;
		this.speedX = speedX;
		this.speedY = speedY;
		this.id = id;
	}

	public abstract void tick();
	public abstract void render(Graphics g);
	public abstract Rectangle getBounds();

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getSpeedX() {
		return speedX;
	}

	public void setSpeedX(float speedX) {
		this.speedX = speedX;
	}
	
	public float getSpeedY() {
		return speedY;
	}
	
	public void setSpeedY(float speedY) {
		this.speedY = speedY;
	}
	
	public ID getID() {
		return id;
	}
	
}
