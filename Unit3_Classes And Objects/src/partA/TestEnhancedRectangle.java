package partA;

public class TestEnhancedRectangle {

	public static void main(String[] args) {
		
		//points are listed clockwise from the top left corner
		Point[] pArray= {new Point(0,0), new Point(0,5), new Point(7,5), new Point(7,0)};
		
		EnhancedRectangle eR1 =  new EnhancedRectangle(pArray);
		eR1.display();
		
		System.out.println(eR1.isSquare());
		System.out.println(eR1.area()+" units squared");
		System.out.println(eR1.perimeter()+" units");
		
//		Point [] p2Array = {new Point(-6,3), new Point(0,6), new Point(2,2), new Point(-4,-1)};
//		EnhancedRectangle eR2 = new EnhancedRectangle(p2Array);
//		eR2.display();
	}
}

