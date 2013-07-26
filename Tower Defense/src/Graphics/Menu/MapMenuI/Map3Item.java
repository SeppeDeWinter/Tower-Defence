package Graphics.Menu.MapMenuI;

import java.awt.Color;
import java.awt.Graphics;

import Graphics.Screen;
import Graphics.Menu.MenuItem;

public class Map3Item extends MenuItem {
	public static int state = 1;
	int x,y;
	Color color;
	String text;
	public boolean selected = false;
	
	public Map3Item(int x, int y, Color color, String text) {
		super(x, y, color, text);
		this.x = x;
		this.y = y;
		this.color = color;
		this.text = text;
	}
	
	
	public  void activate(){
		
	}
	
	public void render(Screen screen, Graphics g){
		
		screen.renderMenuItem(x , y, g, text);
		if(selected){
			screen.renderMenuItem(x - 50, y, g, ">");
			screen.renderMenuItem(x + 100, y, g, "<");
		}
	}
	
	public void select(){
		selected = true;
	}
	public void unselect(){
		selected = false;
	}
	
	public int getState(){
		return state;
	}
}
