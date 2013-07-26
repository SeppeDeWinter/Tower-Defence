import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import Graphics.Screen;
import Graphics.Menu.StateManager;
import Input.Keyboard;
import Input.Mouse;


public class Game extends Canvas implements Runnable {
	private static final long serialVersionUID = 1L;
	static Toolkit tk = Toolkit.getDefaultToolkit();
	private static int width = 480; 
	private static int height = width / 16 * 9; 
	
	private static int scale = 3;
	private static String title = "Tower Defense";

	private Thread thread;
	private JFrame frame;
	private boolean running = false;
	
	private Keyboard key ;
	private Screen screen;
	private StateManager stateManage;
	private int state = 0;
	private BufferedImage image = new BufferedImage(width, height,
			BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer())
			.getData();
	
	public Game() {
		Dimension size = new Dimension(width * scale, height * scale);
		setPreferredSize(size);
		screen = new Screen(width  ,height, scale);
		frame = new JFrame();
		key = new Keyboard();
		
		Mouse mouse = new Mouse(); 
		
		stateManage = new StateManager(width * scale , height * scale, scale, key, mouse);
		stateManage.init();
		
		addKeyListener(key);
		addMouseListener(mouse);
		addMouseMotionListener(mouse);
	}
	
	public static int getWindowWidth() {
		return width;
	}

	public static int getWindowHeight() {
		return height;
	}

	public synchronized void start() {

		running = true;
		thread = new Thread(this, "Display");
		thread.start();
	}

	public synchronized void stop() {

		running = false;
		try {

			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {

		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ns = 1000000000.0 / 60.0;
		double delta = 0;
		int frames = 0;
		int updates = 0;
		

		requestFocus(); // set canvas to focus (so you don't have to click when
						// you launch the game)
		while (running) {

			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {

				update();

				updates++;
				delta--;
			}
			render();
			frames++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				//System.out.println(updates + " ups, " + frames + " fps");
				frame.setTitle(title + " 	| 	" + updates + " ups, " + frames
						+ " fps");
				updates = 0;
				frames = 0;
			}

		}
		stop();
	}
	
	public void update(){
		key.update();
		stateManage.update();
		state = stateManage.state;
		
		if(state == -1) exit(0);
	}
	
	public void render(){
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}
		
		screen.clear();
		
	
		stateManage.render(screen);
		for(int  i = 0; i < pixels.length; i++)
		{
			pixels[i]= screen.pixels[i];
		}
		Graphics g = bs.getDrawGraphics();
		g.drawImage(image, 0, 0, getWidth(), getHeight(),null);
		stateManage.render(screen, g);
		
		g.dispose();
		bs.show();
	}
	
	public static void main(String[] args) {

		Game game = new Game();
		game.frame.setUndecorated(false);
		game.frame.setResizable(false);
		game.frame.setTitle(title);
		game.frame.add(game);
		game.frame.pack();
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.setLocationRelativeTo(null);
		game.frame.setVisible(true);
		game.start();
	}
	
	private void exit(int exitCode){
		if(exitCode != 0) System.out.println ("EXIT WITH ERROR... DAMN!    | exit code: " + exitCode );
		if(exitCode == 0) System.out.println ("exiting with no errors beautiful :D" );
		System.exit(exitCode);
		
	}
	
}
