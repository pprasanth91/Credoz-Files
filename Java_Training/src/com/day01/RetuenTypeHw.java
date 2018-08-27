package com.day01;

public class RetuenTypeHw {

	int a=10,b=20,c;
	
	
	
				public 	void sum() 
				{
					 c=a+b;
				
				System.out.println("Sum of 2no's are"+c);
				}
				public 	void sub() 
				{
					int f,e,d;
					f=2;e=3;
					 d=e+f;
				
				System.out.println("Sub of 2no's are"+d);
				}
			
			/*public void sum(int a) {
				
				System.out.println("Add is  : "+c);
			}
		

			public void sum(int a, int b) {
					c = b*a;
				System.out.println("Mul of 2no's are : "+c);
			}*/
			
		/*public void div() {
				double a=20,b=2;
				double c;
				c = b/a;
			System.out.println("Div of 2no's are : "+c);
		}*/
		
			public static void main(String[] args) {
			
				RetuenTypeHw oSum = new RetuenTypeHw();
				oSum.sum();
				oSum.sub();
				/*oSum.sum(20);
				oSum.sum(2,4);*/
				//oSum.div();
			}

		}
