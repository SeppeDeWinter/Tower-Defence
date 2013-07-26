package Graphics.Menu;

import java.awt.Graphics;

import Graphics.Screen;
import Input.Keyboard;

public class OptionMenu extends State {
	public static int state;
	private int nItems;
	private MenuItem MenuItems[] = new MenuItem[3];
	private boolean init = false;
	private int width, height;
	private Keyboard key;
	private int index = 0;
	private int indexP = index;
	private int pressTimer = 0;
	private int scale;
	
	public OptionMenu(int state, int nItems, int width, int height,int scale, Keyboard key) {
		super(state, nItems, height, height, scale, key);
		this.state = state;
		this.nItems = nItems;
		this.width = width;
		this.height = height;
		this.key = key;
		this.scale = scale;
	}
	
	MenuItem Start;
	MenuItem Options;
	MenuItem Exit;
	public void init(){
		if(!init){
			init = true;
		}
	}
	
	public void update(){
		
		
		if(pressed){
			pressTimer++;
		}
		
		if(pressTimer == 10){
			pressed = false;
			pressTimer = 0;
		}
		
		if(indexP != index){
			MenuItems[index].select();
			MenuItems[indexP].unselect();
		}
		
		if(key.enter && MenuItems[index] != null ) MenuItems[index].activate();
		indexP = index;
		
 	}
	
	public  int getState(){
		return state;
	}
	
	public void render(Screen screen, Graphics g){
		for (int i = 0; i < nItems; i++){
			if(MenuItems[i] != null){ 
				
				MenuItems[i].render(screen, g);
			}
		}
		screen.renderMenuItem((width / 2) - 100, 50, g, "Options!");
	}
}
