package dots;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.geom.Ellipse2D;

public class userDot extends Dot {
	
	private int score;
	private int xChange;
	private int yChange;
	//score will start at 0 and increase by a set amount per second? dot eaten? TBD
	
	public userDot(int xCenter, int yCenter, Color color, int radius) {
		super( xCenter, yCenter, color, radius);
		this.score=0;
		initDot();
	}
	
	private void initDot() {
		//set up image
	}
	
	public void endGame() {
		//dot has been eaten, the game ends and shows score
		//first it stops every other dot
	}
	
	public void movement(int xChange, int yChange) {
		this.setCenter(center[0]+xChange, center[1]+yChange);
		//will go in direction of change
	}
	
	
	public void setColor(Color c) {
		this.c = c;
		//used for changing color as user dot grows
	}
	
	public void setRadius(int newRadius) {
		this.setRadius(newRadius);
		//used for changing size as user grows
	}
	
	public void grow() {
		//grows dot by one pixel radius when it hits a dot smaller than it
		this.radius = this.radius+1;
		this.setRadius(this.getRadius()+1);
	}
	
	public void keyPress(KeyEvent e) {
		//finds key and decides which direction to go for movement
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_UP) {
			//goes up
			yChange = 1;
		}
		if(key == KeyEvent.VK_LEFT) {
			//goes left
			xChange = -1;
		}
		if(key == KeyEvent.VK_RIGHT) {
			//goes right
			xChange = 1;
		}
		if(key==KeyEvent.VK_DOWN) {
			//goes down
			yChange = -1;
		}
		if(key==KeyEvent.VK_PERIOD) {
			//this will be the quick quit button
			endGame();
		}
		
	}
	
	public void keyRelease(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT) {
			xChange = 0;
		}
		if(key==KeyEvent.VK_UP || key == KeyEvent.VK_DOWN) {
			yChange = 0;
		}
		if(key==KeyEvent.VK_PERIOD) {
			endGame();
		}
	}
	
	
	
}
