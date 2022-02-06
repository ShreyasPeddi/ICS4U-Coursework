package partA;

public class Rectangle {

	//attributes
	private double length;
	private double width;
	
	//Constructor method
	public Rectangle(double length, double width) {
		super();
		setLength(length);
		setWidth(width);
	}
	
	//getters(accessors) and setters (mutators)
	public double getLength() {
		return length;
	}
	
	public void setLength(double length) {
		this.length=((length>0 && length<20) ? length:1);
	}	
	
	public double getWidth() {
		return width;
	}
	
	public void setWidth(double width) {
		this.width = ((width>0 && width<20) ? width:1);
	}

	//toString method to display the rectangle's properties
	@Override
	public String toString() {
		return "Rectangle [length=" + length + ", width=" + width + "]";
	}	
	
	//Utility Methods
	
	//This method returns the area of the rectangle
	public double area() {
		return this.length * this.width;
	}
	
	//This method returns the perimeter of the rectangle
	public double perimeter(){
		return 2*(this.length+this.width);
	}
	
}
