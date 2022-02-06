public class TortiseHareRace {
	
	static String [] raceTrack = new String[71];

	public static void main(String[] args) throws InterruptedException{
		
		//Variables
		int tortPos=0;
		int harePos=0;
		int i=0;
		int raceTime=0;
		
		
		//Get the raceTrack setup
		setupRaceTrack();
		
		//Start the race
		do{
			raceTrack[tortPos]="-";
			raceTrack[harePos]="-";
			//Generate a random number to move the tort
			i=(int) ((Math.random()*10) +1);
			
			if(i<=5)
				tortPos+=3;
				
			
			else if (i<=7)
				tortPos-=1;
				
			else
				tortPos+=1;
			
			//Generate a random number to move the hare
			i=(int) ((Math.random()*10) +1);
			
			if(i<=2)
				harePos+=0;
				
			else if (i<=4)
				harePos+=9;
			
			else if(i<=5)
				harePos-=12;
			
			else if (i<=8)
				harePos+=1;
			
			else
				harePos-=2;
			
			//If an animal slips left before square 1, move it back to square 1
			if(tortPos<0)
				tortPos=0;
			if(harePos<0)
				harePos=0;
			
			raceTrack[harePos]="H";
			raceTrack[tortPos]="T";
			
			System.out.print("START\t");
			//Display the current standings
			for(String square:raceTrack) {
				System.out.print(square);
			}
			System.out.print("\tEND");
			
			System.out.printf("\tAfter %d minutes",raceTime++);
			System.out.println();
			Thread.sleep(3000);
			
			
			
		}
		while(tortPos<70 && harePos<70);

	}

	private static void setupRaceTrack() {
		int counter=0;
		
		for(String position:raceTrack){
			raceTrack[counter]= "-";
			counter++;
		}
		
	}

}


