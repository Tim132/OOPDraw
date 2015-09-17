import java.awt.Graphics2D;
import java.awt.Point;

/**
 *  Class MyLine for drawing lines is
 *  derived from our 'base' class AbstractShape
 */
public class MyLine extends AbstractShape {

	@Override
	public void setStart(Point pt) {
		ptStart = pt;
	}

	public void setEnd(Point pt) {
		ptEnd = pt;
	}

	public Point getStart() {
		return ptStart;
	}

	public Point getEnd() {
		return ptEnd;
	}

	// Drawing routine
	public void Draw(Graphics2D g) {
		g.setColor(clrFront); // Set default color -you may ignore colors
		g.drawLine(ptStart.x, ptStart.y, ptEnd.x, ptEnd.y);
	}
}

// Class cLine ends
