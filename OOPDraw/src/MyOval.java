import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

/**
 *  Class MyOval for drawing ovals is derived
 *  from our 'base class' AbstratShape
 */
class MyOval extends AbstractShape {

	public void setStart(Point pt) {
		ptStart = pt;
	}

	public void setEnd(Point pt) {
		ptEnd = pt;
	}

	public void setWidth(int w) {
		nwidth = w;
	}

	public void setHeight(int h) {
		nheight = h;
	}

	public Point getStart() {
		return ptStart;
	}

	public Point getEnd() {
		return new Point(0, 0);
	}

	public int getWidth() {
		return nwidth;
	}

	public int getHeight() {
		return nheight;
	}

	// Drawing routine
	public void Draw(Graphics2D g) {
		g.setColor(Color.green.darker()); // Set default color
		g.drawOval(ptStart.x, ptStart.y, nwidth, nheight);
	}

}

// Class cOval ends
