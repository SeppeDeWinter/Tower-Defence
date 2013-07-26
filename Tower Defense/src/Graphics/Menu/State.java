package Graphics.Menu;

import java.awt.Graphics;

import Graphics.Screen;
import Input.Keyboard;
import Level.Level;

public abstract class State {
	public static boolean pressed;
	public int state;
	private int nItems;
	private MenuItem MenuItems[];
	protected int width;
	protected int height;
	private Keyboard key;
	private int index;
	private int indexP;
	private int pressTimer;
	private Level level;
	public boolean init;

	public State(int state, int nItems, int width, int height,int scale, Keyboard key){
		this.state = state;
		this.nItems = nItems;
		this.width = width;
		this.height = height;
		this.key = key;
	}
	
	public State(int state, int nItems, int width, int height,int scale, Keyboard key, Level level){
		this.state = state;
		this.nItems = nItems;
		this.width = width;
		this.height = height;
		this.key = key;
		this.level = level;
	}
	
	public void update(){}
	
	public void render(Screen screen, Graphics g){}
	
	public void render(Screen screen){}
	
	public void init(){}

	public int getState() {
		
		return state;
	}
}
