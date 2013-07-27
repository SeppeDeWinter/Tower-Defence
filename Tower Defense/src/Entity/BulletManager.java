package Entity;

import java.util.ArrayList;
import java.util.List;

import Graphics.Screen;



public class BulletManager {
	
	
	
	List<Bullet> bullets = new ArrayList <Bullet>();
	
	
	
	public void addBullet(Bullet bullet, int x, int y, double dir){
		
		
		bullets.add(bullet);
		
		bullet.xOrig = x;
		bullet.yOrig = y;
		bullet.x = x;
		bullet.y = y;
		bullet.dir = dir;
	}
	
	public void removeBullet(int i){
		bullets.remove(i);
	}
	
	public void update(){
		
		for (int i = 0; i < bullets.size(); i++){
			bullets.get(i).update();
			if(bullets.get(i).x > bullets.get(i).range +  bullets.get(i).xOrig ||bullets.get(i).y > bullets.get(i).range + bullets.get(i).yOrig) removeBullet(i); //also the -y and -x to check
		}
	}
	
	public void render(Screen screen){
		for (int i = 0; i < bullets.size(); i++){
			bullets.get(i).render(screen);
		}
	}
}
