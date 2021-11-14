package geometry_improvement;

import java.text.DecimalFormat;
import java.util.*;

public class Triangle extends Polygon{
	private double base;
	private double height;
	private String type;
	private Point[] vertices;
	private static final String[] TYPES = {"TRIANGLE","RECTANGLE","CIRCLE"};
	DecimalFormat df; //used to trim the decimal to 3 digits
	
	
	public Triangle(Point p, double base, double height) throws negativeNumException{
		super();
		if (base <= 0 || height <= 0)  {
			throw new negativeNumException("You cannot enter in a negative or zero measurement!");
		} else {
			this.base = base;	
			this.height = height;
			setPoint(p);
		}
	}
	
	public Triangle(Point p, Point p2, Point p3) throws duplicatePointsException, colinearPointsException{ //allows the user to enter in three points
		super();
		if (duplicateCheck(p, p2) || duplicateCheck(p, p3) || duplicateCheck(p2, p3)) {
			throw new duplicatePointsException ("You have 2 or more points located at the same coordinate!");
		}  
		
		if (colinear(p, p2) == colinear(p2, p3) && colinear(p, p3) == colinear(p, p2))
			throw new colinearPointsException("Your triangle has all points on the same line!");
		
		setPoints(p, p2, p3);
	}
	
	private boolean duplicateCheck(Point p, Point p2) {
		if (p.getX() == p2.getX() && p.getY() == p2.getY()) {
			return true;
		}
		return false;
	}
	
	private double colinear(Point p, Point p2) {
		double slope = 0.0;
		slope = ((p.getY() - p2.getY())/(p.getX() - p2.getX()));
		return slope;
	}
	
	public Point[] getVertices() {
		return vertices;
	}
	
	/**
	 * @return the base
	 */
	public double getBase() {
		return base;
	}
	
	/**
	 * @param base the base to set
	 */
	public void setBase(double base) throws negativeNumException{
		if (base <= 0) {
			throw new negativeNumException("You cannot enter in a negative or zero measurement: " + base);
		} else {
			this.base = base;
		}
	}
	
	/**
	 * @return the height
	 */
	public double getHeight() {
		return height;
	}
	
	/**
	 * @param height the height to set
	 */
	public void setHeight(double height) throws negativeNumException{
		if (height <= 0) {
			throw new negativeNumException("You cannot enter in a negative or zero measurement: " + height);
		} else {
			this.height = height;
		}
	}
	
	/**
	 * @param vertices the vertices to set
	 */
	public void setVertices(Point[] vertices) {
			this.vertices = vertices;
			if (this.vertices == null) {
				type = TYPES[2];
			} else if (vertices.length < 3) {
				this.type = TYPES[2];
			} else {
				switch (vertices.length) {
				case 3: type = TYPES[0]; break;
				case 4: type = TYPES[1]; break;
				default: type = TYPES[2];
				}
			}
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	
	
	public Point getPoint() {
		return getVertices()[0];
	}
	
	public void setPoint(Point p) {
		Point points[] = new Point[3];
		points[0] = p;	
		try {
			points[1] = new Point(base + p.getX(), p.getY());
			points[2] = new Point((base/2) + p.getX(), height + p.getY());
		} catch (negativeNumException e) {
			System.out.println(e.getMessage());
		}
		setVertices(points);
		}
	
	public void setPoints(Point p, Point p2, Point p3){
		Point points[] = new Point[3];
		points[0] = p;	
		points[1] = p2;
		points[2] = p3;
		setVertices(points);
		}
	
	public double getArea() {
		return (base * height)/2;
	}
	
	public double getPerimeter() {
		Point a =  getVertices()[0]; 
		Point b = getVertices()[1];
		Point c = getVertices()[2];
		
		double totalDistance = 0.0;
		totalDistance += findDistance(a, b); 
		totalDistance += findDistance(a, c);
		totalDistance += findDistance(b, c);
		
		//total distance stores the distance between each of the points
		return totalDistance;
	}
	
	private double findDistance(Point a, Point b) { //helper method to find distance between two points
		df = new DecimalFormat("#.###"); //initialize the decimal format
		
		double distance = Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY() - b.getY(), 2); 
		distance = Math.sqrt(distance);
		String temp = df.format(distance);
		distance = Double.parseDouble(temp);
		return Math.abs(distance);
	}
	
	public int equalsArea(Triangle t) {
		if (getArea() == t.getArea()) return 0; //returns 0 if the objects are equal
		else if (getArea() > t.getArea()) return 1; //returns 1 if the first object is greater

		return -1; //returns -1 if the second object is greater
	}
	
	public int equalsPerimeter(Triangle t) {
		if (getPerimeter() == t.getPerimeter()) return 0; //returns 0 if the objects are equal
		else if (getPerimeter() > t.getPerimeter()) return 1; //returns 1 if the first object is greater

		return -1; //returns -1 if the second object is greater
	}
	
	@Override
	public String toString() {
		//TODO
		String info = "";
		
		info += "\ntype = " + type;
		
		info += "\nbase = " + base;

		info += "\nheight = " + height;

		info += "\nA = " + getArea();

		info += "\nP = " + getPerimeter();
		
		info += "\nvertices = " + Arrays.toString(getVertices());

		return info;
	}
}//End of class
