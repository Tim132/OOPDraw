package Shapes;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Point2D;

/**
 * base class AbstractShape
 *
 */
public abstract class AbstractShape extends Object

{

	// Data members
	protected Point ptStart; // Start point of shape

	protected Point ptEnd; // End point of shape

	protected int nwidth; // Width of shape

	protected int nheight; // Height of shape

	protected Color clrFront; // Default color

	public AbstractShape() {
		// default color is red, try your combinations
		clrFront = Color.red;
	}

	public abstract void setStart(Point pt);

	public abstract void setEnd(Point pt);

	public Point2D getStart() {
		return ptStart;
	}

	public Point getEnd() {
		return ptEnd;
	}

	public abstract void Draw(Graphics2D g);

	public void setHeight(int nheight1) {
		// TODO Auto-generated method stub
		
	}

	public void setWidth(int nwidth1) {
		// TODO Auto-generated method stub
		
	}
	
	public AbstractShape getShape() {
		return null;	
	}

}

// Base class cShape ends
