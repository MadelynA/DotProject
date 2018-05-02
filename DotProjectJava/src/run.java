import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.Color;
import java.awt.Dimension;

import userint.userInt;

//this class runs the program
public class run {

	public static void main(String[] args) {
		
		EventQueue.invokeLater(() -> {
			userInt run = new userInt();
			run.setVisible(true);
		});
		// TODO Auto-generated method stub
		
	}
	
	private void draw (Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		RenderingHints rh
        = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

		rh.put(RenderingHints.KEY_RENDERING,
			RenderingHints.VALUE_RENDER_QUALITY);

		g2d.setRenderingHints(rh);
        
    }

}
