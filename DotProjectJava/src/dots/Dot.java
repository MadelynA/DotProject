import java.awt.Color;

public abstract class Dot {
	public int xLocation;
	public int yLocation;
	public Color c;
	public int size;
	
	public abstract void movement();
	public abstract boolean collide();
	
}
