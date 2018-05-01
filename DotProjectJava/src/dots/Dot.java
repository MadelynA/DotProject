package dots;

import java.awt.Color;
import java.awt.Image;
import java.util.ArrayList;
import java.awt.geom.Ellipse2D;

public abstract class Dot {
	private int[] center = new int[2];
	public Color c;
	public int radius;
	private boolean onBoard;
	
	public Dot(int xCenter, int yCenter, Color color, int radius) {
		this.radius = radius;
		center[0] = xCenter;
		center[1] = yCenter;
		c = color;
		onBoard = true;
	}
	//uses an  ellipse to find the outside of the dot
	public Ellipse2D.Double getCirc(){
		double upLeftx = (double) (center[0]-radius);
		double upLefty = (double) (center[1]+radius);
		double diameter = (double) (radius*2);
		return new Ellipse2D.Double(diameter, diameter, upLeftx, upLefty);
	}
	//this method sets new center from movement
	public void setCenter(int x, int y) {
		center[0] = x;
		center[1] = y;
	}
	public abstract void movement(int xChange, int yChange);//movement for random  dot will be according to pattern, movement for  userdot will be directly to cursor's current location
	public void displayColor() {
		//displays color
	}
	
	public int getCenterX() {
		return center[0];
	}
	public int getCenterY() {
		return center[1];
	}
	public int getRadius() {
		return radius;
	}
	public Color getColor() {
		return c;
	}
	public boolean isOnBoard() {
		return onBoard;
	}
	public void setOnBoard(boolean onBoard) {
		this.onBoard = onBoard;
	}
	
}
