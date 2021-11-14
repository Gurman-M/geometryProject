package geometry_improvement;

public class TestRectangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		Rectangle r = new Rectangle(new Point(0, 0), 2, 10);
		r.setPoint(new Point(1, 5));
		Rectangle r2 = new Rectangle(new Point(6, 6), 5, 4);
		//Rectangle r3 = new Rectangle(new Point(0, 5), new Point(2, 0), new Point(0, 34), new Point(0, 5));
		//r.setPoint(new Point(0, -5));
		System.out.println(r.equalsArea(r2));
		System.out.println(r.equalsPerimeter(r2));
		System.out.println(r);
		System.out.println(r2);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}//End of class
