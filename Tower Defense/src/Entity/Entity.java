package Entity;

import java.util.Random;

import Graphics.Screen;
import Graphics.Sprite;
import Level.Level;

public class Entity {
	public int x;
	public int y;
	private boolean removed = false;
	protected Level level;
	protected final Random random = new Random();
	protected Sprite sprite;
	protected int size;
	
	public Sprite getSprite(){
		return sprite;
	}
	
	public void move(int xa, int ya){
			x += xa;
			y += ya;
	}
	
	public boolean collision(int x, int y, int xm, int ym){
		
		for (int X = x; X < x +size; X++){
			for (int Y = y ; Y < y + size; Y++){
				if(level.getTile((X + xm) / 16, (Y + ym) / 16).solid()) return true;
			}
		}
		return false;
	}
	
	public void update(){
	}
	
	public void render(Screen screen){
	}
	
	public void render(int x, int y, Screen screen){
	}
	
	public void remove() {
		
		removed = true;
	}
	
	public boolean isRemoved() {
		
		return removed;
	}
	
	public void init(Level level) {
		this.level = level;
		
	}
}
