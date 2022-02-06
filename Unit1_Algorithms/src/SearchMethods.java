import java.util.Arrays;

public class SearchMethods {
	
	public static int binarySearch(int [] arr, int n)  {

		//Variables
		int high=arr.length-1;
		int low=0;
		int mid=0;
		
		do{
			//find the mid value
			mid=(high+low)/2;
			
			if(n==arr[mid]) 
				return mid;
			
			else if(n<arr[mid])
				high=mid-1;
				
			else if (n>arr[mid]) 
				low=mid+1;
			
		} while(low<=high);
	
		//Return -1 if no value is found
		return -1;
	}
	
	
	public static int binarySearchR(int [] arr, int n)  {
		int low=0;
		int high=arr.length-1;
		int mid=(high+low)/2;
		
		if(arr[mid]==n)
			return mid;
		
		else if(n>arr[mid])
			return mid+binarySearch(Arrays.copyOfRange(arr, mid, high+1),n);
		
		else if(n<arr[mid])
			return binarySearch(Arrays.copyOfRange(arr,low,mid+1),n);
		
		return -1;
	}
	
	public static int exponentialSearch(int []arr, int targetNum) {
		//1. Check if the first element is the target number. If so, return that
		//2. Keep incrementing i in powers of 2 as long as i is less than the target number and the length of the array
		//3. If i is greater, then binary search on i/2 to i
		
		if(arr[0]==targetNum)
			return 0;
		
		else {
			int i=1;
			while(i<targetNum && i<arr.length) 
				i*=2;
			
			return (i/2)+binarySearch(Arrays.copyOfRange(arr,i/2, Math.min(i, arr.length)+1),targetNum);
			
		}
	}

}
