
public class PrimeSieve {

	public static void main(String[] args) {
		System.out.println("Hello world");
		//Variables
		boolean numbersArray[]= new boolean[1004];
		
		//Initializing each value to true
		for(int i=2;i<numbersArray.length;i++) {
			numbersArray[i]=true;
		}
		
		//Outer for loop
		for(int number=2;number<1000;number++) {
			
			if(numbersArray[number]) {
				
				//Inner for loop
				for(int multiple=2;number*multiple<1000;multiple++) {
					numbersArray[number*multiple]=false;
				}
			}
		}
		
		int counter=0;
		for(int number=2;number<1000;number++) {
			
			if(numbersArray[number]) {
				System.out.println(number);
				counter++;
			}
			
		}
		
		System.out.println("Num of counters: "+counter);
		
	}

}
