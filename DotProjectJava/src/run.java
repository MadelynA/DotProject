import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;

import userint.userInt;

//this class runs the program
public class run extends JPanel{

	public static void main(String[] args) {
		
		EventQueue.invokeLater(() -> {
			userInt run = new userInt();
			run.setVisible(true);
		});
		// TODO Auto-generated method stub
		
		
	}
	
	public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }
	
	private void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		RenderingHints rh
        = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

		rh.put(RenderingHints.KEY_RENDERING,
			RenderingHints.VALUE_RENDER_QUALITY);

		g2d.setRenderingHints(rh);
		
		Dimension size = getSize();
		double w = size.getWidth();
		double h = size.getHeight();
		
		Ellipse2D e = new Ellipse2D.Double(0, 0, 80, 130);
		g2d.setStroke(new BasicStroke(1));
		g2d.setColor(Color.black);
        
    }

}
