package com.day04;

public class Parent_Ex {
	
	   static int  iParent_ID = 1020;
	   static String  sParent_Name = "Mathan";
	   //Scope of static variable extended to Child class
	   //static int iChild_ID = 3020;
	   //static	String sChild_Name = "Varsha";
	public  Parent_Ex() {
		System.out.println("Parent Default Constructor");
	} 
	public  static void print() {
		System.out.println("Parent Override method");
		
	}
	
	public  static void displayP()
	{
		System.out.println("Parent ID is : "+iParent_ID);
		System.out.println("Parent Name is : "+sParent_Name);
	}
	
	

}
