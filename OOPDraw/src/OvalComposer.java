import java.awt.Point;


public class OvalComposer implements ShapeComposer {

	private MyOval oval;
	
	public AbstractShape getShape()
	{
		return oval;
	}
	
	@Override
	public void create(int x, int y) {
		oval = new MyOval();
		Point start = new Point(x, y);
		oval.setStart(start);
	}

	@Override
	public void expand(int x, int y) {
		Point drawto = new Point(Math.max(x, oval.getStart().x), Math.max(y, oval.getStart().y));
		Point newstart = new Point(Math.min(x, oval.getStart().x), Math.min(y, oval.getStart().y));
		oval.setWidth(Math.abs((drawto.x - newstart.x)));
		oval.setHeight(Math.abs((drawto.y - newstart.y)));
		oval.setEnd(newstart);
	}

	@Override
	public void complete(int x, int y) {
		expand(x, y);
	}
}
