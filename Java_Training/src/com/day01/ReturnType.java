package com.day01;

public class ReturnType {
	

			public void sum() {
			int a=10,b=20,c;
			c = a+b;
			System.out.println("Sum of 2no's are : "+c);
		}
		
		public void add(int a,int b) {
			int c;
			c = a+b;
			System.out.println("Add of 2no's are : "+c);
		}
		
		public int addition(int a,int b) {
			int c = a+b;
			c = c-120;
			if(c>0) {
				return c;
			}else {
				c=c+10;
				return c;
			}
			
		}
		
		public void calculation() {
			int calc = addition(50, 70);
		System.out.println("Calc Value is : "+calc);
		}

		public static void main(String[] args) {
		
			ReturnType oSum = new ReturnType();
			oSum.sum();
			oSum.add(40, 60);
			System.out.println("Sum of 2no's are "+oSum.addition(400, 600));
			oSum.calculation();
			oSum.addition(400, 600);
		}

	}
