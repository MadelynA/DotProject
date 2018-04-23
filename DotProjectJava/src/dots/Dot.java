package dots;

import java.awt.Color;
import java.util.ArrayList;

public abstract class Dot {
	public int xLocation;
	public int yLocation;
	public Color c;
	public int size;
	
	public ArrayList<Int[]> xPoints =  new ArrayList<Int[]>();
	
	
	public abstract void movement();
	
}
