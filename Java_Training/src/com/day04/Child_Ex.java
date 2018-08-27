package com.day04;

public class Child_Ex extends Parent_Ex{
	
	 static int iChild_ID = 3020;
	   static	String sChild_Name = "Varsha";
	
	public Child_Ex() {
		super();
		System.out.println("Child Default Constructor");
	}
	
	public  void display() {
		System.out.println("Child ID : "+iChild_ID);
		System.out.println("Child Name is : "+sChild_Name);
		//super.print();
			
	}
	
	public  static void print() {
		System.out.println("Method Override");
		
			}

	public static void main(String[] args) {
		Child_Ex oChild = new Child_Ex();
		oChild.print();
		oChild.displayP();
		//oChild.displayP();
		System.out.println("=======Only Parent===============");
		Parent_Ex oParent = new Parent_Ex();
		oParent.print();
		//oParent.display();
		oParent.displayP();// scope of Static method extended to Child class
		System.out.println("=======Parent Reference===============");
		Parent_Ex oReference = new Child_Ex();
		oReference.displayP();
		oReference.print();//when method static , cannot overriden.Static binding(Static,Final and Private method)
		//when method not static , overriden.Dynamic binding.
		//oReference.display();
	}

	
}













