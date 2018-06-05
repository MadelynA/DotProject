package dots;


import javafx.scene.paint.Color;
import userint.Keyboard;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Ellipse;

public class secondUser extends Dot {
	
	private int score;
	private int xChange = 0;
	private int yChange = 0;
	private Keyboard k;
	private int moveSpeed = 1;
	//score will start at 0 and increase by a set amount per second? dot eaten? TBD
	
	public secondUser(int xCenter, int yCenter, Color color, int radius, Keyboard k) {
		super(xCenter, yCenter, color, radius);
		this.score=0;
		this.k = k;
		initDot();
	}
	
	private void initDot() {
		//set up image
	}
	
	private void increaseMoveSpeed() {
		if( moveSpeed<10){
			moveSpeed ++;
		}
	}
	
	private void decreaseMoveSpeed() {
		if(moveSpeed>1) {
			moveSpeed--;
		}
	}
	
	
	public void movement() {
		
		if(k.isKeyPressed()) {
			if(k.whatKeyDown().equals(KeyCode.ENTER)) {
				yChange = moveSpeed;
				xChange = 0;
			}
			//else so that both don't happen
			else if(k.whatKeyDown().equals(KeyCode.W)) {
				yChange = -1*moveSpeed;
				xChange = 0;
			}
			if(k.whatKeyDown().equals(KeyCode.A)) {
				xChange = -1*moveSpeed;
				yChange = 0;
			}
			else if (k.whatKeyDown().equals(KeyCode.D)) {
				xChange = moveSpeed;
				yChange = 0;
			}
			if(k.whatKeyDown().equals(KeyCode.E)) { 
				decreaseMoveSpeed();
			}
			else if(k.whatKeyDown().equals(KeyCode.R)) {
				increaseMoveSpeed();
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
		this.circle.setRadius(this.getRadius());
		//this.setRadius(this.getRadius()+1);
	}
	
	public int getRadius() {
		return this.radius;
	}
	public boolean isOnBoard() {
		return true;
	}
	
	
	
	
	
}

