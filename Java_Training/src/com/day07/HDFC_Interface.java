package com.day07;

public class HDFC_Interface implements RBI_Interface,Interface1 {

	public HDFC_Interface()
	{
		System.out.println("This is  Constructor");
	}
	
	public double homeLoanInterest()
	{
		return 8.35;
	}
	
	//static  void print() //This not possible bcoz u cant override static method
	public void print()
	{
		System.out.println("This is  Print Method");
		personalLoanInterest();
	}
	public double carLoanInterest() {
		return 10.5;
	}
	
	public double personalLoanInterest() {
		return 11.5;
	}
	
	//static  double creditCardInterest() {
		// TODO Auto-generated method stub
	//	return 0.1;
		
	//}

	public  double creditCardInterest() {
			// TODO Auto-generated method stub
			return 0.1;
			
		}
	public static void main(String[] args) {
		HDFC_Interface oHDFC = new HDFC_Interface();
		System.out.println("Home Loan % is : "+oHDFC.homeLoanInterest());
		System.out.println("Car Loan % is : "+oHDFC.carLoanInterest());
		System.out.println("Personal Loan % is : "+oHDFC.personalLoanInterest());
		System.out.println("Credit Card  % is : "+oHDFC.creditCardInterest());
		oHDFC.print();

		RBI_Interface oRBI = new HDFC_Interface();
		
		System.out.println("Home Loan % is : "+oRBI.homeLoanInterest());
		System.out.println("Car Loan % is : "+oRBI.carLoanInterest());
		System.out.println("Personal Loan % is : "+oRBI.personalLoanInterest());
		System.out.println("Credit Card  % is : "+oRBI.creditCardInterest());
		oRBI.print();
		
		Interface1 Int = new HDFC_Interface();
		Int.print();
	}

}
