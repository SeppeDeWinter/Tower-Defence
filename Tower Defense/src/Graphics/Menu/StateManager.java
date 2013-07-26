package Graphics.Menu;

import java.awt.Graphics;

import Graphics.Screen;
import Input.Keyboard;
import Input.Mouse;
import Level.Level;

public class StateManager {
	public static int state, PrevState, prevState;
	private int nMenus = 5;
	private State[] states = new State[nMenus];
	private boolean init = false;
	private int width, height;
	Keyboard key;
	Mouse mouse;
	private int scale;

	public StateManager(int width, int height,int scale, Keyboard key, Mouse mouse){
		this.width = width;
		this.height = height;
		this.key = key;
		this.scale = scale;
		this.mouse = mouse;
	}
	
	
	public void init(){
		
			State StartMenu = new StartMenu(0,3, width, height, scale, key);
			State MapMenu = new MapMenu(1,3, width , height, scale, key);
			State OptionMenu = new OptionMenu(2, 3, width, height, scale, key);
			//ingame menu
			State Map1 = new MapState(4, 0, width, height, scale, key, mouse, Level.map1);
			
			states[0] = StartMenu;
			states[1] = MapMenu;
			states[2] = OptionMenu;
			
			states[4] = Map1;
			
			StartMenu.init();
			MapMenu.init();
			OptionMenu.init();
			
	}
	
	public void init(State state){
		if(!state.init) state.init();
	}
	
	public void update(){
		
		
		PrevState = state;
		if(PrevState != state) prevState = PrevState;
 		
		init(states[state]);
		states[state].update();
		
		
			
		if(key.escape) state = prevState;
		
	}
	
	public static int getState(){
		return state;
	}
	
	
	public void render(Screen screen, Graphics g){
		
		states[state].render(screen, g);
	}
	
	public void render(Screen screen){
		
		states[state].render(screen);
	}
}
