package Entity;

import Graphics.Screen;
import Graphics.Sprite;

public class TestBullet extends Bullet{
	
	int speed = 2;
	int rateOfFire = 0;
	int Range = 100;
	int damage = 0;
		
	Sprite sprite = Sprite.testBullet;
		
	int targetX;
	int targetY;
	
	double nx, ny;
	public void setTargetCoord(int x, int y){
		targetX = x;
		targetY = y;
	}
	
	public void update(){
		range = Range;
		
		System.out.println(dir);
		
		nx = speed * Math.cos(dir);
		ny = speed * Math.sin(dir);
		
		
		move(nx , ny);
	}
	
	public void render(Screen screen){
		screen.renderEntity(x, y, sprite, false, false);
	}	

}
