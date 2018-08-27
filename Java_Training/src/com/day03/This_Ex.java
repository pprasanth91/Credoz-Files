package com.day03;

 public class This_Ex {

	int iRoll=10;
	String sName="Mathan";
		
	public This_Ex(int iRoll,String sName) {
		
		this();
		this.iRoll = iRoll;
		this.sName = sName;
		
		}
	public This_Ex(int i)
	{
	System.out.println("I Value is : "+i);
	this.display();
	}
	
	public This_Ex() {
		this(10);
	System.out.println("This is Default Constructor");
	}
	
	public void print() {
		System.out.println("Roll No is : "+iRoll);
		System.out.println("Name is : "+sName);
	}
	
	public  void display() {
		this.print();
		System.out.println("This is diplay method");
		//this.print();
	}
	
	public static void main(String[] args) {
		This_Ex oBj = new This_Ex(200,"Vijay");
		oBj.display();
		
	}
	
}
