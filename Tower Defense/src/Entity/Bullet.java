package Entity;

import Graphics.Screen;
import Graphics.Sprite;

 public class Bullet extends Entity{

	int xOrig;
	int yOrig;  
	double dir;
	
	int speed ;
	int rateOfFire ;
	int range ;
	int damage;
	Sprite sprite;
	
	int targetX;
	int targetY;
	
	double nx, ny, x, y;
	
	public Bullet(int speed, int rateOfFire, int range, int damage, Sprite sprite){
		this.speed = speed;
		this.rateOfFire = rateOfFire;
		this.range = range;
		this.damage = damage;
		this.sprite = sprite;
	}
	
	public void move(double nx , double ny){
		x = x + nx;
		y = y + ny;
	}
	
		
	public void setTargetCoord(int x, int y){
		targetX = x;
		targetY = y;
	}
	
	public void update(){
		
		
		nx = speed * Math.cos(dir);
		ny = speed * Math.sin(dir);
		
		
		move(nx , ny);
	}
	
	public void render(Screen screen){
		screen.renderEntity((int)x, (int)y, sprite, false, false);
	}	
}
