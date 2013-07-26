package Level;

import Graphics.Screen;
import Level.Tile.Tile;

public class Level {
	
	
	protected int width, height;
	protected int[] tilesInt;
	protected int[] tiles;
	
	protected Tile[] Ttiles = new Tile[width * height];
	
	public static Level map1 = new Map1("/levels/Map1.png");
	
	public Level(int width, int height) {
		
		this.width= width;
		this.height = height;
		tilesInt = new int[width * height];
		generateLevel();
	}
	
	public Level(String path){
		LoadLevel(path);
		generateLevel();
	}

	protected void generateLevel() {
		
		
	}
	
	protected void LoadLevel(String path) {
		
	}
	
	
	public void update() {
		
		
	}
	
	private void time() {
		
		
	}
	
	public void render(int Xscroll, int Yscroll, Screen screen){
		
		screen.setOffset(Xscroll, Yscroll);
		int x0 = Xscroll >> 4;
		int x1 = (Xscroll + screen.width + 16) >> 4;
		int y0 = Yscroll >> 4;
		int y1= (Yscroll + screen.height  + 16) >> 4;
		 
		for(int y = y0; y < y1; y++){
			for(int x = x0; x < x1; x++){
				getTile(x, y).render(x, y , screen);
				
			}
		}
	}
	

	
	
	public Tile getTile(int x, int y){
		
		
		if (x < 0 || y < 0 || x >= width|| y >= height ) return Tile.voidTile;
		if (tiles[x + y * width] == Tile.color_grass) return Tile.grassTile;
		if (tiles[x + y * width] == Tile.color_pathUp) return Tile.pathUpTile;
		if (tiles[x + y * width] == Tile.color_pathRight) return Tile.pathRightTile;
		if (tiles[x + y * width] == Tile.color_bend1) return Tile.bend1;
		if (tiles[x + y * width] == Tile.color_bend2) return Tile.bend2;
		if (tiles[x + y * width] == Tile.color_bend3) return Tile.bend3;
		if (tiles[x + y * width] == Tile.color_bend4) return Tile.bend4;
		return Tile.voidTile;
	}
}
