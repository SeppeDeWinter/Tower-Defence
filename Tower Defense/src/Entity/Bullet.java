package Entity;

import Graphics.Screen;
import Graphics.Sprite;

abstract public class Bullet extends Entity{

	protected int xOrig;
	protected int yOrig; 
	protected double distance; 
	protected double speed, rateOfFire, range, damage;
	protected Sprite sprite;
	protected double dir;
	
	
	public void move(double nx , double ny){
		x = (int) (x + nx);
		y = (int) (y + ny);
	}
	
	public void update(){
		
	}
	
	public void render(Screen screen){
		
	}
}
