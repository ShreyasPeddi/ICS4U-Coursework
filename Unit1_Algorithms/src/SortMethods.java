import java.util.List;
import java.util.ArrayList;import java.util.Arrays;

public class SortMethods {

	public static void shellSort(int[]data) {
		
		//Establish a gap by dividing the length by 2
		int gap = (data.length-1)/2;
		boolean swap=false;
		
		//Keep sorting until there is no gap
		while(gap>0) {
			
			//1.)Place a pointer at index 0 and another one at "gap" indices away
			for(int index=0;index<data.length-gap;index++) {
				
				swap=false;
				
				//2.)If the number on the left is bigger, swap
				if(data[index]>data[index+gap]) {
					
					swap(data,index,index+gap);
					swap=true;
				}
			}
			//3.)Repeat steps 1 and 2 until no swaps happen. Then, decrease the gap by dividing by 2 and repeat the same steps
			if(!swap)
				gap=gap/2;
		}
	}
	
	public static void quickSort(int[] data, int start, int end) {

		//Establish two pointers - left pointer and right pointer
		int leftPointer=start;
		int rightPointer=end;
		
		//As long as the left pointer doesn't equal right pointer, keep doing the following to find the pivot index
		while(leftPointer!=rightPointer) {
			
			//Compare the value on the right to the value on the left, THE IDEA IS TO HAVE BIGGER VALUES ON THE RIGHT
			while(data[rightPointer]>data[leftPointer])
				
				//Decrement the right pointer and check the next element
				rightPointer--;
			
			//If the left value is greater,
			if(leftPointer!=rightPointer) {
				
				//Swap the elements
				swap(data,leftPointer,rightPointer);
				
				//Increment the index to check the next value
				leftPointer++;
				
				//Keep checking if left values are less than right values
				while(data[leftPointer]<data[rightPointer])
					leftPointer++;
				
				//If not, then swap the elements and now start checking from the right side
				if(leftPointer!=rightPointer) {
					swap(data,leftPointer,rightPointer);
					rightPointer--;
				}
				
			}
			
		}
		
		//Quick Sort (establishing a pivot) on the values on left side of the current pivot 
		if(leftPointer>start)
			quickSort(data,start,leftPointer-1);
		
		//Quick Sort (establishing a pivot) on the values on right side of the current pivot 
		if(rightPointer<end)
			quickSort(data,rightPointer+1,end);
		
	}
	
	public static void mergeSort(int[] data, int start, int end) {
		
//		Divide the array by halves until there is one element
		if((end-start)>=1) {
			
			int middle= (start+end)/2;
			
			//Merge Sort the first half
			mergeSort(data, start, middle);
			
			//Merge Sort the second half
			mergeSort(data,middle+1,end);
			
//			Repeatedly merge sublists to produce a sorted list
			merge(data, start, end);
		}
		
	}
	
	//This helper method merges adjacent sub lists given the starting index of the 1st sublist and the ending index of 2nd sublist
	private static void merge(int[]data, int start, int end) {
		
		//Temporary array to store the sorted numbers
		int mergedArray[]=new int[end-start+1];
		
		//Pointer to place numbers in the merged array
		int mergeIndex=0;
		
		//Reference point for sub array bounds
		int middle=(start+end)/2;
		
		//Starting Pointer on the left sub array
		int leftIndex=start;
		
		//Starting Pointer on the right sub array
		int rightIndex=middle+1;
		
//		Compare each index of the subarray 
		while(leftIndex<=middle && rightIndex<=end) {
			
//			Place the smaller value into the merged sublist.
			if(data[leftIndex]<data[rightIndex]) {
				mergedArray[mergeIndex]=data[leftIndex];
				//Increment the index of the group that had the smaller value.
				leftIndex++;
			}
			
			else {
				mergedArray[mergeIndex]=data[rightIndex];
				//Increment the index of the group that had the smaller value.
				rightIndex++;
			}
			
			//Increment the merge index to keep track of the merged array
			mergeIndex++;
			
		}
		
		//If the left sub array reached its bounds, then place all the elements remaining on the rightIndex into the merged Array
		if(leftIndex>middle) {
			
			//Keep pulling out values until pointer points to the end of the right sub array
			while(rightIndex<=end) {
				
				//Pull out values and increment respectives pointers
				mergedArray[mergeIndex]=data[rightIndex];
				mergeIndex++;
				rightIndex++;
			}
		}
			
		//If the right sub array reached its bounds, then place all the elements remaining on the left sub array into the merged Array
			else {
				
				//Keep pulling out values until pointer points to the end of the left sub array
				while(leftIndex<=middle) {
					
					//Pull out values and increment respectives pointers
					mergedArray[mergeIndex]=data[leftIndex];
					mergeIndex++;
					leftIndex++;
				}
			}
		
		//Update the original unsorted array with the merged sorted array by taking out each value from
		//merged array and placing it in the original array
		for(int i=0;i<mergedArray.length;i++) {
			data[i+start] = mergedArray[i];
		}

			
	}
	
	public static void radixSort(int[] data) {
		int range = findLargest(data);
		
		//Calculate the most significant digit using log function
		int msd = (int) Math.log10(range)+1;
		
		//Array of arraylists which keeps track of each digit numbers. Digit represents the index
		ArrayList<Integer> digit[] = new ArrayList[10];
		
		//Initialize each element of the array
		for(int i=0;i<digit.length;i++)
			digit[i]=new ArrayList<Integer>();
		
		//Outer loop: Iterates for each digit until the most significant digit
		for(int x=0; x<msd;x++) {
			
			//Calculate which index to place the element in - depends on the number (ex. 327 would be placed in index 3 when comparing the hundreth place value 
			for(int y=0;y<data.length;y++) 
				digit[(int)(data[y]/Math.pow(10,x) %10)].add(data[y]);
			
			//Transfer back the "digit" sorted list into the original array
			int index=0;
			for(int y=0;y<10;y++) {
				
				//As long as there are numbers with that digit
				while(!digit[y].isEmpty())
				data[index++]=digit[y].remove(0);
			}
		}
		
		
	}
	public static void countingSort(int[] data) {
		
		//Find the largest value in the data set
		int largest=findLargest(data);
		
		//Create a tally array to keep tally of each number
		int [] tallyArray=new int[largest+1];
		
		//Keep a tally of each number (how many times a number has occured)
		for(int index=0;index<tallyArray.length;index++) {
			tallyArray[data[index]]++;
		}

		//Update the original array with the tallied values
		int arrIndex=0;
		for(int index=0;index<data.length;index++) {
			
			for(int i=1;i<=tallyArray[index];i++) {
				data[arrIndex++]=index;
			}
		}
		
	}
	
	public static void bucketSort(int [] data) {
		int largest=findLargest(data);
		
		//Square root the largest to find the range
		int range = (int) Math.round(Math.pow(largest, 0.5));
		
		//Create an array of array lists with 'range' number of groups (equally divided)
		ArrayList<Integer>[] buckets = new ArrayList[range+1];
		
		//Initialize the arraylist
		for (int index = 0; index < buckets.length; index++) {
            buckets[index] = new ArrayList<Integer>();
        }
		
		//'Put' the element in the correct bucket
		for(int i=0;i<data.length;i++) 
			buckets[(int)(data[i]/range)].add(data[i]);
		
		int arrIndex=0;
		
		//Sort each bucket using insertion sort
		for(int outerIndex=0;outerIndex<=range;outerIndex++) {
			
			//Convert arraylist to array
			int[]tempBucket= buckets[outerIndex].stream().mapToInt(i -> i).toArray();
			
			//Sort each sub array
			insertionSort(tempBucket);
			
			//Place back the elements in the bucket into the dataset
			for(int innerIndex=0;innerIndex<tempBucket.length;innerIndex++) {
				data[arrIndex++]=tempBucket[innerIndex];
			}
		}
		
	}
	
	public static void bubbleSort(int[]data) {
		boolean swap=false;
		
		for(int pass=1;pass<data.length;pass++) {
			
			//Iterate through the array each round to swap adjacent elements
			for(int index=0;index<data.length-pass;index++) {
				
				//Compare adjacent elements
				if(data[index]>data[index+1]) {
					
					//If the adjacent element is larger, swap the elements
					swap(data,index,index+1);
					swap=true;
				}
			}
			
			if(!swap)
				break;
		}
	}
	
	public static void selectionSort(int[]data) {
		
		int minimum;
		for(int i=0;i<data.length;i++) {
			
			minimum=i;
			for(int index=i;index<data.length;index++) {
				if(data[index]<data[minimum])
					minimum=index;
			}
			
			swap(data,minimum,i);
		}
	}
	
	//My version
	public static void insertionSorter(int[]data) {
		
		//Outer for loop iterates through the array
		for(int i=1;i<data.length;i++) {
				
				for(int j=i;j>0;j--) 
					
					if(data[j]<data[j-1]) {
						swap(data,j,j-1);
			}
		}
		
		
	}
	
	//Teacher's version
	public static void insertionSort(int[]data) {
		
		for(int x=1;x<data.length;x++) {
			
			for(int y=x-1;y>=0;y--) {
				
				if(data[x]<data[y]) {
					swap(data,x--,y);
				}
				else
					break;
			}
		}
	}
	
	
	//This method swaps elements in the array given the indices
	private static void swap(int[]data, int index1,int index2) {
		int temp = data[index1];
		data[index1]=data[index2];
		data[index2]=temp;
	}
	
	
	private static int findLargest(int[] data) {
		//Find the largest number in the array
		int largest=0;
		for(int i=0;i<data.length;i++) {
			if(data[i]>largest)
				largest=data[i];
		}
		return largest;
	}
}
