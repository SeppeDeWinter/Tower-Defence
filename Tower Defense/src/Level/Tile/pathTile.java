package Level.Tile;

import Graphics.Screen;
import Graphics.Sprite;

public class pathTile extends Tile {

	public pathTile(Sprite sprite) {
		super(sprite);
		
	}
	
	public void render(int x, int y, Screen screen){
		
		screen.renderTile(x << 4, y << 4, this);
	}
}
