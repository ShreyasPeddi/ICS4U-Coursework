package partA;

public class TestComplexNumber {

	public static void main(String[] args) {
		Complex c1= new Complex(3,-1);
		Complex c2 = new Complex(4,2);
		Complex sum = c1.add(c2);
		Complex difference = c1.subtract(c2);
		
		
		System.out.println(difference.printNum());
	}

}
