import java.util.Arrays;
import java.util.Scanner;

public class SearchSortApp {

	public static void main(String[]args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter size of array: ");
		int size = input.nextInt();
		
		
		int[][] dataSet = new int[4][size];
		
		
		//Sorted array
		for(int i=0;i<size;i++) {
			dataSet[0][i]=i+1;
		}
		
		//Random array
		for(int i=0;i<size;i++) {
			dataSet[1][i]= (int) (Math.random()*size);
		}
		
		//90% sorted array
		for(int i=0;i<size;i++) {
			dataSet[2][i]=i+1;
		}
		
		//90% sorted array
		for(int i=0;i<size/10;i++) {
			dataSet[2][(int) (Math.random()*size)]= (int) (Math.random()*size);
		}
		
		//descending order
		for(int i=1;i<size;i++) {
			dataSet[3][size-1] = size-1;
		}
		
		System.out.println("Select 1)Search or 2) Sort:");
		int type=input.nextInt();
		
		if(type==1) {
			System.out.println("What number are you looking for?");
			int n = input.nextInt();
			
			System.out.print("Enter 1)Linear Search, 2)Binary Search, 3) Exponential Search: ");
			int choice=input.nextInt();
			
			if(choice==2) {
				SearchMethods.binarySearch(dataSet[0],n);
			}
			
			else if(choice==3) {
				SearchMethods.exponentialSearch(dataSet[0], n);
			}
		
		}
		
		else {
			System.out.println("Enter 1)Bubble sort 2)Selection Sort 3) Insertion Sort "
					+ "4)Bucket Sort 5)Counting Sort 6)Radix Sort 7)Shell Sort "
					+ "8)Quick Sort 9)Merge Sort");
			int choice = input.nextInt();
			
			if(choice==1)
				SortMethods.bubbleSort(dataSet[1]);
			
			else if(choice==2)
				SortMethods.selectionSort(dataSet[1]);
			
			else if(choice==3)
				SortMethods.insertionSorter(dataSet[1]);
			
			else if(choice==4)
				SortMethods.bucketSort(dataSet[1]);
			
			else if (choice==5)
				SortMethods.countingSort(dataSet[1]);
			
			else if(choice==6)
				SortMethods.radixSort(dataSet[1]);
			
			else if(choice==7)
				SortMethods.shellSort(dataSet[1]);
			
			else if(choice==8) {
				SortMethods.quickSort(dataSet[1], 0 ,dataSet[1].length-1);
			}
			
			else  if(choice==9)
				SortMethods.mergeSort(dataSet[1], 0, dataSet[1].length-1);
			System.out.println(Arrays.toString(dataSet[1]));
		}
	}

}
