package Game;

import java.awt.Graphics;

import java.util.LinkedList;

public class Handler {
	
	protected LinkedList<GameObject> listOfSprites = new LinkedList<GameObject>();
	
	public void tick() {
		for (int i = 0; i < listOfSprites.size(); i++) {
			GameObject go = listOfSprites.get(i);
			
			go.tick();
		}
	}
	
	public void render(Graphics g) {
		for (int i = 0; i < listOfSprites.size(); i++) {
			GameObject go = listOfSprites.get(i);
			
			go.render(g);
		}
	}
	
	public void addGameObject(GameObject go) {
		this.listOfSprites.add(go);
	}
	
	public void removeGameObject(GameObject go) {
		this.listOfSprites.remove(go);
	}
	
	public void clearObjectList() {
		this.listOfSprites.clear();
	}
	
}
