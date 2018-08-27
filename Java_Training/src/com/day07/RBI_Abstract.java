package com.day07;

public abstract class RBI_Abstract {
	
	int iRBI_ID = 2030; 
	String sBranch = "Parrys";
	
	public RBI_Abstract() {
		System.out.println("RBI Default Constructor");
	}

	public void display() {
		
		System.out.println("RBI ID is : "+iRBI_ID);
		System.out.println("Branch is : "+sBranch);
	}
	
	public double homeLoanInterest() {
		return 8.35;
	}
	
	public double carLoanInterest() {
		return 10.5;
	}
	
	public double personalLoanInterest() {
		return 11.5;
	}
	
	public   abstract double creditCardInterest();
	
}













