package geometry_improvement;

import java.text.DecimalFormat;

public class Circle implements Shape{
	public double radius;
	private Point[] vertices;
	private String type;
	private static final String[] TYPES = {"TRIANGLE","RECTANGLE","CIRCLE"};
	DecimalFormat df; //used to trim the decimal to 3 digits
	
	Circle (double radius) throws negativeNumException{
		if (radius <= 0) throw new negativeNumException("You cannot enter in a negative or zero measurement!");
		
		this.radius = radius;
		getArea(radius);
		getPerimeter(radius);
		setVertices(null); //no vertices in a circle
	}
	
	public double getArea(double radius) {
		double area = Math.PI * (Math.pow(radius, 2)); //uses formula pi * r^2 to find area
		df = new DecimalFormat("#.###"); //formatting decimals
		String temp = df.format(area);
		
		return Double.parseDouble(temp);
	}

	public double getPerimeter(double radius) {
		double perimeter = 2 * Math.PI * radius; //uses formula 2 * pi * r 
		df = new DecimalFormat("#.###"); //formatting decimals
		String temp = df.format(perimeter);
		
		return Double.parseDouble(temp);
	}
	
	public void setVertices(Point[] vertices) {
		this.vertices = vertices;
		if (this.vertices == null) {
			type = TYPES[2]; //will be set to circle type
		} else if (vertices.length < 3) {
			this.type = TYPES[2];
		} else {
			switch (vertices.length) {
			case 3: type = TYPES[0]; break;
			case 4: type = TYPES[1]; break;
			default: type = TYPES[2]; //defaulted as circle type
			}
		}
}
	
	public String toString() {
		String info = "";
		
		info += "\ntype = " + type;
		
		info += "\nRadius = " + radius;
		
		info += "\nA = " + getArea(radius);
		
		info += "\nP = " + getPerimeter(radius);
		
		return info;
	}
}//End of class
