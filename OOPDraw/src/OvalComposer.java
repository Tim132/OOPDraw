import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;


public class OvalComposer implements ShapeComposer {

	private Point start;
	private Point end;
	private int width;
	private int height;
	
	@Override
	public void create(int x, int y) {
		start = new Point(x, y);
	}

	@Override
	public void expand(int x, int y) {
		Point drawto = new Point(Math.max(x, start.x), Math.max(y, start.y));
		Point newstart = new Point(Math.min(x, start.x), Math.min(y, start.y));
		width = Math.abs((drawto.x - newstart.x));
		height = Math.abs((drawto.y - newstart.y));
		end = newstart;
	}

	@Override
	public void complete(int x, int y) {
		expand(x, y);
	}

	@Override
	public void Draw(Graphics2D g) {
		g.setColor(Color.green.darker()); // Set default color
		g.drawOval(end.x, end.y, width, height);
	}

}
