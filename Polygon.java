package geometry_improvement;

import java.util.Arrays;

public abstract class Polygon {
	
	/**
	 * @return the vertices
	 */
	public abstract Point[] getVertices();
	/**
	 * @param vertices the vertices to set
	 */
	public abstract void setVertices(Point[] vertices);
	/**
	 * @return the type
	 */
	public abstract String getType();
	@Override
	public abstract String toString();
	
	
}//End of class

