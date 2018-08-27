package com.day07;

public interface RBI_Interface {
	
	/*public RBI_Interface() //Interface cannot have constructor bcoz obj not created 
	{
		System.out.println("This is  Consteucoit");
	}*/
	int iRBI_ID =200;
	
	public  double homeLoanInterest() ;
	
	abstract double carLoanInterest();
	
	 default double personalLoanInterest() {
		return 11.2;
	}
	
	 public  double creditCardInterest();

	//default double creditCardInterest();
	//Modifier as private
	//static how
	//interface can be given abstract r not
	public void print();
}