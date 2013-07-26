package Graphics;

public class Sprite {
	public final int SIZE;
	private int x, y;
	private SpriteSheet sheet;
	public int[] pixels;
	
	//sprites
	public static Sprite voidSprite = new Sprite(16, 0x1B65E0);
	public static Sprite grass = new Sprite(16, 0, 0, SpriteSheet.tiles);
	public static Sprite pathUp = new Sprite(16, 1, 0, SpriteSheet.tiles);
	public static Sprite pathRight = new Sprite(16, 2, 0, SpriteSheet.tiles);
	public static Sprite bend1 = new Sprite(16, 3, 0, SpriteSheet.tiles);
	public static Sprite bend2 = new Sprite(16, 6, 0, SpriteSheet.tiles);
	public static Sprite bend3 = new Sprite(16, 4, 0, SpriteSheet.tiles);
	public static Sprite bend4 = new Sprite(16, 5, 0, SpriteSheet.tiles);
	
	public static Sprite back = new Sprite(32, 4, 0, SpriteSheet.tiles);
	
	
	public static Sprite testMob = new Sprite(16, 0, 0, SpriteSheet.entities);
	public static Sprite testTower = new Sprite(32, 0, 1, SpriteSheet.entities);
	
	//bullet sprites
	public static Sprite testBullet = new Sprite(16,0, 9, SpriteSheet.entities);
	
	public Sprite(int size, int x, int y, SpriteSheet sheet){
		
		SIZE = size;
		pixels = new int[SIZE * SIZE];
		this.x = x * size;
		this.y = y * size;
		this.sheet = sheet;
		load();
	}
	
	
	
	public Sprite(int size, int colour) {
		SIZE = size;
		pixels = new int [SIZE * SIZE];
		setColour(colour);
	}
	
	private void setColour(int colour) {
		for (int i = 0; i < SIZE * SIZE; i++){
			pixels[ i ] = colour;
		}
		
	}

	private void load() {
		
		for (int y = 0; y < SIZE; y++){
			for(int x= 0; x < SIZE; x++){
				
				pixels[x + y* SIZE ] = sheet.pixels[(x + this.x) + (y + this.y)* sheet.SIZE];
			}
		}
	}
}
