package partA;

import java.util.Arrays;

public class HugeInteger {
	
	private int hugeNumArray[];

	public HugeInteger(int[] hugeNumArray) {
		this.hugeNumArray = hugeNumArray;
	}

	public int[] getHugeNumArray() {
		return hugeNumArray;
	}

	public void setHugeNumArray(int[] hugeNumArray) {
		this.hugeNumArray = hugeNumArray;
	}

	@Override
	public String toString() {
		return "HugeInteger [hugeNumArray=" + Arrays.toString(hugeNumArray) + "]";
	}
	
	
	//Displays the huge integer
	public String display() {
		String num="";
		
		for(int i=0;i<hugeNumArray.length;i++) 
			num=num+hugeNumArray[i];
		
		return num;
		
	}
	
	//Returns true if the huge integers are equal
	public boolean isEqualTo(HugeInteger num2) {
		
		if(num2.hugeNumArray.length!=this.hugeNumArray.length)
			return false;
			
		for(int i=0;i<hugeNumArray.length;i++) {
			
			if(num2.hugeNumArray[i]!=this.hugeNumArray[i])
				return false;
		}
		
		return true;
		
	}
	
	//Returns true if the current number is greater than the number in the argument
	public boolean isGreaterThan(HugeInteger num2) {
		
		if(this.hugeNumArray.length>num2.hugeNumArray.length)
			return true;
		
		else if(this.hugeNumArray.length<num2.hugeNumArray.length)
			return false;
		
		else {
			
			for(int i=0;i<hugeNumArray.length;i++) {
				
				if(num2.hugeNumArray[i]>this.hugeNumArray[i])
					return false;
				
				else if(num2.hugeNumArray[i]<this.hugeNumArray[i])
					return true;
			}
			
			return false;
		}
		
	}
	
	
	
	public boolean isLessThan(HugeInteger num2) {
		
		if(this.hugeNumArray.length<num2.hugeNumArray.length)
			return true;
		
		else if(this.hugeNumArray.length<num2.hugeNumArray.length)
			return false;
		
		else {
			
			for(int i=0;i<hugeNumArray.length;i++) {
				
				if(num2.hugeNumArray[i]<this.hugeNumArray[i])
					return false;
				
				else if(num2.hugeNumArray[i]<this.hugeNumArray[i])
					return true;
			}
			
			return false;
		}
		
	}
}
