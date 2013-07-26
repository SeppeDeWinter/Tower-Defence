package Graphics.Menu;

import java.awt.Color;
import java.awt.Graphics;

import Graphics.Screen;

public abstract class MenuItem {
	
	int x, y;
	Color color;
	String text;
	public static int state;
	public boolean selected = false;
	
	public MenuItem(int x, int y, Color color, String text){
		this.x = x;
		this.y = y;
		this.color = color;
		this.text = text;
	}
	
	public void render(Screen screen, Graphics g){}
	
	public void activate(){}
	
	public void select(){}
	
	public void unselect(){}
	
	public int getState(){
		return state;}
}
