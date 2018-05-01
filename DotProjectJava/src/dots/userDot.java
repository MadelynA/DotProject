package dots;

import java.awt.Color;
import java.awt.geom.Ellipse2D;

public class userDot extends Dot {
	
	private int score;
	//score will start at 0 and increase by a set amount per second? dot eaten? TBD
	
	public userDot(int xCenter, int yCenter, Color color, int radius) {
		super(int xCenter, int yCenter, Color color, int radius);
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
	
	public void movement() {
		//will go directly to mouse's current location
	}
	
	public void destroy(computerDot dot) {
		//eats other dot
		dot.delete();
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
		this.radius = this.radius+1;
		this.setRadius(this.getRadius()+1);
	}
	
	
	
}
