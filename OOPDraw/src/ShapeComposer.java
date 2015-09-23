import java.awt.Graphics2D;

public interface ShapeComposer {
	
public void create(int x, int y);

public void expand(int x, int y);

public void complete(int x, int y);

public void Draw(Graphics2D g);
}
