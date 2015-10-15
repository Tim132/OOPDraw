package Shapes;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Ellipse2D;

/**
 *  Class MyOval for drawing ovals is derived
 *  from our 'base class' AbstratShape
 */
public class MyOval extends AbstractShape {
	
	private Ellipse2D oval;
	private Point start;
	
	public MyOval() {
		oval = new Ellipse2D.Double();
	}

	public void setStart(Point pt) {
		oval.setFrame(pt.x, pt.y, (oval.getX() - pt.x), (oval.getY() - pt.y));
		start = pt;
	}

	public void setEnd(Point pt) {
		oval.setFrameFromDiagonal(start, pt);
	}
	
	// Drawing routine
	public void Draw(Graphics2D g) {
		g.setColor(Color.green.darker()); // Set default color
		g.draw(oval);
	}
}

// Class cOval ends
