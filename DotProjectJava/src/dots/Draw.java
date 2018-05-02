package dots;

import java.awt.Color;
import java.awt.geom.Ellipse2D;
import java.awt.*;

public class Draw {
	//takes a g, draws images
	
	
	public Draw(Dot d) {
		//Graphics g = new Graphics();
		//g.drawOval(d.getCenterX(), d.getCenterY(), d.getRadius(), d.getRadius());
		//g.setColor(d.getColor());
	}

	
	//takes draw method, animates (current x, current y, change in x, change in y)
	public void animate(int x, int y, int changeX, int changeY) {
		
	}
	
	/**
	 * private void drawDonut(Graphics g) {

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
        g2d.setColor(Color.gray);

        for (double deg = 0; deg < 360; deg += 5) {
            AffineTransform at
                    = AffineTransform.getTranslateInstance(w/2, h/2);
            at.rotate(Math.toRadians(deg));
            g2d.draw(at.createTransformedShape(e));
        }
    }
	 */
	
	
}
