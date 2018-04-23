package dots;

import java.awt.Color;
import java.util.ArrayList;

public abstract class Dot {
	public int xLocation;
	public int yLocation;
	public Color c;
	public int size;
	
	public ArrayList xPoints;
	
	public abstract void movement();
	
}
