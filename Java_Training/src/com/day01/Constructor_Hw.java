package com.day01;

public class Constructor_Hw {
	
		int a=2,b=2,c;
		double d=0.9;
		String name1;
		 
		Constructor_Hw(int i)
		
		{
		this("javaS");
			System.out.println("The i value is:"+i);
			
		}
		
		public void sum(int a,int b)
		{
		this.b=b;
		this.a=a;
		c = a +b;
		System.out.println("The value of a is:"+c);
		}
		
		public void sub()
		{
		c = a - b;
		System.out.println("The value of a is:"+c);
		sum1();
			}
		
		public void sum1()
		{
		System.out.println("The value of d is:"+d);
		}
		
		
		Constructor_Hw(String name1)
			{
			sum(8,2);
			sub();
			this.name1 = name1;
			
				}
		
			public static void main(String[] args) 
		{
						
				Constructor_Hw obj = new Constructor_Hw(23);
				System.out.println("The name1 value is:"+obj.name1);
						}

	}
	
