package Game;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Window extends Canvas {
	
	private static final long serialVersionUID = 1L;

	public Window(Game game, String title) {
		JFrame window = new JFrame(title);
		Dimension windowDim = new Dimension(Game.WIDTH, Game.HEIGHT);
		
		window.setMinimumSize(windowDim);
		window.setMaximumSize(windowDim);
		window.setPreferredSize(windowDim);
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setLocationRelativeTo(null);
		window.add(game);
		
		window.setVisible(true);
		
		game.start();
	}
	
}
