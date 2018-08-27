package com.day07;

public class Interface_Child2_HW extends Interface_Child1_HW {
	
    int a=3,b=2,c;
    static Interface_Child2_HW OBJChild2;
    static Interface_Child1_HW OBJChild1;
    static Interface_Inheritance_HW OBJParent;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OBJChild2 = new Interface_Child2_HW();
		OBJChild1 = new Interface_Child2_HW();
		OBJParent = new Interface_Child2_HW();
		//Child 2
		OBJChild2.Mul();
		int v= OBJChild2.Add(40, 10);
		int x = OBJChild2.Sub(40,10);
		System.out.println("Add valus of a& b is"+v);
		System.out.println("Sub valus of a& b is"+x);
		//Interface implemented method
		Interface_Inheritance_HW.Add();
		Interface_Inheritance_HW.Sub();
		//Parent 
		int v1= OBJParent.Add(10, 10);
		int x1 = OBJParent.Sub(20,10);
		System.out.println("Add valus of a& b is"+v1);
		System.out.println("Sub valus of a& b is"+x1);
		OBJParent.Mul();
		//child1
		int v2= OBJChild1.Add(100, 10);
		int x2 = OBJChild1.Sub(100,10);
		System.out.println("Add valus of a& b is"+v2);
		System.out.println("Sub valus of a& b is"+x2);
		OBJParent.Mul();
	}

	@Override
	public void Mul() {
		// TODO Auto-generated method stub
		c=a*b;
		System.out.println("Mul valus of a& b is"+c);
	}

}
