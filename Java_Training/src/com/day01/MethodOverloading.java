package com.day01;



public class MethodOverloading {
	
	public void sum() {
		int a=10,b=20,c;
		c = a+b;
		System.out.println("Sum of 2no's are : "+c);
	}
	
	
	public  void sum(int a,int b) {
		int c;
		c = a+b;
		//return c;
		System.out.println("Sum of 2 int no's are : "+c);
	}
	public void sum(double a,int b) {
		double c;
		c = a+b;
		System.out.println("Sum of 2 double no's are : "+c);
	}
	
	public static void main(String[] args) {
	
		MethodOverloading oSum = new MethodOverloading();
		oSum.sum();
		oSum.sum(100, 200);
		oSum.sum(10.50, 20);
		
	}

}
