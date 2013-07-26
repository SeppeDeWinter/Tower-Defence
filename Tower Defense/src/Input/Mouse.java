package Input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Mouse implements MouseListener, MouseMotionListener {
	private static int mouseX = -1;
	private static int mouseY = -1;
	private static int mouseB = -1;
	private static boolean clicked = false;
	
	public static void deClick(){
		clicked = false;
	}
	
	public static int getX() {
		return mouseX;
	}

	public static int getY() {
		return mouseY;
	}

	public static int getButton() {
		return mouseB;
	}
	
	public static boolean clicked(){
		return clicked;
	}

	public void mouseDragged(MouseEvent e) {
		mouseX = e.getX();
	}

	public void mouseMoved(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
		
	}

	public void mouseClicked(MouseEvent e) {
		clicked = true;
	}

	public void mouseEntered(MouseEvent e) {

	}

	public void mouseExited(MouseEvent e) {

	}

	public void mousePressed(MouseEvent e) {
		mouseB = e.getButton();
	}

	public void mouseReleased(MouseEvent e) {
		mouseB = -1;
	}
}
