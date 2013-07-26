package Level.Tile;

import Graphics.Screen;
import Graphics.Sprite;

public class Tile {
	public int x, y;
	public Sprite sprite;
	
	
	public static Tile voidTile = new VoidTile(Sprite.voidSprite);
	public static Tile grassTile = new grassTile(Sprite.grass);
	public static Tile pathUpTile = new pathTile(Sprite.pathUp);
	public static Tile pathRightTile = new pathTile(Sprite.pathRight);
	public static Tile bend1 = new pathTile(Sprite.bend1);
	public static Tile bend2 = new pathTile(Sprite.bend2);
	public static Tile bend3 = new pathTile(Sprite.bend3);
	public static Tile bend4 = new pathTile(Sprite.bend4);

	//colors do not forget the alpha channel 0.o:

	public static final int color_grass = 0xff00FF00;
	public static final int color_pathUp = 0xffC1C1C1;
	public static final int color_pathRight = 0xff565656;
	public static final int color_bend1 = 0xff565650;
	public static final int color_bend2 = 0xff565640;
	public static final int color_bend3 = 0xff565630;
	public static final int color_bend4 = 0xff565620;
	
	public Tile(Sprite sprite){
		
		this.sprite = sprite;
		
	}
	
	public void render(int x, int y, Screen screen){
	}
	
	public boolean solid(){
		return false;
	}
}
