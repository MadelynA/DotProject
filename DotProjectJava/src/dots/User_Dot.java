package dots;

public class User_Dot extends Dot {
	
	public void movement() {
		//xLocation = p.x;
	//	yLocation = p.y;
	}
	
	// fix!
	public boolean collide(playingDots d) {
		if(d.xLocation == this.xLocation && d.yLocation == this.yLocation) {
			sizeChange();
			return true;
		}
		
		return false;
	}
	
	public void sizeChange() {
		size+= 15;
	}
	
	

}
