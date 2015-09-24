import java.awt.Point;

public class LineComposer implements ShapeComposer {

	private MyLine line;
	
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
