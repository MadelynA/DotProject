package dots;


import javafx.scene.paint.Color;
import userint.Keyboard;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Ellipse;

public class userDot extends Dot {
	
	private int score;
	private int xChange = 0;
	private int yChange = 0;
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
		
		if(k.isKeyPressed()) {
			if(k.whatKeyDown().equals(KeyCode.DOWN)) {
				yChange = 1;
			}
			//else so that both don't happen
			else if(k.whatKeyDown().equals(KeyCode.UP)) {
				yChange = -1;
			}
			if(k.whatKeyDown().equals(KeyCode.LEFT)) {
				xChange = -1;
			}
			else if (k.whatKeyDown().equals(KeyCode.RIGHT)) {
				xChange = 1;
			}
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
