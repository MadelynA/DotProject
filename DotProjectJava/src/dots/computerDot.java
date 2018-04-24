package dots;
import java.awt.Color;

public class computerDot extends Dot{
	
	public ArrayList dotList;
	//keeps track of list so it can delete itself when  it gets consumed
	
	
	public computerDot(int xCenter, int yCenter, Color color, int radius, int[] boardDimensions, ArrayList dotList) {
		super(int xCenter, int yCenter, Color color, int radius, int[] boardDimensions);
		this.dotList = dotList;
		//xCenter and yCenter are randomly assigned from the side of the frame
		//radius is randomly assigned
	}
	
	public void delete() {
		//has been eaten by user dot or exited the board -- this dot is deleted
		dotList.remove(this);
	}
	
	
	
	
	
	public void movement() {
		
	}
	
	public boolean collide(computerDot dot) {		
		//check if bounces off another dot of the same type -- tells movement to flip
	}
	
	
}
