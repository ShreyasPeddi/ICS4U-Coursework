package model;

import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

//Model class
public class BingoCard {
	
	//Fields
	
	//Stores the actual random numbers
	private int grid[][] = new int[5][5];
	
	public BingoCard() {
		
		createCard();
	}

	public int[][] getGrid() {
		return grid;
	}

	public void setGrid(int[][] grid) {
		this.grid = grid;
	}

	@Override
	public String toString() {
		return "BingoCard [grid=" + Arrays.toString(grid) + "]";
	}
	
	
	//Creates random numbers and places them in the grid
	public void createCard() {
		
		for(int i=0;i<grid.length;i++) {
			
			//Stack data structure to not include a random number which has already been included
			Stack<Integer> nums = new Stack<Integer>();
			//Create a stack of random numbers by shuffling the list
			for(int num=1;num<=15;num++) {
				nums.add(num+(15*i));
			}
			
			Collections.shuffle(nums);
			
			for(int j=0;j<grid[i].length;j++) {
				
				if(i==2 && j==2)
					grid[i][j]=0;
				
				grid[i][j]=nums.pop();
			}
			
			
			
		}
		
		System.out.println(Arrays.deepToString(grid));
	}
	public boolean checkForBingo() {

		int count=0;
		//Check if each row is a bingo
		for(int row=0;row<5;row++) {
			
			for(int col=0;col<5;col++) {
				
				if(grid[row][col]==0) 
					count++;
					
			}
			if(count==5)
				return true;
			
			else
				count=0;
			
		}
		
		
		//Check if each column is a bingo
		for(int col=0;col<5;col++) {
			
			for(int row=0;row<5;row++) {
				
				if(grid[row][col]==0) 
					count++;
					
			}
			if(count==5)
				return true;
			
			else
				count=0;
			
		}
		
		//Check if diagonal is a bingo
		if((grid[0][0]==0 && grid[1][1]==0 && grid[3][3]==0 && grid[4][4]==0) ||
				(grid[0][4]==0 && grid[1][3]==0 && grid[3][1]==0 && grid[4][0]==0))
			return true;
			
		
		
		return false;
		
	}
	
}
