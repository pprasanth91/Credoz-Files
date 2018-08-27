package com.day07;


public interface Interface_Inheritance_HW {
	int a=20,b=10;
	
	public static void Add()
	{
		int c;
		c= a+b;
		System.out.println("Add"+c);
		
	}
	public static void Sub()
	{
		int c;
		c= a-b;
		System.out.println("Sub"+c);
	}
	
	
	public abstract void Mul();
	public int Add(int a, int b);
	public int Sub(int a, int b);
	
	
}
