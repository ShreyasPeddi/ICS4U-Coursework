package partA;

import java.util.Arrays;

//Hold integers in the range (0-100) and is represented by an array of booleans
public class IntegerSet {
	
	//Integer set - true element exists, false - element does not exist
	private boolean setArray[] = new boolean[101];

	//Constructor  method
	public IntegerSet() {
		
		//Set default values to false since no element is added yet
		for(int i=0;i<setArray.length;i++)
			setArray[i]=false;
	}

	public boolean[] getSetArray() {
		return setArray;
	}

	//toString method
	@Override
	public String toString() {
		return "IntegerSet [setArray=" + Arrays.toString(setArray) + "]";
	}
	
	//Utility Method
	
	//creates a third set that is the set-theoretic union of two existing sets
	public IntegerSet union(IntegerSet set2) {
		
		//Create a third set to represent the union between the set1 and set2
		IntegerSet setUnion = new IntegerSet();
		
		for(int i=0;i<setArray.length;i++) {
			
			//If an element is present in an at least one of the sets
			if(setArray[i] || set2.getSetArray()[i])
				setUnion.insertElement(i);
		}
		
		return setUnion;
	}
	
	//creates a third set which is the set-theoretic intersection of two existing sets
	public IntegerSet intersection(IntegerSet set2) {
		
		//Create a third set to represent the intersection between the set1 and set2
		IntegerSet intersectionSet = new IntegerSet();
		
		for(int i=0;i<setArray.length;i++) {
			
			//If an element is present in both of the sets
			if(setArray[i] && set2.getSetArray()[i])
				intersectionSet.insertElement(i);
		}
		
		return intersectionSet;
	}
	//inserts a new integer k into a set
	public void insertElement(int index) {
		if(index>=0 && index<=100) {
//			System.out.println(index+" inserted into the set");
			setArray[index]=true;
		}
		
		else
			System.out.println("Invalid range");
	}
	
	
	//Method deleteElement deletes integer m
	public void deleteElement(int index) {
		if(index>=0 && index<=100) {
//			System.out.println(index+" deleted from the set");
			setArray[index]=false;
		}
		
		else
			System.out.println("Invalid range");
	}

	//Returns a string containing a set of list of numbers seperated by spaces. Includes elements present in the set
	public String toSetString() {
		
		String set="";
		
		//Loop through the possible range
		for(int i=0;i<setArray.length;i++) {
			if(setArray[i])
				set=set+i+" ";
		}
		
		return set;
	}
	
	//determines whether two sets are equal
	public boolean isEqualTo(IntegerSet set2) {
		
		for(int i=0;i<setArray.length;i++) {
			
			//If element at position is present in one set and not present in another, then the sets are not equal
			if(setArray[i]!=set2.getSetArray()[i])
				return false;
		}
		
		return true;
	}
	
}
