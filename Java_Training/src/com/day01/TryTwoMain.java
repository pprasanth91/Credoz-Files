package com.day01;

public class TryTwoMain {
	
	public void add()
	{
		int a=10,b=20,c;
		c=a+b;
		System.out.println("print:"+c);	
	}
	
	public static void main(int a, int b) 
	{
		int c=a+b;
		System.out.println("Main1:"+c);	
	}
	
	public static void main(double a) 
	{
		double b=10;
		double c=a+b;
		System.out.println("Main2:"+c);	
	}
	
	public static int main(int d) 
	{
		int a=2;
		int c=d+a;
		//System.out.println("Main1:"+c);	
		return c;
	}
	
	public static double main(double d,double e) 
	{
		
		double c=d+e;
		//System.out.println("Main1:"+c);	
		return c;
	}
	
	public static void main(String[] args) 
	{
		int g=2,h=1,f;
		f=g+h;
		System.out.println("print f:"+f);
		TryTwoMain omain = new TryTwoMain();
		omain.add();
		main(10,20);
		TryTwoMain.main(10.0);
		System.out.println(TryTwoMain.main(20));
		System.out.println(TryTwoMain.main(20.0,30));
		
	}
	/*public static void main(String[] args) {
		int g=2,h=1,f;
		f=g+h;
		System.out.println("print f:"+f);
	}*/
}
