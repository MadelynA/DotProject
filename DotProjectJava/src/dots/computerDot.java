package dots;
import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;

public class computerDot extends Dot{
	
	//keeps track of list so it can delete itself when  it gets consumed
	
	
	public computerDot(int xCenter, int yCenter, Color color, int radius) {
		super( xCenter, yCenter, color, radius);
		//xCenter and yCenter are randomly assigned from the side of the frame
		//radius is randomly assigned
	}
	
	public void delete() {
		//has been eaten by user dot or exited the board -- this dot is deleted
		//changes pixels back to background color
	}
	
	
	
	
	
	public void movement(int xChange, int yChange) {
		this.setCenter(this.getCenterX()+xChange, this.getCenterY()+yChange);
		//will go in direction of change
	}
	
	
	
	
}
