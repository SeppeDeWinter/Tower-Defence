package Graphics.Menu.StartMenuI;

import java.awt.Color;
import java.awt.Graphics;

import Graphics.Screen;
import Graphics.Menu.MenuItem;
import Graphics.Menu.StateManager;
import Graphics.Menu.StartMenu;

public class ExitItem extends MenuItem {
	public static int state = 0;
	int x,y;
	Color color;
	String text;
	public boolean selected = false;
	
	public ExitItem(int x, int y, Color color, String text) {
		super(x, y, color, text);
		this.x = x;
		this.y = y;
		this.color = color;
		this.text = text;
	}
	
	
	public  void activate(){
		StateManager.state = -1;
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
