package Shapes;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;

public class MyFunnyShape extends AbstractShape {
	
	private ArrayList<AbstractShape> shapes;
	
	public MyFunnyShape() {
		shapes = new ArrayList<AbstractShape>();
		MyRect rect = new MyRect();
		MyLine line = new MyLine();
		MyOval oval = new MyOval();
		shapes.add(rect);
		shapes.add(line);
		shapes.add(oval);
	}

	public void setStart(Point pt) {
		for (AbstractShape shape : shapes) {
			shape.setStart(pt);
		}
	}

	public void setEnd(Point pt) {
		for (AbstractShape shape : shapes) {
			shape.setEnd(pt);
		}
	}
	
	// Drawing routine
	public void Draw(Graphics2D g) {
		for (AbstractShape shape : shapes) {
			shape.Draw(g);
		}
	}
}
