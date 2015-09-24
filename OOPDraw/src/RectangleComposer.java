import java.awt.Point;


public class RectangleComposer implements ShapeComposer {

	private MyRect rect;
	
	public AbstractShape getShape() {
		return rect;
	}
	
	@Override
	public void create(int x, int y) {
		rect = new MyRect();
		rect.setStart(new Point(x, y));
	}

	@Override
	public void expand(int x, int y) {
		Point drawto = new Point(Math.max(x, rect.getStart().x), Math.max(y, rect.getStart().y));
		Point newstart = new Point(Math.min(x, rect.getStart().x), Math.min(y, rect.getStart().y));
		rect.setWidth(Math.abs((drawto.x - newstart.x)));
		rect.setHeight(Math.abs((drawto.y - newstart.y)));
		rect.setEnd(newstart);
	}

	@Override
	public void complete(int x, int y) {
		expand(x, y);
	}
}
