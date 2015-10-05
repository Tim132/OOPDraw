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
		rect.setEnd(new Point(x, y));
	}

	@Override
	public void complete(int x, int y) {
		expand(x, y);
	}
}
