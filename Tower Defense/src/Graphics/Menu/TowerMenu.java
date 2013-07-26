package Graphics.Menu;

import java.awt.Color;
import java.awt.Graphics;

import Entity.Entity;
import Graphics.Screen;
import Graphics.Sprite;
import Input.Keyboard;
import Input.Mouse;

public class TowerMenu {
	private int x, y, width, height;
	private Keyboard key;
	private Mouse mouse;
	private Sprite back = Sprite.back;
	
	private Entity entity;
	
	public TowerMenu (int x, int y, int width, int height, Mouse mouse, Keyboard key){
		
		this.mouse = mouse;
		this.key = key;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
	}
	
	public void setEntity(Entity e){
		
		entity = e;
	}
	
	public void update(){
	}
	
	public void render(Screen screen, Graphics g){
		screen.drawBox(x + 35 + 64 * 2, y, width, height,Color.black,  g);
		screen.drawBox(x , y, x + 35, height,Color.black,  g);
		screen.drawBox(x , y , 64 * 2 + 35, 42,Color.black,  g);
		screen.drawBox(x , y + 170 , width ,height - 150,Color.black,  g);
		screen.drawRect(x + 35, y + 40, 64 * 2, 64 * 2, Color.GREEN, g);
	}
	public void render(Screen screen){
		screen.renderEntity(x + 12, 217, back, false, false);
		screen.renderEntity(x + 22, 217, back, false, false);
		screen.renderEntity(x + 22, 227, back, false, false);
		screen.renderEntity(x + 12, 227, back, false, false);
		if(entity != null ){
			entity.render(x + 17, 223, screen);
		}
		
	}
}
