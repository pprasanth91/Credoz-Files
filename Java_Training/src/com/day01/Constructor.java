package com.day01;

import com.day03.Static_Ex;

public class Constructor {


    int iRoll=10;
	String sName="Mathan";
	
	public Constructor() {
		System.out.println("This is a Default Constructor");
	}
	
	
	public  Constructor(int i,String s) {
		iRoll = i;
		sName = s;
	}
	
	public void print() {
		System.out.println("Roll No is : "+iRoll);
		System.out.println("Name is : "+sName);
		Static_Ex.display();
	}
	

	public static void main(String[] args) {
		Constructor oBj = new Constructor();
		oBj.print();
		Constructor oBj1 = new Constructor(100,"Sathya");
		oBj1.print();
		System.out.println("Roll No is : "+oBj1.iRoll);
		System.out.println("Name is : "+oBj1.sName);


	}

}

