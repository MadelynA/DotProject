package dots;

import java.awt.Color;
import java.util.ArrayList;

public abstract class Dot {
	private int[] center = new int[2];
	private Color c;
	private int radius;
	private ArrayList<Integer[]> circumfrencePts = new ArrayList<Integer[]>();
	private ArrayList<Integer[]> points =  new ArrayList<Integer[]>();
	//circumfrencePts will contain all points on the circumfrence
	//points contains all points in the dot to  assign color to
	public int boardXMax; //set this  value when  assigned from UI
	public int boardYMax; //set this value when  assigned from UI
	
	public Dot(int xCenter, int yCenter, Color color, int radius, int[] boardDimensions) {
		this.radius = radius;
		center[0] = xCenter;
		center[1] = yCenter;
		c = color;
		boardXMax = boardDimensions[0];
		boardYMax = boardDimensions[1];
		setPoints();
	}
	//this method sets the circumfrence points and points based on the center and the radius
	public void setPoints() {
		circumfrencePts =  new ArrayList<Integer[]>();
		points = new ArrayList<Integer[]>();
		int[] tempPt = new int[2];
		int xMin = center[0] - radius;
		int yMin = center[1] - radius;
		int xMax = center[0] + radius;
		int yMax = center[0] + radius;
		if(xMin<0)
			xMin=0; //set equal to zero bc no negative on grid
		if(xMax>boardXMax)
			xMax = boardXMax;//doesn't go off the board
		if(yMin<0)
			yMin=0;//treat all values as positive coords
		if(yMax>boardYMax)
			yMax = boardYMax;//keep it  on the board
		for(int x=xMin;x<xMax;x++) {
			for(int y = yMin; y<yMax; y++) {
				tempPt= {x,y};
				if((x-center[0])*(x-center[0])+(y-center[1])*(y-center[1])==(radius*radius)	) {
					circumfrencePts.add(tempPt);
					points.add(tempPt);
				}
				else if((x-center[0])*(x-center[0])+(y-center[1])*(y-center[1])<(radius*radius)) {
					points.add(tempPt);
				}
			}
		}
		
	}
	
	
	//this method sets new center from movement
	public void setCenter(int x, int y) {
		center[0] = x;
		center[1] = y;
		setPoints();
	}
	public abstract boolean collisionCheck();//checks for collision with every movement
	public abstract void movement();//movement for random  dot will be according to pattern, movement for  userdot will be directly to cursor's current location
	public void displayColor() {
		//displays color
	}
	
	public ArrayList<Integer[]> getcircPoints(){
		return circumfrencePts;
	}
	
	public boolean isEdge(int[] pt) {
		return (circumfrencePts.contains(pt));
	}
	
	public void setColor(Color c) {
		this.c = c;
		//used for changing color as user dot grows
	}
	
	public void setRadius(int newRadius) {
		this.radius = newRadius;
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
	
}
