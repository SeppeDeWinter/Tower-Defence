package Graphics.Menu;

import java.awt.Color;
import java.awt.Graphics;

import Graphics.Screen;
import Graphics.Menu.StartMenuI.ExitItem;
import Graphics.Menu.StartMenuI.OptionsItem;
import Graphics.Menu.StartMenuI.StartItem;
import Input.Keyboard;

public class StartMenu extends State {
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
	
	public StartMenu(int state, int nItems, int width, int height,int scale, Keyboard key) {
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
			Start = new StartItem((width / 2) - (5 * 32) / 2 , height - 150 * scale ,Color.white, "Start Game");
			Options = new OptionsItem((width / 2 - (4 * 32) / 2) + 10, height - 100 * scale, Color.white, "Options");
			Exit = new ExitItem((width / 2) - 20, height - 50 * scale, Color.white, "Exit");
			MenuItems[0] = Start;
			MenuItems[1] = Options;
			MenuItems[2] = Exit;
			
			MenuItems[0].select();
			init = true;
		}
	}
	
	public void update(){
		
		
		if(key.up && !pressed){
			index--;
			pressed = true;
		}
		if(key.down && !pressed){
			index++;
			pressed = true;
		}
		
		
		if(index < 0) index = nItems - 1;
		if(index > nItems - 1) index = 0;
		
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
		
		if(key.enter && ! pressed){
			MapMenu.pressed = true;
			StartMenu.pressed = true;
			OptionMenu.pressed = true;
			MenuItems[index].activate();
		}
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
	}
	

}
