package geometry_improvement;

public class TestTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		Polygon t = new Triangle(new Point(-1, 0), -5, 2);
		//System.out.println(t);
		((Triangle) t).setPoint(new Point(1, 5)); //downcasting
		Triangle t2 = new Triangle(new Point(2, 4), new Point(4, 6), new Point(6, 8));
		//A (2, 4), B (4, 6) and C (6, 8) are colinear points
		//System.out.println(t2);
		System.out.println(t);
		
		System.out.println("TYPE: " + t.getType()); 
		//will call the implementation of the method in the subclass
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}//End of class
