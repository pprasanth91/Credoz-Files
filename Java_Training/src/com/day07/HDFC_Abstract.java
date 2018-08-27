package com.day07;



	public class HDFC_Abstract extends RBI_Abstract {
 
		public HDFC_Abstract() {
			System.out.println("HDFC Default Constructor");
		}
		
		public static void main(String[] args) {
			HDFC_Abstract oHDFC = new HDFC_Abstract();
			System.out.println("Home Loan % is : "+oHDFC.homeLoanInterest());
			System.out.println("Car Loan % is : "+oHDFC.carLoanInterest());
			System.out.println("Personal Loan % is : "+oHDFC.personalLoanInterest());
			System.out.println("Credit Card  % is : "+oHDFC.creditCardInterest());
			oHDFC.display();

			RBI_Abstract oRBI = new HDFC_Abstract();
			
			System.out.println("Home Loan % is : "+oRBI.homeLoanInterest());
			System.out.println("Car Loan % is : "+oRBI.carLoanInterest());
			System.out.println("Personal Loan % is : "+oRBI.personalLoanInterest());
			System.out.println("Credit Card  % is : "+oRBI.creditCardInterest());
			oRBI.display();
		}

		@Override
		public double creditCardInterest() {
			// TODO Auto-generated method stub
			return 0.1;
		}

	
}
