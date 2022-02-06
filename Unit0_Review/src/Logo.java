import java.util.Scanner;

public class Logo {
	
	static int[][] turtleArray=new int[20][20];
	static Turtle turtle=new Turtle(0,0);

	//Main method
	public static void main(String[] args) {
		
		//Variables
		String command=" ";
		boolean isPenDown=false;
		int direction = 2;
		
		Scanner input=new Scanner(System.in);
		
		//Setup turtle array
		setupTurtleArray();
		
		do {
			//Input command from user
			command=input.next();
			
			//Process the command based on table info
			if(command.equals("2"))
				isPenDown=true;
			
			else if (command.equals("3"))
				isPenDown=false;
			
			else if (command.contains("5,")) {
				command=command.substring(2);
				

				//Move the turtle based on the direction
				moveTurtle(command,direction,isPenDown);
				
				
			}
			
			else if(command.equals("3")) { 
				
				if(direction==4)
					direction=1;
				else
					direction+=1;
			}
			
			else if (command.equals("4")) { 
				
				if(direction==0)
					direction=4;
				else
					direction-=1;
			}
			
			else if (command.equals("6")) 
				displayTheGrid();
			
			
			else if (command.equals("9"))
				break;

		}
		while(true);

	}


	private static void displayTheGrid() {
		
		for(int row=0;row<turtleArray.length;row++) {
			
			for(int col=0;col<turtleArray[row].length;col++) {
				
				if(turtleArray[row][col]==0)
					System.out.print(" ");
				
				else if(turtleArray[row][col]==1)
					System.out.print("*");
			}
			System.out.println();
			
		}
		
	}

	private static void moveTurtle(String command, int direction, boolean isPenDown) {
		int numOfSpaces = Integer.valueOf(command);
	
		//Move up
		if(direction==1) {
			
			//Draw out if the pen is down
			if(isPenDown) {
				int counter=0;
				while(counter<numOfSpaces) {
					turtleArray[turtle.getRow()-counter][turtle.getCol()]=1;
					counter++;
				}
			}
			turtle.setRow(turtle.getRow()-numOfSpaces);
			
		}
		
		//Move right
		else if(direction==2) {
			
			//Draw out if the pen is down
			if(isPenDown) {
				int counter=0;
				while(counter<numOfSpaces) {
					turtleArray[turtle.getRow()][turtle.getCol()+counter]=1;
					counter++;
				}
			}
	
			turtle.setCol(turtle.getCol()+numOfSpaces);
			
		}
		
		//Move down
		else if(direction==3) {
			
			//Draw out if the pen is down
			if(isPenDown) {
				int counter=0;
				
				while(counter<numOfSpaces) {
					turtleArray[turtle.getRow()+counter][turtle.getCol()]=1;
					counter++;
				}
			}
			
			turtle.setRow(turtle.getRow()+numOfSpaces);
			
		}
		
		//Move left
		else if(direction==4) {
			
			//Draw out if the pen is down
			if(isPenDown) {
				int counter=0;
				while(counter<numOfSpaces) {
					turtleArray[turtle.getRow()][turtle.getCol()-counter]=1;
					counter++;
				}
			}
			turtle.setCol(turtle.getCol()-numOfSpaces);
			
		}
		
	}

	private static void setupTurtleArray() {
		for(int row=0;row<turtleArray.length;row++) {
			
			for(int col=0;col<turtleArray[row].length;col++)
				
				turtleArray[row][col]=0;
			
		}
		
	}

}


class Turtle{
	
	private int row;
	private int col;
	
	public Turtle(int row, int col) {
		this.row=row;
		this.col=col;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}
	
	
}
