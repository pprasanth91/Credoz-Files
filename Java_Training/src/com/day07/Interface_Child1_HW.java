package com.day07;



public abstract  class Interface_Child1_HW implements Interface_Inheritance_HW{
	int c;
	public  abstract void Mul();
	public int Add(int a, int b)
	{
		c= a+b;
		return c;
	}
	public int Sub(int a, int b)
	{
		c= a-b;
		return c;
	}
	
	
}
