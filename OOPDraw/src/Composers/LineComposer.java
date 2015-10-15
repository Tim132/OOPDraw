package Composers;
import java.awt.Point;

import Shapes.AbstractShape;
import Shapes.MyLine;

public class LineComposer implements ShapeComposer {

	private MyLine line;
	private static LineComposer instance;
	
	public static LineComposer getInstance() {
		if(instance == null) {
			instance = new LineComposer();
		}
		return instance;
	}
	
	public AbstractShape getShape() {
		return line;
	}
	
	@Override
	public void create(int x, int y) {
		line = new MyLine();
		line.setStart(new Point(x, y));
	}

	@Override
	public void expand(int x, int y) {
		line.setEnd(new Point(x, y));
	}

	@Override
	public void complete(int x, int y) {
		expand(x, y);
	}
}
