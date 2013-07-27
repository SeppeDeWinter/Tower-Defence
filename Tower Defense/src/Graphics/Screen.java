package Graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;

import Level.Tile.Tile;

public class Screen {
	private Random random = new Random();
	public int width, height;
	public int[] pixels;
	public final int MAP_SIZE = 64;
	public final int MAPS_SIZE_MASK = MAP_SIZE - 1;
	public int xOffset, yOffset;
	public int[] tiles = new int[MAP_SIZE * MAP_SIZE];
	private int scale;


	public Screen(int width, int height, int scale) {

		this.width = width;
		this.height = height;
		this.scale = scale;
		pixels = new int[width * height];
	
		for(int i = 0; i < tiles.length; i++){
			tiles[i] = random.nextInt(0xffffff);
			
		}
	}
	
	
	
	public void clear(){
		
		for (int i = 0; i < pixels.length; i++){
			pixels[i] = 0;
		}
	}
	
	public void renderMenuItem(int x, int y, Graphics g, String text){
		g.setColor(Color.WHITE);
		g.setFont(new Font("Prestige Elite Std", Font.CENTER_BASELINE, 32));
		g.drawString(text, x, y);
		
	}
	
	public void drawCircel(int x, int y, int r,Color color, Graphics g){
		g.setColor(color);
		g.drawOval(x - r, y - r, r * 2, r * 2);
	}
	
	public void drawBox(int x, int y, int width, int height,Color color, Graphics g){
		g.setColor(color);
		g.fillRect(x, y, width, height);
	}
	
	public void drawRect(int x, int y, int width, int height, Color color, Graphics g){
		g.setColor(color);
		g.drawRect(x, y, width, height);
	}
	public void renderTile(int xp, int yp, Tile tile) {
		
		
		xp -= xOffset;
		yp -= yOffset;
		
		for (int y = 0; y < tile.sprite.SIZE; y++){
			int ya =  y + yp; 
			
			for (int x = 0; x < tile.sprite.SIZE; x++){
				
				int xa =  x + xp; 
				
				if(xa < -tile.sprite.SIZE || xa >= width  || ya < 0 || ya >= height) {
					break;
				}
				
				if (xa < 0 ) xa = 0; 
				
				pixels[xa + ya * width] = tile.sprite.pixels[x + y * tile.sprite.SIZE];
			}
		}
		
		
	}
	
	public void renderSpecial(int xp, int yp, int size, int value){
		xp -= xOffset;
		yp -= yOffset;
		
		for (int y = yp; y < size + yp; y++){
			for (int x = xp; x < size + xp; x++){
				if(x != -1 && y != -1 ){
					if(x + y * width < pixels.length )pixels[x + y * width] = pixels[x + y * width] + value ;
					
				}
			}
		}
	}
	
	public void drawGrid(Graphics g, int size, Color color){
		g.setColor(color);
		for(int x = 0; x < width ; x += size){
			g.drawLine(x * scale, 0, x * scale, height * scale);
		}
		for(int y = 0; y < width ; y += size){
			g.drawLine(0, y * scale, width * scale, y * scale);
		}
	}
	
	public void renderEntity(int xp, int yp, Sprite sprite, boolean xFlip, boolean yFlip){
		xp -= xOffset;
		yp -= yOffset;

		for (int y = 0; y < sprite.SIZE; y++){
			int ys = y;
			int ya =  y + yp; 
			if (yFlip) ys = (sprite.SIZE - 1) - y;
			
			for (int x = 0; x < sprite.SIZE; x++){
				int xs = x;
				int xa =  x + xp; 
				if (xFlip) xs = (sprite.SIZE - 1) - x;
				
				if(xa < - sprite.SIZE || xa >= width  || ya < 0 || ya >= height) break;
				if (xa < 0 ) xa = 0; 
				
				int color = sprite.pixels[xs + ys * sprite.SIZE];
				if(color != 0xffff00ff) pixels[xa + ya * width] = color;
			}
		}
		
	}
	
	public void renderEntity(int xp, int yp, Sprite sprite, boolean xFlip, boolean yFlip, float angle){//isn't really working!
		 xp -= xOffset;
		 yp -= yOffset;

		 for (int y = 0; y < sprite.SIZE; y++){
			 int ys = y;
		  if (yFlip) ys = (sprite.SIZE - 1) - y;
		  for (int x = 0; x < sprite.SIZE; x++) {
			  int xs = x;
		   if (xFlip) xs = (sprite.SIZE - 1) - x;

		   int u = (int) (Math.cos(-angle) * x + Math.sin(-angle) * y);
		   int v = (int) (-Math.sin(-angle) * x + Math.cos(-angle) * y);
		   
		   if(u < - sprite.SIZE || u >= width  || v < 0 || v >= height) break;
		   
		   int color = 0xffff00ff;
		   if(u + v * sprite.SIZE < sprite.pixels.length) color = sprite.pixels[u + v * sprite.SIZE];
		   if(color != 0xffff00ff) pixels[(xp + u) + (yp + v) * width] = color;
		  }
		 }
		}
	
	

	
	public void setOffset(int xOffset, int yOffset){
		
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
	

	
}
