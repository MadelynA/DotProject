package dots;

import javafx.scene.paint.Color;
import java.util.ArrayList;

import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;


public abstract class Dot {
	private int[] center = new int[2];
	public Color c;
	public int radius;
	private boolean onBoard;
	public Circle circle;
	public boolean hasCircle;
	
	public Dot(int xCenter, int yCenter, Color color, int radius) {
		this.radius = radius;
		center[0] = xCenter;
		center[1] = yCenter;
		c = color;
		onBoard = true;
		hasCircle = false;
	}
	//uses an  ellipse to find the outside of the dot
	public Ellipse getCirc(){
		Ellipse ellipse = new Ellipse();
		ellipse.setCenterX((double)center[0]);
		ellipse.setCenterY((double)center[1]);
		ellipse.setRadiusX((double)radius);
		ellipse.setRadiusY((double)radius);
		return ellipse;
		}
	//this method sets new center from movement
	public void setCenter(int x, int y) {
		center[0] = x;
		center[1] = y;
	}
	public abstract void movement();//movement for random  dot will be according to pattern, movement for  userdot will be directly to cursor's current location
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
	public void setColor(Color color) {
		this.c=color;
	}
	public boolean isOnBoard() {
		return onBoard;
	}
	public void setOnBoard(boolean onBoard) {
		this.onBoard = onBoard;
	}
	
}
