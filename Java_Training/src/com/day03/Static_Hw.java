package com.day03;

public class Static_Hw {

	static int a =1,b=3;
	 static int c;
	public static void add()
	{
		
		c= a+b;
		System.out.println("Add : "+c);
	}
	
	public static void sub()
	{
		int a =10,b=3;
		int c;
		c= a-b;
		System.out.println("Sub : "+c);
	}
	public static void sub(int a,int b)
	{

		
		c= a-b;
		//System.out.println("Sub : "+c);
	}
	public  void add(int a,int b)
	{
		
		c= a+b;
		System.out.println("Add1 : "+c);
	}
	public  void mul()
	{
		int a =2,b=3;
		int c;
		this.a=a;
		this.b=b;
		
		c= a*b;
		System.out.println("Mul : "+c);
	}
	public static void main(String[] args) {
		Static_Hw obj = new Static_Hw();
		// TODO Auto-generated method stub
		sub();
		Static_Hw.add();
		System.out.println("Value of Global variable : "+c);
		sub(20,2);
		System.out.println("Value of Sub  : "+c);
		obj.mul();
		System.out.println("Value of Global variable C : "+c);
		System.out.println("Value of Global variable A : "+a);
		System.out.println("Value of Global variable B: "+b);
		
	}

}
