package Entity;

import Graphics.Screen;
import Graphics.Sprite;
import Level.Level;

public class TestMob extends Entity {
	
	private int dir = 0;
	private int nMoves;
	public TestMob(int x, int y) {
		sprite = Sprite.testMob;
		this.size = sprite.SIZE;
		this.x = x ;
		this.y = y ;
	}
	
	public void update(){
		
		if(nMoves % 1== 0){
			if(dir == 0){			
				if(collision(x, y, 1, 0)){
					changeDir(true, false);
					return;
				}
				move(1, 0);
			}
			if(dir == 1){
				if(collision(x, y, 0, 1)){
					changeDir(false, true);
					return;
				}
				move(0, 1);
			}
			if(dir == 2){
				if(collision(x, y, -1, 0)){
					changeDir(true, false);
					return;
				}
				move(-1, 0);
			}
			if(dir == 3){
				if(collision(x, y, 0, -1)){
					changeDir(false, true);
					return;
				}
				move(0, -1);
			}
		}
		nMoves ++;
		if(nMoves > 100) nMoves = 0;
	}
	
	public void changeDir(boolean MovingX, boolean MovingY){
			if(MovingX){
				if(!collision(x, y, 0, -1)) dir = 3;
				if(!collision(x, y, 0, 1 )) dir = 1;
			}
			
			if(MovingY){
				if(!collision(x, y, 1,  0)) dir = 0;
				if(!collision(x, y, -1, 0)) dir = 2;
			}
	}
	
	
	public void render(Screen screen){
		screen.renderEntity(x, y, sprite, false, false);
	}
	
	public void init(Level level){
		this.level = level;
	}
}
