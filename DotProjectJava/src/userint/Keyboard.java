package userint;

import java.awt.event.*;

//this is the keyboard class to make telling if a key is pressed more simple

public class Keyboard implements KeyListener{
	private static boolean[] keys = new boolean[65535];
	//will keep track of keys
	private static int lastCheckPressed = -1;
	private static int lastPressed = -1;
	//keeps track of last key pressed and if it was checked or not
	
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
		//sets true that it is pressed
		if(lastCheckPressed !=e.getKeyCode()) {
			//if it isn't the same as last time, change the val of lastPressed
			lastPressed = e.getKeyCode();
			lastCheckPressed = e.getKeyCode();
		}
	}
	
	public void keyReleased(KeyEvent e) {
		//isn't still held down, set val = false
		keys[e.getKeyCode()] = false;
		lastCheckPressed = -1;
		//resets last check -- if pressed again, is a new press
	}
	
	public static int getLastPressed() {
		//can return the val of the last key pressed one time
		int last = lastPressed;
		lastPressed = -1;
		return  last;
	}
	
	public boolean isKeyDown(int keyCode) {
		return keys[keyCode];
		//returns if it is currently down or not
	}
	
	public void keyTyped(KeyEvent e) {
		//nothing because not used but must  be inherited
	}

}
