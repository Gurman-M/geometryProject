package geometry_improvement;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
	ArrayList <Polygon> list = new ArrayList<Polygon>(); //list that stores polygons
	int triangleCounter = 0;
	int rectangleCounter = 0;
	double totalTriangleArea = 0;
	double totalRectangleArea = 0;
	
	try {
		Triangle t = new Triangle(new Point(2.0, 5.0), 14, 5);
		Triangle t2 = new Triangle(new Point(0, 0), 2, 5); //initializing triangles
		Rectangle r = new Rectangle(new Point(0, 0), 3.0, 5.0);
		Rectangle r2 = new Rectangle(new Point(2, 3), 2, 10); //initializing rectangles
		
		list.add(t);
		list.add(t2);
		list.add(r);
		list.add(r2);
		
		for (Polygon p: list) { 
		 if (p instanceof Triangle) { //checking if object belongs to Triangle class
			 triangleCounter++;
			 totalTriangleArea += ((Triangle) p).getArea(); //downcasting to Triangle 
		 } else if (p instanceof Rectangle) { //checking if object belongs to Rectangle class
			 rectangleCounter++;
			 totalRectangleArea += ((Rectangle) p).getArea(); 
			 //downcasting to Rectangle - can now gain access to Rectangle's specialized methods
		 }
	 }
		
		System.out.println("\ntriangles = " + triangleCounter);
		System.out.println("\ntotal triangle area = " + totalTriangleArea);
		
		System.out.println("\nrectangles = " + rectangleCounter);
		System.out.println("\ntotal rectangle area = " + totalRectangleArea);
	 
	 } catch (Exception e) {
		System.out.println(e.getMessage()); //will print the message for the exception caught
	 }
	 
	
	}
}//End of class

