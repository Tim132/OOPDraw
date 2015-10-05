import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Rectangle2D;;

// Class cRect for drawing Rects is derived
// from our 'base class' cShape

class MyRect extends AbstractShape {

	private Rectangle2D rect;
	private Point start;
	
	public MyRect() {
		rect = new Rectangle2D.Double();
	}

	public void setStart(Point pt) {
		rect.setFrame(pt.x, pt.y, (rect.getX() - pt.x), (rect.getY() - pt.y));
		start = pt;
	}

	public void setEnd(Point pt) {
		rect.setFrameFromDiagonal(start, pt);
	}
	
	// Drawing routine
	public void Draw(Graphics2D g) {
		g.setColor(Color.blue.darker()); // Set default color
		g.draw(rect);
	}
}