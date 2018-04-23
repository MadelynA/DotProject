package dots;

public class User_Dot extends Dot {
	
	Integer[] p = new Integer[2];
	
	public void movement() {
		//xLocation = p.x;
	//	yLocation = p.y;
	}
	
	// fix!
	public boolean collide(playingDots d) {
		
	}
	
	public void sizeChange() {
		size+= 15;
	}
	
	public void setOfPoints() {
		
		//Quadrant 1 of dot
		for(int i = 0; i <= size; i++) {
			p[0] = xLocation + size - i;
			p[1] = yLocation + i;
			points.add(p);
		}
		
		//Quadrant 2 of dot
		for(int i = 0; i <= size; i++) {
			p[0] = xLocation - i;
			p[1] = yLocation + size - i;
			points.add(p);
		}
		
		//Quadrant 3 of dot 
		for(int i = 0; i <= size; i++) {
			p[0] = xLocation - size + i;
			p[1] = yLocation - i;
			points.add(p);
		}
		
		//Quadrant 4 of dot
		for(int i = 0; i <= size; i++) {
			p[0] = xLocation + i;
			p[1] = yLocation - size + i;
			points.add(p);
		}
	}

}
