package com.day03;



public class Static_Ex {
	static Static_Ex oBj1;
	int iRollNo;
	String sName;
	static String sBatch = "WeekEnd";
	static int iPage;
	
	public Static_Ex(int i,String s) {
		iRollNo = i;
		sName = s;
		iPage++;
	}
	
	public void print() {
		//Static_Ex.display();
		//int a=10;
		//System.out.println("value is:"+a);
		System.out.println("Roll No is : "+iRollNo);
		System.out.println("Name is : "+sName);
		System.out.println("Batch is : "+sBatch);
		System.out.println("Page Value is : "+iPage);
		//this.display();
	}
	
	public static void display() {
		//oBj1.print();
		//int c =3;
		//System.out.println("value is:"+c);
		System.out.println("It is a Static Method");
		System.out.println("Roll No is : "+oBj1.iRollNo);
		System.out.println("Name is : "+oBj1.sName);
		System.out.println("Batch is : "+sBatch);
		System.out.println("Page Value is : "+iPage);
		//this.print();
	}
	

	public static void main(String[] args) {
		 oBj1 = new Static_Ex(100,"Karthick");
		 display();
		
		//oBj1.display();
		Static_Ex oBj2 = new Static_Ex(101,"Gopi");
		oBj2.print();
		Static_Ex oBj3 = new Static_Ex(102,"Jone");
		oBj3.print();
		System.out.println("Batch is : "+sBatch);
		display();

	}

}
