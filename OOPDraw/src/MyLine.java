import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Line2D;

/**
 *  Class MyLine for drawing lines is
 *  derived from our 'base' class AbstractShape
 */
public class MyLine extends AbstractShape {

	private Line2D line;
	
	public MyLine() {
		line = new Line2D.Double();
	}
	
	@Override
	public void setStart(Point pt) {
		line.setLine(pt.x, pt.y, pt.x, pt.y);
	}

	public void setEnd(Point pt) {
		line.setLine(line.getX1(), line.getY1(), pt.x, pt.y);
	}

	// Drawing routine
	public void Draw(Graphics2D g) {
		g.setColor(clrFront); // Set default color -you may ignore colors
		g.draw(line);
	}
}

// Class cLine ends
