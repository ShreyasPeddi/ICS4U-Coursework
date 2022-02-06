package partA;

public class TestHugeInteger {

	public static void main(String[] args) {
		
		int []arr = new int[]{1,2,3,4};
		int []arr2 = new int[]{1,2,3,4,5};
		
		HugeInteger num1 = new HugeInteger(arr);
		HugeInteger num2 = new HugeInteger(arr2);
		
		System.out.println(num1.isLessThan(num2));
		System.out.println(num1.isGreaterThan(num2));
		System.out.println(num1.isEqualTo(num2));
	}

}
