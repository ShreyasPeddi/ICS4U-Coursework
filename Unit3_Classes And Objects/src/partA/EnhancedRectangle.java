package partA;

import java.util.Arrays;

public class EnhancedRectangle {
	
	//fields
	private Point[] pointArray = new Point[4];
	private double length;
	private double width;

	
	public EnhancedRectangle(Point[] pointArray) {
		setPointArray(pointArray);
		setLengthAndWidth();
	}

	public double getLength() {
		return length;
	}
	
	public double getWidth() {
		return width;
	}
	
	//Sets the length and width based on distance
	private void setLengthAndWidth() {
		
		//Calculate possible length and width
		double distance1= pointArray[0].distanceTo(pointArray[1]);
		double distance2 = pointArray[1].distanceTo(pointArray[2]);
			
		//Larger distance is the length
		if(distance1>distance2) {
				this.length=distance1;
				this.width=distance2;
			}
			
		else {
				this.length=distance2;
				this.width=distance1;
			}
	}
	
	public Point[] getPointArray() {
		return pointArray;
	}

	public void setPointArray(Point[] pointArray) {
		
		//Check if the points are in Q1
		for(Point p: pointArray) 
			
			if(p.getX()<0 || p.getX()>20 || p.getY()<0 || p.getY()>20) {
				
				//If the coordinates are not in given range, display a message
					System.out.println("Coordinates specified not in the given range");
					return;
			}
			
		
		
		//Check if it is a rectangle - Diagonals are equal in a rectangle
		if(pointArray[0].distanceTo(pointArray[2]) == pointArray[1].distanceTo(pointArray[3]))
		
			this.pointArray=pointArray;
		
		else
			System.out.println("Not a rectangle");
	
	}
	
	//ToString method
	@Override
	public String toString() {
		return "EnhancedRectangle [pointArray=" + Arrays.toString(pointArray) + ", length=" + length + ", width="
				+ width + "]";
	}
	
	//Utility methods
	
	public void display() {
		for(Point p: pointArray) {
			System.out.println(p);
		}
	}
	
	public double area() {
		return length*width;
	}
	
	public double perimeter() {
		return 2*(length+width);
	}
	
	public boolean isSquare() {
		return length==width;
	}
	
	
	
}
