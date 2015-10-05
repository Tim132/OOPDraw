import java.awt.Point;


public class FunnyComposer implements ShapeComposer {

	private MyFunnyShape funny;
	
	public AbstractShape getShape() {
		return funny;
	}
	
	@Override
	public void create(int x, int y) {
		funny = new MyFunnyShape();
		funny.setStart(new Point(x, y));
	}

	@Override
	public void expand(int x, int y) {
		funny.setEnd(new Point(x, y));
	}

	@Override
	public void complete(int x, int y) {
		expand(x, y);
	}
}
