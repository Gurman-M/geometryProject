package geometry_improvement;

public class Point {
	private double x;
	private double y;
	/**
	 * @param x
	 * @param y
	 */
	public Point(double x, double y) throws negativeNumException{
		super();
		if (x < 0 || y < 0) throw new negativeNumException("You cannot enter in a negative or zero measurement!");
		else {
		this.x = x;
		this.y = y;
		}
	}
	/**
	 * @return the x
	 */
	public double getX() {
		return x;
	}
	/**
	 * @param x the x to set
	 */
	public void setX(double x) throws negativeNumException{
		if (x < 0) throw new negativeNumException("You cannot enter in a negative or zero measurement!");
		else {
		this.x = x;
		}
	}
	/**
	 * @return the y
	 */
	public double getY() {
		return y;
	}
	/**
	 * @param y the y to set
	 */
	public void setY(double y) throws negativeNumException{
		if (y < 0) throw new negativeNumException("You cannot enter in a negative or zero measurement!");
		else {
		this.y = y;
		}
	}
	@Override
	public String toString() {
        return "(" + x + "," + y + ")";
	}
	
}//End of class
