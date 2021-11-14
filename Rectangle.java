package geometry_improvement;

import java.util.*;

public class Rectangle extends Polygon{
	private double length;
	private double width;
	private String type;
	private Point[] vertices;
	private static final String[] TYPES = {"TRIANGLE","RECTANGLE","CIRCLE"};
	
	/**
	 * @param length
	 * @param width
	 */
	public Rectangle(Point p, double length, double width) throws negativeNumException{
		super();
		if (length <= 0 || width <= 0)  {
			throw new negativeNumException("You cannot enter in a negative or zero measurement!"); 
			//makes sure length and width are non-zero numbers
		} else {
			this.length = length;
			this.width = width;
			setPoint(p); //sets the top left point to the one passed through the constructor
		}
	}
	
	public Rectangle(Point p, Point p2, Point p3, Point p4) throws duplicatePointsException { //allows the user to enter in 4 points
		super();
		if (duplicateCheck(p, p2) || duplicateCheck(p, p3) || duplicateCheck(p2, p3) || duplicateCheck(p, p4) || duplicateCheck(p2, p4) || duplicateCheck(p3, p4)) {
			throw new duplicatePointsException("You have 2 or more points located at the same coordinate!");
		}
		
		setPoints(p, p2, p3, p4);
		
	}
	
	private boolean duplicateCheck(Point p, Point p2) {
		if (p.getX() == p2.getX() && p.getY() == p2.getY()) {
			return true;
		}
		return false;
	}
	
	
	/**
	 * @return the length
	 */
	public double getLength() {
		return length;
	}
	
	/**
	 * @param length the length to set
	 */
	public void setLength(double length) throws negativeNumException{
		if (length <= 0) {
			throw new negativeNumException("You cannot enter in a negative or zero measurement: " + length);
		} else {
		this.length = length;
		}
	}
	
	/**
	 * @return the width
	 */
	public double getWidth() {
		return width;
	}
	
	/**
	 * @param width the width to set
	 */
	public void setWidth(double width) throws negativeNumException{
		if (width <= 0) {
			throw new negativeNumException("You cannot enter in a negative or zero measurement: " + width);
		} else {
		this.width = width;
		}
	}

	public double getArea() {
		return length * width;
	}
	
	public double getPerimeter() {
		return 2*(length + width);
	}
	
	public Point getPoint() {
		return getVertices()[0];
	}
	
	public void setPoint(Point p){
		Point points[] = new Point[4];
		points[0] = p;	
		try {
			points[1] = new Point(length + p.getX(), p.getY());
			points[2] = new Point(length + p.getX(), width + p.getY());
			points[3] = new Point(p.getX(), width + p.getY());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		setVertices(points);
	}
	
	public void setPoints(Point p, Point p2, Point p3, Point p4){
		Point points[] = new Point[4];
		points[0] = p;	
		points[1] = p2;
		points[2] = p3;
		points[3] = p4;
		setVertices(points);
	}
	
	public Point[] getVertices() {
		return vertices;
	}
	
	public void setVertices(Point[] vertices) {
		this.vertices = vertices;
		if (this.vertices == null) {
			type = TYPES[2];
		}else if (vertices.length < 3) {
			this.vertices = new Point[3];
			try {
				(this.vertices)[0] = new Point(0,0);
				(this.vertices)[1] = new Point(0,0);
				(this.vertices)[2] = new Point(0,0);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			this.type = TYPES[0];
		} else {
			switch (vertices.length) {
			case 3: type = TYPES[0]; break;
			case 4: type = TYPES[1]; break;
			default: type = TYPES[2];
			}
		}
	}

	public int equalsArea(Rectangle r) {
		if (getArea() == r.getArea()) return 0; //returns 0 if both objects are equal
		else if (getArea() > r.getArea()) return 1; //returns 1 if first object is greater

		return -1; //returns -1 if second object is greater
	}
	
	public int equalsPerimeter(Rectangle r) {
		if (getPerimeter() == r.getPerimeter()) return 0; //returns 0 if both objects are equal
		else if (getPerimeter() > r.getPerimeter()) return 1; //returns 1 if first object is greater

		return -1; //returns -1 if second object is greater
	}

	@Override
	public String getType() {
		return type;
	}
	
	@Override
	public String toString() {
		//TODO
		String info = "";
		
		info += "\ntype = " + type;

        info += "\nl = " + length;

        info += "\nw = " + width;

        info += "\nA = " + getArea();

        info += "\nP = " + getPerimeter();
        
        info += "\nvertices = " + Arrays.toString(vertices);

        return info;
	}
}//End of class
