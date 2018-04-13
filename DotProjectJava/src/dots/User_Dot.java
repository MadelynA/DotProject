import java.awt.MouseInfo;
import java.awt.Point;

public class User_Dot extends Dot {
	
	Point p = MouseInfo.getPointerInfo().getLocation();
	
	
	public void movement() {
		xLocation = p.x;
		yLocation = p.y;
	}
	
	// fix!
	public boolean collide(playingDots d) {
		if(d.xLocation == this.xLocation && d.yLocation == this.yLocation) {
			return true;
		}
		
		return false;
	}
}
