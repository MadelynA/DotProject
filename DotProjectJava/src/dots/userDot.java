package dots;

public class userDot extends Dot {
	
	private int score;
	public ArrayList<computerDot> dotList;
	//score will start at 0 and increase by a set amount per second? dot eaten? TBD
	
	public userDot(int xCenter, int yCenter, Color color, int radius, int[] boardDimensions, ArrayList<computerDot> dotList) {
		super(int xCenter, int yCenter, Color color, int radius, int[] boardDimensions);
		this.score=0;
		this.dotList = dotList;
	}
	
	public void endGame() {
		//dot has been eaten, the game ends and shows score
		//first it stops every other dot
	}
	
	public void movement() {
		//will go directly to mouse's current location
	}
	
	public void destroy(computerDot dot) {
		//eats other dot
		dot.delete();
	}
	
	public void grow() {
		this.radius = this.radius+1;
		this.setRadius(this.getRadius()+1);
	}
	public boolean collisionCheck(computerDot dot) {
		for(Integer[] point: dot.getcircPoints()) {
			if(this.getcircPoints().contains(point)) {
				//there is overlap of the circumfrences -- a collision has occurred
				if(dot.getRadius()>this.getRadius()) {
					//other dot is larger, game over
					endGame();
				}
				else {
					this.grow();
					destroy(dot);
					return true;
				}
			}
			else {
				return false;
				//no collision has occurred
			}
		}
		
	}
	
	
	
}
