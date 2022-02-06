package partA;

public class Date {
	
	private int month;
	private int year;
	private int day;
	private String [] monthArray = new String[] {"January","Febuary","March", "April","May","June","July","August","September","October","November","December"};
	
	//Constructor method
	public Date(int month, int day, int year) {
		super();
		this.month = month;
		this.year = year;
		this.day = day;
	}
	
	//Overloaded constructor 
	public Date(String month, int day, int year) {
		super();
		setMonth(month);
		this.year = year;
		this.day = day;
	}
	
	//Overloaded constructor
	public Date(int day, int year) {
		super();
		this.year = year;
		setDay(day);
	}

	//Getters and Setters
	public int getMonth() {
		return month;
	}
	
	
	public void setMonth(int month) {
		this.month=month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		if(day<31)
			this.day = day;
		
		else {
			
			this.month = 1+(int)day/30;
			this.day = day -((month-1)*30);
		}
	}
	
	
	//toString method
	@Override
	public String toString() {
		return "Date [month=" + month + ", year=" + year + ", day=" + day + "]";
	}

	//Utility Methods
	
	//Sets the month based on string representation given
	public void setMonth(String month) {
		for(int m=1;m<=12;m++)
			if(monthArray[m].equals(month))
				this.month = m;
		
		
	}
}
