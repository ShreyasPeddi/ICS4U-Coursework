package partA;

//This class represents a point given a ordered pair
public class Point {

	//Fields
	private double x;
	private double y;
	
	//Constructor method
	public Point(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	//Getters and Setters
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
	
	public double distanceTo(Point p) {
		return Math.sqrt(Math.pow(this.x-p.x,2) + Math.pow(this.y-p.y,2));
	}
	
	
}
