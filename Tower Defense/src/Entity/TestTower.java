package Entity;



import java.awt.Graphics;

import Graphics.Screen;
import Graphics.Sprite;

public class TestTower extends Entity {

	private int target;
	private boolean hasTarget = false;
	private int range = 100;
	
	private BulletManager bulletMng = new BulletManager();
	//bullets go here:
	
	
	int shootTimer = 0;
	
	public TestTower(int x, int y) {
		sprite = Sprite.testTower;
		this.size = sprite.SIZE;
		this.x = x ;
		this.y = y ;
	}
	
	public TestTower() {
		//testing
	}
	
	

	public void update(TestMob[] testMobs){
	
		bulletMng.update();
		if(!hasTarget){
			selectTarget(testMobs);
		}
		if(testMobs[target] != null && hasTarget){ 
			testMobs[target].sprite = Sprite.voidSprite;
			if(getDist(x, y, testMobs[target].x, testMobs[target].y) > range) hasTarget = false;
		}
		
		shootTimer++;
		if(shootTimer > 10){
			shoot( testMobs[target].x, testMobs[target].y);
			shootTimer = 0;
		}
	}
	
	private void selectTarget(TestMob[] testMobs){
		int dist;
		int shortDist = 1000000;
		if(testMobs[target] != null)testMobs[target].sprite = Sprite.testMob;
		for(int i = 0 ;i < testMobs.length; i++){
			if(testMobs[i] != null){
				dist = (int) Math.sqrt(((x - testMobs[i].x) * (x - testMobs[i].x)) + ((y - testMobs[i].y) * (y - testMobs[i].y)));
				if(dist < shortDist ){
					shortDist = dist;
					target = i;
				}
			}
		}
		
		hasTarget = true;
		if(shortDist > range)  hasTarget = false;
		
	}
	
	private int getDist(int x1, int y1, int x2, int y2){
		return (int) Math.sqrt(((x1 - x2) * (x1 - x2)) + ((y1 - y2) * (y1 - y2)));
	}
	
	public void shoot(int xT, int yT ){
		int distX =-1* (x - xT);
		int distY = y - yT;
		
		double dir = -1 * (Math.atan2(distY, distX));
		
		Bullet bullet = new Bullet(2, -999, 100, -999, Sprite.testBullet);
		bulletMng.addBullet(bullet, x, y, dir);
	}
	
	public void render(Screen screen){
		screen.renderEntity(x, y, sprite, false, false);
		bulletMng.render(screen);
	}
	
	public void render(int X, int Y, Screen screen){
		
		screen.renderEntity(X, Y, sprite, false, false);
	}
	
	public void render(Screen screen, Graphics g){
		
	}
	}
