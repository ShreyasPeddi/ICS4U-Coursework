package partA;

public class Complex {

	private double realPart;
	private double imaginaryPart;
	
	//no-argument methods
	public Complex() {
		super();
	}

	public Complex(double realPart, double imaginaryPart) {
		super();
		this.realPart = realPart;
		this.imaginaryPart = imaginaryPart;
	}

	public double getRealPart() {
		return realPart;
	}

	public void setRealPart(double realPart) {
		this.realPart = realPart;
	}

	public double getImaginaryPart() {
		return imaginaryPart;
	}

	public void setImaginaryPart(double imaginaryPart) {
		this.imaginaryPart = imaginaryPart;
	}

	@Override
	public String toString() {
		return "Complex [realPart=" + realPart + ", imaginaryPart=" + imaginaryPart + "]";
	}


	//Utility/ Helper methods

	//This method adds a complex number to the current complex number and returns a new complex number
	public Complex add(Complex c2) {
		
		return new Complex(this.realPart+c2.realPart, this.imaginaryPart+c2.imaginaryPart);
	}
	
	//This method subtracts a complex number from the current complex number and returns a new complex number
	public Complex subtract(Complex c2) {
		
		return new Complex(this.realPart-c2.realPart, this.imaginaryPart-c2.imaginaryPart);
	}
	
	//This method returns a custom version String of a complex number
	public String printNum() {
		
		return String.format("(%.0f,%.0f)",realPart, imaginaryPart);
	}
	
}
