package dots;

import java.awt.Color;
import userint.Keyboard;
import java.awt.event.KeyEvent;
import java.awt.geom.Ellipse2D;

public class userDot extends Dot {
	
	private int score;
	private int xChange;
	private int yChange;
	private Keyboard k;
	//score will start at 0 and increase by a set amount per second? dot eaten? TBD
	
	public userDot(int xCenter, int yCenter, Color color, int radius, Keyboard k) {
		super(xCenter, yCenter, color, radius);
		this.score=0;
		this.k = k;
		initDot();
	}
	
	private void initDot() {
		//set up image
	}
	
	
	public void movement() {
		
		if(k.isKeyDown(KeyEvent.VK_DOWN)) {
			yChange = -1;
		}//use else if so that both don't happen
		else if(k.isKeyDown(KeyEvent.VK_UP)) {
			yChange = 1;
		}
		if(k.isKeyDown(KeyEvent.VK_LEFT)) {
			xChange = -1;
		}
		else if(k.isKeyDown(KeyEvent.VK_RIGHT)) {
			xChange = 1;
		}
		
		this.setCenter(this.getCenterX()+xChange, this.getCenterY()+yChange);
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
	
	public int getRadius() {
		return this.radius;
	}
	
	
	
	
	
	
}
