package dots;
import java.awt.Color;

public class computerDot extends Dot{
	
	public ArrayList<computerDot> dotList;
	private int index;
	//keeps track of list so it can delete itself when  it gets consumed
	
	
	public computerDot(int xCenter, int yCenter, Color color, int radius, int[] boardDimensions, ArrayList<computerDot> dotList) {
		super(int xCenter, int yCenter, Color color, int radius, int[] boardDimensions);
		this.dotList = dotList;
		this.index = dotList.indexOf(this);
		//xCenter and yCenter are randomly assigned from the side of the frame
		//radius is randomly assigned
	}
	
	public void delete() {
		//has been eaten by user dot or exited the board -- this dot is deleted
		dotList.remove(this);
		//changes pixels back to background color
		for(Integer[] Point: this.Points) {
			//set back  to color
		}
	}
	
	
	
	
	
	public void movement() {
		//checks for collision with every other dot first
		for(computerDot dot: dotList) {
			if(dotList.indexOf(dot)!=this.index) {
				if(collisionCheck(dot)) {
					//changes movement
				}
			}
		}
		//acts on movement
	}
	
	public boolean collisionCheck(computerDot dot) {
		
		//check if bounces off another dot of the same type -- tells movement to flip
	}
	
	
}
