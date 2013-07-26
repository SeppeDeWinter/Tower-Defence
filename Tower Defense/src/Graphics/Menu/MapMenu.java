package Graphics.Menu;

import java.awt.Color;
import java.awt.Graphics;

import Graphics.Screen;
import Graphics.Menu.MapMenuI.Map1Item;
import Graphics.Menu.MapMenuI.Map2Item;
import Graphics.Menu.MapMenuI.Map3Item;
import Graphics.Menu.StartMenuI.ExitItem;
import Graphics.Menu.StartMenuI.OptionsItem;
import Graphics.Menu.StartMenuI.StartItem;
import Input.Keyboard;

public class MapMenu extends State {
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
	
	public MapMenu(int state, int nItems, int width, int height, int scale, Keyboard key) {
		super(state, nItems, height, height, scale, key);
		this.state = state;
		this.nItems = nItems;
		this.width = width;
		this.height = height;
		this.key = key;
		this.scale = scale;
	}
	
	MenuItem Map1;
	MenuItem Map2;
	MenuItem Map3;
	public void init(){
		if(!init){
			
			Map1 = new Map1Item( 100 , height - 150 * scale, Color.white, "Map 1");
			Map2 = new Map2Item( 400 , height - 150 * scale, Color.white, "Map 2");
			Map3 = new Map3Item( 700 , height - 150 * scale, Color.white, "Map 3");
			
			MenuItems[0] = Map1;
			MenuItems[1] = Map2;
			MenuItems[2] = Map3;
			
			MenuItems[0].select();
			init = true;
		}
	}
	
	public void update(){
		
		
		if(key.right && !pressed){
			index++;
			pressed = true;
		}
		
		if(key.left && !pressed){
			index--;
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
		
		if(key.enter && MenuItems[index] != null && !pressed ) MenuItems[index].activate();
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
		screen.renderMenuItem((width / 2) - 100, 50, g, "Select Map!");
	}
}
