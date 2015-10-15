package Composers;

import Shapes.AbstractShape;

public interface ShapeComposer {
	
public AbstractShape getShape();
	
public void create(int x, int y);

public void expand(int x, int y);

public void complete(int x, int y);

}
