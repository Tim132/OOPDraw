import java.awt.Point;


public class FunnyComposer implements ShapeComposer {

	private MyFunnyShape funny;
	private static FunnyComposer instance;
	
	public static FunnyComposer getInstance() {
		if(instance == null) {
			instance = new FunnyComposer();
		}
		return instance;
	}
	
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
