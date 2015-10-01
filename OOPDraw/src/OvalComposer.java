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
		oval.setEnd(new Point(x, y));
	}

	@Override
	public void complete(int x, int y) {
		expand(x, y);
	}
}
