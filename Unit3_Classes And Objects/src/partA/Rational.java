package partA;

public class Rational {
	
	private int numerator;
	private int denominator;
	
	//Constructor Method
	public Rational(int numerator, int denominator) {
		int temp = Math.abs(numerator);
		for(int factor = temp;factor>1;factor--) {
			
			//Reduce to simplest form
			if(numerator%factor==0 && denominator%factor==0) {
				numerator/=factor;
				denominator/=factor;
			}
		}
		
		//Set the numerator and denominator
		setNumerator(numerator);
		setDenominator(denominator);
	}
	
	
	//Getters and Setters
	public int getNumerator() {
		return numerator;
	}
	public void setNumerator(int numerator) {
		this.numerator = numerator;
	}
	public int getDenominator() {
		return denominator;
	}
	public void setDenominator(int denominator) {
		if(denominator!=0)
			this.denominator = denominator;
	}

	@Override
	public String toString() {
		return "RationalNumbers [numerator=" + numerator + ", denominator=" + denominator + "]";
	}
	
	
	//Utility Methods
	
	//Adds two rational numbers and returns the sum
	public Rational add(Rational num2) {
		
		int nSum = (this.numerator*num2.denominator) + (num2.numerator*this.denominator);
		int dSum = this.denominator*num2.denominator;
		return new Rational(nSum,dSum);
		
	}
	
	//Subtracts two rational numbers and returns the difference
		public Rational subtract(Rational num2) {
			
			int nDif = (this.numerator*num2.denominator) - (num2.numerator*this.denominator);
			int dDif = this.denominator*num2.denominator;
			return new Rational(nDif,dDif);
			
		}
		
	//Multiples two rational numbers and returns the product
		public Rational multiply(Rational num2) {
			
			int nPro = this.numerator*num2.numerator;
			int dPro = this.denominator*num2.denominator;
			return new Rational(nPro,dPro);
					
		}
		
	//Divides two rational numbers and returns the quotient
		public Rational divide(Rational num2) {
			
			int nPro = this.numerator*num2.denominator;
			int dPro = this.denominator*num2.numerator;
			return new Rational(nPro,dPro);
							
		}
	
	//Prints the current rational number
	public void print() {
		System.out.println(numerator+"/"+denominator);
	}
	
	//Print Rational numbers in floating-point format
	public String printInDecimal(int digits) {
		double num = (double)numerator/denominator;
		
		return String.format("%."+digits+"f", num);
	}
	
	
}
