import java.awt.Graphics2D;
import java.awt.Point;


public class OvalComposer implements ShapeComposer {

	private Point start;
	private Point end;
	
	@Override
	public void create(int x, int y) {
		start = new Point(x, y);
	}

	@Override
	public void expand(int x, int y) {
		end = new Point(x, y);
	}

	@Override
	public void complete(int x, int y) {
		expand(x, y);
	}

	@Override
	public void Draw(Graphics2D g) {
		// TODO Auto-generated method stub
		
	}

}
