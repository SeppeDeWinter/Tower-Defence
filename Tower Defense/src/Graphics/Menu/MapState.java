package Graphics.Menu;


import java.awt.Graphics;
import java.util.List;
import java.util.ArrayList;

import Entity.Bullet;
import Entity.BulletManager;
import Entity.Entity;
import Entity.TestBullet;
import Entity.TestMob;
import Entity.TestTower;
import Graphics.Screen;

import Input.Keyboard;
import Input.Mouse;
import Level.Level;

public class MapState extends State {
	
	private int nItems;
	private Keyboard key;
	private Mouse mouse;
	private int scale;
	public boolean init = false;
	Level level;
	TestTower testTower =  new TestTower(); //testing! 
	
	private TowerMenu towerMenu = new TowerMenu(0, height - 200, width * 3, 200, mouse, key); 
 
	
	private final int SpawnX = 0 * 16;
	private final int SpawnY = 9 * 16;
	
	private int spawnTimer = 0;
	private int spawnCount = 60;
	private boolean allowedToSpawn = true;
	
	//mobs go here:
	private TestMob[] testMobs = new TestMob[100];
	private int nTestMobs = 0;
	
	private TestTower[] testTowers = new TestTower[100];
	private int nTestTowers = 0;
	

	
	
	public MapState(int state, int nItems, int width, int height, int scale, Keyboard key,Mouse mouse, Level level) {
		super(state, nItems, height, height, scale, key);
		this.state = state;
		this.nItems = nItems;
		this.nItems = width;
		this.nItems = height;
		this.key = key;
		this.mouse = mouse;
		this.scale = scale;
		this.level = level;
	}
	
	
	public void init(){
		if(!init){
			// bullets init
			
			//testMob.init(level);
			init = true;
		}
	}
	
	public void update(){
		
		
		
		for(int i = 0; i <= nTestTowers; i++){
			if(testTowers[i] != null) testTowers[i].update(testMobs);
		}
		
		for(int i = 0; i <= nTestMobs; i++ ){
			if(testMobs[i] != null ){
				if(testMobs[i].x > width || testMobs[i].y > height)  testMobs[i] = null;
			}
			
			if(testMobs[i] != null) testMobs[i].update();
		}
		
		//mobs spawn code
		if(allowedToSpawn){
			testMobs[nTestMobs] = new TestMob(SpawnX, SpawnY);
			testMobs[nTestMobs].init(level);
			nTestMobs++;
			allowedToSpawn = false;
		}
		
		if(!allowedToSpawn) spawnTimer++;
		if(spawnTimer >= spawnCount){
			allowedToSpawn = true;
			spawnTimer = 0;
			
			towerMenu.update();
		}
		
		//turrets spawn code
		if(Mouse.clicked()){
			testTowers[nTestTowers] = new TestTower((Mouse.getX() / 96 * 96) / scale, (Mouse.getY() / 96 * 96) / scale);
			towerMenu.setEntity(testTowers[nTestTowers]);//testing
			
			nTestTowers++;
			Mouse.deClick();
			
		}
	}
	
	public void render(Screen screen){
		level.render(0, 0, screen);
		
		
		
		for(int i = 0; i <= nTestMobs; i++ ){
			if(testMobs[i] != null) testMobs[i].render(screen);
		}
		for(int i = 0; i <= nTestTowers; i++){
			

			if(testTowers[i] != null)
				testTowers[i].render(screen);
		}
		
		screen.renderSpecial((((Mouse.getX()) / 96 ) * 96) / scale, (((Mouse.getY()) / 96) * 96) / scale, 32 , 100);
		towerMenu.render(screen);
	}
	
	public void render(Screen screen, Graphics g){
		//screen.drawGrid(g, 32, Color.gray);
		
		for(int i = 0; i <= nTestTowers; i++){
			if(testTowers[i] != null)
				testTowers[i].render(screen, g);
		}
		towerMenu.render(screen, g); 
		
	}
	
	
	
}
