package dots;
import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;

public class computerDot extends Dot{
	private int xChange = 0;
	private int yChange = 0;
	private int mType;
	
	
	//keeps track of list so it can delete itself when  it gets consumed
	
	
	public computerDot(int xCenter, int yCenter, Color color, int radius) {
		mType = (int) (Math.random()*4);
		super( xCenter, yCenter, color, radius);
		//xCenter and yCenter are randomly assigned from the side of the frame
		//radius is randomly assigned
	}
	
	
	
	public void movement() {
		if (this.onBoard()){
			//doesn't move if not on board
			this.movementType();
			this.setCenter(this.getCenterX()+xChange, this.getCenterY()+yChange);
			//will go in direction of change
		}
	}
	
	public boolean onBoard() {
		//checks if it is within the board bounds
		if(this.getCenterX()<0 || this.getCenterX()>400 || this.getCenterY()<0 || this.getCenterY()>800) {
			return false;
		}
		return true;
	}
	
	public void movementType() {
		if(this.mType==0) {
			//goes only left
			xChange = -1;
		}
		if(this.mType==1) {
			//goes only right
			xChange = 1;
		}
		if(this.mType==2) {
			//goes down
			yChange = -1;
		}
		if(this.mType == 3) {
			//goes up
			yChange  = 1;
		}
		
	}
	
	
	
	
}
