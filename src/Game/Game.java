package Game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable {
	
	private static final long serialVersionUID = 1L;
	
	public static int WIDTH = 700;
	public static int HEIGHT = 400;
	
	
	private Thread thread;
	private boolean isRunning = false;
	private Random rand;
	
	private Handler handler;
	private Menu menu;
	private StatusDisplay stats;
	
	public enum STATE {
		Opening, GameInProgress, GameOver
	}
	
	public STATE gameState = STATE.GameInProgress;
	
	public Game() {
		rand = new Random();
		handler = new Handler();
		menu = new Menu(this, handler, stats);
		stats = new StatusDisplay();
		
		this.addKeyListener(new KeyInput(handler));
		this.addMouseListener(menu);
		
		new Window(this, "Pong!");
		
		if (gameState == STATE.GameInProgress) {
			int randIntSpeed = rand.nextInt(10);
			
			if (randIntSpeed == 0) {
				randIntSpeed = 3;
			}
			
			int randIntColor = rand.nextInt(255);
			
			handler.addGameObject(new Player(20, 150, ID.Player1, new Color(204, 0, 0), handler));
			handler.addGameObject(new Player(670, 150, ID.Player2, new Color(178, 178, 0), handler));
			handler.addGameObject(new Ball(350, 200, randIntSpeed, randIntSpeed, ID.Ball, new Color(randIntColor, randIntColor, randIntColor), handler));
		}
	}
	
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		isRunning = true;
	}
	
	public synchronized void stop() {
		try {
			thread.join();
			isRunning = false;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		this.requestFocus();			
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		
		while (isRunning) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				tick();
				delta--;
			}
			if (isRunning) {
				render();
				frames++;
			}
			
			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				frames = 0;
			}
		}
		
		stop();
	}
	
	public void tick()  {
		handler.tick();
	}
	
	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		
		if (bs == null) {
			this.createBufferStrategy(3);
			bs = this.getBufferStrategy();
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(new Color(0, 122, 153));
		g.fillRect(0, 0, WIDTH / 2, HEIGHT);
		
		g.setColor(new Color(204, 255, 153));
		g.fillRect(WIDTH / 2, 0, WIDTH / 2, HEIGHT);
		
		handler.render(g);
		
		g.dispose();	
		bs.show();			
	}
	
	public STATE getGameState() {
		return gameState;
	}

	public void setGameState(STATE gameState) {
		this.gameState = gameState;
	}

	public static void main(String[] args) {
		new Game();
	}

}
